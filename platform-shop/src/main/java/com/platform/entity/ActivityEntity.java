package com.platform.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 实体
 * 表名 nideshop_ activity
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-10-29 13:56:24
 */
public class  ActivityEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //
    private String name;
    //
    private Date startTime;
    //
    private Date endTime;
    //
    private Integer sortOrder;

    private List<ActivityGoodsEntity> activityGoodsList;
    private List<ActivityGoodsEntity> delActivityGoodsList;
    private List<ActivityConponEntity> activityConponEntityList;
    private	List<Integer> selectCouponList;
   
  
    
    
    
    
    public List<ActivityGoodsEntity> getDelActivityGoodsList() {
		return delActivityGoodsList;
	}

	public void setDelActivityGoodsList(List<ActivityGoodsEntity> delActivityGoodsList) {
		this.delActivityGoodsList = delActivityGoodsList;
	}

	public List<Integer> getSelectCouponList() {
		return selectCouponList;
	}

	public void setSelectCouponList(List<Integer> selectCouponList) {
		this.selectCouponList = selectCouponList;
	}

	

	public List<ActivityGoodsEntity> getActivityGoodsList() {
		return activityGoodsList;
	}

	public void setActivityGoodsList(List<ActivityGoodsEntity> activityGoodsList) {
		this.activityGoodsList = activityGoodsList;
	}

	public List<ActivityConponEntity> getActivityConponEntityList() {
		return activityConponEntityList;
	}

	public void setActivityConponEntityList(List<ActivityConponEntity> activityConponEntityList) {
		this.activityConponEntityList = activityConponEntityList;
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
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取：
     */
    public Integer getSortOrder() {
        return sortOrder;
    }
}
