<template>
    <div class="slider">
      <cube-slide :data="banners" :initial-index="1" :loop="true" :interval="4000">
        <cube-slide-item v-for="(item, index) in banners" :key="index">
          <a :href="item.url">
            <img :src="item.image" class="slide-image">
          </a>
        </cube-slide-item>
      </cube-slide>
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
    computed: {
      ...mapState('home', ['banners'])
    },
    methods: {
      ...mapActions('home', ['getBanners']),
    },
    mounted(){
      this.getBanners()
    }
  }
</script>

<style scoped>
  .cube-slide {
    position: relative;
    min-height: 1px;
    height: 100%;
  }
  .cube-slide-group {
    position: relative;
    height: 100%;
    overflow: hidden;
    white-space: nowrap;
  }
  .cube-slide-item {
    float: left;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    height: 100%;
    text-align: center;
  }
  .cube-slide-item > a,
  .cube-slide-item img {
    display: block;
    height: 100%;
  }
  .slide-image {
    width:100%;
    height:208px!important;
  }
</style>
