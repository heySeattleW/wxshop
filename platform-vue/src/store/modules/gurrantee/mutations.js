export default {
  setGurranteeCardList(state, data){
    state.cardList = state.cardList.concat(data);
  },
  setGurranteeCardInfo(state, data){
    state.cardInfo = data
  },
  resetGurranteeList(state){
    state.cardList = []
  }
}
