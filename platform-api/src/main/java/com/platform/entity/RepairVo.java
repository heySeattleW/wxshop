package com.platform.entity;

import java.util.Date;

public class RepairVo {

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
