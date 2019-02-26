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
import com.platform.entity.CommentPictureVo;
import com.platform.entity.CommentVo;
import com.platform.entity.EvaluateVo;
import com.platform.entity.Video;
import com.platform.service.ApiEvaluateService;
import com.platform.util.ApiBaseAction;
import com.platform.util.ApiPageUtils;
import com.platform.utils.Base64;
import com.platform.utils.Query;
import com.platform.utils.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 手机评测管理
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:31
 */
@Api(tags = "手机评测")
@RestController
@RequestMapping("/api/evaluate")
public class ApiEvaluateController  extends ApiBaseAction{
	 @Autowired
	private ApiEvaluateService apiEvaluateService;
	 /**
     * list
     */
	@ApiOperation(value = "手机评测")
    @IgnoreAuth
    @GetMapping(value = "list")
    public Object list( Integer valueId, Integer type,
            @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
            String sort, String order) {
    	  Map<String, Object> resultObj = new HashMap();
          List<EvaluateVo> commentList = new ArrayList();
          Map param = new HashMap();
        
          param.put("page", page);
          param.put("limit", size);
          if (StringUtils.isNullOrEmpty(sort)) {
              param.put("order", "desc");
          } else {
              param.put("order", sort);
          }
          if (StringUtils.isNullOrEmpty(order)) {
              param.put("sidx", "id");
          } else {
              param.put("sidx", order);
          }
          
          
          //查询列表数据
          Query query = new Query(param);
          commentList = apiEvaluateService.queryList(query);
          int total = apiEvaluateService.queryTotal(query);
          ApiPageUtils pageUtil = new ApiPageUtils(commentList, total, query.getLimit(), query.getPage());
          return toResponsSuccess(pageUtil);
    }
}
