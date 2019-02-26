<template>
    <cube-sticky :pos="scrollY">
      <page :better-scroll="true" @scroll="scroll">
        <div class="borderN backgTr">
          <div class="backgW pos-re">
            <cube-slide :data="gallery" :initial-index="1" :loop="true" :interval="4000">
              <cube-slide-item v-for="(item, index) in gallery" :key="index">
                <img :src="item.image_url" style="width:100%;">
              </cube-slide-item>
            </cube-slide>
          </div>
        </div>

        <div class="borderN backgTr mg-b-sm">
          <div class="panel-body backgW pos-re">
            <div class="item pd-r-40 borderN pd-4-10 pd-l-0">
              {{goods.name}}
            </div>
            <div class="fontS12 col-gary">
              {{goods.goods_brief}}
            </div>
            <div class="item pd-r-40 borderN pd-4-10 pd-l-0">
              <span class="colRed fontS20 mg-r-md">￥{{goods.retail_price}}</span>
            </div>
          </div>
          <div class="section-nav section-attr" @click="switchAttrPop">
            <div class="t">{{t('goods.selectSpecText')}}</div>
            <img class="i" src="/static/images/address_right.png" background-size="cover"/>
          </div>
          <div class="section-nav section-attr height-at" v-if="coupons.length>0" @click="switchCouponAttrPop">
            <div class="lq">{{t('goods.fetchCouponText')}}</div>
            <div class="q">
              <span v-for="(item, index) in coupons">{{t('goods.couponCart',{'min_goods_amount':item.min_goods_amount, 'type_money': item.type_money})}}</span>
            </div>
            <img class="i" src="/static/images/address_right.png" background-size="cover"/>
          </div>

        </div>

        <div class="comments" v-if="comment.count > 0">
          <div class="h">
            <router-link :to="{path:'/comment', query:{id:goods.id, typeId:0}}">
              <span class="t fontS16">{{t('goods.commentText',{'count': comment.count > 999 ? '999+' : comment.count})}}</span>
              <span class="i fontS14">{{t('goods.commentMore')}}</span>
            </router-link>
          </div>
          <div class="b">
            <div class="info">
              <div class="user">
                <img :src="comment.data.avatar"/>
                <span>{{comment.data.nickname}}</span>
              </div>
              <span class="time">{{comment.data.add_time}}</span>
            </div>
            <p class="content">
              {{comment.data.content}}
            </p>
            <div class="imgs" v-if="comment.data.pic_list.length > 0">
              <template v-for="(pic, index) in comment.data.pic_list">
                <div v-if="pic.video_url" class="imgbox5 pos-re" @click="playVideo" :data-url="pic.video_url" :data-poster="pic.pic_url"
                     :style="'background: url(\''+pic.pic_url+'\') no-repeat center;background-size: 100%;'">
                  <img class="full op7" style="" src="/static/images/img26.png" mode="widthFix"/>
                  <img src="/static/images/icon_video_play.png" class="imgW40 pos-ab" mode="widthFix"/>
                </div>
                <div v-else class="imgbox5" @click="previewImage" :data-url="pic.pic_url"
                     :style="'background: url(\''+pic.pic_url+'\') no-repeat center;background-size: 100%;'">
                  <img class="" style="width:100%;" src="/static/images/img26.png" mode="widthFix"/>
                </div>
              </template>
            </div>
          </div>
        </div>

        <div v-if="attribute && attribute.length>0" class="goods-attr">
          <div class="t">{{t('goods.abilitiesText')}}</div>
          <div class="l">
            <div class="item" v-for="(item, index) in attribute" :key="index">
              <span class="left">{{item.name}}</span>
              <span class="right">{{item.value}}</span>
            </div>
          </div>
        </div>

        <div class="detail">
          <div v-html="goods.goods_desc"></div>
        </div>

        <div class="common-problem">
          <div class="h">
            <span class="line"></span>
            <span class="title">{{t('goods.issuesText')}}</span>
          </div>
          <div class="b">
            <div class="item" v-for="(item, index) in issueList" :key="index">
              <div class="question-box">
                <span class="spot"></span>
                <p class="question">{{item.question}}</p>
              </div>
              <div class="answer">
                {{item.answer}}
              </div>
            </div>
          </div>
        </div>
        <!--占位-->
        <div style="height:60px;"></div>
      </page>
      <template slot="fixed" slot-scope="props">
        <div style="" class="tabs text-center backgW posf-b2">
          <div style="" class="tab-item1" @click="collectOrDelete">
            <img v-if="userHasCollect==1" src="/static/images/icon_has_collected.png" style="" class="imgW20" alt=""
                 title=""/>
            <img v-else src="/static/images/icon_collect.png" style="" class="imgW20" alt="" title=""/>
          </div>
          <button style="" class="tab-item1" @click="customerContact">
            <img src="/static/images/img61.png" style="" class="imgW20" alt="" title=""/>
          </button>
          <div style="" class="tab-item1 pos-re" @click="openCartPage">
            <span v-if="cartGoodsCount>0"
              class="imgW15 img-circle bg-red fontS10 t5-r5 text-center line-height15">{{cartGoodsCount}}</span>
            <img src="/static/images/img59.png" style="" class="imgW20" alt="" title=""/>
          </div>
          <div style="" class="tab-item2 fontS14" @click="buy">{{t('goods.buyNow')}}</div>
          <div style="" class="tab-item2 fontS14 bg-red" @click="addToCart">{{t('goods.addToCart')}}</div>
        </div>
      </template>

      <template>
        <div class="zhe" v-if="specAttr.onOff"></div>
        <div class="boxsq" :style="{'bottom': specAttr.onOff? '47px': '-667px'}">
          <button class="fr-xbtn" @click="switchAttrPop">×</button>
          <div class="attr-pop">
            <div class="img-info">
              <img class="img" :src="specAttr.specImage"/>
              <div class="info">
                <div class="c">
                  <p class="p">{{t('goods.specPrice', {'price': specAttr.specPrice})}}</p>
                  <p class="a" v-if="productList.length>0">{{t('goods.specCheckedSpecs',{'checkedSpecs': specAttr.checkedSpecText})}}</p>
                </div>
              </div>
            </div>
            <div class="spec-con">
              <div class="spec-item" v-for="(item,index) in specificationList" :key="item.specification_id">
                <div class="name">{{item.name}}</div>
                <div class="values">
                  <div :class="{'value': true, 'selected': vitem.checked, 'disable': vitem.disable}"
                       v-for="(vitem,iindex) in item.valueList" :key="vitem.id"
                       :data-value-id="vitem.id" :data-name-id="vitem.specification_id"
                       @click="clickSkuValue">
                    {{vitem.value}}
                  </div>
                </div>
              </div>

              <div class="number-item">
                <div class="name">{{t('goods.specNum')}}</div>
                <div class="selnum fontS18">
                  <span class="cut" @click="cutNumber">-</span>
                  <input :value="specAttr.number" class="number" disabled="true" type="number"/>
                  <span class="add" @click="addNumber">+</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </template>

      <!--优惠券-->
      <template>
        <div class="zhe" v-if="couponAttr.onOff"></div>
        <div class="boxsq" :style="{'bottom': couponAttr.onOff? '47px': '-667px'}">
          <button class="fr-xbtn" @click="switchCouponAttrPop">×</button>
          <p class="fontS14 text-center mg-t-10 pd-l-37">{{t('goods.CouponAvaliabeMention')}}</p>

          <div class="tab-panel full">
            <div class="tab-panel-item tab-active">
              <div class="tab-item">
                <!--未使用-->
                <div class="tab-item-list" v-for="(item,index) in coupons">
                  <div class="aui-flex">
                    <div class="aui-left-change box-sizing">
                      <h2 >
                        <em >￥</em>{{item.type_money}}
                      </h2>
                      <p >{{t('goods.couponItemText', {'min_goods_amount':item.min_goods_amount})}}</p>
                      <div class="aui-icon-circle"></div>
                    </div>
                    <div class="aui-flex-box aui-flex-box-two box-sizing">
                      <h3>
                        <em>{{t('goods.couponType')}}</em>{{item.name}}</h3>
                      <div class="aui-flex aui-flex-bor-bom">
                        <div class="aui-flex-box aui-flex-box-flow">{{item.use_start_date}}-{{item.use_end_date}}</div>
                      </div>
                      <div class="aui-flex aui-flex-show">
                        <div data-id="24" :class="{'aui-btn-use':true, 'none':item.enabled!=0}"  @click="recevieCoupon(item.id)" >
                          {{item.enabled==0?t('tips.couponFetch'):t('tips.couponFetched')}}
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="aui-show-box">
                    <p >默认隐藏内容</p></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </template>
    </cube-sticky>

</template>

<script type="text/ecmascript-6">
  import {mapState, mapActions} from 'vuex'
  import api from 'src/config/api';
  import {$http} from "src/extends/http";
  import order from "src/extends/order"

  export default {
    props: [],
    data() {
      return {
        scrollY: 0,
        specAttr: {
          onOff: false,
          checkedSpecText: t('goods.selectSpecText'),
          specImage: '',
          specPrice: '',
          number: 1 //买几件
        },
        couponAttr: {
          onOff: false
        }
      }
    },
    computed: {
      ...mapState('goods', ['goods', 'gallery', 'comment', 'coupons', 'attribute', 'specificationList', 'productList', 'issueList', 'userHasCollect', 'cartGoodsCount'])
    },
    methods: {
      ...mapActions('goods', ['getGoodsDetail', 'getCartGoodsCount']),
      initGoodsInfo(goodsId) {
        let that = this
        this.getGoodsDetail(goodsId).then(() => {
          that.specAttr.specImage = that.goods.list_pic_url
          that.specAttr.specPrice = that.goods.retail_price
          that.goods.goods_desc = that.goods.goods_desc.replace(/\<img/gi, '<img class=\"fr-fin\" ')
          that.checkSpecDisable()
        })
      },
      switchAttrPop(e) {
        this.specAttr.onOff = !this.specAttr.onOff
      },
      switchCouponAttrPop(e){
        this.couponAttr.onOff = !this.couponAttr.onOff
      },
      playVideo(e){
        let data = e.currentTarget.dataset
        this.$go({path:'/common/video', query:{poster:data.poster, videoUrl:data.url}})
      },
      previewImage(e){
        this.$createImagePreview({
          imgs: [e.currentTarget.dataset.url]
        }).show()
      },
      clickSkuValue(e) {
        let that = this;
        let specNameId = parseInt(e.currentTarget.dataset.nameId);
        let specValueId = parseInt(e.currentTarget.dataset.valueId);
        let _specificationList = this.specificationList;
        let _specification = _specificationList.find(n => n.specification_id === specNameId)
        if (_specification) {
          let valueObj = _specification.valueList.find(n => n.id === specValueId)
          let valueChecked = !valueObj.checked
          _specification.valueList.forEach(n => {
            n.checked = false
          })
          if (valueObj) {
            valueObj.checked = valueChecked
            if (valueObj.pic_url) {
              that.specAttr.specImage = valueChecked ? valueObj.pic_url : that.goods.list_pic_url
            }
          }
        }

        //收集已选项
        let checkedValues = [];
        let checkedSpecText = t('goods.selectSpecText')
        checkedValues = this.getCheckedSpec()
        if (checkedValues.length > 0) {
          checkedSpecText = checkedValues.map(v => v.valueText).join(' ')
          let specCombineIds = checkedValues.map(v => v.valueId).join('_')
          let product = this.productList.find(p => p.goods_specification_ids == specCombineIds)
          if (product) {
            //TODO
            that.specAttr.specPrice = product.retail_price
          }
        }
        this.checkSpecDisable(checkedValues)
        this.$store.commit('goods/setSpecificationList', _specificationList)
        this.specAttr.checkedSpecText = checkedSpecText;
      },
      checkSpecDisable: function (checkedValues) {
        let _specificationList = this.specificationList;
        let productSpecs = this.productList.map(p => p.goods_specification_ids);
        if (checkedValues && checkedValues.length > 0) {

          checkedValues.forEach(cv => {
            let _productSpecs = []
            let index = _specificationList.findIndex(_spec => _spec.specification_id == cv.nameId)
            for (var i = 0; i < productSpecs.length; i++) {
              let psIdsArr = productSpecs[i].split('_')
              if (psIdsArr[index] == cv.valueId && !_productSpecs.includes(productSpecs[i])) {
                _productSpecs.push(productSpecs[i])
              }
            }
            productSpecs = _productSpecs
          })
        }

        let productSpecificationList = []
        productSpecs.forEach(pSpecs => {
          let pSpecArr = pSpecs.split('_')
          for (let i = 0; i < pSpecArr.length; i++) {
            if (!productSpecificationList[i]) {
              productSpecificationList[i] = []
            }
            if (pSpecArr[i] && !productSpecificationList[i].includes(pSpecArr[i])) {
              productSpecificationList[i].push(pSpecArr[i])
            }
          }
        })

        let _specIndex = 0
        _specificationList.forEach(_spec => {
          _spec.valueList.forEach(sv => {
            sv.disable = true
            if (productSpecificationList.length > 0 && productSpecificationList[_specIndex].includes(sv.id + "")) {
              sv.disable = false
            }
          })
          _specIndex++
        })
        this.$store.commit('goods/setSpecificationList', _specificationList)
      },
      getCheckedSpec() { //返回所有被选中的规格
        let checkedValues = [];
        this.specificationList.forEach(spec => {
          let specV = spec.valueList.find(v => v.checked == true)
          specV && checkedValues.push({
            nameId: spec.specification_id,
            valueId: specV.id,
            valueText: specV.value
          })
        })
        return checkedValues;
      },
      auditAllSpecsChecked(checkedSpecs) { //检查规格完整性
        let _specificationList = this.specificationList
        if (_specificationList.length == 0 || _specificationList.length == checkedSpecs.length) {
          return true
        } else { //规格选择不完整
          this.$toast(t('tips.specsNotCompleted'), "warn")
          return false;
        }
      },
      auditHasProductItem(checkedSpecs) { //检查商品上架和库存
        let specCombineIds = checkedSpecs.map(v => v.valueId).join('_')
        let product = this.productList.find(p => p.goods_specification_ids == specCombineIds)
        if (!product) {
          this.$toast(t("tips.productNotFound"), "warn")
          return false;
        } else if (product.goods_number < this.specAttr.number) {
          this.$toast(t("tips.stockNotEnough"), "warn")
          return false;
        } else {
          return product.id;
        }
      },
      collectOrDelete(e) {
        let that = this;
        $http(api.eshopCollectOrDelete, {typeId: 0, valueId: this.id}, 'POST').then(res => {
          if (res.errno == 0) {
            let userHasCollect = that.userHasCollect;
            if (res.data.type == 'add') {
              userHasCollect = 1
              that.$toast(t("tips.collectSuccess"), "correct")
            } else {
              userHasCollect = 0
              that.$toast(t("tips.deleteCollectSuccess"), "correct")
            }
            that.$store.commit("goods/setUserHasCollect", userHasCollect)
          } else {
            that.$toast(res.errmsg, "error")
          }
        });
      },
      openCartPage(e) {
        this.$go('/shopping')
      },
      cutNumber(e) {
        this.specAttr.number = (this.specAttr.number - 1 > 1) ? this.specAttr.number - 1 : 1
      },
      addNumber(e) {
        this.specAttr.number = this.specAttr.number + 1
      },
      buy(e) {
        let that = this;
        if (this.specAttr.onOff === false) {
          this.switchAttrPop()
        } else {
          //检查规格完整性
          let checkedSpecs = this.getCheckedSpec()
          if (this.auditAllSpecsChecked(checkedSpecs)) {
            let productId = this.auditHasProductItem(checkedSpecs)
            if (productId) {
              $http(api.eshopBuyAdd, {
                goodsId: this.goods.id,
                number: this.specAttr.number,
                productId: productId
              }, 'POST').then(res => {
                if (res.errno == 0) {
                  that.switchAttrPop()
                  that.$go({ name: 'checkout', params: { isBuy: true }})
                } else {
                  that.$toast(res.errmsg, "error")
                }
              });
            }
          }
        }
      },
      addToCart(e) {
        let that = this;
        if (this.specAttr.onOff === false) {
          this.switchAttrPop()
        } else {
          let checkedSpecs = this.getCheckedSpec()
          if (this.auditAllSpecsChecked(checkedSpecs)) {
            let productId = this.auditHasProductItem(checkedSpecs)
            if (productId) {
              $http(api.eshopCartAdd, {
                goodsId: this.goods.id,
                number: this.specAttr.number,
                productId: productId
              }, 'POST').then(res => {
                if (res.errno == 0) {
                  that.$toast(t('tips.addToCartSuccess'), "correct")
                  that.switchAttrPop()
                  that.$store.commit('goods/setCartGoodsCount', res.data)
                } else {
                  that.$toast(res.errmsg, "error")
                }
              });
            }
          }
        }
      },
      recevieCoupon(couponId){
        console.log(couponId)
        let id = parseInt(couponId)
        let coupon = this.coupons.find(coupon=>coupon.id==id)
        if(coupon.enabled==0){
          $http(api.eshopGetCoupon, {couponId: id}, 'POST').then(res=>{
            if(res.errno==0){
              coupon.enabled = 1;

              this.$store.commit("goods/setGoodsCoupons", this.coupons)
              this.$toast(t('tips.fetchSuccess'), 'correct')
            }else{
              this.$toast(res.errmsg, 'warn')
            }
          })
        }
      },
      customerContact() {
        order.callCustomerService(this)
      },
      scroll({y}){
        this.scrollY = -y
      }
    },
    created() {
      this.id = parseInt(this.$route.params.id);
      this.initGoodsInfo(this.id)
      this.getCartGoodsCount()
    }
  }
</script>

<style scoped>
  @import '../../assets/css/goods/goods.css';
  div >>> .cube-sticky-fixed {
    display: block!important;
  }
</style>
