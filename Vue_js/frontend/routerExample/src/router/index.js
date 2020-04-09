import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const About = () => import(/* webpackChunkName: "about" */ '../views/About.vue')

const Users = () => import(/* webpackChunkName: "users" */ '../views/Users.vue')
const UsersDetail = () => import(/* webpackChunkName: "usersDetail" */ '../views/UsersDetail.vue')
const UserEdit = () => import(/* webpackChunkName: "userEdit" */ '../views/UserEdit.vue')

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    // 파라미터 속성을 적을수도 있다.
    // path: '/users/:id',
    path: '/users',
    name: 'Users',
    // 라우터가 불려지기 전에 먼저 실행되는 함수
    beforeEnter: (to, from, next) => {
      next()
    },
    component: Users,
    children : [
      {
      path: ':id',
      name: 'userDetail',
      component: UsersDetail
      },
      {
        path: ':id/edit',
        name: 'userEdit',
        component: UserEdit
      }
    ]
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: About
  },
  {
    // 이상한 경로로 접속시 홈으로 리다이렉트 시켜 버림
    path : '/*',
    redirect : '/'
  }
]

const router = new VueRouter({
  // 라우터의 기본 모드는 '해쉬모드'로써 해쉬태그 뒤의 주소를 인식하게 된다.
  // http://localhost:8080/#/주소
  // 히스토리 모드에서는 해쉬태그 생략하고 사용 가능
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
