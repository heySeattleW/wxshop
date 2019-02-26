<template>
  <div class="mg-b-10 pd-t-12 pd-b-12 pd-l-12 pd-r-12 bgW flex">
    <cube-scroll
      ref="scroll"
      :data="coupons"
      direction="horizontal"
      class="horizontal-scroll-list-wrap">
      <ul class="list-wrapper">
        <li class="list-item">
          <div class="yhq-bg inline-display-block col-fff yhq fontS12 text-center pos-re before-cirl after-cirl"
               v-for="(item,index) in coupons" :key="index">
            <div class="over-ell mg-b-5 mg-t-sm">
              {{item.name}}
            </div>
            <div class="mg-b-5 col-y">
              <span class="fontS16 verb">{{item.type_money}}</span><span class="fontS12 verb">{{t('home.couponText', {'min_goods_amount':item.min_goods_amount})}}</span>
            </div>
            <div :class="{'yhq-btn1':true, 'mg-b-5':true, 'show':item.enabled==0, 'none':item.enabled!=0}" @click="recevieCoupon" :data-id="item.id">
              {{item.enabled==0?t('tips.couponFetch'):t('tips.couponFetched')}}
            </div>
          </div>
        </li>
      </ul>
    </cube-scroll>
  </div>
</template>

<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  import api from 'src/config/api';
  import { $http } from "src/extends/http";
  export default {
    props: [],
    data() {
      return {
      }
    },
    computed:{
      ...mapState('home', ['coupons'])
    },
    methods: {
      ...mapActions('home', ['getCoupons']),
      recevieCoupon(e){
        console.log(e)
        let id = e.currentTarget.dataset.id
        let coupon = this.coupons.find(coupon=>coupon.id==id)
        if(coupon.enabled==0){
          $http(api.eshopGetCoupon, {couponId: id}, 'POST').then(res=>{
            if(res.errno==0){
              coupon.enabled = 1;

              this.$store.commit("home/setCoupons", this.coupons)
              this.$toast(this.$t('tips.fetchSuccess'), 'correct')
            }else{
              this.$toast(res.errmsg, 'warn')
            }
          })
        }
      }
    },
    mounted(){
      this.getCoupons()
    }
  }
</script>

<style scoped>
  @import '../../assets/css/home/text.css';
  .verb{
    vertical-align: bottom;
  }
  .mg-r-5{
    margin-right: 5px;
  }
  .mg-l-5{
    margin-left: 5px;
  }
  .over-ell{
    overflow: hidden;
    text-overflow:ellipsis;
    white-space: nowrap;
  }
  .yhq-bg .over-ell{
    width: 100px;
  }
  .yhq-bg .yhq-btn1{
    display: inline-block;
    padding: 3px 12px;
    border-radius: 50px;
  }
  .yhq-bg .yhq-btn1.show{
    background-color: #FA114E;
  }
  .yhq-bg .yhq-btn1.none{
    background-color: #999;
  }
  .before-cirl::before{
    content: " ";
    display: block;
    width: 12px;
    height: 12px;
    border-radius: 12px;
    background-color: #fff;
    position: absolute;
    bottom: 20px;
    left: -6px;
  }
  .after-cirl::after{
    content: " ";
    display: block;
    width: 12px;
    height: 12px;
    border-radius: 12px;
    background-color: #fff;
    position: absolute;
    bottom: 20px;
    right: -6px;
  }
  .col-y{
    color: yellow;
  }

  .yhq-bg{
    padding: 4px 10px;
    border-radius: 6px;
    background: -webkit-linear-gradient(#fda26b, #ff5556); /* Safari 5.1 - 6.0 */
    background: -o-linear-gradient(#fda26b, #ff5556); /* Opera 11.1 - 12.0 */
    background: -moz-linear-gradient(#fda26b, #ff5556); /* Firefox 3.6 - 15 */
    background: linear-gradient(#fda26b, #ff5556); /* 标准的语法 */
  }
  .yhq-bg:not(:last-of-type){
    margin-right: 5px;
  }
</style>
