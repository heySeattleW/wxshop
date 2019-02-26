package com.platform.controller;

import com.alibaba.fastjson.JSON;
import com.platform.annotation.IgnoreAuth;
import com.platform.annotation.SysLog;
import com.platform.entity.SysOssEntity;
import com.platform.oss.CloudStorageConfig;
import com.platform.oss.OSSFactory;
import com.platform.service.SysConfigService;
import com.platform.service.SysOssService;
import com.platform.utils.*;
import com.platform.validator.ValidatorUtils;
import com.platform.validator.group.AliyunGroup;
import com.platform.validator.group.QcloudGroup;
import com.platform.validator.group.QiniuGroup;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FFmpegFrameGrabber;

import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

/**
 * 文件上传Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-25 12:13:26
 */
@RestController
@RequestMapping("sys/oss")
public class SysOssController {
    @Autowired
    private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = Constant.CLOUD_STORAGE_CONFIG_KEY;
    @Value("${image.dir}")
	private String imageDir;
    /**
     * 列表
     *
     * @param params 请求参数
     * @return R
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:oss:all")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SysOssEntity> sysOssList = sysOssService.queryList(query);
        int total = sysOssService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(sysOssList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 获取云存储配置信息
     *
     * @return R
     */
    @RequestMapping("/config")
    @RequiresPermissions("sys:oss:all")
    public R config() {
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

        return R.ok().put("config", config);
    }


    /**
     * 保存云存储配置信息
     *
     * @param config 配置信息
     * @return R
     */
    @SysLog("保存云存储配置信息")
    @RequestMapping("/saveConfig")
    @RequiresPermissions("sys:oss:all")
    public R saveConfig(@RequestBody CloudStorageConfig config) {
        //校验类型
        ValidatorUtils.validateEntity(config);

        if (config.getType() == Constant.CloudService.QINIU.getValue()) {
            //校验七牛数据
            ValidatorUtils.validateEntity(config, QiniuGroup.class);
        } else if (config.getType() == Constant.CloudService.ALIYUN.getValue()) {
            //校验阿里云数据
            ValidatorUtils.validateEntity(config, AliyunGroup.class);
        } else if (config.getType() == Constant.CloudService.QCLOUD.getValue()) {
            //校验腾讯云数据
            ValidatorUtils.validateEntity(config, QcloudGroup.class);
        }

        sysConfigService.updateValueByKey(KEY, JSON.toJSONString(config));

        return R.ok();
    }

    /**
     * 上传文件
     *
     * @param file 文件
     * @return R
     * @throws Exception 异常
     */
    @IgnoreAuth
    @RequestMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        //上传文件
        String url = OSSFactory.build().upload(file);

        //保存文件信息
        SysOssEntity ossEntity = new SysOssEntity();
        ossEntity.setUrl(url);
        ossEntity.setCreateDate(new Date());
        sysOssService.save(ossEntity);

        R r = new R();
        r.put("url", url);
        r.put("link", url);
        return r;
    }
    
    
    /**
     * 上传文件
     *
     * @param file 文件
     * @return R
     * @throws Exception 异常
     */
    @IgnoreAuth
    @RequestMapping("/uploadvideo")
    public R uploadVideo(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        try {
        System.out.println("begin upload video");
        //上传文件
        String url = OSSFactory.build().upload(file);

        //保存文件信息
        SysOssEntity ossEntity = new SysOssEntity();
        ossEntity.setUrl(url);
        ossEntity.setCreateDate(new Date());
        System.out.println("begin upload url="+url);
      
        sysOssService.save(ossEntity);
        String imgfileName=UUID.randomUUID().toString()+".jpg";
        fetchFrame(url,imageDir+"/"+imgfileName);
        
        
        //上传文件
        FileInputStream input=new FileInputStream(new File(imageDir+"/"+imgfileName));
      
        String url2 = OSSFactory.build().localupload(input,imageDir+"/"+imgfileName);
        System.out.println("begin upload url2="+url2);
        //保存文件信息
        SysOssEntity ossEntity2 = new SysOssEntity();
        ossEntity2.setUrl(url2);
        ossEntity2.setCreateDate(new Date());
        R r = new R();
        r.put("url", url);
        r.put("link", url);
        r.put("urlimg", url2);
        return r;
        }catch(Exception e) {
        	return R.error(e.getMessage());
        }
    }

    private  void fetchFrame(String videofile, String framefile)
            throws Exception {
        long start = System.currentTimeMillis();
        File targetFile = new File(framefile);
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videofile); 
        ff.start();
        int lenght = ff.getLengthInFrames();
        int i = 0;
        Frame f = null;
        while (i < lenght) {
            // 过滤前5帧，避免出现全黑的图片，依自己情况而定
            f = ff.grabFrame();
            if ((i > 5) && (f.image != null)) {
                break;
            }
            i++;
        }
        
        Java2DFrameConverter converter = new Java2DFrameConverter();
		BufferedImage image = converter.getBufferedImage(f);
        ImageIO.write(image, "jpg", targetFile);
        //ff.flush();
        ff.stop();
        System.out.println(System.currentTimeMillis() - start);
    }

 

    /**
     * 删除图片
     *
     * @param ids 主键集
     * @return R
     */
    @SysLog("删除图片")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:oss:all")
    public R delete(@RequestBody Long[] ids) {
        sysOssService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查询所有列表
     *
     * @param params 请求参数
     * @return R
     */
    @RequestMapping("/queryAll")
    public List<String> queryAll(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<SysOssEntity> sysOssList = sysOssService.queryList(params);

        List<String> list = new ArrayList<>();
        if (null != sysOssList && sysOssList.size() > 0) {
            for (SysOssEntity item : sysOssList) {
                list.add(item.getUrl());
            }
        }
        return list;
    }
}
