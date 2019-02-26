package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_evaluate
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-01 10:36:46
 */
public class EvaluateEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //
    private String name;
    //
    private String picUrl;
    //
    private String videoUrl;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 获取：
     */
    public String getPicUrl() {
        return picUrl;
    }
    /**
     * 设置：
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * 获取：
     */
    public String getVideoUrl() {
        return videoUrl;
    }
}
