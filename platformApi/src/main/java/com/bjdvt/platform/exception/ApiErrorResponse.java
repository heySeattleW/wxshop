package com.bjdvt.platform.exception;

public class ApiErrorResponse {
	private int code;
    private String message;
    private int status;
    
    
    public ApiErrorResponse(int code,int status, String message) {
    	this.code=code;
    	this.message=message;
    	this.status=status;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    
}
