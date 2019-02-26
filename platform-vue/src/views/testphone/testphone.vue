<template>
  <page :betterScroll="true" :refresh="refresh" :load-more="loadMore">
    <ul class="list-wrapper">
      <li v-for="(item, index) in items" :key="index">
        <testphone-item :item="item"></testphone-item>
      </li>
    </ul>
  </page>
</template>

<script type="text/ecmascript-6">
  import api from 'src/config/api';
  import { $http } from "src/extends/http";
  import TestphoneItem from "./testphone-item";
  export default {
    props: [],
    data() {
        return {
          options: {
            pullUpLoad: true
          },
          items: []
        }
    },
    methods: {
      async refresh(scroll) {
        await this.getTestphoneList(true);
        scroll.forceUpdate();
      },
      async loadMore(scroll,done) {
        let noMore = await this.getTestphoneList();
        scroll.forceUpdate();
        done(noMore);
      },
      async getTestphoneList(isRefresh = false){
        const size = 10;
        let page = isRefresh ? 1 : parseInt(this.items.length / size) + 1;
        let res = await $http(api.eshopTestphones, {size:size, page: page});
        if(res.errno==0){
          if (isRefresh) this.items.length = 0;
          this.items = this.items.concat(res.data.data);
          let noMore = (parseInt(this.items.length / size)+1)===page
          return noMore;
        }
      }
    },
    mounted() {
      this.getTestphoneList();
    },
    components: {
      TestphoneItem
    }
  }
</script>

<style scoped>
  .list-wrapper {
    height: 100%;
  }
  .list-wrapper li {
    margin-bottom: 10px;
  }
</style>
