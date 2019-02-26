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

import com.platform.entity.EvaluateEntity;
import com.platform.service.EvaluateService;
import com.platform.utils.PageUtils;
import com.platform.utils.Query;
import com.platform.utils.R;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-01 10:36:46
 */
@RestController
@RequestMapping("evaluate")
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("evaluate:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<EvaluateEntity> evaluateList = evaluateService.queryList(query);
        int total = evaluateService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(evaluateList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("evaluate:info")
    public R info(@PathVariable("id") Integer id) {
        EvaluateEntity evaluate = evaluateService.queryObject(id);

        return R.ok().put("evaluate", evaluate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("evaluate:save")
    public R save(@RequestBody EvaluateEntity evaluate) {
        evaluateService.save(evaluate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("evaluate:update")
    public R update(@RequestBody EvaluateEntity evaluate) {
        evaluateService.update(evaluate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("evaluate:delete")
    public R delete(@RequestBody Integer[] ids) {
        evaluateService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<EvaluateEntity> list = evaluateService.queryList(params);

        return R.ok().put("list", list);
    }
}
