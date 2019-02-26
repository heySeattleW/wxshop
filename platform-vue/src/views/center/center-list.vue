<template>
  <ul class="list-container">
    <li class="item"
        v-for="item in list"
        :key="item.link">
      <div class="shop-item border-bottom-1px">
        <router-link :to="item.link"
                     class="link">
          <i :class="item.icon"></i>
          {{item.name}}
          <i class="cubeic-arrow"></i>
        </router-link>
      </div>
    </li>
    <li class="item">
      <div class="shop-item border-bottom-1px">
        <a @click="callPhone"
           class="link">
          <i class="cubeic-phone"></i>
          {{$t('center.telphone')}}：{{phone}}
          <i class="cubeic-arrow"></i>
        </a>
      </div>
    </li>
  </ul>
</template>

<script>
import api from '@/config/api';
import { $http } from "@/extends/http";

export default {
  data() {
    return {
      phone: "18937632576",
      list: [
        { icon: "cubeic-setting", name: t("center.orderLink"), link: "/order" },
        { icon: "cubeic-setting", name: t("center.couponLink"), link: "/coupon" },
        { icon: "cubeic-setting", name: t("center.collectLink"), link: "/collect" },
        { icon: "cubeic-setting", name: t("center.addressLink"), link: "/address" },
        { icon: "cubeic-setting", name: t("center.guaranteeLink"), link: "/guarantee" },
        { icon: "cubeic-setting", name: t("center.bundleLink"), link: "/setting" },
      ]
    };
  },
  methods: {
    callPhone() {
      let data = [{ content: this.$t("center.call") }]; //{ content: this.$t("center.onlineService")}
      this.$createActionSheet({
        title: this.phone,
        data: data,
        zIndex:9999,
        onSelect: (item, index) => {
          if (index == 0) window.location.href = `tel:${this.phone}`;
        }
      }).show();
    }
  },
  async mounted(){
    let res = await $http(api.eshopCustomerServicePhone)
    if(res.errno==0){
      this.phone = res.data
    }
  }
};
</script>

<style lang="scss" scoped>
@import "~static/scss/mixin";

.list-container {
  .border-bottom-1px {
    position: relative;
    &::before {
      content: "";
      display: block;
      position: absolute;
      -webkit-transform-origin: 0 0;
      transform-origin: 0 0;
    }
  }

  font-size: 16px;
  background-color: #fff;
  .item {
    list-style: none;
  }
  .shop-item {
    height: pxTorem(50px);
    line-height: pxTorem(50px);
    padding-left: 16px;
  }
  .link {
    display: block;
    position: relative;
    width: 100%;
    color: #333;
    text-decoration: none;
    outline: 0;
    .cubeic-arrow {
      position: absolute;
      right: 0;
      padding: 0 5px;
      color: #ccc;
    }
  }
}
</style>


