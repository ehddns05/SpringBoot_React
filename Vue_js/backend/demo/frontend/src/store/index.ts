import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

const storage = window.sessionStorage;

export default new Vuex.Store({
  state: {
    authorization: false,
    isLogin: false,
    board: [
      {
        boardnum: null,
        board_title: null,
        writer: null,
        hits: null,
        date: null
      }
    ]
  },
  mutations: {
    loginSuccess(state) {
      state.authorization = true;
    },
    // set_board(state, board) {
    //   console.log(state);
    //   console.log(board);
    // },
    setHeader() {
      axios.defaults.headers.common["Authorization"] = storage.getItem(
        "authorization"
      );
    },
    logout() {
      storage.removeItem("authorization");
    }
  },
  actions: {
    //board enroll
    // save_board({ commit }, formData) {
    //   console.log(formData);

    // },
    login_Status({ commit }) {
      let token = storage.getItem("authorization");
      if (token != null) {
        commit("setHeader");
        this.state.authorization = true;
      }
    }
  },
  modules: {},
  getters: {
    //Get All board
    get_board(state) {
      axios
        .post("/board/findAll")
        .then(response => {
          console.log(response);
          state.board = response.data;
          console.log(state.board);
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
});
