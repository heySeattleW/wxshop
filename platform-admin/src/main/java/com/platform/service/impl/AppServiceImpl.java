package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.AppDao;
import com.platform.entity.AppEntity;
import com.platform.service.AppService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-09-25 17:33:58
 */
@Service("appService")
public class AppServiceImpl implements AppService {
    @Autowired
    private AppDao appMapper;

    @Override
    public AppEntity queryObject(String id) {
        return appMapper.queryObject(id);
    }

    @Override
    public List<AppEntity> queryList(Map<String, Object> map) {
        return appMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return appMapper.queryTotal(map);
    }

    @Override
    public int save(AppEntity app) {
        return appMapper.save(app);
    }

    @Override
    public int update(AppEntity app) {
        return appMapper.update(app);
    }

    @Override
    public int delete(String id) {
        return appMapper.delete(id);
    }

    @Override
    public int deleteBatch(String[] ids) {
        return appMapper.deleteBatch(ids);
    }
}
