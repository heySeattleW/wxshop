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

import com.platform.entity.TimegoodsEntity;
import com.platform.service.TimegoodsService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-10-15 11:08:36
 */
@RestController
@RequestMapping("timegoods")
public class TimegoodsController {
    @Autowired
    private TimegoodsService timegoodsService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("timegoods:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<TimegoodsEntity> timegoodsList = timegoodsService.queryList(query);
        int total = timegoodsService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(timegoodsList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("timegoods:info")
    public R info(@PathVariable("id") Integer id) {
        TimegoodsEntity timegoods = timegoodsService.queryObject(id);

        return R.ok().put("timegoods", timegoods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("timegoods:save")
    public R save(@RequestBody TimegoodsEntity timegoods) {
        timegoodsService.save(timegoods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("timegoods:update")
    public R update(@RequestBody TimegoodsEntity timegoods) {
        timegoodsService.update(timegoods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("timegoods:delete")
    public R delete(@RequestBody Integer[] ids) {
        timegoodsService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<TimegoodsEntity> list = timegoodsService.queryList(params);

        return R.ok().put("list", list);
    }
}
