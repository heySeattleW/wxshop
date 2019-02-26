<template>
  <div class="container">
    <div class="list pd-l-20 backgW mg-t-sm">
      <div class="item borderN">
          <span class="col-blk item-note fontS16">
          {{t('home.promoting')}}
          </span>
      </div>
    </div>

    <div class="backgW item borderN pd-t-0 clearfix">
      <div class="imgbox2 fl"
           v-for="(item,index) in activityGoods" :key="index"
           v-bind:data-index="index" v-bind:data-id="item.goodsId" v-bind:data-activity-id="item.activityId"
           @click="clickActivityGoods">
        <div class="pos-re border-gary" style="">
          <img class="full" :src="item.img_url" alt="" title="" />
          <div class="button1">
            <img class="full width30" src="/static/images/img69.png" alt="" title="" />
          </div>
        </div>
        <div class="mg-t-sm">
          <p class="item-note col-gary2 fontS14">
            <font class="col-red1">{{item.activityName}}</font>
            {{item.goodsName}}
          </p>
        </div>
        <div class="mg-t-sm mg-b-sm fontS12">
          <span class="col-red2 fs16" style="">¥{{item.retail_price}}</span>
          <span class="col-gary3 text-del" style="">¥{{item.market_price}}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  export default {
    props: [],
    data() {
      return {}
    },
    computed: {
      ...mapState('home', ['activityGoods'])
    },
    methods: {
      ...mapActions('home', ['getActivityGoods']),
      clickActivityGoods(e){
        let id = e.currentTarget.dataset.id;
        this.$go('/goods/' + id)
      }
    },
    mounted(){
      this.getActivityGoods()
    }
  }
</script>

<style scoped>
  @import '../../assets/css/home/text.css';
</style>
