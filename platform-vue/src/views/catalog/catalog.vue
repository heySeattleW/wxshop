<template>
    <div class="container">
      <home-search></home-search>

      <div class="catalog">
        <div class="nav" scroll-y="true">
          <page :betterScroll="true">
            <div v-for="(item,index) in navList" :key="index"
                 v-bind:class="{item:true, active:currentCategory.id == item.id?true:false}"
                 v-bind:data-index="index" v-bind:data-id="item.id"
                 v-on:click="switchCate">
              {{item.name}}
            </div>
          </page>
        </div>
        <div class="cate" scroll-y="true">
          <page :betterScroll="true">
            <template slot="top">
              <div class="banner">
                <img class="image" v-bind:src="currentCategory.wap_banner_url" />
                <div class="txt">{{currentCategory.front_name}}</div>
              </div>
              <div class="hd">
                <div class="line"></div>
                <div class="txt">{{$t('catalog.kind',{'name':currentCategory.name})}}</div>
                <div class="line"></div>
              </div>
            </template>
            <div class="bd">
              <div v-for="(item,index) in currentCategory.subCategoryList" :key="index"
                   v-bind:class="{item:true, last:(index+1) % 3 == 0 ? true : false}">
                <router-link :to="'/category/'+item.id" class="input">
                  <img class="icon" v-bind:src="item.wap_banner_url" />
                  <span class="txt">{{item.name}}</span>
                </router-link>
              </div>
            </div>
          </page>
        </div>
      </div>
    </div>
</template>

<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  import homeSearch from '../home/home-search'
  export default {
    props: [],
      data() {
          return {

          }
      },
      computed: {
        ...mapState('catalog', ['navList', 'categoryList', 'currentCategory'])
      },
      methods: {
        ...mapActions('catalog', ['getCatalog','getCurrentCategory']),
        switchCate: function (e) {
          let id = e.target.dataset.id;
          if (this.currentCategory.id === parseInt(id)) {
            return false;
          }
          this.getCurrentCategory(parseInt(id));
        }
      },
      created(){
         this.getCatalog()
      },
      components:{
        homeSearch
      }
  }
</script>

<style scoped>
  .container {
    background:#f9f9f9;
    height:100%;
    width:100%;
    display:flex;
    flex-direction:column;
  }

  .search {
    height: 44px;
    width: 100%;
    padding: 0 15px;
    background: #fff;
    display: flex;
    align-items: center;
  }

  .search .input {
    width: 345px;
    height: 28px;
    background: #ededed;
    border-radius: 4px;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .search a .icon {
    background: url(https://ossyf.oss-cn-beijing.aliyuncs.com/20181105/16123099710a24.png) center no-repeat;
    background-size: 100%;
    width: 14px;
    height: 14px;
  }

  .search a .txt {
    height: 21px;
    line-height: 21px;
    color: #666;
    padding-left: 5px;
    font-size: 15px;
  }

  .catalog {
    flex:1;
    width:100%;
    background:#fff;
    display:flex;
    border-top:1px solid #fafafa;
  }

  .catalog .nav {
    width: 81px;
    height: 100%;
    border-right: solid 1px #ddd;
  }

  .catalog .nav .item {
    text-align: center;
    /*line-height: 45px;*/
    width: 81px;
    height: 35px;
    color: #333;
    font-size: 14px;
    border-left: 3px solid #fff;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .catalog .nav .item.active {
    color: #ab2b2b;
    font-size: 18px;
    border-left: 3px solid #ab2b2b;
  }

  .catalog .cate {
    border-left: 1px solid #fafafa;
    flex: 1;
    height: 100%;
    padding: 0 15px 0 15px;
  }

  .banner {
    display: block;
    height: 111px;
    width: 100%;
    position: relative;
  }

  .banner .image {
    position: absolute;
    top: 15px;
    left: 0;
    border-radius: 2px;
    height: 96px;
    width: 100%;
  }

  .banner .txt {
    position: absolute;
    top: 15px;
    text-align: center;
    color: #fff;
    font-size: 14px;
    left: 0;
    height: 96px;
    line-height: 96px;
    width: 100%;
  }

  .catalog .hd {
    height: 54px;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .catalog .hd .txt {
    font-size: 12px;
    text-align: center;
    color: #333;
    padding: 0 5px;
    width: auto;
  }

  .catalog .hd .line {
    width: 20px;
    height: 1px;
    background: #d9d9d9;
  }

  .catalog .bd {
    width: 100%;
    overflow: hidden;
    height: 100%;
  }

  .catalog .bd .item {
    display: block;
    float: left;
    height: 108px;
    /*width: 72px;*/
    /*margin-right: 17px;*/
    width: 32%;
    margin-right: 2%;
  }

  .catalog .bd .item.last {
    margin-right: 0;
  }

  .catalog .bd .item .icon {
    height: 72px;
    width: 72px;
  }

  .catalog .bd .item .txt {
    display: block;
    text-align: center;
    font-size: 12px;
    color: #333;
    height: 36px;
    width: 72px;
  }
</style>
