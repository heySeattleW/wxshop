<template>
  <page :better-scroll="true" >
    <center-header></center-header>
    <center-list></center-list>
  </page>
</template>

<script type="text/ecmascript-6">
import page from '../../components/page'
import centerHeader from './center-header'
import centerList from "./center-list";
import { mapState, mapActions } from 'vuex'

export default {
  computed: {
    // ...mapState('user', ['isLogin', 'profile'])
  },
  methods:{
    ...mapActions('center', ['getAdderssPicker']),
  },
  created() {
    this.getAdderssPicker();
  },
  components: {
    page,
    centerHeader,
    centerList,
  }
}
</script>

<style lang="scss" scoped>
  @import '~static/scss/mixin';
  h3 {
    height: pxTorem(40px);
    display: inline-block;
    @include remCalc(width,80px);
    @include remCalc(margin,20px, 20px, 20px, 20px);
  }
</style>

