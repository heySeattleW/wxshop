<template>
  <page ref="page" :betterScroll="true" :refresh="refresh" :load-more="loadMore">
    <ul class="list-wrapper">
      <li v-for="(item, index) in items" :key="index">
        <comment-item :comment="item"></comment-item>
      </li>
    </ul>
  </page>
</template>

<script type="text/ecmascript-6">
    import api from 'src/config/api';
    import { $http } from "src/extends/http";
    import CommentItem from "./comment-item";

    export default {
        name:'commentContent',
        props: ['goodsId','type'],
        data() {
            return {
                options: {
                  pullUpLoad: true
                },
                items:[]
            }
        },
        methods: {
          async refresh(scroll) {
            await this.getCommentList(true);
            scroll.forceUpdate();
          },
          async loadMore(scroll,done) {
            let noMore = await this.getCommentList();
            scroll.forceUpdate();
            done(noMore);
          },
          async getCommentList(isRefresh = false){
            const size = 10;
            let page = isRefresh ? 1 : parseInt(this.items.length / size) + 1;
            let res = await $http(api.eshopCommentList, {valueId: this.goodsId, type: this.type, pageSize:size, page: page});
            if(res.errno==0){
              if (isRefresh) this.items.length = 0;
              this.items = this.items.concat(res.data.data);
              let noMore = (parseInt(this.items.length / size)+1)===page
              if(noMore) this.$refs.page.options.pullUpLoad = false
              return noMore;
            }
          }
        },
        mounted() {
          this.getCommentList();
        },
        components:{
          CommentItem
        }
    }
</script>

<style scoped>
  .scroll-list-wrap {
    height: 100%;
  }
</style>
