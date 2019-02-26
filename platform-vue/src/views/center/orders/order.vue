<template>
  <div class="order-container">
    <cube-tab-bar class="tabs"
                  v-model="selectedLabel"
                  show-slider>
      <cube-tab v-for="item in tabs"
                :label="item.label"
                :key="item.label"></cube-tab>
    </cube-tab-bar>
    <div class="tab-container"
         v-if="selectedLabel == item.label"
         v-for="item in tabs"
         :key="item.label">
      <order-content :type="item.code"></order-content>
    </div>


  </div>
</template>

<script>
import orderContent from "./order-content";
export default {
  data() {
    return {
      selectedLabel: "待付款",
      tabs: [
        {
          label: "待付款",
          code: 0
        },
        {
          label: "待发货",
          code: 201
        },
        {
          label: "待收货",
          code: 300
        },
        {
          label: "待评价",
          code: 301
        },
        {
          label: "退款",
          code: 400
        },
        {
          label: "历史",
          code: 302
        }
      ]
    };
  },
  methods: {},
  components: {
    orderContent
  }
};
</script>

<style lang="scss" scoped>
.order-container {
  height: 100%;
  font-size: 16px;
}
.tabs {
  height: 2rem;
  background-color: #fff;
  font-size: 14px;
}
.tab-container {
  height: calc(100% - 2rem);
}
</style>


