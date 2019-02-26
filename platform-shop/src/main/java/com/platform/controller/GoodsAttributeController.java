package com.platform.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.entity.AttributeEntity;
import com.platform.entity.GoodsAttributeEntity;
import com.platform.entity.GoodsEntity;
import com.platform.service.AttributeService;
import com.platform.service.GoodsAttributeService;
import com.platform.service.GoodsService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;


/**
 * 
 * 
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-13 10:41:08
 */
@RestController
@RequestMapping("goodsattribute")
public class GoodsAttributeController {
	@Autowired
	private GoodsAttributeService goodsAttributeService;
	@Autowired
    private AttributeService  attributeService;
	@Autowired
	private GoodsService goodsService;
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("goodsattribute:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GoodsAttributeEntity> goodsAttributeList = goodsAttributeService.queryList(query);
		int total = goodsAttributeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(goodsAttributeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("goodsattribute:info")
	public R info(@PathVariable("id") Integer id){
		GoodsAttributeEntity goodsAttribute = goodsAttributeService.queryObject(id);
		
		return R.ok().put("goodsAttribute", goodsAttribute);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("goodsattribute:save")
	public R save(@RequestBody GoodsAttributeEntity goodsAttribute){
		goodsAttributeService.save(goodsAttribute);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("goodsattribute:update")
	public R update(@RequestBody GoodsAttributeEntity goodsAttribute){
		goodsAttributeService.update(goodsAttribute);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("goodsattribute:delete")
	public R delete(@RequestBody Integer[] ids){
		goodsAttributeService.deleteBatch(ids);
		
		return R.ok();
	}
	/**
	 * 列表
	 */
	@RequestMapping("/queryAll")
	public R queryAll(@RequestParam Map<String, Object> params){
		//查询列表数据
    
        String goodsId=(String)params.get("goodsId");
        String attributeCategoryId=(String)params.get("attributeCategoryId");
        GoodsEntity goodsEntity=null;
        if(goodsId!=null&&!goodsId.equals("null")) {
        	goodsEntity=goodsService.queryObject(Integer.valueOf(goodsId));
        }
        if(goodsEntity!=null&&attributeCategoryId!=null&&attributeCategoryId.length()>0&&Integer.valueOf(attributeCategoryId).equals(goodsEntity.getAttributeCategory()))
        {	
        	  
        	List<GoodsAttributeEntity> goodsAttributeList = goodsAttributeService.queryList(params); 
        	for(GoodsAttributeEntity goodsAttributeEntity:goodsAttributeList) {
        		AttributeEntity attributeEntity=attributeService.queryObject(goodsAttributeEntity.getAttributeId());
        		if(attributeEntity!=null) {
        			goodsAttributeEntity.setAttributeName(attributeEntity.getName());
        		}
        	}
        	return R.ok().put("list", goodsAttributeList);
        }else {
        	 List<AttributeEntity> attributeEntityList= attributeService.queryList(params);
        	 List<GoodsAttributeEntity> goodsAttributeList =new ArrayList();
        	 for(AttributeEntity attributeEntity:attributeEntityList) {
        		 GoodsAttributeEntity goodsAttributeEntity=new GoodsAttributeEntity();
        		 goodsAttributeEntity.setAttributeId(attributeEntity.getId());
        		 goodsAttributeEntity.setAttributeName(attributeEntity.getName());
        		 goodsAttributeList.add(goodsAttributeEntity);
        		
        	 }
        	 return R.ok().put("list", goodsAttributeList);
        }
	}
	
}
