<template>
  <cube-sticky :pos="scrollY">
    <page :better-scroll="true" @scroll="scroll">
      <div class="container">
        <div class="address-box">
          <div class="address-item" @click="selectAddress" v-if="checkedAddress.id">
            <div class="l">
              <span class="name">{{checkedAddress.userName}}</span>
              <span class="default" v-if="checkedAddress.is_default === 1">默认</span>
            </div>
            <div class="m">
              <span class="mobile">{{checkedAddress.telNumber}}</span>
              <span class="address">{{checkedAddress.full_region+checkedAddress.detailInfo}}</span>
            </div>
            <div class="r">
              <img src="/static/images/address_right.png" />
            </div>
          </div>
          <div class="address-item address-empty" @click="addAddress" v-else>
            <div class="m">
              还没有收货地址，去添加
            </div>
            <div class="r">
              <img src="/static/images/address_right.png" />
            </div>
          </div>
        </div>

        <div class="coupon-box" @click='tapCoupon'>
          <div class="coupon-item">
            <div class="l">
              <span class="name">请选择优惠券</span>
              <span class="txt">{{coupon.desc}}</span>
            </div>
            <div class="r">
              <img src="/static/images/address_right.png" />
            </div>
          </div>
        </div>

        <div class="order-box">
          <div class="order-item">
            <div class="l">
              <span class="name">商品合计</span>
            </div>
            <div class="r">
              <span class="txt">￥{{price.goodsTotalPrice}}</span>
            </div>
          </div>
          <div class="order-item">
            <div class="l">
              <span class="name">运费</span>
            </div>
            <div class="r">
              <span class="txt">￥{{price.freightPrice}}</span>
            </div>
          </div>
          <div class="order-item no-border">
        <span class="l">
          <span class="name">优惠券</span>
        </span>
            <div class="r">
              <span class="txt">-￥{{price.couponPrice}}</span>
            </div>
          </div>
        </div>

        <div class="goods-items">
          <div class="item" v-for="item in checkedGoodsList" :key="item.id">
            <div class="img">
              <img :src="item.list_pic_url" />
            </div>
            <div class="info">
              <div class="t">
                <span class="name">{{item.goods_name}}</span>
                <span class="number">{{item.number}}</span>
              </div>
              <div class="m">{{item.goods_specifition_name_value||''}}</div>
              <div class="b">￥{{item.retail_price}}</div>
            </div>
          </div>
          <div class="ddzt">
            <cube-checkbox v-model="isDdzt" position="right" shape="square" :hollow-style="true">
              到店自提
            </cube-checkbox>
          </div>
        </div>


      </div>
    </page>
    <template slot="fixed" slot-scope="props">
      <div class="order-total">
        <div class="l">实付：￥{{price.actualPrice}}</div>
        <div class="r" @click="submitOrder">去付款</div>
      </div>
    </template>
  </cube-sticky>

</template>

<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  import api from 'src/config/api';
  import {$http} from "src/extends/http";
  import order from "src/extends/order";

  export default {
    props: [],
    data() {
      return {
        coupon:{ //优惠券
          desc: '',
          id: 0,
          code: ''
        },
        buyType: 'cart',
        isDdzt: false,
        scrollY: 0
      }
    },
    computed:{
      ...mapState('checkout', ['userCoupon','courseCouponCode',
        'addressId','checkedGoodsList','checkedAddress','checkedCoupon','couponList','price'])
    },
    methods: {
      ...mapActions('checkout', ['getCheckoutInfo']),
      getCouponData(){
        if (this.userCoupon == 'USE_COUPON') {
          this.coupon.desc = this.courseCouponCode.name
          this.coupon.id = this.courseCouponCode.user_coupon_id
        } else if (this.userCoupon == 'NO_USE_COUPON') {
          this.coupon.desc = '不使用优惠券'
          this.coupon.id =  ''
        }
      },
      selectAddress(e){
        this.$go({path:'/buy/address'})
      },
      addAddress(e){
        this.$go({path:'/buy/addressAdd'})
      },
      tapCoupon(e){
        this.$go({path:'/selCoupon', query:{buyType:this.buyType}})
      },
      async submitOrder(e){
        if (!this.checkedAddress.id) {
          this.$toast('请选择收货地址', 'warn')
          return false
        }
        let res = await $http(api.eshopOrderSubmit, { addressId: this.addressId, couponId: this.coupon.id, type: this.buyType, isDdzt:this.isDdzt }, 'POST')
        if (res.errno === 0) {
          console.log(res.data)
          const orderId = res.data.orderInfo.id;
          order.payOrder(orderId)
        }else{
          this.$toast('下单失败', 'error')
        }
      },
      scroll({y}){
        this.scrollY = -y
      }
    },
    created(){
      this.buyType = this.$route.params.isBuy?'buy':'cart'
      this.$store.commit('checkout/resetUserCoupon')
    },
    activated(){
      this.getCouponData()
      this.getCheckoutInfo({addressId:this.addressId, couponId:this.coupon.id, buyType:this.buyType})
    }
  }
</script>

<style scoped>
  @import '../../../assets/css/buy/checkout.css';
  div >>> .cube-sticky-fixed {
    display: block!important;
  }
</style>
