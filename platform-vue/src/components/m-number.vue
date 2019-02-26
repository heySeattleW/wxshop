<template>
  <div class="number-container">
    <span class="cut"
          @click="cutNumber">-</span>
    <input :value="number"
           class="number"
           readonly
           type="text" />
    <span class="add"
          @click="addNumber">+</span>
  </div>
</template>

<script>
export default {
  name: "mNumber",
  props: ["value"],
  data() {
    return {
      number: this.value || 1
    };
  },
  methods: {
    cutNumber() {
      if (this.number > 1) {
        this.number--;
        this.$emit("change", this.number);
      }
    },
    addNumber() {
      this.number++;
      this.$emit("change", this.number);
    }
  },
  watch: {
    value(newValue, oldValue) {
      this.number = newValue || 1; 
    }
  }
};
</script>

<style lang="scss" scoped>
.number-container {
  display: inline-block;
  // width: 161px;
  // height: 35.5px;
  border: 1px solid #ccc;
  display: flex;
}
.number-container .cut {
  width: 30px;
  height: 100%;
  text-align: center;
  // line-height: 32.5px;
}

.number-container .number {
  flex: 1;
  height: 100%;
  text-align: center;
  // line-height: 34.375px;
  border-left: 1px solid #ccc;
  border-right: 1px solid #ccc;
  float: left;
  width: 40px;
  background: #fff;
  color: red;
}

.number-container .add {
  width: 30px;
  height: 100%;
  text-align: center;
  // line-height: 32.5px;
}
</style>
