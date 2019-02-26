<template>
  <page :betterScroll="true">

    <cube-swipe v-if="cartList.length>0">
      <transition-group name="swipe"
                        tag="ul">
        <li v-for="(item,index) in cartList"
            :key="index">
          <cube-swipe-item :btns="btns"
                           :index="index"
                           @btn-click="deleteShop(item.product_id,index)">
            <shop-item :data="item"></shop-item>
          </cube-swipe-item>
        </li>
      </transition-group>
    </cube-swipe>
    <div class="no-cart" v-else>
        <img src="/static/images/no_cart.png" width="200" alt="">
      {{t('cart.emptyText')}}
    </div>

    <div class="bottom-container border-bottom-1px"
         slot="bottom">
      <div class="item-select"
           @click="allSelect">
        <i :class="isAllSelect ? 'cubeic-right checked' : 'cubeic-round-border'"></i>
        <span>{{t('cart.checked', {'checkedCount':checkedCount})}}</span>
      </div>
      <div class="total-price">¥{{totalPrice}}</div>
      <cube-button :disabled="!isAllSelect"
                   @click="purchase"
                   class="purchase-btn"
                   :inline="true">{{t('cart.purchase ')}}</cube-button>
    </div>
  </page>
</template>

<script>
import api from "@/config/api";
import { $http } from "@/extends/http";
import { mapActions } from "vuex";
import shopItem from "./shop-item";

export default {
  name: "shopping",
  data() {
    return {
      btns: [{ action: "delete", text: this.$t('cart.delete'), color: "#ff3a32" }],
      cartList: []
    };
  },
  components: {
    shopItem
  },
  computed: {
    checkedCount() {
      let count = this.cartList.reduce((sum, item) => sum + item.number * Number(item.checked), 0)
      return count;
    },
    isAllSelect() {
      return this.cartList.some(item => item.checked);
    },
    totalPrice() {
      // 这里拿到不精确的浮点数
      let retail_float = this.cartList.reduce(
        (sum, item) => sum + item.retail_price * item.number * !!item.checked,
        0
      );
      // 浮点数->整型->浮点型(进行浮点数的精度差异纠正)
      let m = Math.pow(10, 2);
      return parseInt(retail_float * m, 10) / m;
    }
  },
  async activated() {
    console.log("activated");
    let res = await $http(api.eshopCartList);
    if (res.errno == 0) {
      res.data.cartList.forEach(cart => (cart.checked = !!cart.checked));
      this.cartList = res.data.cartList;
    }
  },
  methods: {
    allSelect() {
      let nowSelectStatus = !this.cartList.every(item => item.checked);
      this.cartList.forEach(item => (item.checked = nowSelectStatus));

      let productIds = this.cartList.map(v => v.product_id).join(',');
      $http(api.eshopCartCheck, { productIds, isChecked: !nowSelectStatus ? 0 : 1 }, 'POST');
    },
    purchase() {
      let checkedGoods = this.cartList.filter(item => item.checked)
      if (checkedGoods.length <= 0) {
        return false;
      }
      this.$go('/checkout')
    },
    deleteShop(product_id, index) {
      $http(api.eshopCartDelete, { productIds: product_id }, "POST").then(
        res => {
          if (res.errno == 0) this.cartList.splice(index, 1);
        }
      );
    }
  }
};
</script>

<style lang="scss" scoped>
@import "~static/scss/mixin";

.bottom-container {
  $height: pxTorem(45px);

  @include fj(flex-start);
  align-items: center;
  height: $height;
  background-color: #fff;
  border-bottom: 1px solid #ccc;
  padding-left: pxTorem(10px);
  .item-select {
    flex: 3;
    height: $height;
    line-height: $height;
    font-size: pxTorem(14px);
    i {
      font-size: 20px;
      vertical-align: middle;
    }
    i.checked {
      color: $themeColor;
    }
    span{
      vertical-align: middle;
    }
  }
  .total-price {
    flex: 2;
    height: $height;
    line-height: $height;
    text-align: center;
    width: pxTorem(70px);
    color: $themeColor;
  }
  .purchase-btn {
    height: $height;
    width: pxTorem(70px);
    @include borderRadius(0);
    background-color: $themeColor;
    /*line-height: pxTorem(46px);*/
  }
}
  .no-cart{
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


