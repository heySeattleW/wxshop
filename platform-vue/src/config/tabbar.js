export default {
  tabs: [
    {
      icon: 'cubeic-home',
      label: 'tabbar.home',
      path: '/home'
    },
    {
      icon: 'cubeic-setting',
      label: 'tabbar.catalog',
      path: '/catalog'
    },
    {
      icon: 'cubeic-mobile-phone',
      label: 'tabbar.testphone',
      path: '/testphone'
    },
    {
      icon: 'cubeic-mall',
      label: 'tabbar.cart',
      path: '/shopping'
    },
    {
      icon: 'cubeic-person',
      label: 'tabbar.center',
      path: '/center'
    }
  ],
  computed: {
    selectedLabel(){
      let routePath = this.$route.name && this.$route.name.startsWith("/") ? this.$route.name : ("/" + this.$route.name)
      let currentTab = this.tabs.find(tab=> tab.path==routePath)
      return this.$t(currentTab.label)
    },
    tabbarVisible() {
      const routes = this.tabs.map(value => {
        return value.path
      })
      let routePath = this.$route.name && this.$route.name.startsWith("/") ? this.$route.name : ("/" + this.$route.name)
      return routes.includes(routePath)
    }
  }
}
