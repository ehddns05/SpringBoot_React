// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Navi from './components/Navi'
// import store from '../veux'

// 전역 컴포넌트
Vue.component('Navi', Navi)

Vue.config.productionTip = false

// eventBus는 새로운 Vue를 선언 해주는 것
// 형제 컴포넌트를 이어주는 가상의 컴포넌트 ( 부모 자식 관계 아님 X)
export const eventBus = new Vue({
  methods: {
  // 공통으로 사용되는 메서드를 미리 제작 해놓을 수 있음
    whatTimeIsIt (date) {
      eventBus.$emit('nowTime', date)
    }
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  // store,
  components: { App },
  template: '<App/>'
})
