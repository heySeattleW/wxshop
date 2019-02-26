export default {
  userCoupon: 'NO_USE_COUPON',
  courseCouponCode: {},

  addressId: 0,
  checkedGoodsList: [], //商品列表
  checkedAddress: {}, //默认地址
  price:{
    goodsTotalPrice: 0.00, //商品总价
    freightPrice: 0.00,    //快递费
    couponPrice: 0.00,     //优惠券的价格
    orderTotalPrice: 0.00,  //订单总价
    actualPrice: 0.00,     //实际需要支付的总价
  },
}
