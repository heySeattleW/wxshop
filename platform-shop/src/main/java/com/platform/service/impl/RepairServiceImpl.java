package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.RepairMapper;
import com.platform.entity.RepairEntity;
import com.platform.service.RepairService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-21 09:25:22
 */
@Service("repairService")
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairMapper repairMapper;

    @Override
    public RepairEntity queryObject(Integer id) {
        return repairMapper.selectByPrimaryKey((long)id);
    }

    @Override
    public List<RepairEntity> queryList(Map<String, Object> map) {
        return repairMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return repairMapper.queryTotal(map);
    }

    @Override
    public int save(RepairEntity repair) {
        return repairMapper.insertSelective(repair);
    }

    @Override
    public int update(RepairEntity repair) {
        return repairMapper.updateByPrimaryKeySelective(repair);
    }

    @Override
    public int delete(Integer id) {
        return repairMapper.deleteByPrimaryKey((long)id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return repairMapper.deleteBatch(ids);
    }
}
