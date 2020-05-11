import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLogin: false,
    board : [
      {
        boardnum : null,
        board_title : null,
        writer : null,
        hits : null,
        date : null
      }
    ]
  },
  mutations: {
    loginSuccess(state){
      state.isLogin = true;
    },
    set_board(state, board){
      console.log(state);
      console.log(board);
    }
  },
  actions: {
    save_board({commit}, board){
      console.log(board);
      axios.post('/user/save_board', board)
      .then(response => {
        console.log(response);
        commit('set_board', response);
        // this.$store.commit('loginSuccess');
        // this.$router.push({name:'Home'})
      })
      .catch(error =>{
        console.log(error);
      });
    }
  },
  modules: {

  },
  getters:{
    //Get All board 
    get_board(state){
      axios.post('/board/findAll')
      .then(response => {
        console.log(response);
        state.board = response.data;
        console.log(state.board);
      })
      .catch(error =>{
        console.log(error);
      });
    }
  }
});
