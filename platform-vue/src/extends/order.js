import Vue from 'vue'
import api from 'src/config/api'
import {$http} from './http'
import {pay} from './pay'
import router from 'src/router'

const $alert = Vue.prototype.$alert
const $confirm = Vue.prototype.$confirm
const $toast = Vue.prototype.$toast

const payOrder = order_id => {
  pay(order_id).then(res=>{
    router.replace('/buy/payResult/1/' + order_id)
  }).catch(err=>{
    router.replace('/buy/payResult/0/' + order_id)
  })
}

const cancelOrder = (order_id, order_status, callback) => {
  let errorMessage = '';
  switch (order_status){
    case 300: {
      console.log('已发货，不能取消');
      errorMessage = '订单已发货，不能取消';
      break;
    }
    case 301:{
      console.log('已收货，不能取消');
      errorMessage = '订单已收货，不能取消';
      break;
    }
    case 101:{
      console.log('已经取消');
      errorMessage = '订单已取消，不能取消';
      break;
    }
    case 102: {
      console.log('已经删除');
      errorMessage = '订单已删除，不能取消';
      break;
    }
    case 401: {
      console.log('已经退款');
      errorMessage = '订单已退款，不能取消';
      break;
    }
    case 402: {
      console.log('已经退款退货');
      errorMessage = '订单已退货，不能取消';
      break;
    }
  }
  if (errorMessage != '') {
    console.log(errorMessage);
    $toast(errorMessage,'warn');
    return false;
  }

  $confirm('提示',"您确定要取消此订单吗？").then(async confirm=>{
    if (confirm) {
      let res = await $http(api.eshopOrderCancel,{ orderId: order_id }, 'POST')
      if (res.errno === 0) {
        $toast('订单取消成功', 'correct')
        callback && setTimeout(callback, 1000)
      }
    }
  })
}

const confirmOrder = (order_id, order_status, callback) => {
  let errorMessage = '';
  switch (order_status) {
    case 301: {
      console.log('已收货，不能再收货');
      errorMessage = '订单已收货';
      break;
    }
    case 101: {
      console.log('已经取消');
      errorMessage = '订单已取消';
      break;
    }
    case 102: {
      console.log('已经删除');
      errorMessage = '订单已删除';
      break;
    }
    case 401: {
      console.log('已经退款');
      errorMessage = '订单已退款';
      break;
    }
    case 402: {
      console.log('已经退款退货');
      errorMessage = '订单已退货';
      break;
    }
  }

  if (errorMessage != '') {
    console.log(errorMessage);
    $toast(errorMessage, 'warn');
    return false;
  }

  $confirm('提示',"确定已经收到商品?").then(async confirm=>{
    if (confirm) {
      let res = await $http(api.eshopOrderConfirm,{ orderId: order_id }, 'POST')
      if (res.errno === 0) {
        $alert('您已确认收货', '快来留下您的宝贵评价吧~','去晒单').then(()=>{
          router.push('/buy/rate/' + order_id)
        })
      }
    }
  })
}

const commentOrder = orderId => {
  router.push('/buy/rate/' + orderId)
}

const returnOrder = (content) => {
  callCustomerService(content)
}

const callCustomerService = (content) =>{
  $http(api.eshopCustomerServicePhone).then(res => {
    if(res.errno==0){
      let phone = res.data
      let data = [{ content: t("center.call") }]; //{ content: this.$t("center.onlineService")}
      content.$createActionSheet({
        title: phone,
        data: data,
        zIndex:9999,
        onSelect: (item, index) => {
          if (index == 0) window.location.href = `tel:${phone}`;
        }
      }).show();
    }
  })
}

export default {
  payOrder,
  cancelOrder,
  confirmOrder,
  commentOrder,
  returnOrder,
  callCustomerService
}
