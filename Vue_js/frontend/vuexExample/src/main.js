import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

export const EventBus = new Vue()

new Vue({
  router,
  // vuex 파일 설정
  store,
  render: h => h(App)
}).$mount('#app')
