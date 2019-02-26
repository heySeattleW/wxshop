<template>
  <div class="page"
       :style="{background: pageBackground}">
    <div class="page-top">
      <slot name="top"></slot>
    </div>
    <div class="page-middle"
         :class="{'page-better-scroll': betterScroll}">
      <template v-if="!betterScroll">
        <router-view></router-view>
        <slot></slot>
      </template>
      <cube-scroll ref="scroll"
                   :scrollEvents="scrollEvents"
                   :options="options"
                   @pulling-down="onPullingDown"
                   @pulling-up="onPullingUp"
                   @before-scroll-start="beforeScrollStart"
                   @scroll="scroll"
                   v-if="betterScroll">
        <router-view></router-view>
        <slot></slot>
      </cube-scroll>

    </div>
    <div class="page-bottom">
      <slot name="bottom"></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: "page",
  data() {
    return {
      options: {
        pullDownRefresh: false,
        pullUpLoad: false
      },
      scrollEvents: ["scroll", "before-scroll-start"]
    };
  },
  beforeMount() {
    const refresh = { threshold: 90, stopTime: 1000, txt: "更新成功" };
    if (this.loadMore) this.options.pullUpLoad = true;
    if (this.refresh) this.options.pullDownRefresh = refresh;
  },
  props: ["betterScroll", "pageBackground", "refresh","loadMore"],
  methods: {
    onPullingUp() {
      this.loadMore && this.loadMore(this.$refs.scroll,(noMore = true) => {
        if (noMore) this.options.pullUpLoad = false;
      });
    },
    onPullingDown() {
      if (this.loadMore) this.options.pullUpLoad = true;
      this.refresh && this.refresh(this.$refs.scroll);
    },
    beforeScrollStart() {
      this.$refs.scroll.refresh();
    },
    scroll(e) {
      this.$emit("scroll", e);
    },
    scrollTo(val, options) {
      if (typeof val === "string") {
        const el = document.querySelector(val);
        const topEl = this.$refs.scroll.$el.querySelector(
          ".cube-scroll-content"
        );
        try {
          this.$refs.scroll.scrollTo(
            0,
            -(
              el.getBoundingClientRect().top - topEl.getBoundingClientRect().top
            ),
            800
          );
        } catch (e) {
          // @TODO
        }
      }
      if (Array.isArray(val)) {
        this.$refs.scroll.scrollTo(...val);
      }
    },
    
  }
};
</script>

<style lang="scss" scoped>
.page {
  position: relative;
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 100%;
  font-size: 16px;
  .page-top {
    flex-grow: 0;
  }
  .page-middle {
    position: relative;
    flex: 1;
    overflow-y: auto;
  }
  .page-better-scroll {
    overflow-y: hidden;
  }
  .page-bottom {
    flex-grow: 0;
  }
}
</style>


