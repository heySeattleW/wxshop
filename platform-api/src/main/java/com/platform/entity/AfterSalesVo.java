package com.platform.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AfterSalesVo {

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
	    private	List<RepairVo>  repairList;
	    private	String startDate;
	    private	String endDate;
	    
	    
	    
	    public String getStartDate() {
	    	SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd");
			return aDate.format(buyTime);
		}
	    

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getEndDate() {
			SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd");
			if(endDate!=null) {
				return aDate.format(endDate);
			}
			return aDate.format(buyTime);
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
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

		public List<RepairVo> getRepairList() {
			if(repairList==null) {
				repairList=new ArrayList();
			}
			return repairList;
		}

		public void setRepairList(List<RepairVo> repairList) {
			this.repairList = repairList;
		}

		
		

		
}
