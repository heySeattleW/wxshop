package com.bjdvt.platform.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-12
 */
public class StyleBorder {
    private Integer id;

    private String style;

    private String width;

    private String color;

    private Integer propsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width == null ? null : width.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Integer getPropsId() {
        return propsId;
    }

    public void setPropsId(Integer propsId) {
        this.propsId = propsId;
    }
}