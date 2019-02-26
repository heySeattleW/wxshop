<template>
    <div class="cate-item">
      <div class="h">
        <span class="name">{{currentCategory.name}}</span>
        <p class="desc">{{currentCategory.front_name}}</p>
      </div>
      <div class="b">
        <router-link :to="'/goods/'+ iitem.id"
                     v-for="(iitem,iindex) in goodsList" :key="iindex"
                     :class="{'item':true, 'item-b':(iindex + 1)%2==0}">
          <img class="img" :src="iitem.list_pic_url" background-size="cover" />
          <span class="name">{{iitem.name}}</span>
          <p class="price">￥{{iitem.retail_price}}</p>
        </router-link>
      </div>
    </div>
</template>

<script type="text/ecmascript-6">
    export default {
        props: ["currentCategory", "goodsList"],
        data() {
            return {}
        },
        methods: {}
    }
</script>

<style scoped>
  .cate-item .h{
    height: 72.5px;
    /*width: 375px;*/
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  .cate-item .h .name{
    display: block;
    height: 17.5px;
    margin-bottom: 9px;
    font-size: 15px;
    color: #333;
  }

  .cate-item .h .desc{
    display: block;
    height: 12px;
    font-size: 12px;
    color: #999;
  }

  .cate-item .b{
    /*width: 375px;*/
    width: 100%;
    padding: 0 3.125px;
    height: auto;
    overflow: hidden;
    box-sizing:border-box;
    -moz-box-sizing:border-box; /* Firefox */
    -webkit-box-sizing:border-box; /* Safari */
  }

  .cate-item .b .item{
    float: left;
    background: #fff;
    /*width: 182.5px;*/
    width: 49%;
    margin-bottom: 3.125px;
    padding-bottom: 16.7777px;
    height: auto;
    overflow: hidden;
    text-align: center;
  }

  .cate-item .b .item-b{
    /*margin-left: 3.125px;*/
  }
  .cate-item .b .item:nth-of-type(odd){
    margin-right: 1%;
  }
  .cate-item .b .item:nth-of-type(even){
    margin-left: 1%;
  }

  .cate-item .item .img{
    width: 151px;
    height: 151px;
  }

  .cate-item .item .name{
    display: block;
    /*width: 182.8125px;*/
    width: 100%;
    height: 18.5px;
    margin: 5.75px 0 11px 0;
    text-align: center;
    /*overflow: hidden;*/
    /*padding: 0 20rpx;*/
    padding: 0 10px;
    /*font-size: 15px;*/
    color: #333;
    box-sizing: border-box;
    font-size: 14px;
    text-overflow:ellipsis; white-space:nowrap; overflow:hidden;
  }

  .cate-item .item .price{
    display: block;
    /*width: 182.8125px;*/
    width: 100%;
    height: 15px;
    text-align: center;
    font-size: 15px;
    color: #b4282d;
  }
</style>
