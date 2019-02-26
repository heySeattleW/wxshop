package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_info
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-21 08:51:39
 */
public class InfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //
    private Integer userId;
    //
    private Date createTime;
    //
    private String info;
    private	String name;
    private String userName;
    
    

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * 设置：
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 获取：
     */
    public String getInfo() {
        return info;
    }
}
