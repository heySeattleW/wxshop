import Vue from 'vue'
import router from 'src/router'
import store from 'src/store'

router.beforeEach((to, from, next) => {
  //动态修改title
  document.title = 'e商号商城'
  if (to.meta.title) document.title = to.meta.title;
  //路由跳转显示loading
  store.commit('common/setIsLoading', true)
  next();
})

router.afterEach((to) =>{
  store.commit('common/setIsLoading', false)
})

Vue.mixin({
  beforeRouteLeave:function(to, from, next){
    if(from){
      if(!from.meta.hasOwnProperty("rank")) from.meta.rank = 1;
      if(!to.meta.hasOwnProperty('rank')) to.meta.rank =1;
      if(from.meta.rank>=to.meta.rank){
        //如果返回上一层，则摧毁本层缓存。
        if (this.$vnode && this.$vnode.data.keepAlive){
          if (this.$vnode.parent && this.$vnode.parent.componentInstance && this.$vnode.parent.componentInstance.cache){
            if (this.$vnode.componentOptions){
              var key = this.$vnode.key == null
                ? this.$vnode.componentOptions.Ctor.cid + (this.$vnode.componentOptions.tag ? `::${this.$vnode.componentOptions.tag}` : '')
                : this.$vnode.key;
              var cache = this.$vnode.parent.componentInstance.cache;
              var keys  = this.$vnode.parent.componentInstance.keys;
              if (cache[key]){
                if (keys.length) {
                  var index = keys.indexOf(key);
                  if (index > -1) {
                    keys.splice(index, 1);
                  }
                }
                delete cache[key];
              }
            }
          }
        }
        this.$destroy();
      }
    }
    next();
  },
});

Vue.prototype.$go = function (path, cache = true) {
  if (cache) {
    router.push(path)
  } else {
    router.replace(path)
  }
}
Vue.prototype.$back = function () {
  router.go(-1)
}
Vue.prototype.$redirect = function(path) {
  router.replace(path)
}
