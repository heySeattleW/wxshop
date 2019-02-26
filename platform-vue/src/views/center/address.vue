<template>
  <page :better-scroll="true">
    <div class="swipe-wrapper">
      <cube-swipe>
        <transition-group name="swipe" tag="ul">
          <li class="swipe-item-wrapper" v-for="(item,index) in swipeData" :key="item.id">
            <cube-swipe-item
                :btns="btns"
                :index="index"
                @btn-click="onBtnClick">
              <div @click="addressAdd(item)" class="item-inner">
                <div class="user-name">
                  <span>{{item.userName}}</span>
                  <span class="default" v-if="item.is_default === 1">默认</span>
                </div>
                <div class="text">
                  <h2 class="item-name" v-html="item.telNumber"></h2>
                  <p class="item-desc" v-html="item.full_region + item.detailInfo"></p>
                </div>
              </div>
            </cube-swipe-item>
          </li>
        </transition-group>
      </cube-swipe>
    </div>
    <div class="footer" slot="bottom">
      <cube-button @click="addressAdd()">新建</cube-button>
    </div>
  </page>
</template>

<script>
import api from '@/config/api';
import { $http } from "@/extends/http";
import { mapActions } from 'vuex';

export default {
  data() {
    return {
      btns: [
        {action: 'delete',text: '删除',color: '#ff3a32'}
      ],
      swipeData: []
    };
  },
  methods: {
    ...mapActions('center', ['editAddress']),
    onBtnClick(btn, index) {
      if (btn.action === "delete") {
        this.$createActionSheet({
          title: "确认要删除吗",
          active: 0,
          data: [{ content: "删除" }],
          onSelect: () => {
            let id = this.swipeData[index].id;
            this.swipeData.splice(index, 1);
            $http(api.eshopAddressDelete, { id }, 'POST');
          }
        }).show();
      }
    },
    addressAdd(item) {
      let id = item && item.id;
      this.editAddress(item);
      this.$router.push({path:'/addressAdd', query:{id}})
    }
  },
  async activated(){
    let res = await $http(api.eshopAddressList);
    if( res.errno == 0) this.swipeData = res.data;
  },
  components: {}
};
</script>

<style lang="scss" scoped>
@import "~static/scss/mixin";

/*.swipe-view {*/
  .swipe-wrapper {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;

    .cube-swipe{
      @include remCalc(padding, 10px, 0,0, 0);
      background:#fff url(https://ossyf.oss-cn-beijing.aliyuncs.com/20181105/161103210889b9.png) 0 0 repeat-x;
    }
    .swipe-item-wrapper {
      overflow: hidden;
      @include remCalc(margin, 0, 0, 0,10px);
      border-bottom: solid 1px #ddd;

      &.swipe-enter-active,
      &.swipe-leave-active {
        transition: all 0.3s;
        .item-inner {
          transition: all 0.3s;
        }
      }
      &.swipe-enter,
      &.swipe-leave-to {
        .item-inner {
          height: 0;
        }
      }
      .item-inner {
        display: flex;
        box-sizing: border-box;
        align-items: center;
        padding: 0 20px;
        /*height: 80px;*/
        height: pxTorem(80px);
        .icon {
          flex: 0 0 60px;
          /*width: 60px;*/
          width: pxTorem(60px);
          padding-right: 20px;
        }
        .user-name{
          flex: 1;
        }
        .default {
          margin-top: pxTorem(6px);
          display: block;
          width: pxTorem(31px);
          height: pxTorem(16px);
          border-radius: pxTorem(2px);
          border: pxTorem(1px) solid #b4282d;
          font-size: pxTorem(10px);
          text-align: center;
          line-height: pxTorem(14px);
          color: #b4282d;
        }
        .text {
          display: flex;
          flex-direction: column;
          justify-content: center;
          /*flex: 1;*/
          line-height: 20px;
          overflow: hidden;
          font-size: 14px;
          flex: 4;
          .item-name {
            @include remCalc(margin, 0, 0,5px, 0);
            color: #333;
          }
          .item-desc {
            color: #aaa;
          }
        }
      }
    }
  }

.page-bottom{
.footer{
  .cube-btn{
    background-color: brown;
    /*border-radius: 0;*/
    @include borderRadius(0px);
    font-size: pxTorem(14.5px);
  }
}
}
/*}*/
</style>
