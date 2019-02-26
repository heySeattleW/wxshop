<template>
  <page :betterScroll="true" :refresh="refresh">
    <div class="tab-panel">
      <div class="tab-panel-item tab-active">
        <div class="tab-item">
          <div :class="{'tab-item-list': true, 'tab-item-list-default': type!=1}"
               v-for="(item, index) in couponList" :key="index">
            <div class="aui-flex">
              <div class="aui-left-change">
                <h2>
                  <em>￥</em>{{item.type_money}}
                </h2>
                <p>满{{item.min_goods_amount}}元可用</p>
                <div class="aui-icon-circle"></div>
              </div>
              <div class="aui-flex-box aui-flex-box-two">
                <span class="aui-icon-used" v-if="type==2">
                  <img src="/static/images/icon-used.png" alt="">
                </span>
                <h3>
                  <em>券票</em>{{item.name}}
                </h3>
                <div class="aui-flex aui-flex-bor-bom">
                  <div class="aui-flex-box aui-flex-box-flow">{{item.use_start_date}}-{{item.use_end_date}}</div>
                </div>
                <div class="aui-flex aui-flex-show" >
                  <div v-if="type==1" class="aui-btn-use" @click="goCouponGoods" :data-id="item.user_coupon_id">
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
      </div>
    </div>
  </page>
</template>

<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  import api from 'src/config/api';
  import { $http } from "src/extends/http";

  export default {
    props: ['type'],
    data() {
      return {
        couponList: []
      }
    },
    methods: {
      async refresh(scroll) {
        await this.getCouponList();
        scroll.forceUpdate();
      },
      async getCouponList(){
        $http(api.eshopCouponList, {type:this.type}).then(res => {
          if (res.errno === 0) {
            this.couponList = res.data
          }
        })
      },
      goCouponGoods(e){
        let id = e.currentTarget.dataset.id;
        let coupon = this.couponList.find(coupon=>coupon.user_coupon_id==id)
        this.$go({path:'/couponGoods/' + id, query:{min_goods_amount: coupon.min_goods_amount, type_money: coupon.type_money}})
      }
    },
    mounted(){
      this.getCouponList()
    },
    components: {

    }
  }
</script>

<style scoped>
  @import "../../../assets/css/coupon/coupon.css";
</style>
