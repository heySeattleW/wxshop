<template>
  <div class="home-header">
    <div class="header-top">
      <div class="top-search">
        <router-link to="/search">
          <div class="search-left">
            <img src="/static/images/img11.png" class="mg-r-sm" height="15" alt="" title=""/>
            <span>{{t('home.searchPlaceHolder', {'goodsCount':goodsCount})}}</span>
          </div>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  export default {
    props: [],
    data() {
      return {
      }
    },
    computed:{
      ...mapState('catalog', ['goodsCount'])
    },
    methods: {
      ...mapActions('catalog', ['getGoodsCount']),
    },
    mounted(){
      this.getGoodsCount();
    }
  }
</script>

<style scoped>
  .mg-r-sm {
    margin-right: 10px;
  }
  .home-header .header-top {
    display: flex;
    align-items: center;
    height: 88px;
    padding: 0 27px;
    background: white;
  }
  .home-header .header-top .top-logo {
    flex-basis: 160px;
    box-sizing: border-box;
    padding-right: 20px;
  }
  .home-header .header-top .top-logo img {
    width: 100%;
  }
  .home-header .header-top .top-search .search-left {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: flex;
    align-items: center;
  }
  .home-header .header-top .top-search .search-left i {
    color: #909090;
  }
  .home-header .header-top .top-search .search-left span {
    white-space: nowrap;
    color: #c8c8c8;
  }
  .home-header .header-bottom {
    width: 100%;
    overflow-x: hidden;
    background: white;
  }
  .home-header .header-bottom .cube-scroll-content {
    display: inline-block;
  }
  .home-header .header-bottom .cube-scroll-content .bottom-tabs {
    white-space: nowrap;
    padding: 0 0.4rem;
  }
  .home-header .header-bottom .cube-scroll-content .bottom-tabs .tabs-item {
    display: inline-block;
    height: 0.77778rem;
    padding: 0 0.2223rem;
    text-align: center;
    line-height: 0.77778rem;
  }
  .home-header .header-bottom .cube-scroll-content .bottom-tabs .tabs-item span {
    font-size: 0.372rem;
    font-weight: 400;
  }
  .home-header .header-bottom .cube-scroll-content .bottom-tabs .tabs-item-active {
    position: relative;
    color: #b4282d;
  }
  .home-header .header-bottom .cube-scroll-content .bottom-tabs .tabs-item-active::after {
    position: absolute;
    content: '';
    bottom: 0;
    left: 0;
    width: 100%;
    height: 0;
    border-bottom: 2px solid #b4282d;
  }
  .home-header .header-bottom .cube-scroll-content .bottom-tabs .tabs-item:not(:first-child) {
    margin-left: 0.833rem;
  }
  .home-header .header-top {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    height: 11.733vw;
    padding: 0 3.6vw;
    background: #fff;
    content: "viewport-units-buggyfill; height: 11.733vw; padding: 0 3.6vw";
  }
  .home-header .header-top .top-search {
    position: relative;
    -webkit-box-flex: 1;
    -ms-flex: 1;
    flex: 1;
    height: 7.733vw;
    background: #fafafa;
    content: "viewport-units-buggyfill; height: 7.733vw; border-radius: 0.667vw";
    border-radius: 50px;
    border: solid 1px #d9d9d9;
  }
  .home-header .header-top .top-search .search-left {
    position: absolute;
    top: 50%;
    left: 50%;
    -webkit-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
  }
  .home-header .header-top .top-search .search-left i {
     color: #909090;
   }
  .home-header .header-top .top-search .search-left span {
    white-space: nowrap;
    color: #7f7f7f;
    font-size: 3.2vw;
  }

</style>
