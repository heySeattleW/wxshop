export default {
  setGoodsCount(state, data){
    state.goodsCount = data.goodsCount
  },
  setCatalog(state, data){
    state.navList = data.categoryList;
    state.currentCategory = data.currentCategory
  },
  setCurrentCategory(state, data){
    state.currentCategory = data.currentCategory
  }
}
