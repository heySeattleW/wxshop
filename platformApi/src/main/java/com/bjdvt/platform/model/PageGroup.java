package com.bjdvt.platform.model;

import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-12
 */
public class PageGroup {
    private String id;

    private String name;

    private String appId;
    
    private	List<Page> pages;
    
    

    public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }
}