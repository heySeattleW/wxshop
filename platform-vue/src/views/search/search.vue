<template>
    <div class="container">
      <div class="search-header">
        <div class="input-box">
          <img class="icon" src="/static/images/icon_search.png" />
          <input name="input" class="keyword" focus="true" :value="keyword" :placeholder="defaultKeyword.keyword"
                 v-on:input="inputChange" v-on:focus="inputFocus" v-on:keyup.enter="onKeywordConfirm"  />
          <img class="del" v-if="keyword" @click="clearKeyword" src="/static/images/icon_delete.png" />
        </div>
        <span class="right" @click="closeSearch">{{$t('search.cancel')}}</span>
      </div>

      <div class="no-search" v-if="!searchStatus">
        <div class="search-keywords search-history" v-if="!keyword  && historyKeyword.length">
          <div class="h">
            <span class="title">{{$t('search.history')}}</span>
            <img class="icon" @click="clearHistory" src="/static/images/icon_clear_history.png" />
          </div>
          <div class="b">
            <template v-for="(item,index) in historyKeyword">
              <div class="item" @click="onKeywordTap" :data-keyword="item"  hover-class="navigator-hover">
                {{item}}
              </div>
            </template>
          </div>
        </div>
      </div>

      <div class="search-keywords search-hot" v-if="!keyword && goodsList.length==0">
        <div class="h">
          <span class="title">{{t('search.hotSearch')}}</span>
        </div>
        <div class="b">
          <template v-for="(item,index) in hotKeyword" >
            <div :class="{'item':true, 'active':item.is_hot === 1}" hover-class="navigator-hover" @click="onKeywordTap" :data-keyword="item.keyword" >
              {{item.keyword}}
            </div>
          </template>
        </div>
      </div>

      <div class="shelper-list" v-if="keyword">
        <template v-for="(item,index) in helpKeyword" >
          <div class="item" hover-class="navigator-hover" @click="onKeywordTap" :data-keyword="item">
            {{item}}
          </div>
        </template>
      </div>

      <div class="search-result" v-if="searchStatus && goodsList.length">
        <div class="sort">
          <div class="sort-box">
            <div :class="{'item':true, 'active':currentSortType == 'default'}" >
              <span class="txt" @click="openSortFilter" id="defaultSort">{{$t('search.general')}}</span>
            </div>
            <div :class="{'item':true, 'by-price':true, 'active':currentSortType == 'price', 'asc': currentSortOrder == 'asc', 'desc':currentSortOrder != 'asc'}" >
              <span class="txt" @click="openSortFilter" id="priceSort">{{$t('search.price')}}</span>
            </div>
            <div :class="{'item':true, 'active':currentSortType == 'category'}" >
              <span class="txt" @click="openSortFilter" id="categoryFilter">{{$t('search.classify')}}</span>
            </div>
          </div>
          <div class="sort-box-category" v-if="categoryFilter">
            <ul class="list">
              <li class="item" :class="{'item':true, 'active':item.checked}"
                  v-for="(item,index) in filterCategory" :key="'cate-'+item.id"
                  :data-category-index="index" @click="selectCategory">{{item.name}}</li>
            </ul>
            <!--<div :class="'item ' + item.checked ? 'active' : ''"-->
                 <!--v-for="(item,index) in filterCategory" :key="'cate-'+item.id"-->
                 <!--:data-category-index="index" @click="selectCategory">{{item.name}}</div>-->

          </div>
        </div>
        <div class="cate-item">
          <page ref="page" :betterScroll="true" :refresh="refresh" :load-more="loadMore">
            <div class="b">
              <div v-for="(iitem,iindex) in goodsList" :key="iindex" :class="{'item':true, 'item-b':(iindex + 1) % 2 == 0}">
                <router-link :to="'/goods/'+ iitem.id">
                  <img class="img" :src="iitem.list_pic_url" background-size="cover" />
                  <span class="name">{{iitem.name}}</span>
                  <span class="price">￥{{iitem.retail_price}}</span>
                </router-link>
              </div>
            </div>
          </page>
        </div>
      </div>

      <div class="search-result-empty" v-if="!goodsList.length && searchStatus">
        <img class="icon" src="/static/images/icon_search_notfound.png" />
        <span class="text">{{$t('search.notForSale')}}</span>
      </div>
    </div>
</template>

<script type="text/ecmascript-6">
    import api from 'src/config/api';
    import {$http} from "src/extends/http";

    export default {
        props: [],
        data() {
            return {
              keyword: '',
              searchKeyword: '',
              searchStatus: false,
              defaultKeyword: {},
              hotKeyword: [],
              historyKeyword: [],
              helpKeyword: [],
              goodsList: [],

              categoryFilter: false,
              currentSortType: 'default',
              currentSortOrder: '',
              filterCategory: [],
              categoryId: 0
            }
        },
        methods: {
          getSearchKeyword(){
            $http(api.eshopSearchIndex).then(res => {
              if (res.errno === 0) {
                  this.historyKeyword = res.data.historyKeywordList
                  this.defaultKeyword = res.data.defaultKeyword
                  this.hotKeyword = res.data.hotKeywordList
              }
            })
          },
          getHelpKeyword(){
            $http(api.eshopSearchHelper, {keyword: this.searchKeyword}).then(res => {
              if (res.errno === 0) {
                this.helpKeyword = res.data
              }
            })
          },
          async refresh(scroll) {
            await this.getGoodsList(true);
            scroll.forceUpdate();
          },
          async loadMore(scroll,done) {
            let noMore = await this.getGoodsList();
            scroll.forceUpdate();
            done(noMore);
          },
          async getGoodsList(isRefresh = false){
            const size = 10;
            let page = isRefresh ? 1 : parseInt(this.goodsList.length / size) + 1;
            let res = await $http(api.eshopGoodsList, {
              keyword: this.searchKeyword,
              page: page,
              size: size,
              sort: this.currentSortType,
              order: this.currentSortOrder,
              categoryId: this.categoryId,
            });
            if(res.errno==0){
              this.filterCategory = res.data.filterCategory
              this.searchStatus = true;
              this.categoryFilter = false;

              if (isRefresh) this.goodsList.length = 0;
              this.goodsList = this.goodsList.concat(res.data.goodsList);
              let noMore = (parseInt(this.goodsList.length / size)+1)===page
              if(noMore) this.$refs.page.options.pullUpLoad = false
              return noMore;
            }
            //重新获取关键词
            // this.keyword = this.searchKeyword
            this.getSearchKeyword();
          },
          getSearchResult(keyword){
            this.keyword = keyword
            this.page = 1
            this.categoryId = 0
            this.goodsList = []
            this.getGoodsList();
          },
          inputChange(e){
            console.log(e)
            this.searchKeyword = e.data
            this.searchStatus = false
            this.getHelpKeyword();
          },
          inputFocus(e){
            this.searchStatus = false
            this.goodsList = []
            if (this.keyword) {
              this.getHelpKeyword();
            }
          },
          onKeywordConfirm(e){
            this.getSearchResult(this.searchKeyword);
          },
          onKeywordTap(e){
            this.getSearchResult(e.currentTarget.dataset.keyword);
          },
          clearKeyword(e){
            this.keyword = ''
            this.searchStatus = false
          },
          closeSearch(e){
            this.$back();
          },
          async clearHistory(e){
            this.historyKeyword = []
            let res = await $http(api.eshopSearchClearHistory, {}, 'POST')
            if(res.errno==0){
              this.$toast(this.$t('tips.clearSuccess'),'correct')
            }
          },
          openSortFilter(e){
            let currentId = e.srcElement.id;
            switch (currentId) {
              case 'categoryFilter':
                this.categoryFilter = !this.categoryFilter
                this.currentSortOrder = 'asc'
                break;
              case 'priceSort':
                let tmpSortOrder = 'asc';
                if (this.currentSortOrder === 'asc') {
                  tmpSortOrder = 'desc';
                }
                this.currentSortType = 'price'
                this.currentSortOrder = tmpSortOrder
                this.categoryFilter = false
                this.getGoodsList(true);
                break;
              default:
                //综合排序
                this.currentSortType = 'default'
                this.currentSortOrder = 'desc'
                this.categoryFilter = false
                this.getGoodsList(true);
            }
          },
          selectCategory(e){
            console.log(e)
            let currentIndex = e.currentTarget.dataset.categoryIndex;
            let filterCategory = this.filterCategory;
            let currentCategory = null;
            for (let key in filterCategory) {
              if (key == currentIndex) {
                filterCategory[key].selected = true;
                currentCategory = filterCategory[key];
              } else {
                filterCategory[key].selected = false;
              }
            }
            this.filterCategory = filterCategory
            this.categoryFilter = false
            this.categoryId = currentCategory.id
            this.goodsList = []
            this.getGoodsList(true);
          }
        },
        created(){
          this.getSearchKeyword()
        }
    }
</script>

<style scoped>
  @import '../../assets/css/search/search.css';
</style>
