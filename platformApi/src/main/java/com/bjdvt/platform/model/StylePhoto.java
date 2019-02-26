package com.bjdvt.platform.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-12
 */
public class StylePhoto {
    private Integer id;

    private String width;

    private String height;

    private String backgroundColor;

    private String paddingLeft;

    private String paddingRight;

    private String paddingTop;

    private String paddingBottom;

    private String opacity;

    private String radius;

    private String shape;

    private String stylePhotocol;

    private Integer propsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width == null ? null : width.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor == null ? null : backgroundColor.trim();
    }

    public String getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(String paddingLeft) {
        this.paddingLeft = paddingLeft == null ? null : paddingLeft.trim();
    }

    public String getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(String paddingRight) {
        this.paddingRight = paddingRight == null ? null : paddingRight.trim();
    }

    public String getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(String paddingTop) {
        this.paddingTop = paddingTop == null ? null : paddingTop.trim();
    }

    public String getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(String paddingBottom) {
        this.paddingBottom = paddingBottom == null ? null : paddingBottom.trim();
    }

    public String getOpacity() {
        return opacity;
    }

    public void setOpacity(String opacity) {
        this.opacity = opacity == null ? null : opacity.trim();
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius == null ? null : radius.trim();
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape == null ? null : shape.trim();
    }

    public String getStylePhotocol() {
        return stylePhotocol;
    }

    public void setStylePhotocol(String stylePhotocol) {
        this.stylePhotocol = stylePhotocol == null ? null : stylePhotocol.trim();
    }

    public Integer getPropsId() {
        return propsId;
    }

    public void setPropsId(Integer propsId) {
        this.propsId = propsId;
    }
}