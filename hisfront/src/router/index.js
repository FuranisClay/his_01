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
    path: '/his',
    name: 'his',
    component: () => import('../views/HisIndex.vue'),
    children: [
      {
        path: '/root/user',
        name: 'user',
        component:()=>import('../components/root/User.vue')
      },
      {
        path: '/root/department',
        name: 'department',
        component:()=>import('../components/root/Department.vue')
      },
      {
        path: '/root/register',
        name: 'register',
        component:()=>import('../components/root/Register.vue')
      },
      {
        path: '/root/contents',
        name: 'contents',
        component:()=>import('../components/root/Contents.vue')
      },
      {
        path: '/root/drugpay',
        name: 'drugpay',
        component:()=>import('../components/root/Drugpay.vue')
      },
      {
        path: '/root/schedule',
        name: 'schedule',
        component:()=>import('../components/root/Schedule.vue')
      },
	  
	  //药房路由
	  {
	  	  path:'/drugstore/give',
	  	  name:'give',
	  	  component:()=>import('../components/drugstore/Give.vue')
	  },
	  {
	  	  path:'/drugstore/out',
	  	  name:'out',
	  	  component:()=>import('../components/drugstore/Out.vue')
	  },
	  {
	  	  path:'/drugstore/drugs',
	  	  name:'drugs',
	  	  component:()=>import('../components/drugstore/Drugs.vue')
	  },
	  {
	  	  path:'/drugstore/history',
	  	  name:'history',
	  	  component:()=>import('../components/drugstore/History.vue')
	  },
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/Login.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
