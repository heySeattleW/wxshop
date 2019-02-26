import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    //第一层
    {
      path: '/',
      name: '/',
      redirect: 'home'
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('views/home/home')
    },
    {
      path: '/catalog',
      name: 'catalog',
      component: () => import('views/catalog/catalog')
    },
    {
      path: '/testphone',
      name: 'testphone',
      component: () => import('views/testphone/testphone')
    },
    {
      path:'/shopping',
      name:'shopping',
      component: () => import('views/shopping/shopping')
    },
    {
      path: '/center',
      name: 'center',
      component: () => import('views/center/center')
    },
    //第二层
    {
      path: '/search',
      name: 'search',
      meta: {
        rank: 2
      },
      component: () => import('views/search/search')
    },
    {
      path: '/goods/:id',
      name: 'goods',
      meta: {
        rank: 5
      },
      component: () => import('views/goods/goods')
    },
    {
      path: '/category/:id',
      name: 'category',
      meta: {
        rank: 3
      },
      component: ()=> import('views/category/category')
    },
    {
      path: '/setting',
      name: 'setting',
      meta: {
        rank: 2
      },
      component: () => import('views/center/setting')
    },
    {
      path: '/collect',
      name: 'collect',
      meta: {
        rank: 2
      },
      component: () => import('views/center/collect')
    },
    {
      path: '/coupon',
      name: 'coupon',
      meta: {
        rank: 2
      },
      component: () => import('views/center/coupon/coupon')
    },
    {
      path: '/address',
      name: 'address',
      meta: {
        rank: 2
      },
      component: () => import('views/center/address')
    },
    {
      path: '/order',
      name: 'order',
      meta: {
        rank: 2
      },
      component: () => import('views/center/orders/order')
    },
    {
      path: '/couponGoods/:id',
      name: 'couponGoods',
      meta: {
        rank: 3
      },
      component: () => import('views/center/coupon/coupon-goods')
    },
    {
      path: '/login',
      name: 'login',
      meta: {
        rank: 2
      },
      component: () => import('views/login/login')
    },
    {
      path: '/checkout',
      name: 'checkout',
      meta: {
        rank: 6
      },
      component: () => import('views/buy/checkout/checkout')
    },
    {
      path: '/buy/address',
      name: 'buy.address',
      meta: {
        rank: 9
      },
      component: () => import('views/buy/address/address')
    },
    //第三层
    {
      path: '/comment',
      name: 'comment',
      meta: {
        rank: 7
      },
      component: () => import('views/comment/comment')
    },
    {
      path: '/addressAdd',
      name: 'addressAdd',
      meta: {
        rank: 7
      },
      component: () => import('views/center/address-add')
    },
    {
      path: '/orderDetail/:id',
      name: 'orderDetail',
      meta: {
        rank: 7
      },
      component: () => import('views/center/orders/order-detail')
    },
    {
      path: '/loginMobile',
      name: 'loginMobile',
      meta: {
        rank: 7
      },
      component: () => import('views/login/login-mobile')
    },
    {
      path: '/guarantee',
      name: 'guarantee',
      meta: {
        rank: 7
      },
      component: () => import('views/center/guarantee/guarantee-card')
    },
    //叶子节点
    {
      path: '/buy/addressAdd',
      name: 'buy.address.add',
      meta: {
        rank: 10
      },
      component: () => import('views/buy/address/address-add')
    },
    {
      path: '/selCoupon',
      name: 'selCoupon',
      meta: {
        rank: 10
      },
      component: () => import('views/buy/selCoupon/sel-coupon')
    },
    {
      path: '/buy/pay',
      name: 'pay',
      meta: {
        rank: 10
      },
      component: () => import('views/buy/pay/pay')
    },
    {
      path: '/buy/payResult/:status/:orderId',
      name: 'payResult',
      meta: {
        rank: 10
      },
      component: () => import('views/buy/payResult/pay-result')
    },
    {
      path: '/buy/rate/:orderId',
      name: 'rate',
      meta: {
        rank: 10
      },
      component: () => import('views/buy/rate/rate-comment')
    },
    {
      path: '/guaranteeDetail/:id',
      name: 'guaranteeDetail',
      meta: {
        rank: 10
      },
      component: () => import('views/center/guarantee/guarantee-detail')
    },
    {
      path: '/common/video',
      name: 'video',
      meta: {
        rank: 10
      },
      component: () => import('views/common/video-full')
    }
  ]
})
