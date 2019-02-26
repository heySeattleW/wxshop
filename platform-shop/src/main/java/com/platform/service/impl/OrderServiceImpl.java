package com.platform.service.impl;

import com.alibaba.fastjson.JSON;
import com.platform.dao.OrderDao;
import com.platform.dao.OrderGoodsDao;
import com.platform.dao.ProductDao;
import com.platform.dao.ShippingDao;
import com.platform.entity.AftersalesEntity;
import com.platform.entity.KdApiVo;
import com.platform.entity.OrderEntity;
import com.platform.entity.OrderGoodsEntity;
import com.platform.entity.ProductEntity;
import com.platform.entity.ShippingEntity;
import com.platform.service.OrderService;
import com.platform.utils.RRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderGoodsDao orderGoodsDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ShippingDao shippingDao;
    @Autowired
    private KdApiEOrderServiceImp kdApiEOrderService;
    @Autowired
    private AftersalesServiceImpl aftersalesServiceImpl;
    @Override
    public OrderEntity queryObject(Integer id) {
        return orderDao.queryObject(id);
    }
    @Override
    public List<OrderEntity> queryList(Map<String, Object> map) {
        return orderDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return orderDao.queryTotal(map);
    }

    @Override
    public int save(OrderEntity order) {
        return orderDao.save(order);
    }

    @Override
    public int update(OrderEntity order) {
        return orderDao.update(order);
    }

    @Override
    public int delete(Integer id) {
        return orderDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return orderDao.deleteBatch(ids);
    }
    @Override
    public int confirm(Integer id) {
        OrderEntity orderEntity = queryObject(id);
        Integer shippingStatus = orderEntity.getShippingStatus();//发货状态
        Integer payStatus = orderEntity.getPayStatus();//付款状态
        if (2 != payStatus) {
            throw new RRException("此订单未付款，不能确认收货！");
        }
        if (4 == shippingStatus) {
            throw new RRException("此订单处于退货状态，不能确认收货！");
        }
        if (0 == shippingStatus) {
            throw new RRException("此订单未发货，不能确认收货！");
        }
        orderEntity.setShippingStatus(2);
        orderEntity.setOrderStatus(301);
        return orderDao.update(orderEntity);
    }
    
    @Override
    public int refund(Integer id) {
        OrderEntity orderEntity = queryObject(id);
        Integer shippingStatus = orderEntity.getShippingStatus();//发货状态
        Integer payStatus = orderEntity.getPayStatus();//付款状态
        if (2 != payStatus) {
            throw new RRException("此订单未付款，不能退款！");
        }
        if (4 == shippingStatus) {
            throw new RRException("此订单处于退货状态，不能退款！");
        }
        if (0 == shippingStatus) {
        	orderEntity.setOrderStatus(401);
        }else {
        	orderEntity.setOrderStatus(402);
        }
        orderEntity.setShippingStatus(4);
        
        return orderDao.update(orderEntity);
    }
    
    @Override
    public int sendShip(OrderEntity order) {
    	 System.out.println("111111111111");
        Integer payStatus = order.getPayStatus();//付款状态
        if (2 != payStatus) {
            throw new RRException("此订单未付款！");
        }
        Integer pickUptype = order.getPickUpType();//付款状态
        if (0 != pickUptype) {
            throw new RRException("自取订单不用快递！");
        }
        
        Integer orderStatus = order.getShippingStatus();//付款状态
        if (0 != orderStatus) {
            throw new RRException("此订单已发货！");
        }
      
        ShippingEntity shippingEntity = shippingDao.queryObject(order.getShippingId());
        if (null != shippingEntity) {
            order.setShippingName(shippingEntity.getName());
        }else {
        	throw new RRException("请选择快递公司！");
        }
        try {
        	System.out.println("send kd");
        	
        	String code=kdApiEOrderService.orderOnlineByJson(order,shippingEntity.getCode());
        	KdApiVo kdApiVo=JSON.parseObject(code, KdApiVo.class);
        	if(!kdApiVo.isSuccess()) {
        		 throw new RRException("获取电子面单失败！"+kdApiVo.getReason());
        	}
        	System.out.println(code);
        	//修改快递单号
        	order.setShippingNo(kdApiVo.getOrder().getLogisticCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        return orderDao.update(order);
    }

    @Override
    public int sendGoods(OrderEntity order) {
    	 System.out.println("111111111111");
        Integer payStatus = order.getPayStatus();//付款状态
        if (2 != payStatus) {
            throw new RRException("此订单未付款！");
        }
        Integer orderStatus = order.getShippingStatus();//付款状态
        if (0 != orderStatus) {
            throw new RRException("此订单已发货！");
        }
       
        Map<String,Object> params=new HashMap( );
        params.put("orderId", order.getId() );
        List<OrderGoodsEntity> orderGoodsList=orderGoodsDao.queryList(params);
        //产生保修卡
        for(OrderGoodsEntity orderGoodsEntity :orderGoodsList) {
        	ProductEntity productEntity=productDao.queryObject(orderGoodsEntity.getProductId());
        	if(productEntity.getRepairMonth()!=null&&productEntity.getRepairMonth()>0) {
	        	for(int i=0;i<orderGoodsEntity.getNumber();i++) {
	        		
        		
	        		AftersalesEntity after=new AftersalesEntity();
	        		after.setBuyTime(order.getPayTime());
	        		after.setGoodsId(orderGoodsEntity.getGoodsId());
	        		after.setGoodsName(orderGoodsEntity.getGoodsName());
	        		after.setGoodsSpecifitionNames(orderGoodsEntity.getGoodsSpecifitionNameValue());
	        		after.setProductId(orderGoodsEntity.getProductId());
	        		after.setUserId(order.getUserId());
	        		after.setOrderSn(order.getOrderSn());
	        		after.setUserName(order.getUserName());
	        		Calendar rightNow = Calendar.getInstance();
	                rightNow.setTime(after.getBuyTime());
	                rightNow.add(Calendar.MONTH, productEntity.getRepairMonth());
	                after.setRepairEndTime(rightNow.getTime());
	        		aftersalesServiceImpl.save(after);
	        	}
        	}
        }
        order.setOrderStatus(300);//订单已发货
        order.setShippingStatus(1);//已发货
        return orderDao.update(order);
    }
}
