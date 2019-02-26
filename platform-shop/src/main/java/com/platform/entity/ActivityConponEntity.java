package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_ activity_conpon
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-10-29 13:56:24
 */
public class  ActivityConponEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //
    private Integer activityId;
    //
    private Integer couponId;

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
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取：
     */
    public Integer getActivityId() {
        return activityId;
    }
    /**
     * 设置：
     */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /**
     * 获取：
     */
    public Integer getCouponId() {
        return couponId;
    }
}
