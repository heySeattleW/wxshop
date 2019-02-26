package com.platform.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.entity.ActivityGoodsEntity;
import com.platform.service.ActivityGoodsService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-10-29 13:56:24
 */
@RestController
@RequestMapping("activitygoods")
public class  ActivityGoodsController {
    @Autowired
    private  ActivityGoodsService  activityGoodsService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("activitygoods:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ActivityGoodsEntity>  activityGoodsList =  activityGoodsService.queryList(query);
        int total =  activityGoodsService.queryTotal(query);

        PageUtils pageUtil = new PageUtils( activityGoodsList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("activitygoods:info")
    public R info(@PathVariable("id") Integer id) {
         ActivityGoodsEntity  activityGoods =  activityGoodsService.queryObject(id);

        return R.ok().put(" activityGoods",  activityGoods);
    }
    
    @RequestMapping("/selectActivityGoods/{activityId}")
    public R  selectActivityGoods(@PathVariable("activityId") Integer activityId) {
    	 List<ActivityGoodsEntity>  activityGoodsList =activityGoodsService.selectActivityGoods(activityId);
    	 return R.ok().put("list", activityGoodsList);
    }
    @RequestMapping("/selectAllActivityGoods")
    public R  selectAllActivityGoods() {
    	 List<ActivityGoodsEntity>  activityGoodsList =activityGoodsService.selectAllActivityGoods();
    	 return R.ok().put("list", activityGoodsList);
    }
    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("activitygoods:save")
    public R save(@RequestBody  ActivityGoodsEntity  activityGoods) {
         activityGoodsService.save( activityGoods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("activitygoods:update")
    public R update(@RequestBody  ActivityGoodsEntity  activityGoods) {
         activityGoodsService.update( activityGoods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("activitygoods:delete")
    public R delete(@RequestBody Integer[] ids) {
         activityGoodsService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ActivityGoodsEntity> list =  activityGoodsService.queryList(params);

        return R.ok().put("list", list);
    }
}
