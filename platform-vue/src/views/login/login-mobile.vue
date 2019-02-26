<template>
  <page :betterScroll="true">
    <div class="login-logo">
      <div class="logo-wrap">
        <img class="ignore" src="/static/images/logo.png" alt="">
      </div>
    </div>
    <div class="login-form">
      <cube-input class="mg-b-15" type="text" placeholder="手机号" v-model="form.mobile" :clearable="true"></cube-input >
      <div class="mg-b-15">
        <cube-input type="password" placeholder="验证码" v-model="form.password" :clearable="true">
          <cube-button slot="append" :inline="true" class="btn-yellow" @click="getIdentifyingCode">
            <span>{{identifyingCode.time === 60 ? '获取验证码' : `${identifyingCode.time}s`}}</span>
          </cube-button>
        </cube-input>
      </div>

      <cube-button class="btn-red" @click="loginHandler">
        <span>登录</span>
      </cube-button>
    </div>
  </page>
</template>

<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  export default {
    props: [],
    data() {
      return {
        form: {
          mobile: '',
          password: ''
        }
      }
    },
    computed: {
      ...mapState('user', ['identifyingCode'])
    },
    methods: {
      ...mapActions('user', ['getIdentifyingCode']),
      loginHandler () {
        this.$redirect('/home')
      },
    }
  }
</script>

<style lang="scss" scoped>
  .login-logo {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 410px;
    .logo-wrap {
      display: inline-block;
      width: 300px;
      height: 100px;
      .ignore {
        width: 100%;
        height: 100%;
      }
    }
  }
  .login-form{
    padding:0 27px;
    .input-verify{
      span{
        color:#999;
      }
    }
    .btn-yellow {
      border: 1px solid #000;
      background-color: #fff;
      color: #000;
    }
    .btn-red {
      background-color: #D52B2B;
      color: #fff;
    }
    .mg-b-15 {
      margin-bottom: 15px;
    }
  }
</style>
