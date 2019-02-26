package com.bjdvt.platform.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-12
 */
public class StylePadding {
    private Integer id;

    private Integer propsId;

    private String top;

    private String bottom;

    private String left;

    private String right;

    private String fontSize;

    private String align;

    private String bold;

    private String italic;

    private String underline;

    private String shadow;

    private String lineHeight;

    private String paddingTop;

    private String paddingBottom;

    private String paddingLeft;

    private String paddingRight;

    private String backgroundColor;

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

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top == null ? null : top.trim();
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom == null ? null : bottom.trim();
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left == null ? null : left.trim();
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right == null ? null : right.trim();
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize == null ? null : fontSize.trim();
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align == null ? null : align.trim();
    }

    public String getBold() {
        return bold;
    }

    public void setBold(String bold) {
        this.bold = bold == null ? null : bold.trim();
    }

    public String getItalic() {
        return italic;
    }

    public void setItalic(String italic) {
        this.italic = italic == null ? null : italic.trim();
    }

    public String getUnderline() {
        return underline;
    }

    public void setUnderline(String underline) {
        this.underline = underline == null ? null : underline.trim();
    }

    public String getShadow() {
        return shadow;
    }

    public void setShadow(String shadow) {
        this.shadow = shadow == null ? null : shadow.trim();
    }

    public String getLineHeight() {
        return lineHeight;
    }

    public void setLineHeight(String lineHeight) {
        this.lineHeight = lineHeight == null ? null : lineHeight.trim();
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

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor == null ? null : backgroundColor.trim();
    }
}