import Vue from 'vue'
import {
  /* eslint-disable no-unused-vars */
  Style,
  Button,
  Scroll,
  Input,
  Toast,
  ActionSheet,
  Slide,
  Dialog,
  Rate,
} from 'cube-ui'

Vue.use(Button)
Vue.use(Scroll)
Vue.use(Input)
Vue.use(Toast)
Vue.use(ActionSheet)
Vue.use(Slide)
Vue.use(Dialog)
Vue.use(Rate)

export const toast = (text, type) => {
  Toast.$create({
    $props: {
      time: 1000,
      txt: text,
      type: type || 'correct'
    }
  }).show()
}

export const sheet = (title, data, fn) => {
  ActionSheet.$create({
    $props: {
      maskClosable1: false,
      title: title,
      data: data,
    },
    onSelect: (item, index) => {
      fn(item, index)
    }
  }).show()
}

export const confirm = (title="提示",content="") => {
  return new Promise( resolve => {
    Dialog.$create({
      type: 'confirm',
      title,
      content,
      confirmBtn: {
        text: '确定',
        active: true,
        disabled: false,
        href: 'javascript:;'
      },
      cancelBtn: {
        text: '取消',
        active: false,
        disabled: false,
        href: 'javascript:;'
      },
      onConfirm: () => {
        resolve(true);
      },
      onCancel: () => {
        resolve(false);
      }
    }).show()
  });
}

export const alert = (title="提示",content="", confirmTxt="我知道了") => new Promise( resolve => {
  Dialog.$create({
    type: 'alert',
    title: title,
    content: content,
    icon: 'cubeic-alert',
    confirmBtn: {
      text: confirmTxt,
      active: true
    },
    onConfirm: () => {
      console.log(1111)
      resolve(true);
    },
  }).show()
})

Vue.prototype.$toast = toast
Vue.prototype.$sheet = sheet
Vue.prototype.$confirm = confirm
Vue.prototype.$alert = alert
