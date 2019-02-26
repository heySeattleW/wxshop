package com.platform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_ activity_goods
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-10-29 13:56:24
 */
public class  ActivityGoodsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //
    private Integer activityId;
    //
    private Integer productId;
  
    
 
	//
    private BigDecimal price;
    private BigDecimal activityPrice;
    private String goodsName;
    private String goodsSpecificationIds;
    private String goodsSpecificationName;
    private	String picUrl;
    
    
    
    public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public BigDecimal getActivityPrice() {
		return activityPrice;
	}

	public void setActivityPrice(BigDecimal activityPrice) {
		this.activityPrice = activityPrice;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsSpecificationIds() {
		return goodsSpecificationIds;
	}

	public void setGoodsSpecificationIds(String goodsSpecificationIds) {
		this.goodsSpecificationIds = goodsSpecificationIds;
	}

	public String getGoodsSpecificationName() {
		return goodsSpecificationName;
	}

	public void setGoodsSpecificationName(String goodsSpecificationName) {
		this.goodsSpecificationName = goodsSpecificationName;
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
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取：
     */
    public BigDecimal getPrice() {
        return price;
    }
}
