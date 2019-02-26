package com.platform.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.IgnoreAuth;
import com.platform.annotation.LoginUser;
import com.platform.dao.ApiAfterSalesMapper;
import com.platform.entity.AfterSalesVo;
import com.platform.entity.EvaluateVo;
import com.platform.entity.OrderVo;
import com.platform.entity.UserVo;
import com.platform.service.ApiAfterSalesService;
import com.platform.service.SysConfigService;
import com.platform.util.ApiBaseAction;
import com.platform.util.ApiPageUtils;
import com.platform.utils.Query;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "API登录授权接口")
@RestController
@RequestMapping("/api/aftersales")
public class ApiAfterSalesController  extends ApiBaseAction {
	@Autowired
	private ApiAfterSalesService apiAfterSalesService;
	@Autowired
    private SysConfigService sysConfigService;
	 /**
     * list
     */
	@ApiOperation(value = "手机保修卡")
    @GetMapping(value = "list")
    public Object list(@LoginUser UserVo loginUser,
            @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
    	  Map<String, Object> resultObj = new HashMap();
          List<EvaluateVo> commentList = new ArrayList();
          Map params=new HashMap();
          params.put("userId", loginUser.getUserId());
          params.put("page", page);
          params.put("limit", size);
        
          Query query = new Query(params);
          List<AfterSalesVo> afterSalesVoList = apiAfterSalesService.queryList(query);
          int total = apiAfterSalesService.queryTotal(query);
          ApiPageUtils pageUtil = new ApiPageUtils(afterSalesVoList, total, query.getLimit(), query.getPage());
          //
          return toResponsSuccess(pageUtil); 
	}
	
	 /**
     * list
     */
	@ApiOperation(value = "手机保修卡")
    @GetMapping(value = "detail")
    public Object detail(@LoginUser UserVo loginUser,@RequestParam(value = "afterId", defaultValue = "1") Integer afterId) {
		
		return apiAfterSalesService.detail(afterId);
	}
	@ApiOperation(value = "客服电话")
    @GetMapping(value = "phone")
	@IgnoreAuth
    public Object phone() {
		
		String phone=sysConfigService.getValue("103", "");
		return toResponsSuccess(phone);
	}
}
