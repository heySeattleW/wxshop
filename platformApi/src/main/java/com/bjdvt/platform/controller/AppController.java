package com.bjdvt.platform.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.platform.annotation.IgnoreAuth;
import com.platform.dao.ApiTokenMapper;
import com.platform.util.ApiBaseAction;
import com.platform.util.ApiUserUtils;
import com.platform.util.wechat.WechatUtil;
import com.platform.utils.MapUtils;
import com.platform.utils.ResourceUtil;
import com.platform.utils.XmlUtil;
import com.qiniu.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.bjdvt.platform.model.App;
import com.bjdvt.platform.model.Page;
import com.bjdvt.platform.service.AppServiceImp;


@Api(tags = "收货地址")
@RestController
@RequestMapping(value = "/app",produces = "application/json;charset=UTF-8")
public class AppController  extends ApiBaseAction{

	@Autowired
	AppServiceImp appServiceImp;
	@Autowired
	private RestTemplate restTemplate;

	/*
	@RequestMapping("/save")
	public String save(@RequestBody App app) {
		appServiceImp.save(app);
		System.out.println(app);
		return "success";
	}*/
	
	@IgnoreAuth
	@RequestMapping("/getapp/{id}")
	public Object getApp(@PathVariable("id") String appId) {
		//String appId="appId";
		App app=appServiceImp.getApp(appId);
		return toResponsSuccess(app);	
	}
	@IgnoreAuth
	@RequestMapping("/page")
	public Object getPage() {
		//String appId="appId";
		String appId = request.getHeader("appId");
		App app=appServiceImp.getApp(appId);
		return toResponsSuccess(app);	
	}
	
	@IgnoreAuth
	@RequestMapping("/save")
	public Object save(HttpServletRequest request) {
		BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            System.out.println(sb.toString());
            App app=JSON.parseObject(sb.toString(),App.class);
            appServiceImp.save(app);
            br.close();
           
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return toResponsFail(e.getLocalizedMessage());
        }

		 return toResponsSuccess("success");
				
	}
	@IgnoreAuth
	@RequestMapping("/page/{id}")
	public Object page(@PathVariable("id")String  pageId) {
		
		Page page= appServiceImp.getPage(pageId);	
		page.setSections(page.getComponents());
		page.setNavigationBarTitleText(page.getName());
		page.setComponents(null);
		return toResponsSuccess(page);
	}
	
	
	@RequestMapping("/list")
	public Object listApp() {
		 return toResponsSuccess(appServiceImp.searchApps());
		
	}
	@RequestMapping("/preview")
	public Object preView() {
		try {
		//获取token
			 Map<Object, Object> paramtoken = new TreeMap<Object, Object>();	
			 String requestUrl = ApiUserUtils.geToken("client_credential",  ResourceUtil.getConfigByName("wx.appId"), ResourceUtil.getConfigByName("wx.secret"));
			 String res = restTemplate.getForObject(requestUrl, String.class);
			 JSONObject sessionData = JSON.parseObject(res);
			 if (null == sessionData || StringUtils.isNullOrEmpty(sessionData.getString("access_token"))) {
		            return toResponsFail("登录失败");
		        }
			 String access_token=sessionData.getString("access_token");
			 if(access_token!=null) {
				 logger.info("access_token：" + access_token);
				 Map<String, Object> parame = new TreeMap<String, Object>();
				
				 parame.put("page", "pages/index/index");
		         parame.put("width", 430);
		         parame.put("scene","11111");
		        
		         
		         String tokenrequestUrl = ApiUserUtils.getWxacode(access_token);
		         
		         byte[] codeImage= WechatUtil.requestImage(tokenrequestUrl,parame );
		         logger.info("codeImage:" + codeImage.length);
		         HttpHeaders headers = new HttpHeaders();// 设置一个head
		 		headers.setContentDispositionFormData("attachment", "wxcode.png");// 文件的属性，也就是文件叫什么吧
		 		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);// 内容是字节流
		 		//headers.add("Content-Disposition", "attchement;filename=" + image.getImageUrl());
		 		return new ResponseEntity<byte[]>(codeImage, headers, HttpStatus.OK);
			 }
			 return toResponsFail("预览失败,access_token获取失败" );
		}
		catch(Exception e) {
			 return toResponsFail("预览失败," + e.getMessage());
		}
	}
}
