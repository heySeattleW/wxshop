package com.platform.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.platform.annotation.IgnoreAuth;
import com.platform.entity.FullUserInfo;
import com.platform.entity.UserInfo;
import com.platform.entity.UserVo;
import com.platform.service.ApiUserService;
import com.platform.service.TokenService;
import com.platform.util.ApiBaseAction;
import com.platform.util.ApiUserUtils;
import com.platform.util.CommonUtil;
import com.platform.utils.CharUtil;
import com.platform.utils.R;
import com.platform.validator.Assert;
import com.qiniu.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * API登录授权
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:31
 */
@Api(tags = "API登录授权接口")
@RestController
@RequestMapping("/api/auth")
public class ApiAuthController extends ApiBaseAction {
    private Logger logger = Logger.getLogger(getClass());
    @Autowired
    private ApiUserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private RestTemplate restTemplate;
    private final String token = "eshopdoerafer";
    
    @ApiOperation(value = "验证token")
    @IgnoreAuth
    @GetMapping("check_token")
    public String checkToken(@RequestParam(value = "signature") String signature,
            @RequestParam(value = "timestamp") String timestamp,
            @RequestParam(value = "nonce")String nonce,
            @RequestParam(value = "echostr")String echostr
            ) {
    	 
         ArrayList<String> array = new ArrayList<String>();
         array.add(signature);
         array.add(timestamp);
         array.add(nonce);
      
         //排序
         String sortString = sort(token, timestamp, nonce);
         //加密
         String mytoken = CommonUtil.SHA1(sortString);
         //校验签名
         if (mytoken != null && mytoken != "" && mytoken.equals(signature)) {
             return echostr;
         } else {
            return "签名校验失败";
         }
    }
    /**
     * 排序方法
     * @param token
     * @param timestamp
     * @param nonce
     * @return
     */
    private  String sort(String token, String timestamp, String nonce) {
        String[] strArray = { token, timestamp, nonce };
        Arrays.sort(strArray);
     
        StringBuilder sbuilder = new StringBuilder();
        for (String str : strArray) {
            sbuilder.append(str);
        }
     
        return sbuilder.toString();
    }
    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping("login")
    @ApiOperation(value = "登录接口")
    public R login(String mobile, String password) {
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");

        //用户登录
        long userId = userService.login(mobile, password);
        //生成token
        Map<String, Object> map = tokenService.createToken(userId,Integer.valueOf(1));

        return R.ok(map);
    }
    
    /**
     * 登录
     */
    @ApiOperation(value = "登录")
    @IgnoreAuth
    @PostMapping("login_by_wx")
    public Object loginByWx() {
    	 JSONObject jsonParam = this.getJsonRequest();
         FullUserInfo fullUserInfo = null;
         String code = "";
         if (!StringUtils.isNullOrEmpty(jsonParam.getString("code"))) {
             code = jsonParam.getString("code");
         }
    	  Map<String, Object> resultObj = new HashMap<String, Object>();
    	  UserVo userVo =userService.queryObject(Long.valueOf(code));
    	Map<String, Object> tokenMap = tokenService.createToken(userVo.getUserId(),Integer.valueOf(1));
    	  String token = MapUtils.getString(tokenMap, "token");
    	  UserInfo userInfo=new UserInfo();
    	 resultObj.put("token", token);
         resultObj.put("userInfo", userInfo);
         resultObj.put("userId", userVo.getUserId());
         return toResponsSuccess(resultObj);
    }

    /**
     * 登录
     */
    @ApiOperation(value = "公众号登录")
    @IgnoreAuth
    @PostMapping("login_by_wxgzh")
    public Object loginByWxgzh() {
        JSONObject jsonParam = this.getJsonRequest();
        String code = "";
        
        if (!StringUtils.isNullOrEmpty(jsonParam.getString("code"))) {
            code = jsonParam.getString("code");
        }
       
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
      
        Map<String, Object> resultObj = new HashMap<String, Object>();
        //
       
        String requestUrl =null;
        requestUrl = ApiUserUtils.getGzhWebAccess(code);
      
        logger.info("》》》组合token为：" + requestUrl);
        String res = restTemplate.getForObject(requestUrl, String.class);
        logger.info("res：" +res);
        JSONObject sessionData = JSON.parseObject(res);

        if (null == sessionData || StringUtils.isNullOrEmpty(sessionData.getString("openid"))) {
            return toResponsFail("登录失败");
        }
        String requestUrl2 = ApiUserUtils.getUserMessage(sessionData.getString("access_token"),sessionData.getString("openid"));
   	   logger.info("》》》组合userInfo为1111111：" + requestUrl2);
   	 String resuserInfo =restTemplate.getForObject(requestUrl2, String.class);
       
        
        logger.info("sessionData.getString(\"session_key\")="+sessionData.getString("session_key"));
       
        Date nowTime = new Date();
        UserVo userVo = userService.queryByOpenId(sessionData.getString("openid"));
        if (null == userVo) {
        	
        	 
        	 System.out.println("resuserInfo="+resuserInfo);
        	 UserInfo userInfo=JSON.parseObject(resuserInfo,UserInfo.class);
        	 if(userInfo.getNickName()==null) {
        		 return toResponsFail("获取用户失败");
        	 }
              //验证用户信息完整性
            userVo = new UserVo();
            userVo.setUsername(userInfo.getNickName()+"_" + CharUtil.getRandomString(12));
            userVo.setPassword(sessionData.getString("openid"));
            userVo.setRegister_time(nowTime);
            userVo.setRegister_ip(this.getClientIp());
            userVo.setLast_login_ip(userVo.getRegister_ip());
            userVo.setLast_login_time(userVo.getRegister_time());
            userVo.setWeixin_openid(sessionData.getString("openid"));
            userVo.setAvatar(userInfo.getHeadimgurl());
            userInfo.setAvatarUrl(userInfo.getHeadimgurl());
            userInfo.setGender(userInfo.getSex());
            userVo.setGender(userInfo.getSex()); // //性别 0：未知、1：男、2：女
            userVo.setNickname(userInfo.getNickName());
            userService.save(userVo);
        } else {
            userVo.setLast_login_ip(this.getClientIp());
            userVo.setLast_login_time(nowTime);
            userService.update(userVo);
        }
        UserInfo userInfo=new UserInfo();
        userInfo.setAvatarUrl(userVo.getAvatar());
        userInfo.setNickName(userVo.getNickname());
        userInfo.setGender(userVo.getGender());

        Map<String, Object> tokenMap = tokenService.createToken(userVo.getUserId(),Integer.valueOf(0));
        String token = MapUtils.getString(tokenMap, "token");


        resultObj.put("token", token);
        resultObj.put("userInfo", userInfo);
        resultObj.put("userId", userVo.getUserId());
        return toResponsSuccess(resultObj);
    }
    /**
     * 登录
     */
    @ApiOperation(value = "登录")
    @IgnoreAuth
    @PostMapping("login_by_weixin")
    public Object loginByWeixin() {
        JSONObject jsonParam = this.getJsonRequest();
        FullUserInfo fullUserInfo = null;
        String code = "";

        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        if (!StringUtils.isNullOrEmpty(jsonParam.getString("code"))) {
            code = jsonParam.getString("code");
        }
       
        Integer wxgzh = null;
        
        if (!StringUtils.isNullOrEmpty(jsonParam.getString("wxgzh"))) {
        	wxgzh = jsonParam.getInteger("wxgzh");
        }
       
        if (null != jsonParam.get("userInfo")) {
            fullUserInfo = jsonParam.getObject("userInfo", FullUserInfo.class);
        }

        Map<String, Object> resultObj = new HashMap<String, Object>();
        //
        UserInfo userInfo = fullUserInfo.getUserInfo();
        String requestUrl =null;
        //获取openid
        if(wxgzh==null) {
        	 requestUrl = ApiUserUtils.getWebAccess(code);//通过自定义工具类组合出小程序需要的登录凭证 code
        }else {
        	 requestUrl = ApiUserUtils.getGzhWebAccess(code);
        }
        	logger.info("》》》组合token为：" + requestUrl);
        String res = restTemplate.getForObject(requestUrl, String.class);
        logger.info("res：" +res);
        JSONObject sessionData = JSON.parseObject(res);

        if (null == sessionData || StringUtils.isNullOrEmpty(sessionData.getString("openid"))) {
            return toResponsFail("登录失败");
        }
        //验证用户信息完整性
        logger.info("fullUserInfo.getRawData()="+fullUserInfo.getRawData());
        logger.info("sessionData.getString(\"session_key\")="+sessionData.getString("session_key"));
        String sha1 = CommonUtil.getSha1(fullUserInfo.getRawData() + sessionData.getString("session_key"));
        logger.info("sha1="+sha1);
        logger.info("fullUserInfo.getSignature()="+fullUserInfo.getSignature());
        if (!fullUserInfo.getSignature().equals(sha1)) {
            return toResponsFail("验证用户信息完整性失败");
        }
        Date nowTime = new Date();
        UserVo userVo = userService.queryByOpenId(sessionData.getString("openid"));
        if (null == userVo) {
            userVo = new UserVo();
            userVo.setUsername(userInfo.getNickName()+"_" + CharUtil.getRandomString(12));
            userVo.setPassword(sessionData.getString("openid"));
            userVo.setRegister_time(nowTime);
            userVo.setRegister_ip(this.getClientIp());
            userVo.setLast_login_ip(userVo.getRegister_ip());
            userVo.setLast_login_time(userVo.getRegister_time());
            userVo.setWeixin_openid(sessionData.getString("openid"));
            userVo.setAvatar(userInfo.getAvatarUrl());
            userVo.setGender(userInfo.getGender()); // //性别 0：未知、1：男、2：女
            userVo.setNickname(userInfo.getNickName());
            userService.save(userVo);
        } else {
            userVo.setLast_login_ip(this.getClientIp());
            userVo.setLast_login_time(nowTime);
            userService.update(userVo);
        }

        Map<String, Object> tokenMap = tokenService.createToken(userVo.getUserId(),Integer.valueOf(0));
        String token = MapUtils.getString(tokenMap, "token");

        if (null == userInfo || StringUtils.isNullOrEmpty(token)) {
            return toResponsFail("登录失败");
        }

        resultObj.put("token", token);
        resultObj.put("userInfo", userInfo);
        resultObj.put("userId", userVo.getUserId());
        return toResponsSuccess(resultObj);
    }
}
