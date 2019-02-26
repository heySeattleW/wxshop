import Vue from 'vue'
import VueI18n from 'vue-i18n'
import CubeUI from 'cube-ui'
import enUSMessages from 'cube-ui/src/locale/lang/en-US'

Vue.use(VueI18n)

const locale = 'en'

import zh from './lang/zh'
import en from './lang/en'

const messages = {
  zh,
  en
}

if(locale==='en'){
  const Locale = CubeUI.Locale
  Locale.use('en-US', enUSMessages)
}

export default new VueI18n({
  locale: locale, // 语言标识
  messages
})

