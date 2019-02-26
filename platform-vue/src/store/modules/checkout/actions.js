import api from 'src/config/api'
import {$http} from 'src/extends/http'
export default {
  getCheckoutInfo: async function({commit,state}, o){
    let res = await $http(api.eshopCartCheckOut, { addressId: o.addressId, couponId: o.couponId, type: o.buyType})
    if (res.errno==0) {
      commit('setCheckoutInfo', res.data)
    }
  }
}
