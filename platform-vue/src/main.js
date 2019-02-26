// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import i18n from './i18n'
Vue.config.productionTip = false
//全局样式
import './assets/css/global.css'

// 公共组件
import "src/components/components"

//lib
import Cube from 'cube-ui'
Vue.use(Cube)

//extends
import 'src/extends'

/* eslint-disable no-new */
var $vm = new Vue({
  el: '#app',
  router,
  store,
  i18n,
  components: { App },
  template: '<App/>'
})

//i18n扩展
window.t = function(str, args){
  let t_str = $vm.$t(str);
  if(args){
    if (typeof (args) == "object") {
      for (var key in args) {
        if(args[key]!=undefined){
          var reg = new RegExp("({" + key + "})", "g");
          t_str = t_str.replace(reg, args[key]);
        }
      }
    }
  }
  return t_str
}
Vue.prototype.t = window.t



