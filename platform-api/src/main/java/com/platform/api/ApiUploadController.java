package com.platform.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.Base64;
import com.platform.annotation.IgnoreAuth;
import com.platform.oss.OSSFactory;
import com.platform.service.ApiWxService;
import com.platform.util.ApiBaseAction;
import com.platform.utils.RRException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-09-08 13:20<br>
 * 描述: ApiUploadController <br>
 */
@Api(tags = "上传")
@RestController
@RequestMapping("/api/upload")
public class ApiUploadController extends ApiBaseAction {

	private	 ApiWxService apiWxService;
    /**
     * 上传文件
     */
	@ApiOperation(value = "上传文件")
    @IgnoreAuth
    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        //上传文件
        String url = OSSFactory.build().upload(file);
        return toResponsSuccess(url);
    }
	/**
     * 上传文件
     */
	@ApiOperation(value = "上传文件")
    @IgnoreAuth
    @PostMapping("/gzhUpload")
    public Object upload() throws Exception {
		 JSONObject jsonParam = getJsonRequest();
		 JSONArray pics = jsonParam.getJSONArray("pics");
		 String[] urls=new String[pics.size()];
		 for(int i=0;i<pics.size();i++) {
			 //上传文件
			 String mediaId=pics.get(i).toString();
			 InputStream inputStream=apiWxService.getMedia(mediaId);
			  ByteArrayOutputStream baos = new ByteArrayOutputStream();
	           //<2>创建缓存大小
	           byte[] buffer = new byte[1024]; // 1KB
	           //每次读取到内容的长度
	           int len = -1;
	           //<3>开始读取输入流中的内容
	           while ((len = inputStream.read(buffer)) != -1) { //当等于-1说明没有数据可以读取了
	               baos.write(buffer, 0, len);   //把读取到的内容写到输出流中
	           }
			
		      String url = OSSFactory.build().upload(baos.toByteArray());
		      urls[i]=url;
		      System.out.println(url);
		 }
       
        return toResponsSuccess(urls);
    }
	
	

	
}