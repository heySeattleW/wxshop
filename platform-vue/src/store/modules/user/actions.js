import api from 'src/config/api'
import {$http} from 'src/extends/http'
import {toast} from 'src/extends/cube-ui'
import {getStore} from "src/extends/mUtils";

export default {
  loginByWechat: async function({commit}, code){
    let res = await $http(api.eshopLoginWechat, {code}, 'POST')
    if (res.errno==0){
      commit('setUserInfo', res.data)
      return true;
    }
  },
  getUserInfo: async function({commit,state}){
    let userInfo = getStore('userInfo')
    if(userInfo){
      state.userInfo = JSON.parse(userInfo)
    }
    return state.userInfo
  },
  getIdentifyingCode: async function({commit, state}){
    if (state.identifyingCode.time !== 60) {
      toast('请稍后重试', 'correct')
    } else {
      let res = await $http(api.eshopGetIdentifyingCode, {}, 'POST')
      if(res.success){
        toast('发送验证码成功', 'correct')
        const timer = setInterval(() => {
          if (state.identifyingCode.time === 0) {
            commit('clearIdentifyTimer')
          }else{
            commit('updateIdentifyTime', state.identifyingCode.time - 1)
          }
        },1000)
        commit('updateIdentifyTimer', timer)
      }else{
        toast(res.msg, 'warn')
      }
    }
  }
}
