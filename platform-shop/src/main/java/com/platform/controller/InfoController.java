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

import com.platform.entity.InfoEntity;
import com.platform.service.InfoService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-21 08:51:39
 */
@RestController
@RequestMapping("info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("info:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<InfoEntity> infoList = infoService.queryList(query);
        int total = infoService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(infoList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("info:info")
    public R info(@PathVariable("id") Integer id) {
        InfoEntity info = infoService.queryObject(id);

        return R.ok().put("info", info);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("info:save")
    public R save(@RequestBody InfoEntity info) {
        infoService.save(info);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("info:update")
    public R update(@RequestBody InfoEntity info) {
        infoService.update(info);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("info:delete")
    public R delete(@RequestBody Integer[] ids) {
        infoService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<InfoEntity> list = infoService.queryList(params);

        return R.ok().put("list", list);
    }
}
