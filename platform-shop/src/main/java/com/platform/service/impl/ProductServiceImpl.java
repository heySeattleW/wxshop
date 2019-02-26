package com.platform.service.impl;

import com.platform.dao.GoodsAttributeDao;
import com.platform.dao.GoodsSpecificationDao;
import com.platform.entity.AttributeEntity;
import com.platform.entity.GoodsAttributeEntity;
import com.platform.entity.GoodsEntity;
import com.platform.entity.GoodsSpecificationEntity;
import com.platform.utils.BeanUtils;
import com.platform.utils.R;
import com.platform.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.platform.dao.ProductDao;
import com.platform.entity.ProductEntity;
import com.platform.entity.SpecificationEntity;
import com.platform.service.AttributeService;
import com.platform.service.GoodsService;
import com.platform.service.ProductService;
import com.platform.service.SpecificationService;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-30 14:31:21
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private GoodsSpecificationDao goodsSpecificationDao;
    @Autowired
    private GoodsAttributeDao goodsAttributeDao;
    @Autowired
    private SpecificationService specificationService;
    @Autowired
    private AttributeService  attributeService;
    @Autowired
    private GoodsService goodsService;
    @Override
    public ProductEntity queryObject(Integer id) {
    	ProductEntity product=productDao.queryObject(id);
    	List<Integer> idList=new ArrayList();
    	if(product.getGoodsSpecificationIds()!=null) {
    		String[] ids=product.getGoodsSpecificationIds().split(",");
    		for(String idstr :ids) {
    			if(idstr.trim().length()>0) {
    				idList.add(Integer.valueOf(idstr));
    			}
    		}
    	}
    	
    	 product.setSpecificationList(idList);
        return product;
    }
    public List<GoodsSpecificationEntity>  querySpecification( Integer id)
    {
    	ProductEntity product=productDao.queryObject(id);
    	
    	List<GoodsSpecificationEntity>  selectSpecificationList=new ArrayList();
    
    	if(product.getSpecificationValue()!=null) {
    		String[] specificationIds= product.getSpecificationValue().split("_");
         	for(int i=0;i<specificationIds.length;i++) {
         		if(specificationIds[i].trim().length()>0) {
         			
         			GoodsSpecificationEntity goodsSpecificationEntity=goodsSpecificationDao.queryObject(Integer.valueOf(specificationIds[i].trim()));
         			if(goodsSpecificationEntity!=null)
         				selectSpecificationList.add(goodsSpecificationEntity);
		         	System.out.println("specificationIds"+i+" "+specificationIds[i]);
         			
         		}
         	}
         }
    	return selectSpecificationList;
    }
    /*
    @Override
    public List queryAttribute(Integer id) {
   	 List<AttributeEntity>  attributeEntityList=attributeService.queryList(null);
        
        List<GoodsAttributeEntity>  selectAttributeEntityList=new ArrayList();
        ProductEntity product = productDao.queryObject(id);
        GoodsEntity goods = goodsService.queryObject(product.getGoodsId());
        if(goods.getAttributeIds()!=null) {
        	String[] attributeIds= goods.getAttributeIds().split("_");
        	for(int i=0;i<attributeIds.length;i++) {
        		if(attributeIds[i].trim().length()>0) {
        			for(AttributeEntity attributeEntity:attributeEntityList) {
        				if(attributeEntity.getId().equals(Integer.valueOf(attributeIds[i]))){
        					GoodsAttributeEntity goodsAttributeEntity=new GoodsAttributeEntity();
        					goodsAttributeEntity.setGoodsId(goods.getId());
        					goodsAttributeEntity.setAttributeId(attributeEntity.getId());
        					goodsAttributeEntity.setAttributeName(attributeEntity.getName());
        					goodsAttributeEntity.setProductId(product.getId());
        					
        					Map<String, Object> params=new HashMap();
         			    	params.put("productId", product.getId());
         			    	params.put("attributeId", attributeEntity.getId());
         			    	List<GoodsAttributeEntity> goodsAttributeEntityList=goodsAttributeDao.queryList(params);
         					if(goodsAttributeEntityList.size()>0) {
         						GoodsAttributeEntity tmpgoodsAttribute=goodsAttributeEntityList.get(0);
         						goodsAttributeEntity.setValue(tmpgoodsAttribute.getValue());
         					}
         					selectAttributeEntityList.add(goodsAttributeEntity);
        				}
        			}
        		}
        		
        	}
        }
        return selectAttributeEntityList;
   }*/
    @Override
    public List<ProductEntity> queryList(Map<String, Object> map) {
        List<ProductEntity> list = productDao.queryList(map);

        
        List<ProductEntity> result = new ArrayList<>();
        //翻译产品规格
        if (null != list && list.size() > 0) {
            for (ProductEntity item : list) {
                String specificationIds = item.getGoodsSpecificationIds();
                String specificationValue = "";
                if (!StringUtils.isNullOrEmpty(specificationIds)) {
                    String[] arr = specificationIds.split(",");

                    for (String goodsSpecificationId : arr) {
                        GoodsSpecificationEntity entity = goodsSpecificationDao.queryObject(goodsSpecificationId);
                        if (null != entity) {
                            specificationValue += entity.getValue() + "；";
                        }
                    }
                }
                item.setSpecificationValue(item.getGoodsName() + " " + specificationValue);
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return productDao.queryTotal(map);
    }

    @Override
    @Transactional
    public int save(ProductEntity product) {
        int result = 0;
       
       
        
        productDao.save(product);
       
        
        if(product.getAttributeList()!=null) {
	        for(GoodsAttributeEntity goodsAttributeEntity:product.getAttributeList())
	        {
	        	goodsAttributeEntity.setProductId(product.getId());
	        	goodsAttributeEntity.setGoodsId(product.getGoodsId());
	        	if(goodsAttributeEntity.getId()==null) {
	        		goodsAttributeDao.save(goodsAttributeEntity);
	        	}else {
	        		goodsAttributeDao.update(goodsAttributeEntity);
	        	}
	        }
        }
        String goodsSpecificationStr="";
        boolean isFirst=true;
        if(product.getSpecificationList()!=null) {
	        for(Integer specificationId:product.getSpecificationList())
	        {
	        	if(isFirst) {
	        		isFirst=false;
	        	}else {
	        		goodsSpecificationStr+=",";
	        		
	        	}
	        	goodsSpecificationStr+=specificationId;
	        	
	        }
	        product.setGoodsSpecificationIds(goodsSpecificationStr);
        }
        productDao.update(product);
       
        return result;
    }

    @Override
    public int update(ProductEntity product) {
    	 String goodsSpecificationStr="";
         boolean isFirst=true;
        
        
         for(Integer specificationId:product.getSpecificationList())
         {
         	if(isFirst) {
         		isFirst=false;
         	}else {
         		goodsSpecificationStr+=",";
         		
         	}
         	goodsSpecificationStr+=specificationId;
         	
         }
         
        
         
         product.setGoodsSpecificationIds(goodsSpecificationStr);
         productDao.update(product);
        return productDao.update(product);
    }

    @Override
    public int delete(Integer id) {
        return productDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return productDao.deleteBatch(ids);
    }
}
