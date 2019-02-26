const APPID = 'wx48b49a30f283989a'
const SCOPE= 'snsapi_userinfo'
const REDIRECT_URI = 'https://shop.bjdvtyun.com/login'

export default {
  getOauthCode () {
    window.location.href = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=' + APPID
      + '&redirect_uri=' + encodeURIComponent(REDIRECT_URI)
      + '&response_type=code&scope=' + SCOPE + '&state=STATE#wechat_redirect'
  }
}
