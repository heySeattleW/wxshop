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

import com.platform.entity.AppEntity;
import com.platform.service.AppService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-09-25 17:33:58
 */
@RestController
@RequestMapping("appAdmin")
public class AdminAppController {
    @Autowired
    private AppService appService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("appAdmin:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<AppEntity> appList = appService.queryList(query);
        int total = appService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(appList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("appAdmin:info")
    public R info(@PathVariable("id") String id) {
        AppEntity app = appService.queryObject(id);

        return R.ok().put("app", app);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("appAdmin:save")
    public R save(@RequestBody AppEntity app) {
        appService.save(app);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("appAdmin:update")
    public R update(@RequestBody AppEntity app) {
        appService.update(app);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("appAdmin:delete")
    public R delete(@RequestBody String[] ids) {
        appService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<AppEntity> list = appService.queryList(params);

        return R.ok().put("list", list);
    }
}
