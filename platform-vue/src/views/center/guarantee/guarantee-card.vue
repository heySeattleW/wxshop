<template>
  <page ref="page" :betterScroll="true" :refresh="refresh" :load-more="loadMore">
    <template v-for="card in cardList">
      <router-link :to="'/guaranteeDetail/' + card.id">
        <!--保修卡-->
        <div class="tab-panel">
          <div class="tab-panel-item tab-active">
            <div class="tab-item">
              <div class="tab-item-list">
                <div class="aui-flex boxS mg-b-15">
                  <div class="aui-left-change">
                    <div class="aui-icon-circle"></div>
                  </div>
                  <div class="aui-flex-box aui-flex-box-two">
                    <h3>产品名称：{{card.goodsName}}</h3>
                    <div class="aui-flex aui-flex-bor-bom">
                      <div class="aui-flex-box aui-flex-box-flow">保修日期：{{card.startDate}}至{{card.endDate}}</div>
                    </div>
                    <div class="aui-flex aui-flex-show" >
                      <div class="aui-btn-use">
                        查看详情
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </router-link>
    </template>
  </page>
</template>

<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  export default {
    props: [],
    data() {
      return {
        options: {
          pullUpLoad: true
        }
      }
    },
    computed: {
      ...mapState('gurrantee', ['cardList'])
    },
    methods: {
      ...mapActions('gurrantee', ['getGurranteeCardList']),
      async refresh(scroll) {
        await this.getData(true);
        scroll.forceUpdate();
      },
      async loadMore(scroll,done) {
        let noMore = await this.getData();
        scroll.forceUpdate();
        done(noMore);
      },
      async getData(isRefresh = false) {
        const size = 5;
        console.log(this.cardList.length);
        let page = isRefresh ? 1 : parseInt(this.cardList.length / size) + 1;
        if (isRefresh) this.$store.commit('gurrantee/resetGurranteeList');
        await this.getGurranteeCardList({page, size});
        let noMore = (parseInt(this.cardList.length / size)+1)===page
        if(noMore) this.$refs.page.options.pullUpLoad = false;
        return noMore;
      }
    },
    created(){
      this.getData()
    }
  }
</script>

<style scoped>
  @import "../../../assets/css/coupon/coupon.css";
  .boxS{
    box-shadow: 1px 3px 13px #e4e4e4;
  }
  .mg-b-15{
    margin-bottom: 15px;
  }
  .tab-item-list{
    padding-top: 15px;
    padding-right: 15px;
    padding-left: 50px;
  }
  .aui-flex{
    padding: 0;
  }
  .aui-left-change{
    background: #fff;
    width: 20%;
    overflow: initial;
  }
  .aui-icon-circle{
    background-image: url(/static/images/guarantee.png);
    background-size: 145px;
    background-position: -8px -22px;
    background-repeat: no-repeat;
    width: 120px;
    height: 100px;
    left: -60px;
  }
  .aui-flex-box-two{
    box-shadow: none;
  }
</style>
