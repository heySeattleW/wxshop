<template>
  <div  data-tag="recommend" class="home-banner">
    <div  class="banner-policy col-gary4">
      <div  class="policy-item">
        <img src="/static/images/img10.png" height="16" alt="" title=""/>
        <span >Big straight for</span>
      </div>
      <div  class="policy-item">
        <img src="/static/images/img10.png" height="16" alt="" title=""/>
        <span >7-day return</span>
      </div>
      <div  class="policy-item">
        <img src="/static/images/img10.png" height="16" alt="" title=""/>
        <span >Package mail</span>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    props: [],
    data() {
      return {}
    },
    methods: {}
  }
</script>

<style scoped>
  .home-banner {
    background: #fff;
    content: "viewport-units-buggyfill";
  }
  .home-banner .banner-policy,
  .home-banner .banner-policy .policy-item {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
  }
  .home-banner .banner-policy {
    height: 9.867vw;
    padding: 0 3.6vw;
    content: "viewport-units-buggyfill; height: 9.867vw; padding: 0 3.6vw";
  }
  .home-banner .banner-policy .policy-item {
    -webkit-box-flex: 1;
    -ms-flex: 1;
    flex: 1;
  }
  .home-banner .banner-policy,
  .home-banner .banner-policy .policy-item {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
  }
  .home-banner .banner-policy .policy-item i {
    color: #b4282d;
  }
  .home-banner .banner-policy .policy-item span {
    padding-left: 1.333vw;
    content: "viewport-units-buggyfill; padding-left: 1.333vw";
    font-size: 3.2vw;
  }
  .col-gary4 {
    color: #7f7f7f;
  }
</style>
