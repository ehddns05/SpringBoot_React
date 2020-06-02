import Vue from "vue";
import Vuex from "vuex";
import router from "../router/index";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    allUsers: [
      { id: "1", name: "test", email: "test@gmail.com", password: "123456" },
      { id: "2", name: "user", email: "user@gmail.com", password: "123456" }
    ],
    userInfo : null,
    isLogin: false,
    isError: false
  },
  mutations: {
    loginSuccess(state, payload) {
      state.isLogin = true;
      state.userInfo = payload
    }
  },
  actions: {
    login({ state, commit }, payload) {
      let exist = 0;
      state.allUsers.forEach(user => {
        if (
          user.email === payload.email &&
          user.password === payload.password
        ) {
          exist = 1;
          commit("loginSuccess", user);
          router.push({ name: "mypage" });
        }
      });
      if (exist === 0) {
        state.isError = true;
      }
    }
  },
  modules: {}
});
