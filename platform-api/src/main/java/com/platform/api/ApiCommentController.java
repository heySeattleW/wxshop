package com.platform.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.platform.annotation.IgnoreAuth;
import com.platform.annotation.LoginUser;
import com.platform.entity.*;
import com.platform.service.*;
import com.platform.util.ApiBaseAction;
import com.platform.util.ApiPageUtils;
import com.platform.utils.Base64;
import com.platform.utils.CharUtil;
import com.platform.utils.Query;
import com.platform.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-08-11 08:32<br>
 * 描述: ApiIndexController <br>
 */
@Api(tags = "评论")
@RestController
@RequestMapping("/api/comment")
public class ApiCommentController extends ApiBaseAction {
    @Autowired
    private ApiCommentService commentService;
    @Autowired
    private ApiUserService userService;
    @Autowired
    private ApiCommentPictureService commentPictureService;
    @Autowired
    private ApiCouponService apiCouponService;
    @Autowired
    private ApiUserCouponService apiUserCouponService;
    
    @Autowired
    private ApiOrderService orderService;

    /**
     * 发表评论
     */
    @ApiOperation(value = "发表评论")
    @PostMapping("postcomment")
    public Object postComment(@LoginUser UserVo loginUser) {
    	JSONObject jsonParam = getJsonRequest();
    	String comments=jsonParam.getString("comments");
    	System.out.println(jsonParam.toString());
    	System.out.println(jsonParam.get("comments"));
    	List<CommentVo> componentList=JSONObject.parseArray(comments,CommentVo.class);
    
    	for(int i=0;i<componentList.size();i++) {
    		CommentVo commentVo=componentList.get(i);
    		if(commentVo.getStars()==null) {
    			commentVo.setType(1);
    		}
    		if(commentVo.getStars()>=4) {
    			commentVo.setType(1);
    		}
    		else if(commentVo.getStars()>=2) {
    			commentVo.setType(2);
    		}
    		else {
    			commentVo.setType(3);
    		}
    		commentVo.setType_id(0);
    		commentVo.setValue_id(commentVo.getGoods_id());
    		commentVo.setAdd_time(System.currentTimeMillis() / 1000);
    		commentVo.setUser_id(loginUser.getUserId());
    		if(commentVo.getContent()==null||commentVo.getContent().trim().length()==0){
    			commentVo.setContent("此用户没有评价");
    		}
    		commentVo.setContent(Base64.encode(commentVo.getContent()));
    		if(commentVo.getImages()!=null&&commentVo.getImages().length>0) {
    			commentVo.setImageflag(true);
    		}
    		Integer insertId = commentService.save(commentVo);
            //
    		 int inx = 0;
    		 System.out.println("begin insert image");
            if (insertId > 0 && null != commentVo.getImages() && commentVo.getImages().length > 0) {
            	 System.out.println("begin insert image="+commentVo.getImages());
                for (String imgLink : commentVo.getImages()) {
                	inx++;
                    CommentPictureVo pictureVo = new CommentPictureVo();
                    System.out.println("begin insert insertId="+insertId);
                    pictureVo.setComment_id(commentVo.getId());
                    pictureVo.setPic_url(imgLink);
                    pictureVo.setSort_order(inx);
                    
                    System.out.println("save insert commentPictureService");
                    commentPictureService.save(pictureVo);
                }
            }
           
            if (insertId > 0 && null != commentVo.getVideos() && commentVo.getVideos().length > 0) {
           	
               for (Video video : commentVo.getVideos()) {
               	inx++;
                   CommentPictureVo pictureVo = new CommentPictureVo();
                   System.out.println("begin insert insertId="+insertId);
                   pictureVo.setComment_id(commentVo.getId());
                   pictureVo.setPic_url(video.getUrlimg());
                   pictureVo.setSort_order(inx);
                   pictureVo.setVideo_url(video.getUrl());
                   System.out.println("save insert commentPictureService");
                   commentPictureService.save(pictureVo);
               }
           }
            OrderVo orderVo = orderService.queryObject(commentVo.getOrder_id());
            orderVo.setOrder_status(302);
            orderVo.setShipping_status(2);
            orderVo.setConfirm_time(new Date());
            orderService.update(orderVo);
           
    	}
    	
    	 return toResponsObject(0, "评论添加成功",null);
    }
    /**
     * 发表评论
     */
    @ApiOperation(value = "发表评论")
    @PostMapping("post")
    public Object post(@LoginUser UserVo loginUser) {
        Map resultObj = new HashMap();
        //
        JSONObject jsonParam = getJsonRequest();
        Integer typeId = jsonParam.getInteger("typeId");
        Integer valueId = jsonParam.getInteger("valueId");
        String content = jsonParam.getString("content");
        JSONArray imagesList = jsonParam.getJSONArray("imagesList");
        CommentVo commentEntity = new CommentVo();
        commentEntity.setType_id(typeId);
        commentEntity.setValue_id(valueId);
        commentEntity.setContent(content);
        commentEntity.setStatus(0);
        //
        commentEntity.setAdd_time(System.currentTimeMillis() / 1000);
        commentEntity.setUser_id(loginUser.getUserId());
        commentEntity.setContent(Base64.encode(commentEntity.getContent()));
        Integer insertId = commentService.save(commentEntity);
        //
        if (insertId > 0 && null != imagesList && imagesList.size() > 0) {
            int i = 0;
            for (Object imgLink : imagesList) {
                i++;
                CommentPictureVo pictureVo = new CommentPictureVo();
                pictureVo.setComment_id(insertId);
                pictureVo.setPic_url(imgLink.toString());
                pictureVo.setSort_order(i);
                commentPictureService.save(pictureVo);
            }
        }
        // 是否领取优惠券
        if (insertId > 0 && typeId == 0) {
            // 当前评价的次数
            Map param = new HashMap();
            param.put("value_id", valueId);
            List<CommentVo> commentVos = commentService.queryList(param);
            boolean hasComment = false;
            for (CommentVo commentVo : commentVos) {
                if (commentVo.getUser_id().equals(loginUser.getUserId())
                        && !commentVo.getId().equals(insertId)) {
                    hasComment = true;
                }
            }
            if (!hasComment) {
                Map couponParam = new HashMap();
                couponParam.put("send_type", 6);
                CouponVo newCouponConfig = apiCouponService.queryMaxUserEnableCoupon(couponParam);
                if (null != newCouponConfig
                        && newCouponConfig.getMin_transmit_num() >= commentVos.size()) {
                    UserCouponVo userCouponVo = new UserCouponVo();
                    userCouponVo.setAdd_time(new Date());
                    userCouponVo.setCoupon_id(newCouponConfig.getId());
                    userCouponVo.setCoupon_number(CharUtil.getRandomString(12));
                    userCouponVo.setUser_id(loginUser.getUserId());
                    apiUserCouponService.save(userCouponVo);
                    resultObj.put("coupon", newCouponConfig);
                }
            }
        }
        if (insertId > 0) {
            return toResponsObject(0, "评论添加成功", resultObj);
        } else {
            return toResponsFail("评论保存失败");
        }
    }

    /**
     */
    @ApiOperation(value = "评论数量")
    @GetMapping("count")
    public Object count(Integer typeId, Integer valueId) {
        Map<String, Object> resultObj = new HashMap();
        //
        Map param = new HashMap();
        param.put("type_id", typeId);
        param.put("value_id", valueId);
        Integer allCount = commentService.queryTotal(param);
        Integer hasPicCount = commentService.queryhasPicTotal(param);
        //
        resultObj.put("allCount", allCount);
        resultObj.put("hasPicCount", hasPicCount);
        return toResponsSuccess(resultObj);
    }
    
    /**
     */
    @ApiOperation(value = "评论数量")
    @GetMapping("groupcount")
    public Object groupcount( Integer valueId) {
        Map<String, Object> resultObj = new HashMap();
        //
        Map param = new HashMap();
        param.put("goods_id", valueId);
        List<GroupCountVo> groupCountVoList = commentService.queryGroupCount(param);
        GroupCountVo[] groupCountVos=new GroupCountVo[5];
        groupCountVos[0]=new GroupCountVo(); 
        groupCountVos[1]=new GroupCountVo(); 
        groupCountVos[2]=new GroupCountVo(); 
        groupCountVos[3]=new GroupCountVo(); 
        groupCountVos[4]=new GroupCountVo(); 
        groupCountVos[0].setFlag(0);
        groupCountVos[1].setFlag(1);
        groupCountVos[2].setFlag(2);
        groupCountVos[3].setFlag(3);
        groupCountVos[4].setFlag(4);
        for(GroupCountVo groupCountVo:groupCountVoList) {
        	 groupCountVos[0].setNum( groupCountVos[0].getNum()+groupCountVo.getNum());
        	 if(groupCountVo.getStars()==null) {
        		 groupCountVos[1].setNum( groupCountVos[1].getNum()+groupCountVo.getNum());
        	 }
        	 if(groupCountVo.getStars()>=4) {
        		 groupCountVos[1].setNum( groupCountVos[1].getNum()+groupCountVo.getNum());
        	 }
        	 if(groupCountVo.getStars()>=2&&groupCountVo.getStars()<4) {
        		 groupCountVos[2].setNum( groupCountVos[2].getNum()+groupCountVo.getNum());
        	 }
        	 if(groupCountVo.getStars()<2) {
        		 groupCountVos[3].setNum( groupCountVos[3].getNum()+groupCountVo.getNum());
        	 }
        	 System.out.println("isImageflag="+groupCountVo.isImageflag());
        	 if(groupCountVo.isImageflag()) {
        		 groupCountVos[4].setNum( groupCountVos[4].getNum()+groupCountVo.getNum());
        	 }
        }
       
        return toResponsSuccess(groupCountVos);
    }

    /**
     * @param typeId
     * @param valueId
     * @param type 选择评论的类型 0 全部， 1 好评 2 中评 3差评 4 有图
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "选择评论类型")
    @IgnoreAuth
    @GetMapping("list")
    public Object listtype( Integer valueId, Integer type,
                       @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                       String sort, String order) {
        Map<String, Object> resultObj = new HashMap();
        List<CommentVo> commentList = new ArrayList();
        Map param = new HashMap();
        param.put("value_id", valueId);
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
        if(type!=null&&type!=0&&type!=4) {
           param.put("type", type);
        }
        if(type!=null&&type==4) {
            param.put("imageflag", 1);
         }
        
        //查询列表数据
        Query query = new Query(param);
        commentList = commentService.queryList(query);
        int total = commentService.queryTotal(query);
        ApiPageUtils pageUtil = new ApiPageUtils(commentList, total, query.getLimit(), query.getPage());
        //
        for (CommentVo commentItem : commentList) {
            commentItem.setContent(Base64.decode(commentItem.getContent()));
            commentItem.setUser_info(userService.queryObject(commentItem.getUser_id()));

            Map paramPicture = new HashMap();
            paramPicture.put("comment_id", commentItem.getId());
           
            List<CommentPictureVo> commentPictureEntities = commentPictureService.queryList(paramPicture);
            Integer imgnum=0;
            Integer videonum=0;
            for(CommentPictureVo commentPictureVo : commentPictureEntities ) {
            	if(commentPictureVo.getVideo_url()==null) {
            		imgnum++;
            	}else {
            		videonum++;
            	}
            }
            String[] images=new String[imgnum];
            Video[] videos=new Video[videonum];
             imgnum=0;
             videonum=0;
            for(CommentPictureVo commentPictureVo : commentPictureEntities ) {
            	if(commentPictureVo.getVideo_url()==null) {
            		images[imgnum]=commentPictureVo.getPic_url();
            		imgnum++;
            	}else {
            		videos[videonum]=new Video();
            		videos[videonum].setUrl(commentPictureVo.getPic_url());
            		videos[videonum].setUrlimg(commentPictureVo.getVideo_url());
            		videonum++;
            	}
            }
            commentItem.setImages(images);
            commentItem.setVideos(videos);
            
            commentItem.setPic_list(commentPictureEntities);
        }
        return toResponsSuccess(pageUtil);
    }
    
    /**
     * @param typeId
     * @param valueId
     * @param showType 选择评论的类型 0 全部， 1 好评 2 中评 3差评 4 有图
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "选择评论类型")
    @IgnoreAuth
    @GetMapping("listgroup")
    public Object list(Integer typeId, Integer valueId, Integer showType,
                       @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size,
                       String sort, String order) {
        Map<String, Object> resultObj = new HashMap();
        List<CommentVo> commentList = new ArrayList();
        Map param = new HashMap();
        param.put("type_id", typeId);
        param.put("value_id", valueId);
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
        if (null != showType && showType == 1) {
            param.put("hasPic", 1);
        }
        //查询列表数据
        Query query = new Query(param);
        commentList = commentService.queryList(query);
        int total = commentService.queryTotal(query);
        ApiPageUtils pageUtil = new ApiPageUtils(commentList, total, query.getLimit(), query.getPage());
        //
        for (CommentVo commentItem : commentList) {
            commentItem.setContent(Base64.decode(commentItem.getContent()));
            commentItem.setUser_info(userService.queryObject(commentItem.getUser_id()));

            Map paramPicture = new HashMap();
            paramPicture.put("comment_id", commentItem.getId());
            List<CommentPictureVo> commentPictureEntities = commentPictureService.queryList(paramPicture);
            commentItem.setPic_list(commentPictureEntities);
        }
        return toResponsSuccess(pageUtil);
    }
}