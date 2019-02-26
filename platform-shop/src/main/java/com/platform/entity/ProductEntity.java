package com.platform.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * 实体
 * 表名 nideshop_product
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-30 14:31:21
 */
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //商品Id
    private Integer goodsId;
    //商品规格ids
    private String goodsSpecificationIds;
    //商品序列号
    private String goodsSn;
    //商品库存
    private Integer goodsNumber;
    private Integer repairMonth;
    //零售价格
    private BigDecimal retailPrice;
    //市场价格
    private BigDecimal marketPrice;

    private List<Integer> specificationList;
    
    private  List<GoodsAttributeEntity>   attributeList;
    
    


    

	public Integer getRepairMonth() {
		return repairMonth;
	}

	public void setRepairMonth(Integer repairMonth) {
		this.repairMonth = repairMonth;
	}

	public List<Integer> getSpecificationList() {
		return specificationList;
	}

	public void setSpecificationList(List<Integer> specificationList) {
		this.specificationList = specificationList;
	}

	public List<GoodsAttributeEntity> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(List<GoodsAttributeEntity> attributeList) {
		this.attributeList = attributeList;
	}

	/**
     * 翻译用字段
     */
    //商品
    private String goodsName;
    private String specificationValue;

    public String getSpecificationValue() {
        return specificationValue;
    }

    public void setSpecificationValue(String specificationValue) {
        this.specificationValue = specificationValue;
    }

    /**
     * 设置：主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：商品Id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取：商品Id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置：商品规格ids
     */
    public void setGoodsSpecificationIds(String goodsSpecificationIds) {
        this.goodsSpecificationIds = goodsSpecificationIds;
    }

    /**
     * 获取：商品规格ids
     */
    public String getGoodsSpecificationIds() {
        return goodsSpecificationIds;
    }

    /**
     * 设置：商品序列号
     */
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    /**
     * 获取：商品序列号
     */
    public String getGoodsSn() {
        return goodsSn;
    }

    /**
     * 设置：商品库存
     */
    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    /**
     * 获取：商品库存
     */
    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    /**
     * 设置：零售价格
     */
    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 获取：零售价格
     */
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
