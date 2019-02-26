import Vue from 'vue'
import api from 'src/config/api'
import {$http} from './http'
const wx = require('weixin-js-sdk');

const $toast = Vue.prototype.$toast
const $alert = Vue.prototype.$alert

const getWxConfig = (path)=> new Promise((resolve,reject)=>{
  $http(api.eshopGetWxConfig, {path: path}).then((res)=>{
    if(res.errno==0){
      let data = res.data
      let appId = data.appId;
      let timestamp = data.timeStamp;
      let nonceStr = data.nonceStr;
      let signature = data.signature;
      wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: appId, // 必填，公众号的唯一标识
        timestamp: timestamp, // 必填，生成签名的时间戳
        nonceStr: nonceStr, // 必填，生成签名的随机串
        signature: signature, // 必填，签名，见附录1
        jsApiList: [
          'chooseImage',
          'previewImage',
          'uploadImage',
          'downloadImage',
          'getLocalImgData'
        ]
      });
      wx.ready(function(){
        resolve(true)
      })
      wx.error(function(err){
        $toast("验证失败，请重试！", 'error');
        reject(err)
      })
    }
  })
})

const chooseImage = (num)=> new Promise((resolve,reject)=>{
  wx.chooseImage({
    count: num,
    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
    success: (res) => {
      if (res.localIds.length == 0) {
        $toast('没有选中任何图片','warn');
      }else{
        let promiseArr = []
        res.localIds.forEach(localId => {
          promiseArr.push(uploadImage(localId))
        })
        Promise.all(promiseArr).then((result) => {
          resolve(result)
        })
        // wx.uploadImage({
        //   localId: res.localIds.toString(), // 需要上传的图片的本地ID，由chooseImage接口获得
        //   isShowProgressTips: 1, // 默认为1，显示进度提示
        //   success: function (result) {
        //     let serverId = result.serverId; // 返回图片的服务器端ID
        //     resolve(serverId)
        //   },
        //   fail: function(error){
        //     reject(error)
        //   }
        // });
      }
    }
  });
})

const getLocalImgData = (localId) => new Promise((resolve,reject)=>{
  wx.getLocalImgData({
    localId: localId, // 图片的localID
    success: function (res) {
      resolve(res.localData); // localData是图片的base64数据，可以用img标签显示
    }
  });
})

const uploadImage = (localId) => new Promise((resolve, reject)=> {
  wx.uploadImage({
    localId: localId,
    isShowProgressTips: 1, // 默认为1，显示进度提示
    success: function (res) {//获取成功
      resolve(res.serverId)
    },
    fail: function(error){
      reject(error)
    }
  })
})

export default {
  uploadImages : (path, num) => new Promise((resolve,reject)=>{
    num = num || 5
    getWxConfig(path).then(res => {
      if(res){
        chooseImage(num).then(async results =>{
          console.log("真正的上传")
          let res = await $http(api.eshopUploadImage, {serverIds :results}, 'POST')
          if(res.errno==0){
            resolve(res.data)
          }
        })
      }
    })
  })
}
