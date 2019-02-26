package com.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.ApiGoodsSpecificationMapper;
import com.platform.dao.ApiInfoMapper;
import com.platform.entity.InfoVo;
@Service
public class ApiInfoService {
	 @Autowired
	    private ApiInfoMapper apiInfoMapper;
	
	 public List<InfoVo> queryList(Map params){
		 return apiInfoMapper.queryList(params);
	 }
	 
}
