package com.platform.entity;

public class TicketVo {

	
	private	long errcode;
	private	String errmsg;
	private	String ticket;
	private long expires_in;
	private	 long expires_time;
	public long getErrcode() {
		return errcode;
	}
	public void setErrcode(long errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
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
