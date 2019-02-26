package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.platform.dao.ApiRepairMapper;
import com.platform.entity.RepairVo;

@Service
public class ApiRepairService {

	public ApiRepairMapper apiRepairMapper;
	
	public List<RepairVo> queryList(Map params){
		return apiRepairMapper.queryList(params);
	}
	
}
