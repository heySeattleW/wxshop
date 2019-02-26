import Vue from 'vue'
import Vuex from 'vuex'

import common from './modules/common'
import home from './modules/home'
import goods from './modules/goods'
import comment from './modules/comment'
import catalog from './modules/catalog'
import category from './modules/category'
import center from './modules/center'
import user from './modules/user'
import checkout from './modules/checkout'
import order from './modules/order'
import gurrantee from './modules/gurrantee'

Vue.use(Vuex);
const store = new Vuex.Store({
  modules: {
    common,
    user,
    home,
    catalog,
    goods,
    center,
    category,
    comment,
    checkout,
    order,
    gurrantee
  }
})

export default store;
