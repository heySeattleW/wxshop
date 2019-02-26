package com.bjdvt.platform.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-10-09
 */
public class Tabbaritem {
    private Integer id;

    private Integer tabbarId;

    private String pagePath;

    private String text;

    private String iconPath;

    private String selectedIconPath;

    private String active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTabbarId() {
        return tabbarId;
    }

    public void setTabbarId(Integer tabbarId) {
        this.tabbarId = tabbarId;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath == null ? null : pagePath.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath == null ? null : iconPath.trim();
    }

    public String getSelectedIconPath() {
        return selectedIconPath;
    }

    public void setSelectedIconPath(String selectedIconPath) {
        this.selectedIconPath = selectedIconPath == null ? null : selectedIconPath.trim();
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active == null ? null : active.trim();
    }
}