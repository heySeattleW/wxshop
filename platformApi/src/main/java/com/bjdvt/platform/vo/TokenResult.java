package com.bjdvt.platform.vo;

import java.io.Serializable;
import java.util.Date;

public class TokenResult  implements Serializable{

	private String access_token;
	private int expires_in;
	private Date timeout;
	 private static final long serialVersionUID = 1L;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public Date getTimeout() {
		return timeout;
	}
	public void setTimeout(Date timeout) {
		this.timeout = timeout;
	}
	
	
}
