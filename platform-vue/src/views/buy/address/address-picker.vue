<template>
  <div>
    <div class="addAddress"
         @click="choseAdd()">
      <input type="text"
             placeholder="所在地区"
             class="txtmangth"
             disabled="disabled"
             v-model="userAddress">
    </div>
    <!-- 收货地址三级联动选项 start-->
    <section class="address"
             :class="{toggHeight:istoggHeight}">
      <section class="title">
        <div class="area"
             @click="provinceSelected()"
             :class="[oneac ? 'accolor' : '']">{{Province?Province:'请选择'}}</div>
        <div class="area"
             @click="citySelected()"
             :class="[twoac ? 'accolor':'']"
             v-show="twoshow">{{City?City:'请选择'}}</div>
        <div class="area"
             @click="districtSelected()"
             :class="threeac ? 'accolor':''"
             v-show="threeshow">{{District?District:'请选择'}}</div>
        <div class="area"
             @click="treeSelected()"
             :class="[fourac ? 'accolor':'']"
             v-show="fourshow">{{Tree?Tree:'请选择'}}</div>
        <div class="closeBtn"
             @click="closeBtn()"><i class="cubeic-close"></i></div>
      </section>
      <ul v-show="showProvince"
          class="proJuli">
        <li class="addList"
            v-for="(v,k) in info"
            @click="getProvinceId(v.id, v.name, k)"
            :key="v.id"
            :class="{active : v.selected}"><span>{{v.name}}</span></li>
      </ul>
      <ul v-show="showCity"
          class="citJuli">
        <li class="addList"
            v-for="(v,k) in showCityList"
            @click="getCityId(v.id, v.name, k)"
            :key="v.id"
            :class="{active : v.selected}"><span>{{v.name}}</span></li>
      </ul>
      <ul v-show="showDistrict"
          class="disJuli">
        <li class="addList"
            v-for="(v,k) in showDistrictList"
            @click="getDistrictId(v.id, v.name, k)"
            :key="v.id"
            :class="{active : v.selected}"><span>{{v.name}}</span></li>
      </ul>
      <ul v-show="showTree"
          class="treeJuli">
        <li class="addList"
            v-for="(v,k) in showTreeList"
            @click="getTreeId(v.id, v.name, k)"
            :key="v.id"
            :class="{active : v.selected}"><span>{{v.name}}</span></li>
      </ul>
    </section>
    <!-- 收货地址三级联动选项 end-->
    <div class="layout"
         :class="{layoutBg:islayout}"
         @click="closeAdd()"></div>
  </div>
</template>
<script>
import api from "@/config/api";
import { $http } from "@/extends/http";
import { mapState, mapActions } from 'vuex'
// TODO:JS 当地址选择很长时 close图标会错位 待优化
export default {
  name:'addressPicker',
  data() {
    return {
      islayout: false,
      istoggHeight: false,
      isBc: false, // 用于控制保存按钮高亮
      toggle: false, // 用于切换默认地址
      oneac: true,
      twoac: false,
      threeac: false,
      fourac:false,
      twoshow: false,
      threeshow: false,
      fourshow: false,
      userAddress: "",
      oneliIndex: "", // 用于高亮子菜单
      twoliIndex: "",
      threeliIndex: "",
      titleIndex: Number,
      showProvince: true, // 第一个li默认显示
      showCity: false, // 第二个li默认隐藏
      showDistrict: false, // 第三个li默认隐藏
      showTree: false,
      showCityList: [],
      showDistrictList: [],
      showTreeList: [],
      province: "",
      city: "",
      district: "",
      tree: "",
      GetProvinceId: 2,
      District: "",
      Province: "",
      City: "",
      Tree: "",
      // v-for循环判断是否为当前
      selected: true,
      info: this.addressPicker // 三级联动城市列表
    };
  },
  async mounted() {

    // 先显示部分数据 因为不依赖网络数据
    if (this.editAddress != undefined) {
      let editDate = JSON.parse(JSON.stringify(this.editAddress));
      this.province = editDate.provinceId;
      this.city = editDate.cityId;
      this.district = editDate.countyId;
      this.tree = editDate.townId;
      this.Province = editDate.provinceName;
      this.City = editDate.cityName;
      this.District = editDate.countyName;
      this.Tree = editDate.townName;
      this.userAddress = [this.Province, this.City, this.District, this.Tree].join(" ");
    }

    if (this.addressPicker.length) {
      this.info = this.addressPicker;
    } else {
      let res = await $http(api.eshopAllRegionTree);
      this.saveAddressPicker(res.data);
      this.info = res.data;
    }

    if (this.editAddress != undefined) { // 数据存在
      // 获取picker列表数据
      this.showCityList = this._filter( this.info, "childList", this.province);
      this.showDistrictList = this._filter(this.showCityList, "childList", this.city );
      this.showTreeList = this._filter( this.showDistrictList, "childList", this.district );

      // 高亮后台返回选中的地址，需要对应id
      this.twoshow = true; // 控制第二个nav显示
      this.threeshow = true; // 给第三个nav显示
      this.fourshow = true;
      this.oneac = false;
      this.twoac = false;
      this.threeac = false;
      this.fourac = true;
      this.showProvince = false;
      this.showCity = false;
      this.showDistrict = false;
      this.showTree = true;
      this._newArr(this.info, this.province);
      this._newArr(this.showCityList, this.city);
      this._newArr(this.showDistrictList, this.district);
      this._newArr(this.showTreeList, this.tree);
    }
    
  },
  computed: {
      ...mapState('center', ['editAddress','addressPicker'])
    },
  methods: {
    ...mapActions('center', ['saveAddressPicker']),
    choseAdd: function() {
      // 选择地址弹层，打开弹层
      this.islayout = true;
      this.istoggHeight = true;
      if (this.editAddress !== undefined) {
        // this._gotoTop(".treeJuli", 1);
      }
    },
    closeAdd: function() {
      // 关闭弹层
      this.istoggHeight = false;
      this.islayout = false;
    },
    closeBtn() {
      this.closeAdd();
    },
    doneAdd() {
      this.userAddress = [this.Province, this.City, this.District, this.Tree].join(" ");
      this.closeBtn(); 
      let result = {
        provinceId: this.province,
        provinceName: this.Province,
        cityId: this.city,
        cityName: this.City,
        countyId: this.district,
        countyName: this.District,
        townId: this.tree,
        townName: this.Tree
      }
      this.$emit('done',result);
    },
    _newArr(arr, selectid) {
      for (var i = 0; i < arr.length; i++) {
        if (arr[i].id === selectid) {
          this.$set(arr[i], "selected", true);
        } else if (selectid === -1) {
          this.$set(arr[i], "selected", false);
        }
      }
      return arr;
    },
    _filter(add, name, code) {
      // 数组，对应数组内容，对应数组id
      let result = [];
      for (let i = 0; i < add.length; i++) {
        if (code === add[i].id) {
          result = add[i][name];
        }
      }
      return result;
    },
    _gotoTop(info, index) {
      // 滚动距离 --> 对应class,第几个index
      let proJuliBox = document.querySelector(info);
      let activeBox = document.getElementsByClassName("active")[index];
      let t = activeBox.offsetTop - 67 + 20; // 后面的数据，根据页面情况自己调整
      proJuliBox.scrollTo(0, t);
    },
    getProvinceId: function(code, input, index) {
      // 点击第一个li
      // console.log('code', code, input, index)
      this.titleIndex = Number;
      this.province = code;
      this.Province = input; // 获取选中的省份
      this.showProvince = false;
      this.showCity = true;
      this.showDistrict = false;
      this.showTree = false;
      this.showCityList = this._filter(this.info, "childList", this.province);
      // 点击选择当前
      this.info.map(a => {
        a.selected = false;
      });
      this.info[index].selected = true;
      // console.log(this.info[index].name) // 点击的省份的名字

      this.oneac = false; // 给第一个nav去掉高亮
      this.twoac = true; // 给第二个nav添加高亮
      this.threeac = false; // 去除第三个li的高亮
      this.fourac = false; // 去除第四个li的高亮
      this.twoshow = true; // 控制第二个nav显示
      this.City = ""; // 第二nav置空
      this.threeshow = false; // 第三nav隐藏
      this.fourshow = false; // 第四nav隐藏
      this.oneliIndex = index;
      this._newArr(this.showCityList, -1); // 清除市级高亮
    },
    provinceSelected: function() {
      this.showProvince = true;
      this.showCity = false;
      this.showDistrict = false;
      this.showTree = false;

      this.oneac = true; // 给第一个nav添加高亮
      this.twoac = false; // 给第二个nav去除高亮
      this.threeac = false; // 给第三个nav去掉高亮
      this.fourac = false; // 给第四个nav去掉高亮
    },
    getCityId: function(code, input, index) {
      // 点击第二个li

      this.titleIndex = Number;
      this.city = code;
      this.City = input;
      this.showProvince = false;
      this.showCity = false;
      this.showDistrict = true;
      this.showTree = false;
      this.showDistrictList = this._filter(
        this.showCityList,
        "childList",
        this.city
      );
      // 选择当前添加active
      this.showCityList.map(a => {
        a.selected = false;
      });
      this.showCityList[index].selected = true;
      this.twoliIndex = index;

      this.twoac = false; // 给第二个nav去除高亮
      this.threeac = true; // 给第三个nav添加高亮
      this.threeshow = true; // 给第三个nav显示
      this.fourshow = false; // 给第四个nav隐藏
      this.District = ""; // 第三nav置空
      this._newArr(this.showDistrictList, -1); // 清除区级高亮
    },
    citySelected: function() {
      this.titleIndex = 2;
      this.showProvince = false;
      this.showCity = true;
      this.showDistrict = false;
      this.showTree = false;

      this.oneac = false; // 给第一个nav去掉高亮
      this.twoac = true; // 给第二个nav添加高亮
      this.threeac = false; // 给第三个nav去掉高亮
      this.fourac = false; // 给第四个nav去掉高亮
      if (this.editAddress !== undefined) {
        this.$nextTick(() => {
          // 让li标签回到顶部
          this._gotoTop(".citJuli", 1);
        });
      }
    },
    getDistrictId: function(code, input, index) {

      this.titleIndex = Number;
      this.district = code;
      this.District = input;
      // 选择当前添加active
      this.showDistrictList.map(a => {
        a.selected = false;
      });
      this.showDistrictList[index].selected = true;
      this.threeliIndex = index;
      this.showDistrict = false;

      this.showTreeList = this._filter(
        this.showDistrictList,
        "childList",
        this.district
      );
      this.showTree = true;
      this.fourshow = true;
      this.fourac = true;

      this.threeac = false; // 给第一个nav去掉高亮

      this.Tree = ""; // 第四nav置空
      this._newArr(this.showTreeList, -1); // 清除区级高亮
    },
    districtSelected: function() {
      
      // 第三个选择
      this.titleIndex = 3;
      this.showCity = false;
      this.showDistrict = true;
      this.showTree = false;

      this.twoac = false; // 给第一个nav去掉高亮
      this.threeac = true; // 给第二个nav添加高亮
      this.fourac = false; // 给第三个nav去掉高亮
      if (this.editAddress !== undefined) {
        this.$nextTick(() => {
          // 让li标签回到顶部
          this._gotoTop(".citJuli", 1);
        });
      }
    },
    treeSelected() {

      this.showProvince = false;
      this.showCity = false;
      this.showDistrict = false;
      this.showTree = true;

      this.oneac = false; // 给第一个nav去掉高亮
      this.twoac = false; // 给第二个nav去掉高亮
      this.threeac = false; // 给第三个nav添加高亮
      this.fourac = true;
      if (this.editAddress !== undefined) {
        this.$nextTick(() => {
          // 让li标签回到顶部
          this._gotoTop(".disJuli", 2);
        });
      }
    },
    getTreeId(code,input,index) {
      this.titleIndex = Number
      this.tree = code
      this.Tree = input

      // 选择当前添加active
      this.showTreeList.map(a => { a.selected = false })
      this.showTreeList[index].selected = true;

      this.doneAdd();
    }
  },
  watch:{
    data(newName, oldName) {
      console.log(newName,oldName);
    }
  },
  beforeDestroy() {
    document.querySelector("body").style.backgroundColor = "#fff";
  }
};
</script>
<style>
* {
  margin: 0;
  padding: 0;
}
.ysc-header {
  /* font-size: 0.7rem; */
  text-align: center;
}
.addAddress input {
  /*height: 2rem;*/
  height: 50px;
  /*width: 83%;*/
  width: 100%;
  background: #fff;
  color: #262e31;
  font-size: 0.7rem;
  border: none;
  /*margin: 0 0.75rem;*/
  padding: 0 15.625px;
}
/* 地址选择弹层 */
.ac {
  color: #000 !important;
  border-bottom: 0.125rem solid #fff !important;
}
.myAddress {
  width: 100%;
  background-color: white;
  border-top: 4px solid rgba(245, 245, 245, 1);
  color: #333;
}
.myAddress .cont {
  border-bottom: 1px solid rgba(245, 245, 245, 0.8);
}
.myAddress .cont span {
  display: inline-block;
  /* font-size: 0.7rem; */
  color: #333;
  line-height: 2.2rem;
  margin-left: 0.8rem;
}
.myAddress .cont section {
  float: left;
}
.myAddress .cont p {
  display: inline-block;
  /* font-size: 0.7rem; */
  color: #333333;
  line-height: 2.2rem;
  margin-left: 2.5rem;
}
.myAddress .cont .pic2 {
  float: right;
  width: 0.35rem;
  height: 0.6rem;
  margin: 0.8rem 0.8rem 0.8rem 0;
}
.myAddress .cont p.text {
  margin-left: 1.8rem;
}
.address {
  position: absolute;
  bottom: 0;
  left: 0;
  z-index: 121;
  background: #fff;
  width: 100%;
  height: 0;
  overflow: hidden;
  transition: height 0.5s;
}
.toggHeight {
  height: 19.25rem;
}
.layout {
  width: 100%;
  height: 100%;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 120;
  opacity: 0;
  transition: all 0.5s;
  background: rgb(53, 58, 60);
  visibility: hidden;
}
.layoutBg {
  opacity: 0.7;
  visibility: visible;
}
.area {
  float: left;
  display: inline-block;
  /* font-size: 0.6rem; */
  height: 1.2rem;
  line-height: 1.2rem;
  margin-left: 1.05rem;
  color: #262e31;
  margin-top: 0.75rem;
  max-width: calc(100% - 80%);
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.addList {
  margin-left: 1rem;
  /* font-size: 1.875rem; */
  line-height: 1.675rem;
  color: #262e31;
}
/* 修改的格式 */
.address ul {
  height: calc(100% - 2.05rem);
  overflow: auto;
}
.address ul li {
  list-style: none;
}
.address .title .accolor {
  color: #d2a24e;
  border-bottom: 0.1rem solid #d2a24e;
}
.address ul .active {
  color: #d2a24e;
}
.address ul .active span::after {
  content: "";
  /* background-image: url(../assets/images/gou_img.png); */
  width: 1rem;
  height: 0.5rem;
  background-repeat: no-repeat;
  background-size: 0.5rem 0.325rem;
  background-position: left 0.4rem center;
  display: inline-block;
}
.title {
  height: 2.05rem;
  border-bottom: 0.025rem solid #8a96a3;
}
.closeBtn {
  display: inline-block;
  width: 1.875rem;
  text-align: center;
  float: right;
  height: 2.05rem;
  line-height: 2.05rem;
  margin-right: 0.75rem;
  color: #d2a24e;
  /* font-size: 0.7rem; */
}
</style>
