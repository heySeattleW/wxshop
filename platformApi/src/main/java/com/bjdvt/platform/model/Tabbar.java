package com.bjdvt.platform.model;

import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-10-09
 */
public class Tabbar {
    private Integer id;

    private String color;

    private String selectedColor;

    private String backgrounColor;

    private String borderStyle;

    private String appId;

    private List<Tabbaritem> list;
    
    
    
    public List<Tabbaritem> getList() {
		return list;
	}

	public void setList(List<Tabbaritem> list) {
		this.list = list;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(String selectedColor) {
        this.selectedColor = selectedColor == null ? null : selectedColor.trim();
    }

    public String getBackgrounColor() {
        return backgrounColor;
    }

    public void setBackgrounColor(String backgrounColor) {
        this.backgrounColor = backgrounColor == null ? null : backgrounColor.trim();
    }

    public String getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(String borderStyle) {
        this.borderStyle = borderStyle == null ? null : borderStyle.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }
}