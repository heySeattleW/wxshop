<template>
  <page :betterScroll="true">
    <div class="login-logo">
      <div class="logo-wrap">
        <img class="ignore" src="/static/images/logo.png" alt="">
      </div>
    </div>
    <div class="login-btns">
      <cube-button class="btn-red mg-b-15" icon="cubeic-message" @click="getOauthCode">
        <span>微信授权登陆</span>
      </cube-button>
      <!--<cube-button class="btn-default" @click="$go('/loginMobile')" icon="cubeic-mobile-phone">-->
        <!--<span>手机号码登陆</span>-->
      <!--</cube-button>-->
    </div>
  </page>
</template>

<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  import wechat from 'src/config/wechat'
  export default {
    props: [],
    data() {
      return {
        code: ''
      }
    },
    computed: {
      ...mapState('user', ['userInfo'])
    },
    methods: {
      ...mapActions('user', ['loginByWechat']),
      getOauthCode:wechat.getOauthCode,
      async wechatLoginHandler () {
        let res = await this.loginByWechat(this.code)
        if(res){
          this.$toast('登陆成功','correct')
          setTimeout(()=>{
            this.$redirect('/center')
          },1000)
        }
      }
    },
    created () {
      if(this.$route.query.hasOwnProperty('code')){
        this.code = this.$route.query.code
        this.wechatLoginHandler()
      }
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

  .login-btns {
    padding: 0 40px;
    .btn-red {
      background: #CC3333;
      color: #fff
    }
    .btn-default {
      border: solid 1px #CC3333;
      color: #CC3333;
      background: #fff;
    }
    .mg-b-15 {
      margin-bottom: 15px;
    }
  }
</style>
