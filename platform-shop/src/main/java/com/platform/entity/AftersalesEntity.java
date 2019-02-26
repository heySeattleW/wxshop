package com.platform.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 实体
 * 表名 nideshop_aftersales
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-21 09:28:36
 */
public class AftersalesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //
    private Integer productId;
    //
    private Date buyTime;
    //
    private String goodsSpecifitionNames;
    //
    private Integer goodsId;
    //
    private Integer orderId;
    //
    private String productSn;
    //
    private String orderSn;
    private	String goodsName;
    private Integer userId;
    private	String userName;
    //
    private Date repairEndTime;
    private	List<RepairEntity>  repairList;
    private	List<RepairEntity>  deleteRepairList;

    
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取：
     */
    public Integer getProductId() {
        return productId;
    }
    /**
     * 设置：
     */
    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    /**
     * 获取：
     */
    public Date getBuyTime() {
        return buyTime;
    }
    
    public String getGoodsSpecifitionNames() {
		return goodsSpecifitionNames;
	}

	public void setGoodsSpecifitionNames(String goodsSpecifitionNames) {
		this.goodsSpecifitionNames = goodsSpecifitionNames;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
     * 设置：
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取：
     */
    public Integer getGoodsId() {
        return goodsId;
    }
    /**
     * 设置：
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取：
     */
    public Integer getOrderId() {
        return orderId;
    }
    /**
     * 设置：
     */
    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    /**
     * 获取：
     */
    public String getProductSn() {
        return productSn;
    }
    /**
     * 设置：
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * 获取：
     */
    public String getOrderSn() {
        return orderSn;
    }
    /**
     * 设置：
     */
    public void setRepairEndTime(Date repairEndTime) {
        this.repairEndTime = repairEndTime;
    }

    /**
     * 获取：
     */
    public Date getRepairEndTime() {
        return repairEndTime;
    }

	public List<RepairEntity> getRepairList() {
		if(repairList==null) {
			return new ArrayList();
		}
		return repairList;
	}

	public void setRepairList(List<RepairEntity> repairList) {
		this.repairList = repairList;
	}

	public List<RepairEntity> getDeleteRepairList() {
		if(deleteRepairList==null) {
			return new ArrayList();
		}
		return deleteRepairList;
	}

	public void setDeleteRepairList(List<RepairEntity> deleteRepairList) {
		this.deleteRepairList = deleteRepairList;
	}

	

    
}
