<template>
  <div class="container posf-b3 box-circle100 clearfix" >
    <transition class="pmd" name="test" mode="out-in">
      <span class="fontS12 col-fff pmd width50b" v-if="ready" :style="'background: url(\''+avatars[number]+'\') no-repeat;background-size: 30px 30px;background-position: 5px center;'"
            :key="text.id"  ref="pmd">{{text.val}}</span>
    </transition>
    <div class="pmdr">
      <img class="imgW30 fr" src="/static/images/img55.png" alt="" title="" />
      <span class="fontS12 col-fff fr" @click="buyNow">{{t('goods.buyNow')}}</span>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import api from 'src/config/api';
  import {$http} from "src/extends/http";

  export default {
    data() {
      return {
        ready: false,
        number:0,
        list: [],
        avatars: []
      }
    },
    computed: {
      text() {
        return {
          id: this.number,
          val: this.list[this.number]
        }
      }
    },
    methods: {
      startMove() {
        let timer = setTimeout(() => {
          if (this.number === this.list.length - 1) {
            this.number = 0;
          } else {
            this.number += 1;
          }
          this.startMove();
        }, 5000)
      },
      buyNow(id){
        this.$go('/goods/' + id)
      },
      getMarqueeList(){
        $http(api.eshopGetMarquee).then(res=>{
          if(res.errno==0){
            this.list = res.data.map(n=> {
              return n.nickName + "刚刚购买了" + n.info
            })
            this.avatars = res.data.map(n=>{
              return n.avatar
            })
            this.ready = true
            this.startMove()
          }
        })
      }
    },
    mounted(){
      this.getMarqueeList()
    },
    components:{
    }
  }
</script>

<style scoped>
  @import '../../assets/css/home/text.css';
  .container {
    position: absolute;
    bottom: -620px;
  }
  .test-enter-active, .test-leave-active {
    transition: all 0.5s linear;
  }
  .test-leave-to {
    transform: translateY(-100%);
  }
  .test-enter {
    transform: translateY(100%);
  }
</style>
