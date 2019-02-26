package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.InfoMapper;
import com.platform.entity.InfoEntity;
import com.platform.service.InfoService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-21 08:51:39
 */
@Service("infoService")
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper infoMapper;

    @Override
    public InfoEntity queryObject(Integer id) {
        return infoMapper.selectByPrimaryKey((long)id);
    }

    @Override
    public List<InfoEntity> queryList(Map<String, Object> map) {
        return infoMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return infoMapper.queryTotal(map);
    }

    @Override
    public int save(InfoEntity info) {
        return infoMapper.insertSelective(info);
    }

    @Override
    public int update(InfoEntity info) {
        return infoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public int delete(Integer id) {
        return infoMapper.deleteByPrimaryKey((long)id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return infoMapper.deleteBatch(ids);
    }
}
