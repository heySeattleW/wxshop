package com.bjdvt.platform.model;

import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-12
 */
public class App {
    private String id;

    private String name;

    private String appUserId;

    private String createTime;

    private String type;

    private String indexPage;
    
    private List<Page> pages;
    
    private Tabbar tabbar;
    
    

	
	

	public Tabbar getTabbar() {
		return tabbar;
	}

	public void setTabbar(Tabbar tabbar) {
		this.tabbar = tabbar;
	}

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

    public String getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId == null ? null : appUserId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(String indexPage) {
        this.indexPage = indexPage == null ? null : indexPage.trim();
    }
}