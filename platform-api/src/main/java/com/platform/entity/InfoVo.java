package com.platform.entity;

import java.util.Date;

public class InfoVo {

	 private static final long serialVersionUID = 1L;

	    //
	    private Integer id;
	    //
	    private long userId;
	    //
	    private Date createTime;
	    //
	    private String info;
	    private	String name;
	    private String  avatar;
	    private	String nickName;
	    
	    private	String userName;
	    


		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}

		public String getNickName() {
			return nickName;
		}

		public void setNickName(String nickName) {
			this.nickName = nickName;
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
	  
	    public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
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
