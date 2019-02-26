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

import com.platform.entity.FlashgoodsEntity;
import com.platform.service.FlashgoodsService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-09-29 14:36:33
 */
@RestController
@RequestMapping("flashgoods")
public class FlashgoodsController {
    @Autowired
    private FlashgoodsService flashgoodsService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("timegoods:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<FlashgoodsEntity> flashgoodsList = flashgoodsService.queryList(query);
        int total = flashgoodsService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(flashgoodsList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("flashgoods:info")
    public R info(@PathVariable("id") Integer id) {
        FlashgoodsEntity flashgoods = flashgoodsService.queryObject(id);

        return R.ok().put("flashgoods", flashgoods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("flashgoods:save")
    public R save(@RequestBody FlashgoodsEntity flashgoods) {
    	if(flashgoods.getRebate()<0||flashgoods.getRebate()>100) {
    		return R.error("折扣必须大于0且小于100");
    	}
        flashgoodsService.save(flashgoods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("flashgoods:update")
    public R update(@RequestBody FlashgoodsEntity flashgoods) {
        flashgoodsService.update(flashgoods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("flashgoods:delete")
    public R delete(@RequestBody Integer[] ids) {
        flashgoodsService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<FlashgoodsEntity> list = flashgoodsService.queryList(params);

        return R.ok().put("list", list);
    }
}
