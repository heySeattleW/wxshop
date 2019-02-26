package com.platform.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.platform.entity.ProductVo;

/**
 * 
 * 
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:46
 */
public interface ApiProductMapper extends BaseDao<ProductVo> {

	public BigDecimal queryActivityProduct(@Param("productId")Integer productId,@Param("nowDate")Date nowDate);
}
