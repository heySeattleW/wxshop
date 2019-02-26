package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.EvaluateMapper;
import com.platform.entity.EvaluateEntity;
import com.platform.service.EvaluateService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-01 10:36:46
 */
@Service("evaluateService")
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public EvaluateEntity queryObject(Integer id) {
        return evaluateMapper.selectByPrimaryKey(id.longValue());
    }

    @Override
    public List<EvaluateEntity> queryList(Map<String, Object> map) {
        return evaluateMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return evaluateMapper.queryTotal(map);
    }

    @Override
    public int save(EvaluateEntity evaluate) {
        return evaluateMapper.insertSelective(evaluate);
    }

    @Override
    public int update(EvaluateEntity evaluate) {
        return evaluateMapper.updateByPrimaryKeySelective(evaluate);
    }

    @Override
    public int delete(Integer id) {
        return evaluateMapper.deleteByPrimaryKey(id.longValue());
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return evaluateMapper.deleteBatch(ids);
    }
}
