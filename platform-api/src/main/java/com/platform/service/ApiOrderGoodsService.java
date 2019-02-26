package com.platform.service;

import com.platform.dao.ApiOrderGoodsMapper;
import com.platform.entity.OrderGoodsVo;
import com.platform.entity.ProductVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ApiOrderGoodsService {
    @Autowired
    private ApiOrderGoodsMapper orderGoodsDao;
    
    @Autowired
    private ApiProductService productService;



    public OrderGoodsVo queryObject(Integer id) {
        return orderGoodsDao.queryObject(id);
    }

    public  List<OrderGoodsVo>   queryList(Map<String, Object> map) {
    	
    	 return orderGoodsDao.queryList(map);
    	
    }
    public Map<String, Object>  checkqueryList(Map<String, Object> map) {
    	Map<String, Object> resultObj = new HashMap<String, Object>();
    	 List<OrderGoodsVo> orderGoodsVoList=  orderGoodsDao.queryList(map);
    	 //重新检查商品价格
    	 for(OrderGoodsVo orderGoodsVo:orderGoodsVoList) {
    		 ProductVo productVo=productService.queryObject(orderGoodsVo.getProduct_id());
    		 if(!orderGoodsVo.getRetail_price().equals(productVo.getRetail_price())) {
    			 resultObj.put("errno", 400);
                 resultObj.put("errmsg", orderGoodsVo.getGoods_name()+"商品价格有变换,请重新购买");
                 return resultObj;
    		 }
    	 }
    	  resultObj.put("list", orderGoodsVoList);
    	  return resultObj;
    }


    public int queryTotal(Map<String, Object> map) {
        return orderGoodsDao.queryTotal(map);
    }


    public void save(OrderGoodsVo order) {
        orderGoodsDao.save(order);
    }


    public void update(OrderGoodsVo order) {
        orderGoodsDao.update(order);
    }


    public void delete(Integer id) {
        orderGoodsDao.delete(id);
    }


    public void deleteBatch(Integer[] ids) {
        orderGoodsDao.deleteBatch(ids);
    }

}
