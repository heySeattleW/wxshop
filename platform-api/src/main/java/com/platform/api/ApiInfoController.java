package com.platform.api;

import java.util.Calendar;
import java.util.Date;
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
import com.platform.entity.InfoVo;
import com.platform.entity.UserVo;
import com.platform.service.ApiInfoService;
import com.platform.util.ApiBaseAction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "跑马灯")
@RestController
@RequestMapping("/api/info")
public class ApiInfoController extends ApiBaseAction  {
	@Autowired
	private ApiInfoService apiInfoService;
	@ApiOperation(value = "跑马灯")
    @GetMapping(value = "list")
	@IgnoreAuth
    public Object list() {
		Map params=new HashMap();
		Date date=new Date();
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, -1);//
	    date = calendar.getTime();
		params.put("nowDate", date.getTime());
		List<InfoVo> infoVoList=apiInfoService.queryList(params);
		return toResponsSuccess(infoVoList);
	}
}
