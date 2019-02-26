package com.bjdvt.platform.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-12
 */
public class Page {
    private String id;

    private String name;

    private String pageGroupId;
    private String navigationBarTitleText;
    
    private List<Component> components;
    
    private List<Component>  sections;
    


    //根据小程序端修改,名字匹配
    public String getNavigationBarTitleText() {
		return navigationBarTitleText;
	}

	public void setNavigationBarTitleText(String navigationBarTitleText) {
		this.navigationBarTitleText = navigationBarTitleText;
	}
	//根据小程序端修改,名字匹配
	public List<Component> getSections() {
		return sections;
	}

	public void setSections(List<Component> sections) {
		this.sections = sections;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}
	

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPageGroupId() {
        return pageGroupId;
    }

    public void setPageGroupId(String pageGroupId) {
        this.pageGroupId = pageGroupId == null ? null : pageGroupId.trim();
    }
}