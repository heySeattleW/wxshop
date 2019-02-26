package com.platform.entity;

import java.util.List;

public class MyRegion {
	 //主键
    private Integer id;
    //父节点
    private Integer pid;
    //区域名称
    private String name;
    private	Integer type;
    
    
   
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	private List<MyRegion> childList;
    
	public List<MyRegion> getChildList() {
		return childList;
	}
	public void setChildList(List<MyRegion> childList) {
		this.childList = childList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
    
}
