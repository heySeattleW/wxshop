import api from 'src/config/api'
import {$http} from 'src/extends/http'
export default {
  getCommentCount: async function({commit}, id){
    let res = await $http(api.eshopCommentCount, {valueId: id})
    if (res.errno==0) {
      commit('setCommentCount', res.data)
    }
  }
}
