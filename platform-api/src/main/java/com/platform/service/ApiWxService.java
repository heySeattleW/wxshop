package com.platform.service;

import java.io.InputStream;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.platform.entity.TicketVo;
import com.platform.entity.TokenVo;
import com.platform.util.ApiUserUtils;
import com.platform.utils.ResourceUtil;

@Service
public class ApiWxService {
	private Logger logger = Logger.getLogger(getClass());
	public static TokenVo tokenVo;
	public static TicketVo ticketVo;
	@Autowired
    private RestTemplate restTemplate;
	public String getGzhToken() {
			if(tokenVo!=null) {
				long time=new Date().getTime();
				if(tokenVo.getExpires_time()>time)
					return tokenVo.getAccess_token();
			}
	        String requestUrl = ApiUserUtils.getToken("client_credential", ResourceUtil.getConfigByName("gzh.appId"),  ResourceUtil.getConfigByName("gzh.secret"));      
	        logger.info("》》》组合token为：" + requestUrl);
	        String res = restTemplate.getForObject(requestUrl, String.class);
	        logger.info("res：" +res);
	        TokenVo tokenVo = JSON.parseObject(res,TokenVo.class);
	        if(tokenVo!=null&&tokenVo.getAccess_token()!=null) {	
	        	long time=new Date().getTime()+7000*1000;
	        	
	        	this.tokenVo=tokenVo;
	        	this.tokenVo.setExpires_time(time);
	        	return tokenVo.getAccess_token();
	        }
	        return null;
	}
	
	public String getGzhTicket() {
		if(this.ticketVo!=null) {
			long time=new Date().getTime();
			System.out.println(ticketVo.getExpires_time()+" "+time);
			if(ticketVo.getExpires_time()>time)
				return ticketVo.getTicket();
		}
		String token=getGzhToken();
		if(token==null) {
			return null;
		}
        String requestUrl = ApiUserUtils.getToken(token );
        String res = restTemplate.getForObject(requestUrl, String.class);
        logger.info("res：" +res);
        TicketVo ticketVo = JSON.parseObject(res,TicketVo.class);
        if(ticketVo!=null&&ticketVo.getTicket()!=null) {	
        	long time=new Date().getTime()+7000*1000;
        	
        	this.ticketVo=ticketVo;
        	this.ticketVo.setExpires_time(time);
        	return ticketVo.getTicket();
        }
        return null;
	}
	/**
	 * 获取临时素材
	 */
	public InputStream getMedia(String mediaId) {
		String token=getGzhToken();
		if(token==null) {
			return null;
		}
		String requestUrl = ApiUserUtils.getMediaImg(token,mediaId );
	    InputStream is = null;
	    try {
	        
	    	   ResponseEntity<Resource> entity = restTemplate.postForEntity(requestUrl, null,Resource.class);
	    	   is= entity.getBody().getInputStream();
	          
	     } catch (Exception e) {
	           e.printStackTrace();
	    }
	    return is;
	}
	
}
