package com.bjdvt.platform.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-12
 */
public class Data {
    private Integer id;

    private Integer propsId;

    private Integer src;

    private String title;

    private String subTitle;
    private  String text;
    private  String image_url;
    private	String link;
    
    
    
    public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
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

    public Integer getSrc() {
        return src;
    }

    public void setSrc(Integer src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }
}