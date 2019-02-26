package com.platform.entity;

import java.io.Serializable;


/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-15 08:03:41
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private String avatarUrl;
    //
    private String city;
    //
    private Integer gender;
    //
    private String nickName;
    //
    private String province;

    private Integer sex;
    private	String headimgurl;
    private	String  country;
    
    
    public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
