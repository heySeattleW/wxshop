package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.FlashgoodsDao;
import com.platform.entity.FlashgoodsEntity;
import com.platform.service.FlashgoodsService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-09-29 14:36:33
 */
@Service("flashgoodsService")
public class FlashgoodsServiceImpl implements FlashgoodsService {
    @Autowired
    private FlashgoodsDao flashgoodsMapper;

    @Override
    public FlashgoodsEntity queryObject(Integer id) {
        return flashgoodsMapper.queryObject(id);
    }

    @Override
    public List<FlashgoodsEntity> queryList(Map<String, Object> map) {
        return flashgoodsMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return flashgoodsMapper.queryTotal(map);
    }

    @Override
    public int save(FlashgoodsEntity flashgoods) {
        return flashgoodsMapper.save(flashgoods);
    }

    @Override
    public int update(FlashgoodsEntity flashgoods) {
        return flashgoodsMapper.update(flashgoods);
    }

    @Override
    public int delete(Integer id) {
        return flashgoodsMapper.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return flashgoodsMapper.deleteBatch(ids);
    }
}
