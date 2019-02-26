<template>
    <div class="comment-item">
      <div style="border-bottom:solid 1px #ddd;">
        <div class="list backgW">
          <div class="item pd-l-20 pd-r-40 borderN">
            <img class="imgW40 mg-r-md img-circle" style="" :src="comment.user_info.avatar" mode="widthFix" />
            <span class="fontS14 mg-r-xs">{{comment.user_info.nickname}}</span>
            <cube-rate class="cube-xx" v-model="comment.stars" disabled :max="5"></cube-rate>
          </div>
        </div>

        <div class="pd-l-20 backgW">
          <div class="item pd-r-40 borderN  pd-t-0 pd-b-0">
            <div class="fontS12 col-gary">{{comment.add_time}}</div>
            <span class="fontS14">{{comment.content}}</span>
          </div>
        </div>

        <div class="panel-body backgW item borderN">
          <template v-for="(pic,index) in comment.pic_list">
            <div v-if="pic.video_url" class="imgbox5 pos-re" @click="playVideo" :data-url="pic.video_url" :data-poster="pic.pic_url" :style="'background: url(\''+pic.pic_url+'\') no-repeat center;background-size: 100%;'" >
              <img class="full op7" style="" src="/static/images/img26.png"  />
              <img src="/static/images/icon_video_play.png" class="imgW40 pos-ab"  />
            </div>
            <div v-else class="imgbox5" @click="previewImage" :data-url="pic.pic_url"
                  :style="'background: url(\''+pic.pic_url+'\') no-repeat center;background-size: 100%;'" >
              <img class="" style="width:100%;" src="/static/images/img26.png"  />
            </div>
          </template>
        </div>
      </div>

    </div>
</template>

<script type="text/ecmascript-6">
    export default {
        props: ['comment'],
        data() {
            return {}
        },
        methods: {
          playVideo(e){
            let data = e.currentTarget.dataset
            this.$go({path:'/common/video', query:{poster:data.poster, videoUrl:data.url}})
          },
          previewImage(e){
            this.$createImagePreview({
              imgs: [e.currentTarget.dataset.url]
            }).show()
          }
        }
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
  .backgW {    background-color: #fff!important;}
  .item.borderN,.panel-footer.borderN {    border: none;}
  .panel-body {padding: 15px;}
  .mg-r-md {margin-right: 15px;}
  .mg-r-xs {margin-right: 5px;}
  .fontS12{font-size:12px;}
  .fontS14{font-size:14px;}
  .img-circle {
    border-radius: 50%;
  }
  .imgW40{width: 40px;height: 40px;}
  .item.border-b, .border-b {border-bottom: solid 1px #ddd;}
  .pd-t-0{padding-top: 0;}
  .pd-b-0{padding-bottom: 0;}
  .col-gary {color: #aaa;}
  span,img{display: inline-block;vertical-align:middle;}
  .imgbox5{
    width:18%;
    margin-right:2%;
    margin-bottom:10px;
    display: inline-block;
    padding:0;
    box-sizing: border-box;
    border: solid 1px #ccc;
  }
  .imgbox5>img{  display: block;}
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
  /*星星*/
  .cube-xx{
    vertical-align: middle;
  }
  .cube-xx >>>.cube-rate-item{
    width: 20px;
  }
</style>
