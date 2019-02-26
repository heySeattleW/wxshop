package com.bjdvt.platform.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-12
 */
public class StyleText {
    private Integer id;

    private Integer propsId;

    private boolean bold;

    private String color;

    private String fontSize;

    private String align;

    private boolean italic;

    private boolean underline;

    private boolean shadow;

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

    

    public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
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

   

    public boolean isItalic() {
		return italic;
	}

	public void setItalic(boolean italic) {
		this.italic = italic;
	}

	

    public boolean isUnderline() {
		return underline;
	}

	public void setUnderline(boolean underline) {
		this.underline = underline;
	}

	public boolean isShadow() {
		return shadow;
	}

	public void setShadow(boolean shadow) {
		this.shadow = shadow;
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