package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 app
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-09-25 17:33:58
 */
public class AppEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private String id;
    //
    private String name;
    //
    private String appUserId;
    //
    private String createTime;
    //
    private String type;
    //
    private String indexPage;

    /**
     * 设置：
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public String getId() {
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
    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }

    /**
     * 获取：
     */
    public String getAppUserId() {
        return appUserId;
    }
    /**
     * 设置：
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：
     */
    public String getCreateTime() {
        return createTime;
    }
    /**
     * 设置：
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：
     */
    public String getType() {
        return type;
    }
    /**
     * 设置：
     */
    public void setIndexPage(String indexPage) {
        this.indexPage = indexPage;
    }

    /**
     * 获取：
     */
    public String getIndexPage() {
        return indexPage;
    }
}
