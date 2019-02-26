package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.ActivityGoodsMapper;
import com.platform.dao.ActivityMapper;
import com.platform.entity.ActivityEntity;
import com.platform.entity.ActivityGoodsEntity;
import com.platform.entity.example.ActivityGoodsExample;
import com.platform.service.ActivityGoodsService;
import com.platform.service.ActivityService;
import com.platform.utils.R;
import com.platform.service.ActivityService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-10-29 13:56:24
 */
@Service(" activityService")
public class ActivityServiceImpl implements  ActivityService {
    @Autowired
    private  ActivityMapper  activityMapper;
    @Autowired
    private  ActivityGoodsMapper  activityGoodsMapper;
    @Autowired
    private  ActivityGoodsService  activityGoodsService;


    @Override
    public  ActivityEntity queryObject(Integer id) {
    	ActivityEntity activityEntity=  activityMapper.selectByPrimaryKey(id.longValue());
    	List<ActivityGoodsEntity> activityGoodsEntityList=activityGoodsService.selectActivityGoods(id);
    	
    	activityEntity.setActivityGoodsList(activityGoodsEntityList);
    	return activityEntity;
    }

    @Override
    public List<ActivityEntity> queryList(Map<String, Object> map) {
        return  activityMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  activityMapper.queryTotal(map);
    }

    @Override
    public int save(ActivityEntity  activity) throws Exception {
    	
          activityMapper.insertSelective( activity);
          if(activity.getActivityGoodsList()!=null) {
        	  for(ActivityGoodsEntity activityGoodsEntity:activity.getActivityGoodsList()) {
        		  ActivityGoodsExample activityGoodsExample=new ActivityGoodsExample();
        	      activityGoodsExample.createCriteria().andProductIdEqualTo(activityGoodsEntity.getProductId());
        	      List<ActivityGoodsEntity> activityGoodsList =activityGoodsMapper.selectByExample(activityGoodsExample);
        	      if(activityGoodsList.size()>0) {
          			throw new Exception(activityGoodsEntity.getGoodsName()+"已经参加了其他活动");
          		  }
        	      activityGoodsEntity.setId(null);
        		  activityGoodsEntity.setActivityId(activity.getId());
        		  activityGoodsMapper.insertSelective(activityGoodsEntity);
        	  }
          }
          return 1;
          
    }

    @Override
    public int update(ActivityEntity  activity) throws Exception {
    	ActivityGoodsExample activityGoodsExample=new ActivityGoodsExample();
    	activityGoodsExample.createCriteria().andActivityIdEqualTo(activity.getId());
    	activityGoodsMapper.deleteByExample(activityGoodsExample);
        activityMapper.updateByPrimaryKeySelective( activity);
        if(activity.getActivityGoodsList()!=null) {
        	  for(ActivityGoodsEntity activityGoodsEntity:activity.getActivityGoodsList()) {
        		  ActivityGoodsExample activityGoodsExample2=new ActivityGoodsExample();
        	      activityGoodsExample2.createCriteria().andProductIdEqualTo(activityGoodsEntity.getProductId());
        	      List<ActivityGoodsEntity> activityGoodsList =activityGoodsMapper.selectByExample(activityGoodsExample2);
        		  if(activityGoodsList.size()>0) {
        			throw new Exception(activityGoodsEntity.getGoodsName()+"已经参加了其他活动");
        		  }
        		  
        		  activityGoodsEntity.setId(null);
        		  activityGoodsEntity.setActivityId(activity.getId());
        		  activityGoodsMapper.insertSelective(activityGoodsEntity);
        	  }
          }
        return 1;
    }

    @Override
    public int delete(Integer id) {
    	ActivityGoodsExample activityGoodsExample=new ActivityGoodsExample();
    	activityGoodsExample.createCriteria().andActivityIdEqualTo(id);
    	activityGoodsMapper.deleteByExample(activityGoodsExample);
        return  activityMapper.deleteByPrimaryKey(id.longValue());
    }

    @Override
    public int deleteBatch(Integer[] ids) {
    	for(Integer id :ids) {
	    	ActivityGoodsExample activityGoodsExample=new ActivityGoodsExample();
	    	activityGoodsExample.createCriteria().andActivityIdEqualTo(id);
	    	activityGoodsMapper.deleteByExample(activityGoodsExample);
	         activityMapper.deleteByPrimaryKey(Long.valueOf(id));
    	}
    	return 1;
    }
}
