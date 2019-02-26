package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.AftersalesMapper;
import com.platform.dao.RepairMapper;
import com.platform.entity.AftersalesEntity;
import com.platform.entity.RepairEntity;
import com.platform.entity.example.RepairExample;
import com.platform.service.AftersalesService;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-21 09:28:36
 */
@Service("aftersalesService")
public class AftersalesServiceImpl implements AftersalesService {
    @Autowired
    private AftersalesMapper aftersalesMapper;
    @Autowired
    private RepairMapper repairMapper;
    @Override
    public AftersalesEntity queryObject(Integer id) {
    	AftersalesEntity aftersalesEntity= aftersalesMapper.selectByPrimaryKey((long)id);
        
    		 RepairExample repairExample=new RepairExample();
    		 repairExample.createCriteria().andAftersalesIdEqualTo(aftersalesEntity.getId());
    		 List list=repairMapper.selectByExample(repairExample);
    		 aftersalesEntity.setRepairList(list);
    		 
    	 return aftersalesEntity;
    }

    @Override
    public List<AftersalesEntity> queryList(Map<String, Object> map) {
    	 List<AftersalesEntity>  queryList=aftersalesMapper.queryList(map);
    	
    	 return queryList;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return aftersalesMapper.queryTotal(map);
    }

    @Override
    public int save(AftersalesEntity aftersales) {
    	aftersalesMapper.insert(aftersales);
    	updateRepair(aftersales);
        return 1;
    }

    @Override
    public int update(AftersalesEntity aftersales) {
    	
    	updateRepair(aftersales);
        return aftersalesMapper.updateByPrimaryKeySelective(aftersales);
    }
    
    private void updateRepair(AftersalesEntity aftersales) {
    	if(aftersales.getDeleteRepairList()!=null) {
    		
    		for(RepairEntity repair:aftersales.getDeleteRepairList()) {
    			repairMapper.deleteByPrimaryKey((long)repair.getId());
    		}
    	}
    	if(aftersales.getRepairList()!=null) {
    		for(RepairEntity repair:aftersales.getRepairList()) {
    				if(repair.getId()!=null) {
    					repairMapper.updateByPrimaryKey(repair);
    				}else {
    					repair.setAftersalesId(aftersales.getId());
    					repairMapper.insert(repair);
    				}
    		}
    	}
    }

    @Override
    public int delete(Integer id) {
        return aftersalesMapper.deleteByPrimaryKey((long)id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return aftersalesMapper.deleteBatch(ids);
    }
}
