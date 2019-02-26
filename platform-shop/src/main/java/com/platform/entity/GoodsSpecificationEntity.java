package com.platform.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 商品对应规格表值表实体
 * 表名 nideshop_goods_specification
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-31 11:15:55
 */
public class GoodsSpecificationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //商品
    private Integer goodsId;
    //规范Id
    private Integer specificationId;
    //规范说明
    private String value;
    //规范图片
    private String picUrl;
    private	Integer productId;
    
    private	String name;
    
    //前台js 定位
    private	Integer index;
    
    private	Integer isDelete=0;
    
    
    public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getName() {
		return specificationName+":"+value;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
     * 翻译用字段
     */
    
    //商品
    private String goodsName;
    public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	//规范
    private String specificationName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
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
     * 设置：商品
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取：商品
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置：规范Id
     */
    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }

    /**
     * 获取：规范Id
     */
    public Integer getSpecificationId() {
        return specificationId;
    }

    /**
     * 设置：规范说明
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取：规范说明
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置：规范图片
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 获取：规范图片
     */
    public String getPicUrl() {
        return picUrl;
    }
}
