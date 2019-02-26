package com.platform.entity;

public class KdApiVo {
private String EBusinessID;
private	 boolean Success;
private	String Reason;
private	 KdApiOrder Order;


public KdApiOrder getOrder() {
	return Order;
}
public void setOrder(KdApiOrder order) {
	Order = order;
}
public String getEBusinessID() {
	return EBusinessID;
}
public void setEBusinessID(String eBusinessID) {
	EBusinessID = eBusinessID;
}
public boolean isSuccess() {
	return Success;
}
public void setSuccess(boolean success) {
	Success = success;
}
public String getReason() {
	return Reason;
}
public void setReason(String reason) {
	Reason = reason;
}


}
