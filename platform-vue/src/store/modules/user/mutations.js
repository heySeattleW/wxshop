import {setStore} from "src/extends/mUtils";
export default {
  setUserInfo(state, data){
    state.userInfo = data.userInfo
    setStore('token', data.token);
    setStore('userInfo', data.userInfo)
  },
  clearIdentifyTimer(state){
    clearInterval(state.identifyingCode.timer)
    state.identifyingCode.timer = null
    state.identifyingCode.time = 60
  },
  updateIdentifyTimer(state, timer){
    state.identifyingCode.timer = timer;
  },
  updateIdentifyTime(state, time){
    state.identifyingCode.time = time
  }
}
