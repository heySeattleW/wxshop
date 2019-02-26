export default {
  setGoodsDetail(state, data){
    state.goods = data.info
    state.gallery = data.gallery.map(item => {
      return {id:item.id, image_url:item.img_url};
    })
    state.attribute = data.attribute
    state.specificationList = data.specificationList
    state.productList = data.productList
    state.comment = data.comment
    state.issueList = data.issue;
    state.userHasCollect = data.userHasCollect
  },
  setCartGoodsCount(state, data){
    state.cartGoodsCount = data.cartTotal.goodsCount
  },
  setSpecificationList(state, data){
    state.specificationList = data
  },
  setUserHasCollect(state, data){
    state.userHasCollect = data
  },
  setGoodsCoupons(state, data){
    state.coupons = data
  }
}
