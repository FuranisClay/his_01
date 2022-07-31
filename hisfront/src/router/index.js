import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
	path:'/drugstore',
	name:'drugstore',
	component:()=>import('../views/Drugstore.vue')
  },
  {
	path:'/drugstore/drugs',
	name:'drugs',
	component:()=>import('../views/Drugs.vue')
  },
  {
	path:'/drugstore/give',
	name:'give',
	component:()=>import('../views/Give.vue')
  },
  {
  	path:'/drugstore/out',
  	name:'out',
  	component:()=>import('../views/Out.vue')
  },
  {
  	path:'/drugstore/history',
  	name:'history',
  	component:()=>import('../views/History.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
