package com.bjdvt.platform.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-12
 */
public class StyleButton {
    private Integer id;

    private String innerColor;

    private String outerColor;

    private Integer opacity;

    private String fixTop;

    private String fixBottom;

    private Integer propsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInnerColor() {
        return innerColor;
    }

    public void setInnerColor(String innerColor) {
        this.innerColor = innerColor == null ? null : innerColor.trim();
    }

    public String getOuterColor() {
        return outerColor;
    }

    public void setOuterColor(String outerColor) {
        this.outerColor = outerColor == null ? null : outerColor.trim();
    }

    public Integer getOpacity() {
        return opacity;
    }

    public void setOpacity(Integer opacity) {
        this.opacity = opacity;
    }

    public String getFixTop() {
        return fixTop;
    }

    public void setFixTop(String fixTop) {
        this.fixTop = fixTop == null ? null : fixTop.trim();
    }

    public String getFixBottom() {
        return fixBottom;
    }

    public void setFixBottom(String fixBottom) {
        this.fixBottom = fixBottom == null ? null : fixBottom.trim();
    }

    public Integer getPropsId() {
        return propsId;
    }

    public void setPropsId(Integer propsId) {
        this.propsId = propsId;
    }
}