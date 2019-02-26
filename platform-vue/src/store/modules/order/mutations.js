export default {
  setOrderDetail(state, data){
    state.orderInfo = data.orderInfo
    state.orderGoods = data.orderGoods
    state.handleOption = data.handleOption
  },
}
