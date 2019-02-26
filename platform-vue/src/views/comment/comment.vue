<template>
  <div class="borderN backgTr">
    <div class="list backgW">
      <div class="item pd-l-20 pd-r-40 borderN border-b fontS14">
        <span class="mg-r-xs">评价</span>
        <cube-rate class="cube-xx" v-model="totals.totalStars" disabled :max="5"></cube-rate>
        <span class="">{{totals.favorableRating}}%好评</span>
        <div class="mg-t-xs">
          <span v-for="(num, index) in totals.nums" :key="index"
            :class="{'button':true, 'button-red':current==index, 'button-gary':current!=index} "
            :data-current="index" @click="clickTab" >{{totals.labels[index]}}({{num}})</span>
        </div>
      </div>
    </div>

    <div class="tab-container" v-if="current==index" v-for="(item,index) in totals.nums" :key="index">
      <comment-content :goods-id="id" :type="index"></comment-content>
    </div>

  </div>
</template>

<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  import CommentContent from "./comment-content";

  export default {
    props: [],
      data() {
          return {
            id: 0,
            current: 0
          }
      },
      computed:{
          ...mapState('comment', ['totals'])
      },
      methods: {
          ...mapActions('comment', ['getCommentCount']),
        clickTab(e){
            this.current = parseInt(e.currentTarget.dataset.current)
        }
      },
      created(){
          this.id = parseInt(this.$route.query.id)
          this.getCommentCount(this.id)
      },
      components: {
          CommentContent
      },
  }
</script>

<style scoped>
  .item {
    border-color: #ddd;
    background-color: #fff;
    color: #444;
    position: relative;
    z-index: 2;
    display: block;
    padding: 16px;
    border-width: 1px;
    border-style: solid;
    font-size: 16px;
  }


  .button-block:after {
    clear: both;
  }
  .backgTr {    background-color: transparent;}
  .backgW {    background-color: #fff!important;}
  .item.borderN,.panel-footer.borderN {    border: none;}

  .panel-body {padding: 15px;}
  .mg-r-md {margin-right: 15px;}
  .mg-r-xs {margin-right: 5px;}
  .mg-t-xs {margin-top: 5px;}
  .fontS12{font-size:12px;}
  .fontS14{font-size:14px;}
  .fontS16{font-size:16px;}
  .imgW16{  width:16px;  height: 16px;}

  .img-circle {
    border-radius: 50%;
  }
  .imgW40{width: 40px;height: 40px;}
  .imgW50{width: 50px;height: 50px;}
  .item.border-b, .border-b {border-bottom: solid 1px #ddd;}

  .pd-l-0{padding-left: 0;}
  .pd-t-0{padding-top: 0;}
  .pd-b-0{padding-bottom: 0;}
  .pd-10{padding: 10px;}
  .col-blk {color: #000;}
  .col-gary {color: #aaa;}
  .bg-gary {background-color: #eee;}


  span,image{display: inline-block;vertical-align:middle;}


  .imgbox5{
    width:18%;
    margin-right:2%;
    margin-bottom:10px;
    display: inline-block;
    padding:0;
    box-sizing: border-box;
    border: solid 1px #ccc;
  }
  .imgbox5>image{  display: block;}


  .button.button-gary,
  .button.button-red{
    padding:4px 5px;
    margin-right:8px;
    margin-top:10px;
  }

  .button-gary{
    border: solid 1px #aaa;
    color: #aaa;
  }
  .button-red{
    border: solid 1px #ee4c44;
    color: #ee4c44;
  }


  .pos-re{
    position: relative;
  }

  .full{width:100%}
  .op7{
    opacity: 0.7;
  }
  .imgW40{
    width:40px;
    height: 40px;
  }
  .pos-ab.imgW40{
    position: absolute;
    top:50%;
    margin-top:-20px;
    left:50%;
    margin-left:-20px;
  }

  .tab-container {
    height:529px;
  }


  /*星星*/
  .cube-xx{
    vertical-align: middle;
  }
  .cube-xx >>>.cube-rate-item{
    width: 20px;
  }
</style>
