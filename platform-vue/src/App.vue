<template>
  <div id="app">
    <div class="app-page"
         :class="{'app-page-with-tabbar':tabbarVisible}">
      <keep-alive>
        <router-view  />
      </keep-alive>
    </div>
    <div class="app-tabbar" v-if="tabbarVisible">
      <cube-tab-bar
        :value="selectedLabel"
        show-slider
        @change="changeHandler">
        <cube-tab v-for="item in tabs" :icon="item.icon" :label="$t(item.label)" :key="$t(item.label)">
        </cube-tab>
      </cube-tab-bar>
    </div>
    <div class="app-loading" v-if="isLoading">
      <cube-loading :size="28" ></cube-loading>
    </div>
  </div>
</template>
<script>
  import {mapState, mapActions} from 'vuex'
  import tabbarConfig from './config/tabbar'
  export default {
    name: 'App',
    data() {
      return {
        tabs: tabbarConfig.tabs,
      }
    },
    computed: {
      ...tabbarConfig.computed,
      ...mapState('common', ['isLoading'])
  },
  methods: {
    changeHandler(label) {
      let clickedTab = this.tabs.find(p => this.$t(p.label) === label)
      this.$redirect(clickedTab.path)
    }
  }
  }
</script>


<style lang="scss" scoped>
  @import '~static/scss/common';
  #app {
    position: absolute;
    top:0;
    bottom:0;
    width:100%;
    font-size: 24px;
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    background: #f3f5f4;
  }
  .app-page{
    position: absolute;
    top:0;
    bottom:0;
    width:100%;
  }
  .app-page-with-tabbar {
     bottom:42px;
  }
  .app-tabbar{
    font-size: 14px;
    background-color: #fff;
    position: fixed;
    bottom: 0;
    left: 0;
    right: 0;
    z-index:9999
  }
  .app-loading {
    position: absolute;
    top: 50%;
    left: 50%;
    margin-left: -14px;
    margin-top: -14px;
    z-index: 9999
  }
  .cube-tab-bar {
    height: 42px;
  }
  .border-bottom-1px {
  position: relative;
  &::before{
    content: "";
    display: block;
    position: absolute;
    -webkit-transform-origin: 0 0;
    transform-origin: 0 0
  }
}
</style>
