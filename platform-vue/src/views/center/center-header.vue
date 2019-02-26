<template>
  <div class="center-header">
    <section class="img-title" @click="$go('/login')">
      <img class="img"
      :src="userInfo.avatarUrl" alt="">
    <p>{{userInfo.nickName}}</p>
    </section>
  </div>
</template>

<script>
  import {mapState, mapActions} from 'vuex'
  export default {
    data(){
      return {
        userInfo:{}
      }
    },
    methods: {
      ...mapActions('user', ['getUserInfo'])
    },
    async activated(){
      this.userInfo = await this.getUserInfo()
      console.log(this.userInfo)
    }
  }

</script>

<style lang="scss">
@import '~static/scss/mixin';

  .center-header{
    @include sc(16px,#fff);
    position: relative;
    height: pxTorem(140px);
    background-color: brown;
    text-align: center;
    .img-title {
      @include center();
    }
    .img {
      height: pxTorem(70px);
      margin-bottom: pxTorem(10px);
    }
    .header-right {
      position: absolute;
      top: 50%;
      right: 27px;
      transform: translateY(-50%);
      i {
        font-size: 50px;
        color: white;
        &:not(:last-child) {
          padding-right: 27px;
        }
      }
    }
  }
</style>


