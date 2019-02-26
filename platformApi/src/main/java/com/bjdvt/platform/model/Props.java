package com.bjdvt.platform.model;

import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-12
 */
public class Props {
    private Integer id;

    private Integer componentId;

    private Integer src;

    private String text;

    private String title;

    private String subtitle;

 

    private String styleTitle;

    private String styleSubtitle;

    private String styleHeight;

    private String styleBackgroundColor;
    
    private	StyleBorder styleBorder;
    private StyleBorderBottom styleBorderBottom;
    private	StyleBox styleBox;
    private	 StyleButton styleButton;
    private   StyleLineMark styleLineMark;
    private StylePadding stylePadding;
    private  StyleText styleText;
    private StylePhoto stylePhoto;
    private List<Data> dataList;

    
    public StyleBorder getStyleBorder() {
		return styleBorder;
	}

	public void setStyleBorder(StyleBorder styleBorder) {
		this.styleBorder = styleBorder;
	}

	public StyleBorderBottom getStyleBorderBottom() {
		return styleBorderBottom;
	}

	public void setStyleBorderBottom(StyleBorderBottom styleBorderBottom) {
		this.styleBorderBottom = styleBorderBottom;
	}

	public StyleBox getStyleBox() {
		return styleBox;
	}

	public void setStyleBox(StyleBox styleBox) {
		this.styleBox = styleBox;
	}

	public StyleButton getStyleButton() {
		return styleButton;
	}

	public void setStyleButton(StyleButton styleButton) {
		this.styleButton = styleButton;
	}

	public StyleLineMark getStyleLineMark() {
		return styleLineMark;
	}

	public void setStyleLineMark(StyleLineMark styleLineMark) {
		this.styleLineMark = styleLineMark;
	}

	public StylePadding getStylePadding() {
		return stylePadding;
	}

	public void setStylePadding(StylePadding stylePadding) {
		this.stylePadding = stylePadding;
	}

	public StyleText getStyleText() {
		return styleText;
	}

	public void setStyleText(StyleText styleText) {
		this.styleText = styleText;
	}

	public StylePhoto getStylePhoto() {
		return stylePhoto;
	}

	public void setStylePhoto(StylePhoto stylePhoto) {
		this.stylePhoto = stylePhoto;
	}

	public List<Data> getDataList() {
		return dataList;
	}

	public void setDataList(List<Data> dataList) {
		this.dataList = dataList;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public Integer getSrc() {
        return src;
    }

    public void setSrc(Integer src) {
        this.src = src;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

 
    public String getStyleTitle() {
        return styleTitle;
    }

    public void setStyleTitle(String styleTitle) {
        this.styleTitle = styleTitle == null ? null : styleTitle.trim();
    }

    public String getStyleSubtitle() {
        return styleSubtitle;
    }

    public void setStyleSubtitle(String styleSubtitle) {
        this.styleSubtitle = styleSubtitle == null ? null : styleSubtitle.trim();
    }

    public String getStyleHeight() {
        return styleHeight;
    }

    public void setStyleHeight(String styleHeight) {
        this.styleHeight = styleHeight == null ? null : styleHeight.trim();
    }

    public String getStyleBackgroundColor() {
        return styleBackgroundColor;
    }

    public void setStyleBackgroundColor(String styleBackgroundColor) {
        this.styleBackgroundColor = styleBackgroundColor == null ? null : styleBackgroundColor.trim();
    }
}