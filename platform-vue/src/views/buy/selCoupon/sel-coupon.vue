<template>
  <page :better-scroll="true">
    <div class="yhq-yes" v-if="couponList.length>0">
      <div class="page-bottom">
        <div class="footer">
          <button type="button" class="cube-btn" @click='noUseCoupon'>
            不使用优惠券
          </button>
        </div>
      </div>
      <!--可使用-->
      <div v-for="(item,index) in couponList" :key="item.id"
        :class="{'tab-item-list':true, 'tab-item-list-default':item.enabled==0}">
        <div class="aui-flex" @click="tapCoupon(item)">
          <div class="aui-left-change">
            <h2>
              <em>￥</em>{{item.type_money}}
            </h2>
            <p>满{{item.min_goods_amount}}元可用</p>
            <div class="aui-icon-circle"></div>
          </div>
          <div class="aui-flex-box aui-flex-box-two">
            <span class="aui-icon-used">
              <img :src="item.enabled?'/static/images/coupon_ksy.png': '/static/images/coupon_bky.png'" alt="">
            </span>
            <h3>
              <em>券票</em>{{item.name}}
            </h3>
            <div class="aui-flex aui-flex-bor-bom">
              <div class="aui-flex-box aui-flex-box-flow">{{item.use_start_date}}-{{item.use_end_date}}</div>
            </div>
            <div class="aui-flex aui-flex-show" >
              <div data-id="24" class="aui-btn-use" v-if="item.enabled">
                立即使用
              </div>
            </div>
          </div>
        </div>
        <div class="aui-show-box">
          <p>默认隐藏内容</p>
        </div>
      </div>
    </div>

    <div class="yhq-no"  v-else>
      <img src="/static/images/my_course_empty.png" width="200" alt="">
      没有可用的优惠券
    </div>
  </page>
</template>

<script type="text/ecmascript-6">
  import api from 'src/config/api'
  import {$http} from 'src/extends/http'

  export default {
    props: [],
    data() {
      return {
        buyType: '',
        couponList:[]
      }
    },
    methods: {
      noUseCoupon(e){
        this.$store.commit('checkout/resetUserCoupon')
        this.$back()
      },
      tapCoupon(item){
        if (item.enabled==0) return
        this.$store.commit('checkout/useUserCoupon', item)
        this.$back()
      },
      loadListData(){
        $http(api.eshopGoodsCouponList, {type: this.buyType}).then(res => {
          if (res.errno === 0) {
            this.couponList = res.data
          }
        });
      }
    },
    created(){
      this.buyType = this.$route.query.buyType;
      this.loadListData()
    }
  }
</script>

<style scoped>
  @import '../../../assets/css/coupon/coupon.css';
  .cube-btn {
    display: block;
    margin: 0;
    padding: 17px 16px;
    width: 100%;
    text-align: center;
    white-space: nowrap;
    cursor: pointer;
    font-size: 16px;
    line-height: 1;
    color: #fff;
    background: #4a4c5b;
    outline: none;
    border: none;
    border-radius: 2px;
    box-sizing: border-box;
    -webkit-tap-highlight-color: transparent;
  }
  .page-bottom .footer .cube-btn{
    background-color: brown;
    border-radius: 0px;
    font-size: 0.725rem;
  }
   .aui-flex {
    padding-bottom: 0;
  }
  .yhq-no{
    font-size: 14px;
    text-align: center;
    margin-top: 100px;
    color: #333;
  }
  .yhq-no img{
    display: block;
    margin: auto;
    margin-bottom: 20px;
  }

</style>
