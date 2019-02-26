import api from 'src/config/api'
import {$http} from 'src/extends/http'
export default {
  getGoodsCount: async function({commit}){
    let res = await $http(api.eshopGoodsCount)
    if (res.errno==0) {
      commit('setGoodsCount', res.data)
    }
  },
  getCatalog: async function({commit}){
    let res = await $http(api.eshopCatalogList)
    if (res.errno==0){
      commit('setCatalog', res.data)
    }
  },
  getCurrentCategory: async function({commit}, id){
    let res = await $http(api.eshopCatalogCurrent, {id:id})
    if (res.errno==0){
      commit('setCurrentCategory', res.data)
    }
  }
}
