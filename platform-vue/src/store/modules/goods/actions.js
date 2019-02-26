import api from 'src/config/api'
import {$http} from 'src/extends/http'
export default {
  getGoodsDetail: async ({commit}, id) => {
    let res = await $http(api.eshopGoodsDetail, {id})
    if (res.errno==0) {
      commit('setGoodsDetail', res.data)

      let _res = await $http(api.eshopGetGoodsCoupon, {goodsId:id})
      commit('setGoodsCoupons', _res)
    }
  },
  getCartGoodsCount: async ({commit}) => {
    let res = await $http(api.eshopCartGoodsCount)
    if (res.errno==0) {
      commit('setCartGoodsCount', res.data)
    }
  }
}
