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

import com.platform.entity.ActivityEntity;
import com.platform.service.ActivityService;
import com.platform.service.GoodsService;
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
@RequestMapping("activity")
public class  ActivityController {
    @Autowired
    private  ActivityService  activityService;
    @Autowired
    private GoodsService goodsService;
    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions(" activity:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ActivityEntity>  activityList =  activityService.queryList(query);
        int total =  activityService.queryTotal(query);

        PageUtils pageUtil = new PageUtils( activityList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }
    
    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("activity:info")
    public R info(@PathVariable("id") Integer id) {
         ActivityEntity  activity =  activityService.queryObject(id);

        return R.ok().put("activity",  activity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("activity:save")
    public R save(@RequestBody  ActivityEntity  activity) {
    	try {
         activityService.save( activity);
    	}
    
		catch(Exception e) {
			return R.error(e.getMessage());
		}

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("activity:update")
    public R update(@RequestBody  ActivityEntity  activity) {
    	try {
         activityService.update( activity);
    	}
    	catch(Exception e) {
    		return R.error(e.getMessage());
    	}
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("activity:delete")
    public R delete(@RequestBody Integer[] ids) {
         activityService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List< ActivityEntity> list =  activityService.queryList(params);

        return R.ok().put("list", list);
    }
}
