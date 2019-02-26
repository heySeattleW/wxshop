<template>
  <div class="container">
    <div class="total">
      <div class="label">订单金额</div>
      <div class="txt">{{actualPrice}}元</div>
    </div>
    <div class="pay-list">
      <div class="h">请选择支付方式</div>
      <div class="b">
        <div class="item">
          <div class="checkbox checked"></div>
          <img src="/static/images/wxpay.png" class="icon" />
          <div class="name">微信支付</div>
        </div>
      </div>
    </div>
    <div class="tips">本公众号仅支持微信支付，如需其它支付方式，请联系客服</div>

    <div class="pay-btn" @click="startPay">确定</div>
  </div>
</template>

<script type="text/ecmascript-6">
  import order from "src/extends/order";

  export default {
    props: [],
    data() {
      return {
        orderId: 0,
        actualPrice: 0.00
      }
    },
    methods: {
      startPay(e) {
        order.payOrder(this.orderId)
      }
    },
    created(){
      this.orderId = this.$route.query.orderId
      this.actualPrice = this.$route.query.actualPrice
    }
  }
</script>

<style scoped>
  @import '../../../assets/css/buy/pay.css';
</style>
