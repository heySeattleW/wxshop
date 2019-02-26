package com.platform.entity;

public class TokenVo {
	private	String access_token;
	private long expires_in;
	private long expires_time;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}
	public long getExpires_time() {
		return expires_time;
	}
	public void setExpires_time(long expires_time) {
		this.expires_time = expires_time;
	}
	
	
	
}
