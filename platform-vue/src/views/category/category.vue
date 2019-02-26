<template>
    <div class="category-container">
      <div class="cate-nav">
        <cube-scroll-nav-bar :current="current" :labels="navLabels" :txts="navTxts" @change="switchCate" class="cate-nav-bar"/>
      </div>
      <div class="cate-content" v-if="current == item" v-for="item in navLabels" :key="item">
        <category-content :category-id="item"></category-content>
      </div>
    </div>
</template>

<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  import categoryContent from "./category-content";
  export default {
    props: [],
      data() {
          return {
            current:0,
            navLabels:[],
            navTxts:[]
          }
      },
      computed: {
        ...mapState('category', ['navList']),
      },
      methods: {
        ...mapActions('category', ['getCategoryInfo']),
        initNavBar(categoryId){
          let that = this;
          this.getCategoryInfo(categoryId).then(()=>{
            this.navLabels = this.navList.map(nav=>nav.id)
            this.navTxts = this.navList.map(nav=>nav.name)
          })
        },
        switchCate(cur){
          this.current = cur
        }
      },
      created(){
        this.current = parseInt(this.$route.params.id)
        this.initNavBar(this.current)
      },
      components:{
        categoryContent
      },
    }
</script>

<style scoped>
  .cate-nav{
    position: fixed;
    left:0;
    right:0;
    top:0;
    z-index: 1000;
  }
  .cate-nav /deep/ .cube-scroll-wrapper {
    text-align: left!important;
  }
  .cate-content{
    margin-top: 47px;
  }
</style>
