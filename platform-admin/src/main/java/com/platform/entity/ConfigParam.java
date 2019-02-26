package com.platform.entity;

public enum ConfigParam {
	KDNKEY("快递鸟key", 100), 
	KDN("快递鸟", 101),
	KDZF("快递资费", 102),
	KFDH("客服电话", 103),
	POST_MAN("发件人", 201),
	POST_MOBILE("发件人电话", 202),
	POST_PROVINCE("发件人所在省", 203),
	POST_CITY("发件人所在城市", 204),
	POST_TOWN("发件人所在区县", 205),
	POST_ADDRESS("发件人地址", 207),
	POST_COMPANY("公司名称", 208);
	
	String name;
	int key;

	private ConfigParam(String name, int key) {
		this.name = name;
		this.key = key;
	}

	public static String getName(int key) {
		for (ConfigParam c : ConfigParam.values()) {
			if (c.getKey() == key) {
				return c.name;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
