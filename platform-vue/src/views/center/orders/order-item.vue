<template>
  <router-link :to="'/orderDetail/'+data.id">
    <div class="order-item">
      <div class="order-top border-bottom-1px">
        <span class="order-sn">订单编号：{{data.order_sn}}</span>
        <span class="theme-color">{{data.order_status_text}}</span>
      </div>
      <ul class="good-container">
        <li class="goods-item"
            v-for="good in data.goodsList"
            :key="good.id">
          <img class="good-img"
               :src="good.list_pic_url">
          <div>
            <p>{{good.goods_name}}</p>
            <p>{{'共'+good.number+'件商品'}}</p>
          </div>
        </li>
      </ul>
      <p class="order-bottom border-top-1px">
        <span class="order-price">实付：¥{{data.order_price}}</span>
        <!-- <cube-button class=""
                     :inline="true"
                     v-if="data.handleOption.cancel">取消订单</cube-button> -->
        <cube-button class="theme-btn"
                     :inline="true"
                     v-if="data.handleOption.pay" @click.prevent="payOrder(data)">去付款</cube-button>
        <!--<cube-button class=""-->
                     <!--:inline="true"-->
                     <!--v-if="data.handleOption.delete">删除订单</cube-button>-->
        <cube-button class="theme-btn"
                     :inline="true"
                     v-if="data.handleOption.comment" @click.prevent="commentOrder(data)">去评价</cube-button>
        <cube-button class="theme-btn"
                     :inline="true"
                     v-if="data.handleOption.confirm" @click.prevent="confirmOrder(data)">确认收货</cube-button>
        <cube-button class=""
                     :inline="true"
                     v-if="data.handleOption.return" @click.prevent="returnOrder">退换货</cube-button>
        <!--<cube-button class="theme-btn"-->
                     <!--:inline="true"-->
                     <!--v-if="data.handleOption.buy" @click.prevent="reBuy(data)">再次购买</cube-button>-->

      </p>
    </div>
  </router-link>
</template>

<script>
import order from 'src/extends/order'
export default {
  props: ["data"],
  data(){
    return {
    }
  },
  methods:{
    payOrder(item){ //去付钱
      this.$go({path: '/buy/pay', query:{orderId: item.id, actualPrice:item.actual_price}})
    },
    confirmOrder(item){ //确认收货
      order.confirmOrder(item.id, item.order_status)
    },
    commentOrder(item){
      order.commentOrder(item.id)
    },
    returnOrder(e){
      order.returnOrder(this)
    }
  }
};
</script>

<style lang="scss" scoped>
@import "~static/scss/mixin";
.order-item {
  background-color: #fff;
  padding-left:pxTorem(15.625px);
  padding-right:pxTorem(15.625px);
  margin-top: pxTorem(10px);
}
.order-top {
  @include fj();
  height: pxTorem(40px);
  line-height: pxTorem(40px);
}
.theme-color {
  color: $themeColor;
}

.order-bottom {
  height: pxTorem(40px);
  line-height: pxTorem(40px);
  @include fj(flex-start);
}
.order-price {
  flex: auto;
  font-size: pxTorem(14px);
}
.cube-btn-inline {
  flex: 0, 0, auto;
  @include borderRadius(6px);
  @include borderRadius(4px);
  margin: pxTorem(5px);
}
.theme-btn {
  background-color: $themeColor;
  color: #fff;
}
.border-bottom-1px,
.border-top-1px {
  position: relative;
  &::before{
    content: "";
    display: block;
    position: absolute;
    -webkit-transform-origin: 0 0;
    transform-origin: 0 0
  }
  span.order-sn{
    font-size:pxTorem(14.5px);
  }
   span.theme-color{
    font-size:pxTorem(12px);
  }

}
.goods-item {
  @include fj(flex-start);
  align-items: center;
  height: pxTorem(85px);
  .good-img {
    height: pxTorem(70px);
    flex: none;
  }
  &>div{
    padding-left: pxTorem(10px);
    &>p:first-of-type{
      font-size: pxTorem(14.5px);
      margin-bottom: pxTorem(5px);
    }
    &>p:last-of-type{
      font-size: pxTorem(12px);
    }
  }
}
</style>

