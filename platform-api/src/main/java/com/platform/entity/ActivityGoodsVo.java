package com.platform.entity;

import java.math.BigDecimal;

public class ActivityGoodsVo {
	
	
	  	private	Integer goodsId;
	    private	String  goodsName;
	    private String  img_url;
	    private	String  activityName;
	    private	Integer activityId;
	    //市场价
	    private BigDecimal market_price;
	    //零售价格(现价)
	    private BigDecimal retail_price;

	   
		public Integer getGoodsId() {
			return goodsId;
		}
		public void setGoodsId(Integer goodsId) {
			this.goodsId = goodsId;
		}
		public String getGoodsName() {
			return goodsName;
		}
		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}
		public String getImg_url() {
			return img_url;
		}
		public void setImg_url(String img_url) {
			this.img_url = img_url;
		}
		public String getActivityName() {
			return activityName;
		}
		public void setActivityName(String activityName) {
			this.activityName = activityName;
		}
		public Integer getActivityId() {
			return activityId;
		}
		public void setActivityId(Integer activityId) {
			this.activityId = activityId;
		}
		public BigDecimal getMarket_price() {
			return market_price;
		}
		public void setMarket_price(BigDecimal market_price) {
			this.market_price = market_price;
		}
		public BigDecimal getRetail_price() {
			return retail_price;
		}
		public void setRetail_price(BigDecimal retail_price) {
			this.retail_price = retail_price;
		}
		
	    
	    
	    
	    
	    

}
