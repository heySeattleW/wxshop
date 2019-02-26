package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiCouponMapper;
import com.platform.dao.ApiEvaluateMapper;
import com.platform.entity.EvaluateVo;
@Service
public class ApiEvaluateService {

	 @Autowired
	 private ApiEvaluateMapper apiEvaluateMapper;
	 
	 public List<EvaluateVo> queryList(Map params){
		 return apiEvaluateMapper.queryList(params);
	 }
	 
	 public int queryTotal(Map params){
		 return apiEvaluateMapper.queryTotal(params);
	 }
	 
	 public EvaluateVo queryObject(Map params){
		 return apiEvaluateMapper.queryObject(params);
	 }
}
