import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLogin: false
  },
  mutations: {
    loginSuccess(state){
      state.isLogin = true;
    }
  },
  actions: {
    
  },
  modules: {}
});
