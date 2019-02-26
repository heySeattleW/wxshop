<template>
  <div class="scroll-list-wrap">
    <cube-scroll ref="scroll" @pulling-up="onPullingUp"
                 :options="options">
      <category-item :currentCategory="currentCategory" :goodsList="goodsList"></category-item>
    </cube-scroll>
  </div>
</template>
<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  import api from 'src/config/api';
  import { $http } from "src/extends/http";
  import categoryItem from "./category-item";

  export default {
    name:'categoryContent',
    props: ['categoryId'],
    data() {
      return {
        options: {
          pullUpLoad: true
        },
        goodsList: []
      }
    },
    computed:{
      ...mapState('category', ['currentCategory']),
    },
    methods: {
      ...mapActions('category', ['getCategoryInfo']),
      onPullingUp() {
        this.getGoodsList();
      },
      async getGoodsList(){
        const size = 10;
        let page = parseInt(this.goodsList.length / size + 1);
        let res = await $http(api.eshopGoodsList, {categoryId:this.categoryId, page, size})
        if (res.errno == 0) {
          this.goodsList = this.goodsList.concat(res.data.goodsList)
          page = parseInt(this.goodsList.length / size + 1);
          let noMore = (page === res.data.totalPages)
          if(noMore) this.options.pullUpLoad = false;
        }
        this.$nextTick(() => {
          // 让li标签回到顶部
          this.$refs.scroll.refresh();
          this.$refs.scroll.forceUpdate()
        });
      }
    },
    mounted(){
      this.getCategoryInfo(this.categoryId)
      this.getGoodsList();
    },
    components:{
      categoryItem
    },
  }
</script>


<style scoped>
  .scroll-list-wrap {
    height: 620px;
  }
</style>
