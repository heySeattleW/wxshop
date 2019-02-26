package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_timegoods
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-10-15 11:08:36
 */
public class TimegoodsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //
    private String goodsId;
    //
    private Date startTime;
    //
    private Date endTime;
    //
    private Float rebate;
    //
    private String appId;

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
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取：
     */
    public String getGoodsId() {
        return goodsId;
    }
    /**
     * 设置：
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取：
     */
    public Date getStartTime() {
        return startTime;
    }
    /**
     * 设置：
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取：
     */
    public Date getEndTime() {
        return endTime;
    }
    /**
     * 设置：
     */
    public void setRebate(Float rebate) {
        this.rebate = rebate;
    }

    /**
     * 获取：
     */
    public Float getRebate() {
        return rebate;
    }
    /**
     * 设置：
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 获取：
     */
    public String getAppId() {
        return appId;
    }
}
