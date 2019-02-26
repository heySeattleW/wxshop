<template>
    <div class="container">
      <html-video autoplay :poster="poster" :video-url="videoUrl" class="video"></html-video>
    </div>
</template>

<script type="text/ecmascript-6">
    export default {
        props: [],
        data() {
            return {}
        },
        methods: {},
        created(){
          this.poster = this.$route.query.poster
          this.videoUrl = this.$route.query.videoUrl
        }
    }
</script>

<style lang="scss" scoped>
  @import "~static/scss/mixin";
  .container {
    background: #000;
    height: 100%;
  }
  .video {
    position: absolute;
    width: 100%;
    top: 50%;
    margin-top: pxTorem(-110px);
  }
</style>
