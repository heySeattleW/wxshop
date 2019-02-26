<template>
  <div class="page">
    <template v-for="(goods,index) in orderGoods">
      <div class="borderN backgTr border-b">
        <div class="list backgW pd-tl-16">
          <div class="pd-l-20 col-gary pd-r-40 borderN border-b">
            <img class="imgW50 mg-r-md" style="" :src="goods.list_pic_url" mode="widthFix" />
            <span hover-class="none">
              <cube-rate class="cube-xx" v-model="comments[index].stars" :max="5" @change="onStarChange"></cube-rate>
            </span>
            <div class="fontS14 col-gary mg-t-xs">{{goods.goods_specifition_name_value +  t('rate.number')+":"+ goods.number}}</div>
          </div>
        </div>

        <div class="pd-l-20 backgW">
          <div class="item col-gary pd-r-40 borderN pd-b-0">
            <textarea :placeholder="t('rate.placeholder')" :data-index="index"  maxlength="500"
                      v-model="comments[index].content"
                      class="fontS14" style="width:96%;height: 50px;" name="textarea"/>
          </div>
        </div>

        <div class="panel-body backgW item borderN">
          <div v-for="(img,iindex) in comments[index].images" :key="iindex"
            class="imgbox5 pos-re" @click="previewImage" :data-url="img" :style="'background: url(\''+img+'\') no-repeat center;background-size: 100%;'" >
            <img class="" style="width:100%;" src="/static/images/img26.png" mode="widthFix" />
            <span class="button-del3" @click.stop="deleteImg" :data-+-index="index" :data-value="img">
              <img class="imgW20" src="/static/images/img28.png" mode="aspectFill" />
            </span>
          </div>

          <div v-for="(video,iindex) in comments[index].videos" :key="iindex"
             class="imgbox5 pos-re" @click="playVideo" :data-poster="video.urlimg" :data-url="video.url" :style="'background: url(\''+video.urlimg+'\') no-repeat center;background-size: 100%;'" >
            <img class="full op7" style="" src="/static/images/img26.png" mode="widthFix" />
            <img src="/static/images/icon_video_play.png" class="imgW40 pos-ab" mode="widthFix"/>
            <span class="button-del3" @click.prevent="deleteVideo" :data-index="index" :data-value="iindex">
              <img class="imgW20" src="/static/images/img28.png" mode="aspectFill" />
            </span>
          </div>

          <div v-if="(comments[index].images.length + comments[index].videos.length)<5"
                class="imgbox5" style="background: url('/static/images/img68.png') no-repeat center;background-size: 100%;" >
            <img class="" style="width:100%;" src="/static/images/img26.png" mode="widthFix"
                   :data-index="index" @click="uploadImage" />
          </div>
          <div class="col-gary fontS14">{{t('rate.up5mention')}}</div>
        </div>
      </div>

      <template v-if="index!=orderGoods.length-1">
        <div style="height:20px;background-color: #eee;"></div>
      </template>

    </template>
    <div class="item padding-vertical borderN backgTr">
      <cube-button class="button-block button-positive button-red fontS16"  @click="submitComments">
        {{$t('rate.submit')}}
      </cube-button>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import {$http} from 'src/extends/http'
  import api from 'src/config/api'
  import upload from 'src/extends/upload'

  export default {
    props: [],
    data() {
      return {
        orderInfo:{},
        orderGoods: [],
        comments: []
      }
    },
    methods: {
      getOrderDetail(orderId){
        $http(api.eshopOrderDetail, { orderId: orderId }).then((res)=>{
          if (res.errno === 0) {
            console.log(res.data);

            let comments = []
            res.data.orderGoods.forEach(g => {
              comments.push({
                order_id: orderId,
                goods_id: g.goods_id,
                product_id: g.product_id,
                content: '',
                stars: 5,
                images: [],
                videos: []
              })
            })
            this.orderInfo = res.data.orderInfo
            this.orderGoods = res.data.orderGoods
            this.comments = comments
          }
        })
      },
      onStarChange(e){

      },
      uploadImage(e){
        // this.$sheet("您想：",[{content:"晒照片"},{content:"晒视频"}],(item,index)=>{
        //   if(index==0){ //照片
            let index = e.currentTarget.dataset.index
            let num = 5 - this.comments[index].images.length - this.comments[index].videos.length;
            upload.uploadImages(this.$route.fullPath, num).then(res=>{
              let images = this.comments[index].images;
              alert(JSON.stringify(images))
              images = images.concat(res)
              this.comments[index].images =  images
            })
          // }
        //   else if(index==1){ //视频
        //
        //   }
        // })
      },
      deleteImg(e){
        let index = e.currentTarget.dataset.index
        let imgLink = e.currentTarget.dataset.value
        let images = this.comments[index].images;
        let i = images.indexOf(imgLink)
        if(i>-1){
          images.splice(i, 1);
          this.comments[index].images = images
        }
      },
      deleteVideo(e){
        let index = e.currentTarget.dataset.index
        let iindex = e.currentTarget.dataset.value
        let videos = this.comments[index].videos;
        videos.splice(iindex, 1)
        this.comments[index].videos = videos
      },
      previewImage(e){
        this.$createImagePreview({
          imgs: [e.currentTarget.dataset.url]
        }).show()
      },
      playVideo(e){
        let data = e.currentTarget.dataset
        this.$go({path:'/common/video', query:{poster:data.poster, videoUrl:data.url}})
      },
      submitComments(e){
        $http(api.eshopCommentSubmit, {comments: this.comments}, 'POST').then(res=>{
          if (res.errno === 0) {
            this.$toast(this.$t('tips.rateSuccess'), 'correct')
            setTimeout(()=>{
              this.$back()
            },1000)
          }
        })
      }
    },
    created(){
      this.getOrderDetail(parseInt(this.$route.params.orderId));
    }
  }
</script>

<style scoped>
  @import '../../../assets/css/buy/rate.css';
  .cube-xx{
    vertical-align: middle;
  }
  .cube-xx >>>.cube-rate-item{
    width: 20px;
  }
  textarea{
    border: solid 1px #ccc;
    padding: 6px;
    outline:none;
    resize: none;
  }
  .pd-tl-16{
    padding-top: 16px;
    padding-left: 16px;
  }
  .pd-tl-16>div{
    padding-bottom: 16px;
  }
  .pd-b-0{
    padding-bottom: 0px!important;
  }
</style>
