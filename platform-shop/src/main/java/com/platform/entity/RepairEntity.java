package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_repair
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-21 09:25:22
 */
public class RepairEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //
    private Integer aftersalesId;
    //
    private Date repairTime;
    //
    private String info;
    
    private	Integer index;
    

    public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
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
    public void setAftersalesId(Integer aftersalesId) {
        this.aftersalesId = aftersalesId;
    }

    /**
     * 获取：
     */
    public Integer getAftersalesId() {
        return aftersalesId;
    }
    /**
     * 设置：
     */
    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    /**
     * 获取：
     */
    public Date getRepairTime() {
        return repairTime;
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
