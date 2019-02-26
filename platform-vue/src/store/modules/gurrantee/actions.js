import api from 'src/config/api'
import {$http} from 'src/extends/http'
export default {
  getGurranteeCardInfo: async ({commit}, id) => {
    let res = await $http(api.eshopGurranteeInfo, {afterId:id})
    if (res.errno==0) {
      commit('setGurranteeCardInfo', res.data)
    }
  },
  getGurranteeCardList: async ({commit}, params) => {
    let res = await $http(api.eshopGurranteeList, params)
    if (res.errno==0) {
      commit('setGurranteeCardList', res.data.data)
    }
  }
}
