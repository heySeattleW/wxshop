<template>
  <page :better-scroll="true">
    <div class="container">

      <div class="order-info">
        <div class="item-a">下单时间：{{orderInfo.add_time}}</div>
        <div class="item-b">订单编号：{{orderInfo.order_sn}}</div>
        <div class="item-c">
          <div class="l">实付：<span class="cost">￥{{orderInfo.actual_price}}</span></div>
          <div class="r">
            <cube-button :inline="true" v-if="handleOption.pay" class="btn active" @click="payOrder">去付款</cube-button>
            <cube-button :inline="true" v-if="handleOption.cancel" class="btn" @click="cancelOrder">取消订单</cube-button>
            <cube-button :inline="true" v-if="handleOption.confirm" class="btn active" @click="confirmOrder">确认收货</cube-button>
            <cube-button :inline="true" v-if="handleOption.comment" class="btn active" @click="commentOrder">去评价</cube-button>
            <cube-button :inline="true" class="btn" v-if="handleOption.return" @click="returnOrder">退换货</cube-button>
          </div>
        </div>
      </div>

      <div class="order-goods">
        <div class="h">
          <div class="label">商品信息</div>
          <div class="status">{{orderInfo.order_status_text}}</div>
        </div>
        <div class="goods">
          <div class="item" v-for="(item,index) in orderGoods" :key="item.id">
            <div class="img">
              <img :src="item.list_pic_url" />
            </div>
            <div class="info">
              <div class="t">
                <span class="name">{{item.goods_name}}</span>
                <span class="number">x{{item.number}}</span>
              </div>
              <div class="attr">{{item.goods_specifition_name_value||''}}</div>
              <div class="price">￥{{item.retail_price}}</div>
            </div>
          </div>
        </div>
      </div>

      <div class="order-bottom">
        <div class="address">
          <div class="t">
            <span class="name">{{orderInfo.consignee}}</span>
            <span class="mobile">{{orderInfo.mobile}}</span>
          </div>
          <div class="b">{{orderInfo.full_region + orderInfo.address}}</div>
        </div>
        <div class="ddzt">
          <cube-checkbox v-model="!!orderInfo.isDdzt" position="right" shape="square" :hollow-style="true" :option="{disabled: true}">
            到店自提
          </cube-checkbox>
        </div>
        <div class="total">
          <div class="t" v-if="orderInfo.coupon_price>0">
            <span class="label">优惠券抵扣：</span>
            <span class="txt">￥{{orderInfo.coupon_price}}</span>
          </div>
          <div class="t">
            <span class="label">商品合计：</span>
            <span class="txt">￥{{orderInfo.goods_price}}</span>
          </div>
          <div class="t">
            <span class="label">运费：</span>
            <span class="txt">￥{{orderInfo.freight_price}}</span>
          </div>
        </div>
        <view class="pay-fee">
          <text class="label">实付：</text>
          <text class="txt">￥{{orderInfo.actual_price}}</text>
        </view>
      </div>
    </div>
  </page>
</template>

<script type="text/ecmascript-6">
  import {mapState,mapActions } from 'vuex';
  import order from 'src/extends/order'
  export default {
    props: [],
    data() {
      return {
        orderId: 0
      }
    },
    computed: {
      ...mapState('order', ['orderInfo','orderGoods','handleOption'])
    },
    methods: {
      ...mapActions('order', ['getOrderDetail']),
      payOrder(e){
        order.payOrder(this.orderId)
      },
      cancelOrder(e){
        order.cancelOrder(this.orderId, this.orderInfo.order_status, ()=>{
          this.$back()
        })
      },
      confirmOrder(e){
        order.confirmOrder(this.orderId, this.orderInfo.order_status)
      },
      commentOrder(e){
        order.commentOrder(this.orderId)
      },
      returnOrder(e){
        order.returnOrder(this)
      }
    },
    activated(){
      this.orderId = parseInt(this.$route.params.id)
      this.getOrderDetail(this.orderId)
    }
  }
</script>

<style scoped>
  @import '../../../assets/css/buy/orderDetail.css';
</style>
