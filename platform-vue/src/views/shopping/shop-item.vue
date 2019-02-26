<template>
  <div class="shop-item border-bottom-1px">
    <div class="item-select"
         @click="select(data)">
      <i :class="data.checked ? 'cubeic-right checked' : 'cubeic-round-border'"></i>
    </div>
    <div class="item-pic">
      <img class="ignore"
           :src="data.list_pic_url"
           alt="">
    </div>
    <div class="item-info">
      <p class="info-name">{{data.goods_name}}</p>
      <p class="info-spec">{{data.goods_specifition_name_value==null?"标准规格":data.goods_specifition_name_value}}</p>
      <div class="info-price-num">
        <span class="price">￥{{data.retail_price}}</span>
        <m-number @change="change"
                  :value="data.number"
                  class="num"></m-number>
      </div>
    </div>
  </div>
</template>

<script>
import api from "@/config/api";
import { $http } from "@/extends/http";
import mNumber from "@/components/m-number";

export default {
  name: "shopItem",
  props: ["data"],
  components: {
    mNumber
  },
  data() {
    return {
      item: this.data,
      timer: undefined
    };
  },
  methods: {
    change(newValue) {
      this.item.number = newValue;
      // 这里向后台提交数据 延时 1s 防止用户1s内多次提交
      clearTimeout(this.timer);
      this.timer = setTimeout(() => {
        let productId = this.item.product_id;
        let goodsId = this.item.goods_id;
        let id = this.item.id;
        $http(api.eshopCartUpdate, { productId, goodsId, number:newValue, id}, 'POST');
      }, 1000);
    },
    postNuber() {},
    select(item) {
      console.log(item)
      $http(api.eshopCartCheck,{ productIds: item.product_id, isChecked: item.checked ? 0 : 1 }, 'POST');
      item.checked = !item.checked;
    }
  }
};
</script>

<style lang="scss" scoped>
@import "~static/scss/mixin";

.shop-item {
  @include fj(flex-start);
  height: pxTorem(100px);
  box-sizing: border-box;
  padding: 18px 0;
  background-color: #fff;
  .item-select {
    align-items: center;
    flex-basis: pxTorem(40px);
    text-align: center;
    align-self: center;
    i {
      font-size: 1rem;
    }
    i.checked {
      color: $themeColor;
    }
  }
  .item-pic {
    flex-basis: pxTorem(80px);
    .ignore {
      width: 100%;
      height: 100%;
    }
  }
  .item-info {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    flex: 1;
    padding: 0 10px;
    font-size: 14px;
    .info-name {
      p {
        font-size: 28px;
        font-weight: 600;
        color: #333;
      }
    }
    .info-spec{
      font-size: pxTorem(12px);
      color: #aaa;
    }
    .info-price-num {
      display: flex;
      justify-content: space-between;
      line-height: 24px;
      .price {
        display: flex;
        flex-direction: column;
        justify-content: flex-end;
        font-weight: bold;
        span {
          color: #b60a0a;
        }
      }
    }
  }
}
</style>


