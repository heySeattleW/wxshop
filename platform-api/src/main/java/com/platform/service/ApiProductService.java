package com.platform.service;

import com.platform.dao.ApiProductMapper;
import com.platform.entity.GoodsSpecificationVo;
import com.platform.entity.ProductVo;
import com.qiniu.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiProductService {
	@Autowired
	private ApiProductMapper productDao;
	@Autowired
	private ApiGoodsSpecificationService goodsSpecificationService;
	public ProductVo queryObject(Integer id) {
		System.out.println("begin ativityproduct=" + id);
		ProductVo productVo = productDao.queryObject(id);
		BigDecimal ativity_price = productDao.queryActivityProduct(id, new Date());
		System.out.println("ativity_price=" + ativity_price);
		if (ativity_price != null) {
			productVo.setRetail_price(ativity_price);
		}
		return productVo;
	}
	
	public String getGoods_specificationName(ProductVo productVo) {
		String[] goodsSepcifitionValue = null;
		if (null != productVo.getGoods_specification_ids() && productVo.getGoods_specification_ids().length() > 0) {

			Map specificationParam = new HashMap();
			String[] idsArray = getSpecificationIdsArray(productVo.getGoods_specification_ids());
			specificationParam.put("ids", idsArray);
			specificationParam.put("specification", true);
			specificationParam.put("sidx", "sort_order");
			specificationParam.put("goods_id", productVo.getGoods_id());
			List<GoodsSpecificationVo> specificationEntities = goodsSpecificationService.queryList(specificationParam);
			goodsSepcifitionValue = new String[specificationEntities.size()];
			for (int i = 0; i < specificationEntities.size(); i++) {
				goodsSepcifitionValue[i] = specificationEntities.get(i).getValue();
			}
		}
		if (null != goodsSepcifitionValue) {
        	return StringUtils.join(goodsSepcifitionValue, ";");
        }
		return "";
	}

	private String[] getSpecificationIdsArray(String ids) {
		String[] idsArray = null;
		if (org.apache.commons.lang.StringUtils.isNotEmpty(ids)) {
			String[] tempArray = ids.split("[\\,,_]");
			if (null != tempArray && tempArray.length > 0) {
				idsArray = tempArray;
			}
		}
		return idsArray;
	}

	public List<ProductVo> queryList(Map<String, Object> map) {
		return productDao.queryList(map);
	}

	public BigDecimal queryActivityPrice(Integer productId) {
		BigDecimal ativity_price = productDao.queryActivityProduct(productId, new Date());
		return ativity_price;
	}

	public int queryTotal(Map<String, Object> map) {
		return productDao.queryTotal(map);
	}

	public void save(ProductVo goods) {
		productDao.save(goods);
	}

	public void update(ProductVo goods) {
		productDao.update(goods);
	}

	public void delete(Integer id) {
		productDao.delete(id);
	}

	public void deleteBatch(Integer[] ids) {
		productDao.deleteBatch(ids);
	}

}
