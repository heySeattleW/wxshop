package com.bjdvt.platform.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-12
 */
public class StyleBox {
    private Integer id;

    private Integer propsId;

    private String paddingTop;

    private String paddingBottom;

    private String paddingLeft;

    private String paddingRight;

    private String borderStyle;

    private String borderWidth;

    private String borderColor;

    private String shadow;

    private String radius;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPropsId() {
        return propsId;
    }

    public void setPropsId(Integer propsId) {
        this.propsId = propsId;
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

    public String getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(String borderStyle) {
        this.borderStyle = borderStyle == null ? null : borderStyle.trim();
    }

    public String getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(String borderWidth) {
        this.borderWidth = borderWidth == null ? null : borderWidth.trim();
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor == null ? null : borderColor.trim();
    }

    public String getShadow() {
        return shadow;
    }

    public void setShadow(String shadow) {
        this.shadow = shadow == null ? null : shadow.trim();
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius == null ? null : radius.trim();
    }
}