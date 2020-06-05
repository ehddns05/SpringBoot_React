import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/signUp",
    name: "SignUp",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/SignUp.vue")
  },
  {
    path: "/login",
    name: "login",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/SignIn.vue")
  },
  {
    path: "/main",
    name: "main",
    component: () => import(/* webpackChunkName: "about" */ "../views/Main.vue")
  },
  {
    path: "/board",
    name: "Board",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/board/Board.vue")
    // children:[
    //   {
    //     path: '/BoardDetail',
    //     name: 'BoardDetail',
    //     component: () =>
    //       import(/* webpackChunkName: "about" */ "../views/board/BoardDetail.vue")
    //     }
    // ]
  },
  {
    path: "/user/board/writing_Page",
    name: "Board_writing_Page",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/board/Writing.vue")
  },
  {
    path: "/BoardDetail:boardnum",
    name: "BoardDetail",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/board/BoardDetail.vue")
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
