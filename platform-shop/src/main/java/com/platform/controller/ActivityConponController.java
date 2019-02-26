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

import com.platform.entity.ActivityConponEntity;
import com.platform.service.ActivityConponService;
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
@RequestMapping("activityconpon")
public class  ActivityConponController {
    @Autowired
    private  ActivityConponService  activityConponService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("activityconpon:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ActivityConponEntity>  activityConponList =  activityConponService.queryList(query);
        int total =  activityConponService.queryTotal(query);

        PageUtils pageUtil = new PageUtils( activityConponList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("activityconpon:info")
    public R info(@PathVariable("id") Integer id) {
         ActivityConponEntity  activityConpon =  activityConponService.queryObject(id);

        return R.ok().put(" activityConpon",  activityConpon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("activityconpon:save")
    public R save(@RequestBody  ActivityConponEntity  activityConpon) {
         activityConponService.save( activityConpon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("activityconpon:update")
    public R update(@RequestBody  ActivityConponEntity  activityConpon) {
         activityConponService.update( activityConpon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("activityconpon:delete")
    public R delete(@RequestBody Integer[] ids) {
         activityConponService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List< ActivityConponEntity> list =  activityConponService.queryList(params);

        return R.ok().put("list", list);
    }
}
