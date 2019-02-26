package com.platform.api;

import com.alibaba.fastjson.JSONObject;
import com.platform.annotation.IgnoreAuth;
import com.platform.annotation.LoginUser;
import com.platform.cache.J2CacheUtils;
import com.platform.entity.*;
import com.platform.service.*;
import com.platform.util.ApiBaseAction;
import com.platform.utils.CharUtil;
import com.platform.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * API优惠券管理
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:31
 */
@Api(tags = "优惠券")
@RestController
@RequestMapping("/api/coupon")
public class ApiCouponController extends ApiBaseAction {
    @Autowired
    private ApiUserService apiUserService;
    @Autowired
    private ApiCouponService apiCouponService;
    @Autowired
    private ApiUserCouponService apiUserCouponService;
    @Autowired
    private ApiProductService apiProductService;
    @Autowired
    private ApiCartService apiCartService;
    @Autowired
    private ApiGoodsService goodsService;
    /**
     * 获取优惠券列表
     */
    @ApiOperation(value = "获取优惠券列表")
    @GetMapping("/list")
    public Object list(@LoginUser UserVo loginUser,@RequestParam(defaultValue = "type") Integer type) {
        Map param = new HashMap();
        param.put("user_id", loginUser.getUserId());
        List<CouponVo> couponVos = apiCouponService.queryUserCoupons(param,type);
        return toResponsSuccess(couponVos);
    }
    
    /**
     * 获取优惠券列表
     */
    @ApiOperation(value = "查找优惠券列表")
    @IgnoreAuth
    @GetMapping("/listAll")
    public Object listAll(@LoginUser UserVo loginUser) {
        Map param = new HashMap();
        param.put("enabled", true);
        List<CouponVo> couponVos = apiCouponService.queryList(param);
        return toResponsSuccess(couponVos);
    }

    /**
     * 根据商品获取可用优惠券列表
     */
    @ApiOperation(value = "根据商品获取可用优惠券列表")
    @GetMapping("/listGoodsCoupon")
    @IgnoreAuth
    public Object listGoodsCoupon( Integer goodsId) {
    	return apiCouponService.querylistGoodsCoupont(goodsId);
    }
    /**
     * 根据商品获取可用优惠券列表
     */
    @ApiOperation(value = "根据商品获取可用优惠券列表")
    @GetMapping("/listByGoods")
    public Object listByGoods(@RequestParam(defaultValue = "cart") String type, @LoginUser UserVo loginUser) {
       
        List<CartVo> cartVoList=new ArrayList();
        if (type.equals("cart")) {
            Map param = new HashMap();
            param.put("user_id", loginUser.getUserId());
            List<CartVo> cartList = apiCartService.queryList(param);
            cartVoList=cartList;
            //获取购物车统计信息
            /*
            for (CartVo cartItem : cartList) {
                if (null != cartItem.getChecked() && 1 == cartItem.getChecked()) {
                    goodsTotalPrice = goodsTotalPrice.add(cartItem.getRetail_price().multiply(new BigDecimal(cartItem.getNumber())));
                 
                }
            }*/
        } else { // 是直接购买的
            BuyGoodsVo goodsVo = (BuyGoodsVo) J2CacheUtils.get(J2CacheUtils.SHOP_CACHE_NAME, "goods" + loginUser.getUserId() + "");
            ProductVo productInfo = apiProductService.queryObject(goodsVo.getProductId());
            CartVo cartVo=new CartVo();
            cartVo.setGoods_id(productInfo.getGoods_id());
            cartVo.setRetail_price(productInfo.getRetail_price());
            cartVo.setNumber(goodsVo.getNumber());
            cartVoList.add(cartVo);
            //商品总价
           // goodsTotalPrice = productInfo.getRetail_price().multiply(new BigDecimal(goodsVo.getNumber()));
        }

        // 获取可用优惠券
        Map param = new HashMap();
        param.put("user_id", loginUser.getUserId());
        param.put("coupon_status", 1);
        List<CouponVo> couponVos = apiCouponService.queryUserCoupons(param,1);
        for(CouponVo couponVo:couponVos) {
        	 List<CouponGoodsVo> goodsEntityList = goodsService.queryCouponoodsList(couponVo.getUser_coupon_id());
        	 for(CouponGoodsVo couponGoodsVo:goodsEntityList) {
        		 
        		 couponVo.getCouponGoodsVoMap().put(couponGoodsVo.getGoodsId(), couponGoodsVo);
        		 System.out.println("put couponVoid"+couponVo.getUser_coupon_id()+" goods="+couponGoodsVo.getGoodsId());
        	 }
        }
      
        
        List<CouponVo> useCoupons = new ArrayList<>();
        List<CouponVo> notUseCoupons = new ArrayList<>();
        for (CouponVo couponVo : couponVos) {
        	 BigDecimal goodsTotalPrice = new BigDecimal(0.00);
        	for(CartVo cartVo:cartVoList) {
        		
        		CouponGoodsVo couponGoodsVo=couponVo.getCouponGoodsVoMap().get(cartVo.getGoods_id());
        		System.out.println("get goods="+cartVo.getGoods_id()+" "+couponGoodsVo);
        		if(couponGoodsVo!=null) {
        			
        			goodsTotalPrice=goodsTotalPrice.add(cartVo.getRetail_price().multiply(new BigDecimal(cartVo.getNumber())));
        			
        		}
        	}
        	System.out.println(goodsTotalPrice+" == "+couponVo.getMin_goods_amount());
        	if(goodsTotalPrice.compareTo(couponVo.getMin_goods_amount())>=0) {
        		couponVo.setEnabled(1);
                useCoupons.add(couponVo);
                couponVo.setCouponGoodsVoMap(null);
        	}
        	else {
        		 couponVo.setEnabled(0);
        		 couponVo.setCouponGoodsVoMap(null);
                 notUseCoupons.add(couponVo);
        	}
        	
            
        }
        useCoupons.addAll(notUseCoupons);
        return toResponsSuccess(useCoupons);
    }

    /**
     * 兑换优惠券
     */
    @ApiOperation(value = "领券优惠券")
    @PostMapping("exchange")
    public Object exchange(@LoginUser UserVo loginUser) {
        JSONObject jsonParam = getJsonRequest();
        String coupon_number = jsonParam.getString("coupon_number");
        if (StringUtils.isNullOrEmpty(coupon_number)) {
            return toResponsFail("当前优惠码无效");
        }
        //
        Map param = new HashMap();
        param.put("coupon_number", coupon_number);
        List<UserCouponVo> couponVos = apiUserCouponService.queryList(param);
        UserCouponVo userCouponVo = null;
        if (null == couponVos || couponVos.size() == 0) {
            return toResponsFail("当前优惠码无效");
        }
        userCouponVo = couponVos.get(0);
        if (null != userCouponVo.getUser_id() && !userCouponVo.getUser_id().equals(0L)) {
            return toResponsFail("当前优惠码已经兑换");
        }
        CouponVo couponVo = apiCouponService.queryObject(userCouponVo.getCoupon_id());
        if (null == couponVo || null == couponVo.getUse_end_date() || couponVo.getUse_end_date().before(new Date())) {
            return toResponsFail("当前优惠码已经过期");
        }
        userCouponVo.setUser_id(loginUser.getUserId());
        userCouponVo.setAdd_time(new Date());
        apiUserCouponService.update(userCouponVo);
        return toResponsSuccess(userCouponVo);
    }

    /**
     * 　　填写手机号码，领券
     */
    @ApiOperation(value = "领券优惠券")
    @PostMapping("newuser")
    public Object newuser(@LoginUser UserVo loginUser) {
        JSONObject jsonParam = getJsonRequest();
        //
        String phone = jsonParam.getString("phone");
        String smscode = jsonParam.getString("smscode");
        // 校验短信码
        SmsLogVo smsLogVo = apiUserService.querySmsCodeByUserId(loginUser.getUserId());
        if (null != smsLogVo && !smsLogVo.getSms_code().equals(smscode)) {
            return toResponsFail("短信校验失败");
        }
        // 更新手机号码
        if (!StringUtils.isNullOrEmpty(phone)) {
            if (phone.equals(loginUser.getMobile())) {
                loginUser.setMobile(phone);
                apiUserService.update(loginUser);
            }
        }
        // 判断是否是新用户
        if (!StringUtils.isNullOrEmpty(loginUser.getMobile())) {
            return toResponsFail("当前优惠券只能新用户领取");
        }
        // 是否领取过了
        Map params = new HashMap();
        params.put("user_id", loginUser.getUserId());
        params.put("send_type", 4);
        List<CouponVo> couponVos = apiCouponService.queryUserCoupons(params,1);
        if (null != couponVos && couponVos.size() > 0) {
            return toResponsFail("已经领取过，不能重复领取");
        }
        // 领取
        Map couponParam = new HashMap();
        couponParam.put("send_type", 4);
        CouponVo newCouponConfig = apiCouponService.queryMaxUserEnableCoupon(couponParam);
        if (null != newCouponConfig) {
            UserCouponVo userCouponVo = new UserCouponVo();
            userCouponVo.setAdd_time(new Date());
            userCouponVo.setCoupon_id(newCouponConfig.getId());
            userCouponVo.setCoupon_number(CharUtil.getRandomString(12));
            userCouponVo.setUser_id(loginUser.getUserId());
            apiUserCouponService.save(userCouponVo);
            return toResponsSuccess(userCouponVo);
        } else {
            return toResponsFail("领取失败");
        }
    }
    
    /**
     * 　　填写手机号码，领券
     */
    @ApiOperation(value = "领券优惠券")
    @PostMapping("newusercoupon")
    public Object newusercoupon(@LoginUser UserVo loginUser) {
        JSONObject jsonParam = getJsonRequest();
       
        Map params = new HashMap();
        Integer couponId=jsonParam.getInteger("couponId");
       
        CouponVo newCouponConfig = apiCouponService.queryObject(couponId);
        if (null == newCouponConfig || null == newCouponConfig.getUse_end_date() || newCouponConfig.getUse_end_date().before(new Date())) {
            return toResponsFail("当前优惠码已经过期");
        }
        //检查是否已经领取过
        Map couponparams=new HashMap();
        couponparams.put("user_id", loginUser.getUserId());
        couponparams.put("coupon_id", couponId);
        List<UserCouponVo> usercouponList=apiUserCouponService.queryList(couponparams);
        boolean find=false;
        for(UserCouponVo userCouponVo:usercouponList) {
        	if(userCouponVo.getCoupon_status()==1) {
        		find=true;
        		break;
        	}
        }
        if(find==true) {
        	 return toResponsFail("有未使用的优惠码");
        }
        if (null != newCouponConfig) {
        	
            UserCouponVo userCouponVo = new UserCouponVo();
            userCouponVo.setAdd_time(new Date());
            userCouponVo.setCoupon_id(newCouponConfig.getId());
            userCouponVo.setCoupon_number(CharUtil.getRandomString(12));
            userCouponVo.setUser_id(loginUser.getUserId());
            apiUserCouponService.save(userCouponVo);
            return toResponsSuccess(userCouponVo);
        } else {
            return toResponsFail("领取失败");
        }
    }


    /**
     * 　　转发领取红包
     */
    @ApiOperation(value = "转发领取红包")
    @PostMapping("transActivit")
    public Object transActivit(@LoginUser UserVo loginUser, String sourceKey, Long referrer) {
        JSONObject jsonParam = getJsonRequest();
        // 是否领取过了
        Map params = new HashMap();
        params.put("user_id", loginUser.getUserId());
        params.put("send_type", 2);
        params.put("source_key", sourceKey);
        List<CouponVo> couponVos = apiCouponService.queryUserCoupons(params,1);
        if (null != couponVos && couponVos.size() > 0) {
            return toResponsObject(2, "已经领取过", couponVos);
        }
        // 领取
        Map couponParam = new HashMap();
        couponParam.put("send_type", 2);
        CouponVo newCouponConfig = apiCouponService.queryMaxUserEnableCoupon(couponParam);
        if (null != newCouponConfig) {
            UserCouponVo userCouponVo = new UserCouponVo();
            userCouponVo.setAdd_time(new Date());
            userCouponVo.setCoupon_id(newCouponConfig.getId());
            userCouponVo.setCoupon_number(CharUtil.getRandomString(12));
            userCouponVo.setUser_id(loginUser.getUserId());
            userCouponVo.setSource_key(sourceKey);
            userCouponVo.setReferrer(referrer);
            apiUserCouponService.save(userCouponVo);
            
            //
            List<UserCouponVo> userCouponVos = new ArrayList();
            userCouponVos.add(userCouponVo);
            //
            params = new HashMap();
            params.put("user_id", loginUser.getUserId());
            params.put("send_type", 2);
            params.put("source_key", sourceKey);
            couponVos = apiCouponService.queryUserCoupons(params,1);
            return toResponsSuccess(couponVos);
        } else {
            return toResponsFail("领取失败");
        }
    }
}
