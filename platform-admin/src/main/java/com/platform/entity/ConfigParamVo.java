package com.platform.entity;

public class ConfigParamVo {

	private	Integer key;
	private	String name;
	public ConfigParamVo(Integer key,String name) {
		this.key=key;
		this.name=name;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
