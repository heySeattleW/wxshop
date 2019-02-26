import api from 'src/config/api'
import {$http} from 'src/extends/http'
export default {
  getCategoryInfo: async function({commit}, id){
    let res = await $http(api.eshopGoodsCategory, {id:id})
    if (res.errno==0) {
      commit('setCategoryInfo', res.data)
    }
  }
}
