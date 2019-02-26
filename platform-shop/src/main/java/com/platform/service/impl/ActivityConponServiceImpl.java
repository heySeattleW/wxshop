package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.ActivityConponMapper;
import com.platform.entity.ActivityConponEntity;
import com.platform.service.ActivityConponService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-10-29 13:56:24
 */
@Service(" activityConponService")
public class  ActivityConponServiceImpl implements  ActivityConponService {
    @Autowired
    private  ActivityConponMapper  activityConponMapper;

    @Override
    public  ActivityConponEntity queryObject(Integer id) {
        return  activityConponMapper.selectByPrimaryKey(id.longValue());
    }

    @Override
    public List<ActivityConponEntity> queryList(Map<String, Object> map) {
        return  activityConponMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return  activityConponMapper.queryTotal(map);
    }

    @Override
    public int save(ActivityConponEntity  activityConpon) {
        return  activityConponMapper.insertSelective( activityConpon);
    }

    @Override
    public int update( ActivityConponEntity  activityConpon) {
        return  activityConponMapper.updateByPrimaryKeySelective( activityConpon);
    }

    @Override
    public int delete(Integer id) {
        return  activityConponMapper.deleteByPrimaryKey(id.longValue());
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return  activityConponMapper.deleteBatch(ids);
    }
}
