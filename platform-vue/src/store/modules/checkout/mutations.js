export default {
  setCheckoutInfo(state, data){
    state.checkedGoodsList = data.checkedGoodsList
    state.checkedAddress = data.checkedAddress
    state.checkedCoupon = data.checkedCoupon || {}
    state.couponList = data.couponList || []
    state.price = {
      actualPrice : data.actualPrice,
      couponPrice : data.couponPrice,
      freightPrice : data.freightPrice,
      goodsTotalPrice : data.goodsTotalPrice,
      orderTotalPrice : data.orderTotalPrice
    }
    if(data.checkedAddress.id){
      state.addressId = data.checkedAddress.id
    }
  },
  useUserCoupon(state, coupon){
    state.userCoupon = 'USE_COUPON'
    state.courseCouponCode = coupon
  },
  resetUserCoupon(state){
    state.userCoupon = 'NO_USE_COUPON'
    state.courseCouponCode = {}
  },
  setAddressId(state, data){
    state.addressId = data
  }
}
