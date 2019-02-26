import api from 'src/config/api'
import {$http} from 'src/extends/http'
export default {
  getBanners: async function({commit}){
    let res = await $http(api.eshopBanners)
    if (res.errno==0){
      commit('setBanners', res.data)
    }
  },
  getChannel: async function({commit}){
    let res = await $http(api.eshopChannel)
    if (res.errno==0){
      commit('setChannel', res.data)
    }
  },
  getCoupons: async function({commit}){
    let res = await $http(api.eshopAllCoupons)
    if (res.errno==0){
      commit('setCoupons', res.data)
    }
  },
  getActivityGoods: async function({commit}){
    let res = await $http(api.eshopActivityGoods)
    if (res.errno==0){
      commit('setActivityGoods', res.data)
    }
  }
}
