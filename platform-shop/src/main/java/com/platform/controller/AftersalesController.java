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

import com.platform.entity.AftersalesEntity;
import com.platform.service.AftersalesService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-21 09:28:36
 */
@RestController
@RequestMapping("aftersales")
public class AftersalesController {
    @Autowired
    private AftersalesService aftersalesService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("aftersales:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<AftersalesEntity> aftersalesList = aftersalesService.queryList(query);
       
        int total = aftersalesService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(aftersalesList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("aftersales:info")
    public R info(@PathVariable("id") Integer id) {
        AftersalesEntity aftersales = aftersalesService.queryObject(id);

        return R.ok().put("aftersales", aftersales);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("aftersales:save")
    public R save(@RequestBody AftersalesEntity aftersales) {
        aftersalesService.save(aftersales);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("aftersales:update")
    public R update(@RequestBody AftersalesEntity aftersales) {
        aftersalesService.update(aftersales);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("aftersales:delete")
    public R delete(@RequestBody Integer[] ids) {
        aftersalesService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<AftersalesEntity> list = aftersalesService.queryList(params);

        return R.ok().put("list", list);
    }
}
