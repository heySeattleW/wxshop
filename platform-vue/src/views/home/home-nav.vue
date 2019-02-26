<template>
  <div class="home-direct-supply mg-b-10">
    <div class="m-floor">
      <div class="floor-view">
        <div  class="direct-supply-wrap flex">
          <div class="text-c fs12 mg-t-sm mg-b-sm"
               v-for="(item,index) in channel" :key="index">
            <router-link :to="item.url">
              <img :src="item.icon_url" class="width60 mg-b-5" alt="" title="" />
              {{item.name}}
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {mapState, mapActions} from 'vuex'
  export default {
    props: [],
    data() {
      return {
      }
    },
    computed:{
      ...mapState('home', ['channel'])
    },
    methods: {
      ...mapActions('home', ['getChannel']),
    },
    mounted(){
      this.getChannel();
    }
  }
</script>

<style scoped>
  .home-direct-supply .direct-supply-wrap {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
  }
  .home-direct-supply .direct-supply-wrap .wrap-item {
    position: relative;
    -ms-flex-preferred-size: calc(49.533%);
    flex-basis: calc(49.533%);
    height: 32.267vw;
    background: #f4f4f4;
    color: #333;
    content: "viewport-units-buggyfill; -ms-flex-preferred-size: calc(50% - 0.467vw); flex-basis: calc(50% - 0.467vw); height: 32.267vw";
  }
  .home-direct-supply .direct-supply-wrap .wrap-item:nth-child(odd) {
    margin: 0 .933vw .933vw 0;
    content: "viewport-units-buggyfill; margin: 0 0.933vw 0.933vw 0";
  }
  .home-direct-supply .direct-supply-wrap .wrap-item:nth-child(2n) {
    margin-bottom: .933vw;
    content: "viewport-units-buggyfill; margin-bottom: 0.933vw";
  }
  .mg-b-10 {
    margin-bottom: 10px;
  }
  .m-floor {
    background: #fff;
  }
  .m-floor .floor-view {
    padding: 0 1.867vw;
    content: "viewport-units-buggyfill; padding: 0 1.867vw";
  }
  .flex {
    display: flex;
  }
  .flex > div {
    flex: 1;
  }
  .flex > div > img {
    display: block;
    margin: auto;
  }
  .text-c {
    text-align: center;
  }
  .fs12 {
    font-size: 12px;
  }
  .mg-b-sm {
    margin-bottom: 10px;
  }
  .mg-t-sm {
    margin-top: 10px;
  }
  .width60 {
    width: 60%;
    display: block;
    margin: auto;
  }
  .mg-b-5 {
    margin-bottom: 5px;
  }
</style>
