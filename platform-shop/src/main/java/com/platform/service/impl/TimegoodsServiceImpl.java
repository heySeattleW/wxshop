package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.TimegoodsMapper;
import com.platform.entity.TimegoodsEntity;
import com.platform.service.TimegoodsService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-10-15 11:08:36
 */
@Service("timegoodsService")
public class TimegoodsServiceImpl implements TimegoodsService {
    @Autowired
    private TimegoodsMapper timegoodsMapper;

    @Override
    public TimegoodsEntity queryObject(Integer id) {
        return timegoodsMapper.selectByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public List<TimegoodsEntity> queryList(Map<String, Object> map) {
        return timegoodsMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return timegoodsMapper.queryTotal(map);
    }

    @Override
    public int save(TimegoodsEntity timegoods) {
        return timegoodsMapper.insertSelective(timegoods);
    }

    @Override
    public int update(TimegoodsEntity timegoods) {
        return timegoodsMapper.updateByPrimaryKeySelective(timegoods);
    }

    @Override
    public int delete(Integer id) {
        return timegoodsMapper.deleteByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return timegoodsMapper.deleteBatch(ids);
    }
}
