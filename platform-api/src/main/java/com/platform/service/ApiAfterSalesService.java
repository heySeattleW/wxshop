package com.platform.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiAfterSalesMapper;
import com.platform.dao.ApiRepairMapper;
import com.platform.entity.AfterSalesVo;
import com.platform.entity.RepairVo;

@Service
public class ApiAfterSalesService {
	@Autowired
	private ApiAfterSalesMapper apiAfterSalesMapper;
	@Autowired
	public ApiRepairMapper apiRepairMapper;
	
	public List<AfterSalesVo> queryList(Map params){
		return apiAfterSalesMapper.queryList(params);
	}
	
	public int queryTotal(Map params) {
		return apiAfterSalesMapper.queryTotal(params);
	}
	public AfterSalesVo detail(Integer id){
		AfterSalesVo afterSalesVo= apiAfterSalesMapper.queryObject(id);
		Map params=new HashMap();
		params.put("aftersalesId", afterSalesVo.getId());
		List<RepairVo> repairList=apiRepairMapper.queryList(params);
		afterSalesVo.setRepairList(repairList);
		return  afterSalesVo;
	}
}
