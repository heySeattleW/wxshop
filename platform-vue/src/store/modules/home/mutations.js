export default {
  setBanners(state, data){
    state.banners = data.banner.map(r=>{return {image:r.image_url, url:r.url}})
  },
  setChannel(state, data){
    state.channel = data.channel
  },
  setCoupons(state, data){
    state.coupons = data
  },
  setActivityGoods(state, data){
    state.activityGoods = data
  }
}
