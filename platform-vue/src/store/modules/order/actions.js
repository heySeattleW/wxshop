import api from 'src/config/api'
import {$http} from 'src/extends/http'

export default {
  getOrderDetail: async ({commit}, orderId) => {
    let res = await $http(api.eshopOrderDetail, { orderId: orderId })
    if (res.errno === 0) {
      commit('setOrderDetail', res.data)
    }
  }
}

