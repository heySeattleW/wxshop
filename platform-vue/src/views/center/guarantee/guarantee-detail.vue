<template>
  <div class="pos-re bgW">
      <!--保修卡明细-->

    <div class="bx-top g-tac g-pt40">
      <p class="s-fs24 g-mb20">商城专属电子保修卡</p>
      <p class="s-fs14" @click="customerContact">售后电话：点我拨打</p>
    </div>


    <div class="bx-intrd pos-re top160 boxS s-fs14 col-gary1" style="z-index: 2;">

      <div class="border-b">
        <p class="g-mb20">产品名称</p>
        <p class="g-mb10">{{cardInfo.goodsName + '(' + cardInfo.goodsSpecifitionNames + ")"}}</p>
      </div>
      <div class="border-b">
        <p class="g-mb20 g-mt20">产品编号</p>
        <p class="g-mb10">{{cardInfo.productSn}}</p>
      </div>
      <div>
        <p class="g-mb20 g-mt20">保修时间</p>
        <p class="g-mb10">{{cardInfo.startDate}}－{{cardInfo.endDate}}</p>
      </div>

    </div>

    <div class="bx-his pos-re top160 g-pt20 bgW">
      <p class="s-fs18 g-mb10 col-gary1 fontW">维修历史</p>
      <div class="bx-hiss border-b g-pt10 s-fs14"
        v-for="repair in repairList" :key="repair.id">
        <p class="clearfix g-mb10"><span class="fl">维修日期</span><span class="fr">{{repair.repairTime}}</span></p>
        <p class="clearfix g-mb10"><span class="fl">故障原因</span><span class="fr">{{repair.reason}}</span></p>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import order from "src/extends/order"
  import {mapState, mapActions} from 'vuex'
  export default {
    props: [],
    data() {
      return {
        id: 0
      }
    },
    computed: {
      ...mapState('gurrantee', ['cardInfo'])
    },
    methods: {
      ...mapActions('gurrantee', ['getGurranteeCardInfo']),
      customerContact() {
        order.callCustomerService(this)
      }
    },
    created(){
      this.id = this.$route.params.id
      this.getGurranteeCardInfo(this.id)
    }
  }
</script>

<style scoped>

  .s-fs12{font-size:12px}
  .s-fs14{font-size:14px}
  .s-fs18{font-size:18px}
  .s-fs24{font-size:24px}
  .g-tac{text-align:center}
  .g-mb10{margin-bottom:10px}
  .g-mb20{margin-bottom:20px}
  .g-mt20{margin-top:20px}
  .g-pt10{padding-top:10px}
  .g-pt20{padding-top:20px}
  .g-pt40{padding-top:40px}
  .col-gary1{color: #333;}
  .fontW{font-weight: bold}
  .fl{float: left;}
  .fr{float: right;}
  .clearfix{overflow: hidden;zoom:1;}
  .bgW{background-color: #fff;}
  .top160{top:160px;}
  .border-b{border-bottom: solid 1px #e5e5e5;}
  .pos-re{position: relative;}
  .boxS{box-shadow: 1px 3px 13px #e4e4e4;}
  .bx-top{
    color: #fae5db;
    background-image: url(/static/images/guaranteeBg.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    background-position:center center;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    height: 250px;
    box-sizing: border-box;
  }
  .bx-intrd{
    background: #fff;
    margin-left: 15px;
    margin-right: 15px;
    border-radius: 6px;
    padding: 20px;
    box-sizing: border-box;
  }
  .bx-his{
    padding-left: 15px;
    padding-right: 15px;
  }
  .bx-hiss p span.fl{color: #9a9a9a;}
  .bx-hiss p span.fr{color: #333;}
</style>
