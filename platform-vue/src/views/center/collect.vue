<template>
  <page :betterScroll="true"
        :refresh="refresh">

    <cube-swipe>
      <transition-group name="swipe"
                        tag="ul">
        <li v-for="(item,index) in items"
            :key="item.id">
          <cube-swipe-item :btns="btns"
                           :index="index"
                           ref="swipeItem"
                           @btn-click="deleteShop(item,index)">
            <div @click="detail(item.value_id)" class="collect-item border-bottom-1px">
              <div class="item-pic">
                <img class="ignore"
                     :src="item.list_pic_url"
                     alt="">
              </div>
              <div class="item-info">
                <p class="info-name">{{item.name}}</p>
                <p class="info-spec">{{item.goods_brief}}</p>
                <p class="info-spice">¥{{item.retail_price}}</p>
              </div>
            </div>
          </cube-swipe-item>
        </li>
      </transition-group>
    </cube-swipe>

  </page>
</template>

<script>
import api from "@/config/api";
import { $http } from "@/extends/http";

export default {
  data() {
    return {
      btns: [{ action: "delete", text: "删除", color: "#ff3a32" }],
      items: []
    };
  },
  mounted() {
    this.getCollects();
  },
  methods: {
    async refresh(scroll) {
      await this.getCollects();
      scroll.forceUpdate();
    },
    // 取消收藏
    async deleteShop(item, index) {
      let result = await this.$confirm('提示',"确定要取消收藏吗？");
      this.$refs.swipeItem[index].shrink();
      if (result) {
        this.items.splice(index,1);
        $http(api.eshopCollectOrDelete, { typeId: item.type_id, valueId: item.value_id}, 'POST').then(res => {
          if (res.errno === 0) this.$toast('删除成功');
        })
      }
    },
    async getCollects() {
      let res = await $http(api.eshopCollect);
      if (res.errno === 0) this.items = res.data;
    },
    detail(goodsId) {
      this.$go('/goods/' + goodsId)
    }
  }
};
</script>

<style lang="scss" scoped>
@import "~static/scss/mixin";

.collect-item {
  @include fj(flex-start);
  height: pxTorem(100px);
  box-sizing: border-box;
  padding: 18px 0;
  background-color: #fff;
  .item-pic {
    flex-basis: pxTorem(80px);
    .ignore {
      width: 100%;
      height: 100%;
    }
  }
  .item-info {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    flex: 1;
    padding: 0 10px;
    font-size: 14px;
    .info-name {
      p {
        font-size: 28px;
        font-weight: 600;
        color: #333;
      }
    }
    .info-spec {
      font-size: pxTorem(12px);
      color: #aaa;
    }
  }
}
</style>

