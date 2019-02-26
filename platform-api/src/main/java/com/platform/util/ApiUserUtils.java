package com.platform.util;

import com.platform.utils.ResourceUtil;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-08-11 08:58<br>
 * 描述: ApiUserUtils <br>
 */
public class ApiUserUtils {

    //替换字符串
    public static String getCode(String APPID, String REDIRECT_URI, String SCOPE) {
        return String.format(ResourceUtil.getConfigByName("wx.getCode"), APPID, REDIRECT_URI, SCOPE);
    }

    //替换字符串
    public static String getWebAccess(String CODE) {
        return String.format(ResourceUtil.getConfigByName("wx.webAccessTokenhttps"),
                ResourceUtil.getConfigByName("wx.appId"),
                ResourceUtil.getConfigByName("wx.secret"),
                CODE);
    }

    
    //替换字符串
    public static String getGzhWebAccess(String CODE) {
        return String.format(ResourceUtil.getConfigByName("wx.getToken"),
                ResourceUtil.getConfigByName("gzh.appId"),
                ResourceUtil.getConfigByName("gzh.secret"),
                CODE);
    }
    //替换字符串
    
    public static String getUserMessage(String access_token, String openid) {
        return String.format(ResourceUtil.getConfigByName("wx.userMessage"), access_token, openid);
    }
    //替换字符串
    public static String getToken(String grant_type,String appid, String secret) {
        return String.format(ResourceUtil.getConfigByName("wx.token"),grant_type, appid, secret);
    }
    //替换字符串
    public static String getToken(String token) {
        return String.format(ResourceUtil.getConfigByName("wx.ticket"),token);
    }
    //替换字符串
    public static String getWxacode(String token) {
        return String.format(ResourceUtil.getConfigByName("wx.wxacode"),token);
    }
    //获取上传的图片
    public static String getMediaImg(String token,String mediaId) {
    	 return String.format(ResourceUtil.getConfigByName("wx.mediaimg"),token,mediaId);
    }
}