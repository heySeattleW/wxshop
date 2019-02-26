package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.platform.dao. ActivityGoodsMapper;
import com.platform.dao.GoodsSpecificationDao;
import com.platform.entity.ActivityGoodsEntity;
import com.platform.entity.GoodsSpecificationEntity;
import com.platform.entity.ProductEntity;
import com.platform.service.ActivityGoodsService;

import com.platform.service.ProductService;
import com.platform.utils.StringUtils;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-10-29 13:56:24
 */
@Service(" activityGoodsService")
public class  ActivityGoodsServiceImpl implements  ActivityGoodsService {
    @Autowired
    private  ActivityGoodsMapper  activityGoodsMapper;
    @Autowired
    private GoodsSpecificationDao goodsSpecificationDao;
    @Autowired
    private ProductService productService;
    @Override
    public  ActivityGoodsEntity queryObject(Integer id) {
        return  activityGoodsMapper.selectByPrimaryKey(id.longValue());
    }

    @Override
    public List<ActivityGoodsEntity> queryList(Map<String, Object> map) {
        return  activityGoodsMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  activityGoodsMapper.queryTotal(map);
    }

    @Override
    public int save(ActivityGoodsEntity  activityGoods) {
        return  activityGoodsMapper.insertSelective( activityGoods);
    }

    @Override
    public int update( ActivityGoodsEntity  activityGoods) {
        return  activityGoodsMapper.updateByPrimaryKeySelective( activityGoods);
    }
    
  

    @Override
    public int delete(Integer id) {
        return  activityGoodsMapper.deleteByPrimaryKey(id.longValue());
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return  activityGoodsMapper.deleteBatch(ids);
    }
    @Override
    public List<ActivityGoodsEntity> selectActivityGoods(Integer activityId){
    	List<ActivityGoodsEntity>  activityGoodsEntityList=  activityGoodsMapper.selectActivityGoods(activityId);
    	 chagespecificationIdsToName(activityGoodsEntityList);
     	return activityGoodsEntityList;
    } 
    @Override
	public List<ActivityGoodsEntity>  selectAllActivityGoods()
	{
    	List<ActivityGoodsEntity>  activityGoodsEntityList=activityGoodsMapper.selectAllActivityGoods();
    	 chagespecificationIdsToName(activityGoodsEntityList);
    	return activityGoodsEntityList;
	}
    
    public void chagespecificationIdsToName(List<ActivityGoodsEntity>  activityGoodsEntityList ) {
    	for(ActivityGoodsEntity activityGoodsEntity:activityGoodsEntityList) {
    		ProductEntity product=productService.queryObject(activityGoodsEntity.getProductId());
    		String names=chagespecificationIdsToName(product.getGoodsSpecificationIds());
    		activityGoodsEntity.setGoodsSpecificationName(names);
    	}
    	
    }
    private String chagespecificationIdsToName(String specificationIds) {
    	
		String specificationValue = "";
		if (!StringUtils.isNullOrEmpty(specificationIds)) {
			String[] arr = specificationIds.split(",");

			for (String goodsSpecificationId : arr) {
				GoodsSpecificationEntity entity = goodsSpecificationDao.queryObject(goodsSpecificationId);
				if (null != entity) {
					specificationValue += entity.getValue() + "；";
				}
			}
         }
		return specificationValue;
                
    
    }
}
