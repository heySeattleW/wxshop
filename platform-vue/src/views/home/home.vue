<template>
  <cube-sticky :pos="scrollY">
    <page :better-scroll="true" @scroll="scroll">
      <div class="container">
        <!--搜索框-->
        <home-search></home-search>
        <!--轮播图-->
        <home-banner></home-banner>
        <!--提示-->
        <home-recommend></home-recommend>
        <!--导航按钮 -->
        <home-nav></home-nav>
        <!--三张优惠券-->
        <home-coupon></home-coupon>
        <!--商品列表-->
        <home-sales-promotion></home-sales-promotion>

      </div>
    </page>
    <!--底部浮动  跑马灯-->
    <template slot="fixed" slot-scope="props">
      <home-marquee></home-marquee>
    </template>
  </cube-sticky>
</template>

<script type="text/ecmascript-6">
  import homeSearch from "./home-search";
  import homeBanner from "./home-banner";
  import homeRecommend from "./home-recommend";
  import homeNav from "./home-nav";
  import homeCoupon from "./home-coupon";
  import homeSalesPromotion from "./home-sales-promotion";
  import homeMarquee from "./home-marquee";

  import api from 'src/config/api'
  import {$http} from 'src/extends/http'
  import db from "src/extends/websql"

  export default {
    props: [],
    data() {
      return {
        scrollY: 0
      }
    },
    computed: {},
    methods: {
      scroll({y}){
        this.scrollY = -y
      }
    },
    async created(){
      let addressPicker = await db.getItem('addressPicker')
      if(!addressPicker){
        $http(api.eshopAllRegionTree).then(res=>{
          if(res.errno ==0){
            addressPicker = res.data
            this.$store.commit('center/getAdderssPicker', addressPicker)
            db.setItem("addressPicker",addressPicker)
          }
        })
      }else{
        this.$store.commit('center/getAdderssPicker', JSON.parse(addressPicker))
      }
    },
    components:{
      homeSearch,
      homeBanner,
      homeRecommend,
      homeNav,
      homeCoupon,
      homeSalesPromotion,
      homeMarquee
    }
  }
</script>

<style scoped>
  @import '../../assets/css/home/text.css';
  div >>> .cube-sticky-fixed {
    display: block!important;
  }
</style>

