package com.platform.service;

import com.platform.entity.OrderEntity;

public interface KdApiEOrderService {
	public String orderOnlineByJson(OrderEntity order,String code) throws Exception;
}
