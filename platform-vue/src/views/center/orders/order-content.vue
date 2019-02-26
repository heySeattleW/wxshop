<template>
<page ref="page" :betterScroll="true" :refresh="refresh" :load-more="loadMore">
  <ul class="list-wrapper" v-if="items.length>0">
    <li v-for="(item, index) in items" :key="index">
      <order-item :data="item"></order-item>
    </li>
  </ul>
  <div class="no-order" v-show="noOrders">
    <img src="/static/images/no_order.png" width="200" alt="">
    还没有任何订单呢
  </div>
</page>


  <!-- <div class="scroll-list-wrap">
          <cube-scroll ref="scroll" @pulling-up="onPullingUp"
                       :options="options">
            <ul class="list-wrapper">
              <li v-for="(item, index) in items"
                  :key="index">
                  <order-item :data="item"></order-item>
              </li>
            </ul>
          </cube-scroll>
        </div> -->
</template>

<script>
import api from '@/config/api';
import { $http } from "@/extends/http";
import orderItem from "./order-item";

export default {
  name:'orderContent',
  props:['type'],
  components:{
    orderItem
  },
  data() {
    return {
      options: {
        pullUpLoad: true
      },
      items:[],
      noOrders: false
    }
  },
  mounted() {
    this.getOrderList();
  },
  methods: {
    async refresh(scroll) {
      await this.getOrderList(true);
      scroll.forceUpdate();
    },
    async loadMore(scroll,done) {
      let noMore = await this.getOrderList();
      scroll.forceUpdate();
      done(noMore);
    },
    async getOrderList(isRefresh = false) {
      const size = 5;
      console.log(this.items.length);
      let page = isRefresh ? 1 : parseInt(this.items.length / size) + 1;
      let res = await $http(api.eshopOrderList, {page, size, type: this.type});
      let data = res.data.data;
      if (isRefresh) this.items.length = 0;
      if (res.errno == 0) this.items = this.items.concat(data);
      let noMore = res.data.data.length < size;
      if(noMore) this.$refs.page.options.pullUpLoad = false;
      this.noOrders = this.items.length>0?false:true
      return noMore;
    }
  },
  watch: {
    $route(to, from) {
      if(["orderDetail","rate"].includes(from.name)){
        this.items = [];
        this.getOrderList(true);
      }
    }
  }
}
</script>

<style lang="scss" scoped>
  @import "~static/scss/mixin";
  .scroll-list-wrap {
    height: 100%;
  }
  .no-order{
    font-size:pxTorem(14px);
    text-align:center;
    margin-top:pxTorem(100px);
    color: #333;
    img{
      display: block;
      margin: auto;
      margin-bottom: pxTorem(20px);
    }
  }
</style>


