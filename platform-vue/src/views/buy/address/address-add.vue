<template>
  <!-- <page :better-scroll="false">

  </page> -->
  <div style="font-size:16px;">
    <section class="form-container">
      <cube-input v-model="address.userName" placeholder="收货人" type="text" :autofocus="true"></cube-input>
      <cube-input v-model="address.telNumber" placeholder="手机号码" type="text"></cube-input>
      <address-picker :data="address" @done="addressDone"></address-picker>
      <cube-input v-model="address.detailInfo" placeholder="详细地址,如街道、楼盘号等" type="text"></cube-input>
      <cube-checkbox class="default-address" v-model="address.is_default">设为默认地址</cube-checkbox>
    </section>
    <div class="footer" slot="bottom">
      <cube-button class="save" @click="save()">保存</cube-button>
    </div>
  </div>
</template>

<script>
import api from '@/config/api';
import { $http } from "@/extends/http";
import addressPicker from "./address-picker";
export default {
  data() {
    return {
      address: {
        id:0,
        detailInfo:'',
        full_region: '',
        userName: '',
        telNumber: '',
        is_default: false,
        provinceId: 0,
        cityId: 0,
        countyId: 0,
        townId: 0
      }
    };
  },
  methods: {
    async save() {
      let res = await $http(api.eshopAddressSave,{...this.address},"POST");
      if (res.errno == 0){
        this.$store.commit('checkout/setAddressId', res.data.id)
        this.$back();
      }
    },
    addressDone(address) {
      this.address = Object.assign(this.address,address);
    }
  },
  async beforeMount(){
   if (this.$route.query.id) {
     let id = this.$route.query.id;
     let res = await $http(api.eshopAddressDetail,{id});
     res.data.is_default = !!res.data.is_default;
     this.address = res.data;
    }
  },
  components: {
    addressPicker
  }
};
</script>

<style lang="scss" scoped>
.default-address {
  text-align: center;
}
.footer {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  overflow:hidden;
  display:flex;
  .cube-btn{
    border-radius: 0px;
    font-size: 14px;
  &.save{
    background-color: brown;
  }
  }
}
.cube-input{
  height: 50px;
  font-size: 14px;
  padding-left: 5.625px;    /*15.625*/

}
</style>
