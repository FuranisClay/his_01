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
	  path:'/hisindex',
	  name:'hisindx',
	  component:()=> import('../views/HisIndex.vue')
  },
  {
	  //患者查看
  	  path:'/physician_patient',
  	  name:'physician_patient',
  	  component:()=> import('../views/Physician_patient.vue')
  },
  {
	  //医生诊疗
  	  path:'/doctor',
  	  name:'doctor',
  	  component:()=> import('../views/Doctor.vue')
  },
  {
	  //费用查询
  	  path:'/expense_query',
  	  name:'expense_query',
  	  component:()=> import('../views/Expense_query.vue')
  },
  
  
 {
 	  //医生诊疗.1.病历首页
 	  path:'/home_medical_record',
 	  name:'home_medical_record',
 	  component:()=> import('../views/Home_medical_record.vue')
 },
  {
  	  //医生诊疗.2.检查申请
  	  path:'/check_request',
  	  name:'check_request',
  	  component:()=> import('../views/Check_request.vue')
  },
  {
  	  //医生诊疗.3.检验申请
  	  path:'/inspection_request',
  	  name:'inspection_request',
  	  component:()=> import('../views/Inspection_request.vue')
  },
  {
  	  //医生诊疗.4.看诊记录
  	  path:'/physician-history',
  	  name:'physician-history',
  	  component:()=> import('../views/Physician-history.vue')
  },
  {
  	  //医生诊疗.5.检查结果查看
  	  path:'/check_results',
  	  name:'check_results',
  	  component:()=> import('../views/Check_results.vue')
  },
  {
  	  //医生诊疗.6.检验结果查看
  	  path:'/inspection_results',
  	  name:'inspection_results',
  	  component:()=> import('../views/Inspection_results.vue')
  },
  {
  	  //医生诊疗.7.门诊确诊
  	  path:'/outpatient_diagnosis',
  	  name:'outpatient_diagnosis',
  	  component:()=> import('../views/Outpatient_diagnosis.vue')
  },
  {
  	  //医生诊疗.8.开立处方
  	  path:'/write_prescription',
  	  name:'write_prescription',
  	  component:()=> import('../views/Write_prescription.vue')
  },
  {
  	  //医生诊疗.9.处置申请
  	  path:'/disposal_request',
  	  name:'disposal_request',
  	  component:()=> import('../views/Disposal_request.vue')
  },

  
]

const router = new VueRouter({
  routes
})

export default router
