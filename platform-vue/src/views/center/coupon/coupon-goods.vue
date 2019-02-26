<template>
  <div class="container">
    <div class="tips">限时促销:以下商品可使用满{{min_goods_amount}}减{{type_money}}的优惠券</div>
    <div class="content">
      <page ref="page" :betterScroll="true" :refresh="refresh" :load-more="loadMore">
        <template v-for="(item, index) in goodsList" >
          <router-link :to="'/goods/'+item.goodsId" class="aui-scrollView-list-item">
            <div class="aui-product-list-img">
              <img :src="item.img_url" alt="">
            </div>
            <div class="aui-product-list-text">
              <h3 class="aui-product-list-title">{{item.goodsName}}</h3>
              <div class="aui-product-list-center">
                <div>
                  <span class="aui-product-list-price"><em>¥</em>{{item.retail_price}}</span>
                  <span class="aui-product-list-del-price">¥{{item.market_price}}</span>
                </div>
                <!--<div class="aui-product-evaluate">100%好评</div>-->
              </div>
            </div>
          </router-link>
        </template>
      </page>
    </div>
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
        id:0,
        goodsList: []
      }
    },
    methods: {
      async refresh(scroll) {
        await this.getCouponGoods(true);
        scroll.forceUpdate();
      },
      async loadMore(scroll,done) {
        let noMore = await this.getCouponGoods();
        scroll.forceUpdate();
        done(noMore);
      },
      async getCouponGoods(isRefresh = false){
        const size = 10;
        let page = isRefresh ? 1 : parseInt(this.goodsList.length / size) + 1;
        let res = await $http(api.eshopGetCouponGoods, {usercoupouid:this.id, page, size})
        if(res.errno==0){
          if (isRefresh) this.goodsList.length = 0;
          this.goodsList = this.goodsList.concat(res.data.data);
          let noMore = (parseInt(this.goodsList.length / size)+1)===page
          console.log(noMore)
          if(noMore) this.$refs.page.options.pullUpLoad = false
          return noMore;
        }
      }
    },
    created(){
      this.id = parseInt(this.$route.params.id);
      this.min_goods_amount = this.$route.query.min_goods_amount
      this.type_money = this.$route.query.type_money
      this.getCouponGoods()
    }
  }
</script>

<style scoped>
  .tips {
    position: relative;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    background-color: #FFF171;
    font-size: 12px;
    /*color: #fff;*/
    padding:6px 10px;
  }

  .content {
    position: absolute;
    z-index: 3;
    top: 24px;
    height: 623px;
    bottom: 0;
    left: 0;
    width: 100%;
    background: #f0f2f5;
  }

  .aui-scrollView-list-item {
    width: 50%;
    float: left;
    padding: 0 5px;
    margin-top: 10px;
    box-sizing: border-box;
  }

  .aui-product-list-img {
    height: 0;
    width: 100%;
    padding: 50% 0;
    overflow: hidden;
  }

  .aui-product-list-img img {
    width: 100%;
    margin-top: -50%;
    background-color: #FFF;
    border: none;
  }

  .aui-product-list-text {
    background-color: #FFF;
    padding: .4rem;
  }

  .aui-product-list-title {
    color: #505050;
    font-size: .7rem;
    font-weight: normal;
    word-wrap: normal;
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
    text-align: justify;
    margin-bottom: 10px;
  }

  .aui-product-list-center {
    overflow: hidden;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: end;
    -webkit-align-items: flex-end;
    -ms-flex-align: end;
    align-items: flex-end;
    -webkit-box-pack: justify;
    -webkit-justify-content: space-between;
    -ms-flex-pack: justify;
    justify-content: space-between;
    color: #999;
  }

  .aui-product-list-price {
    font-size: .8rem;
    color: #EB5211;
    font-weight: 800;
  }

  .aui-product-list-price em {
    font-size: .6rem;
    padding-right: 2px;
  }

  .aui-product-list-del-price {
    padding-left: .06rem;
    font-size: .7rem;
    margin-left: .02rem;
    position: relative;
    color: #8C8C8C;
  }

  .aui-product-evaluate {
    color: #999;
    font-size: .7rem;
  }

  .aui-search-tab {
    position: relative;
    height: 2.5rem;
    font-size: 0;
    width: 100%;
    background-color: #fff;
  }

  .aui-change-eleven {
    width: 25%;
    border-right: 0;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    display: inline-block;
    font-size: .875rem;
    text-align: center;
    line-height: 2.5rem;
  }

  .aui-change-eleven span {
    color: #232326;
    display: block;
  }

  .aui-search-tab .active span {
    color: #f15353 !important;
  }

  .aui-custom-tab {
    width: 100%;
    height: 42px;
    line-height: 40px;
    position: relative;
    padding: 0 5px;
    font-size: 0;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    background-color: #fff;
  }

  .aui-custom-item {
    width: 25%;
    display: inline-block;
    padding: 0 6px;
    height: 28px;
    line-height: 28px;
    font-size: 12px;
    margin: 7px 0;
    vertical-align: middle;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
  }

  .aui-custom-item span {
    display: block;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    text-align: center;
    width: 200%;
    color: #232326;
    height: 200%;
    background-color: #f0f2f5;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 5px;
    border: solid 1px #f0f2f5;
    -moz-transform: scale(.5, .5);
    -ms-transform: scale(.5, .5);
    -webkit-transform: scale(.5, .5);
    transform: scale(.5, .5);
    -moz-transform-origin: 0 0;
    -ms-transform-origin: 0 0;
    -webkit-transform-origin: 0 0;
    transform-origin: 0 0;
    font-size: 24px;
    line-height: 54px;
    vertical-align: middle;
  }

  /* aui 鍒嗙被鏍峰紡  鏉庢尟浜�  */

  .aui-scroll-box {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    padding-top: 1px;
    padding-bottom: 44px;
  }

  .aui-scroll-nav {
    width: auto;
    height: 100%;
    text-align: center;
    background-color: #f3f5f7;
    -webkit-overflow-scrolling: touch;
    position: relative;
    z-index: 1;
    overflow-y: auto;
  }

  .aui-scroll-item {
    padding: 0 10px;
    height: 3rem;
    line-height: 3rem;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -webkit-align-items: center;
    -ms-flex-align: center;
    align-items: center;
    position: relative;
    z-index: 1;
    font-size: .8rem;
    text-align: center;
  }

  .aui-scroll-item-text {
    font-size: 0.8rem;
    color: #232326;
    overflow-x: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    width: 100%;
    text-align: center;
  }

  .aui-scroll-nav .aui-crt {
    background-color: #FFF;
  }

  .aui-scroll-nav .aui-crt .aui-scroll-item-text {
    color: #fc6248;
  }

  .aui-scroll-content {
    height: 100%;
    background-color: #FFF;
    overflow-y: auto;
    -webkit-overflow-scrolling: touch;
    -webkit-box-flex: 1;
    -webkit-flex: 1;
    -ms-flex: 1;
    flex: 1;
    padding: 0 .5rem .5rem .5rem;
    position: relative;
  }

  .aui-scroll-content-item {
    padding-top: 15px;
  }

  .aui-class-img img {
    width: 100%;
    height: 100%;
    display: block;
    border: none;
  }

  .aui-scroll-content-title {
    height: 2rem;
    line-height: 2rem;
    font-size: .8rem;
    font-weight: normal;
    color: #555;
    display: block;
    padding-bottom: .1rem;
    padding-top: .32rem;
    margin-bottom: .2rem;
    position: relative;
    z-index: 1;
  }

  .aui-grid-content {
    width: 100%;
    background-color: #ffffff;
    display: table;
    table-layout: fixed;
  }

  .aui-grid-row {
    overflow: hidden;
    margin: 0;
  }

  .aui-grid-row-item {
    display: table-cell;
    position: relative;
    text-align: center;
    vertical-align: middle;
    width: 33.333%;
    padding: .8rem 0 0 0;
    float: left;
  }

  .aui-icon-large {
    width: 40px;
    height: 40px;
    display: inline-block;
    background-position: center;
    background-repeat: no-repeat;
    background-size: 40px;
  }

  .aui-grid-row-clear .aui-grid-row-item .aui-icon-large {
    width: 60px;
    height: 60px;
  }

  .aui-grid-row-clear .aui-grid-row-item i img {
    width: 100%;
    height: 100%;
    display: block;
    border: none;
  }

  .aui-grid-row-label {
    display: block;
    font-size: 0.7rem;
    position: relative;
    margin-top: 0.25rem;
  }
</style>
