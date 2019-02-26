export default {
  setCategoryInfo(state, data){
    state.navList = data.brotherCategory
    state.currentCategory = data.currentCategory
  }
}
