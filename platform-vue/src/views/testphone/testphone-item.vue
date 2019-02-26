<template>
    <div class="phone-cp">
      <div class="con" @click="playVideo" :data-url="item.videoUrl" :data-poster="item.picUrl">
        <img :src="item.picUrl" style="" alt="" type=""/>
        <div class="video-contr">
          <img src="/static/images/img13.png" width="50" alt="" type=""/>
        </div>
      </div>
      <p>{{item.name}}</p>
    </div>
</template>

<script type="text/ecmascript-6">
    export default {
        props: ['item'],
        data() {
            return {}
        },
        methods: {
          playVideo(e){
            let data = e.currentTarget.dataset
            this.$go({path:'/common/video', query:{poster:data.poster, videoUrl:data.url}})
          }
        },
    }
</script>

<style scoped>
  @import '../../assets/css/testphone/common.css';
  @import '../../assets/css/testphone/pingce.css';
</style>
