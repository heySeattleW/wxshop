<template>
  <div class="container">
    <div class="pay-result">
      <div class="success" v-if="status">
        <img class="imgW30 fr" src="/static/images/pay01.png" alt="" title="" />
        <div class="msg">付款成功</div>
        <div class="btns">
          <router-link class="btn" to="/order" replace>查看订单</router-link>
          <router-link class="btn" to="/home"  replace>继续逛</router-link>
        </div>
      </div>

      <div class="error" v-else>
        <img class="imgW30 fr" src="/static/images/pay02.png" alt="" title="" />
        <div class="msg">付款失败</div>
        <div class="tips">
          <div class="p">请在<span class="time">1小时</span>内完成付款</div>
          <div class="p">否则订单将会被系统取消</div>
        </div>
        <div class="btns">
          <router-link class="btn" to="/order" replace>查看订单</router-link>
          <div class="btn" @click='payOrder'>重新付款</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import api from 'src/config/api';
  import {$http} from "src/extends/http";
  import {pay} from "src/extends/pay";

  export default {
    props: [],
    data() {
      return {
        status: false,
        orderId: 0
      }
    },
    methods: {
      updateSuccess() { //修改订单状态为成功
        $http(api.eshopOrderQuery, {orderId: this.orderId})
      },
      payOrder(e){
        pay(orderId).then(res=>{
          this.status = true
        }).catch(err=>{
          this.$toast('支付失败,请联系客服', 'error')
        })
      }
    },
    created(){
      this.status = parseInt(this.$route.params.status);
      this.orderId = parseInt(this.$route.params.orderId);
      if(this.stauts){
        this.updateSuccess()
      }
    }
  }
</script>

<style scoped>
  @import "../../../assets/css/buy/payResult.css";
</style>
