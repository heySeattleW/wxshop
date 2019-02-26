<template>
  <page :better-scroll="true"
        page-background="#fff">
    <section class="header-container">
      <div class="setting-header">
        <section class="img-title">
          <img class="img"
               src="https://gss3.bdstatic.com/-Po3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=30cf1489b34543a9f51bfdca262cedbf/b8389b504fc2d56206e31a90e31190ef77c66ce0.jpg"
               alt="">
          <p class="fontS14">阿飞</p>
        </section>
      </div>
    </section>

    <section class="form-container">
      <p>关联手机号</p>
      <cube-input v-model="phoneNum" placeholder="输入手机号" type="text" :autofocus="true"></cube-input>
      <div class="yanzm">
        <cube-input v-model="authcode" placeholder="四位验证码" type="text"></cube-input>
        <cube-button @click="sendCode(phoneNum)" slot="append" :primary="true" :inline="true">{{codeBtnText}}</cube-button>
      </div>

      <cube-button @click="submit(phoneNum,authcode)" :primary="true" class="submit-btn">提交</cube-button>
    </section>
  </page>

</template>

<script>
import api from '@/config/api';
import { $http } from "@/extends/http";
export default {
  data() {
    return {
      authcode: "",
      phoneNum: "",
      codeBtnText:'获取验证码'
    };
  },
  methods:{
    async sendCode(mobile) {
      if (!this.validatePhone(mobile)) return;
      let res = await $http(api.eshopSmsCode,{phone: mobile},"POST");
      if (res.errno == 0) {
        this.$toast("验证发发送成功",'text');
        let second = 60;
        // 这里的定时器可能会导致内存浪费,如果要优化请页面返回时清除
        let timer = setInterval(() => {
          second--;
          this.codeBtnText = second + 's';
          if (second <= 0) {
            clearInterval(timer);
            this.codeBtnText = '获取验证码';
          }
        },1000)
      }
    },
    async submit(mobile,mobile_code) {
      if (!this.validatePhone(mobile)) return;
      if (!(mobile_code && mobile_code.length === 4)) return;
      let res = await $http(api.eshopBindMobile,{mobile_code,mobile},'POST');
      if (res.errno == 0) {
        this.$toast('操作成功','txt');
        this.$back();
      } else {
        this.$toast('验证码错误','txt');
      }
    },
    validatePhone(mobile) {
      if (!mobile.match(/^1[3-9][0-9]\d{8}$/)) {
        this.$toast('手机号格式不正确，仅支持国内手机号码','txt');
        return false;
      }
      return true;
    }
  },
  components: {}
};
</script>

<style lang="scss" scoped>
@import "~static/scss/mixin";

.fontS14{ font-size:14px;}
.fontS16{ font-size:16px;}
.header-container {
  background-color: #f3f5f4;
  padding-bottom: 10px;
  .setting-header {
    @include sc(16px, #fff);
    height: pxTorem(100px);
    background: linear-gradient(to bottom, #FCD33D 0%, #FFF6D7 100%);
    position: relative;
    text-align: center;
    .img-title {
      @include center();
    }
    .img {
      height: pxTorem(50px);
      @include borderRadius(50%);
      @include remCalc(margin, 0, 0,10px, 0);
    }
    p{
      color: #000;
    }
  }
}
.form-container {
  @include remCalc(padding, 10px, 30px, 0px);
  text-align: center;
  &>p{
    font-size: 14px;
    @include remCalc(margin, 0, 0,10px, 0);
  }
.cube-input{

  @include remCalc(margin, 0, 0,10px, 0);
  border: solid 1px #ddd;
  border-radius:5px;
  overflow: hidden;
  color:#333;

  &::after{
    border: none;
  }
}
.yanzm{
  overflow: hidden;
  zoom:1;
  .cube-input{
    float: left;
    width:pxTorem(200px);
  }
  .cube-btn{
    float: right;
    width:pxTorem(100px);
    height:pxTorem(40px);
    color: #000;
    border-radius:5px;
    background-color: #FFC800;
  }
}

  .submit-btn {
    @include remCalc(margin, 10px, 0);
    @include remCalc(padding, 13px,16px);
    font-size: 14px;
    border-radius:5px;
    background-color:#F7F7F7;
    color:rgba(0, 0, 0, 0.3);
    border: solid 1px #ddd;
  }
}
</style>


