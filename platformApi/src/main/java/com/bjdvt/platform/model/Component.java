package com.bjdvt.platform.model;

import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-12
 */
public class Component {
    private Integer id;

  

    private Integer sectionId;
    
    private Integer component;

    private String componentName;

    private String pageId;
    private Props props;
    private String uid;
   
    
    
    
    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Props getProps() {
		return props;
	}

	public void setProps(Props props) {
		this.props = props;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public Integer getComponent() {
        return component;
    }

    public void setComponent(Integer component) {
        this.component = component;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName == null ? null : componentName.trim();
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId == null ? null : pageId.trim();
    }

	
    
}