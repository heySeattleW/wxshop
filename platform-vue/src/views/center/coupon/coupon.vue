<template>
  <div class="coupon-container">
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
      <coupon-content :type="item.code"></coupon-content>
    </div>
  </div>
</template>

<script>
  import couponContent from './coupon-content'
  export default {
    data() {
      return {
        selectedLabel: "未使用",
        tabs: [
          {
            label: "未使用",
            code: 1
          },
          {
            label: "使用记录",
            code: 2
          },
          {
            label: "已过期",
            code: 3
          }
        ]
      }
    },
    methods: {

    },
    created(){

    },
    components: {
      couponContent
    }
  }
</script>

<style scoped>
  .coupon-container {
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

