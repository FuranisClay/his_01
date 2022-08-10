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
//  {
//    path: '/about',
//    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
//    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
//  },
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
	  
		{
		  //患者查看
		  path:'/doctor/physician_patient',
		  name:'physician_patient',
		  component:()=> import('../components/doctor/Physician_patient.vue')
	   },
	   // {
		 //  //医生诊疗
	   // 	  path:'/doctor',
	   // 	  name:'doctor',
	   // 	  component:()=> import('../views/Doctor.vue')
	   // },
	   {
		  //费用查询
		  path:'/doctor/expense_query',
		  name:'expense_query',
		  component:()=> import('../components/doctor/Expense_query.vue')
	   },
	   
	   
	  {
		  //医生诊疗.1.病历首页
		  path:'/doctor/home_medical_record',
		  name:'home_medical_record',
		  component:()=> import('../components/doctor/Home_medical_record.vue')
	  },
	   {
		  //医生诊疗.2.检查申请
		  path:'/doctor/check_request',
		  name:'check_request',
		  component:()=> import('../components/doctor/Check_request.vue')
	   },
	   {
		  //医生诊疗.3.检验申请
		  path:'/doctor/inspection_request',
		  name:'inspection_request',
		  component:()=> import('../components/doctor/Inspection_request.vue')
	   },
	   {
		  //医生诊疗.4.看诊记录
		  path:'/doctor/physician-history',
		  name:'physician-history',
		  component:()=> import('../components/doctor/Physician-history.vue')
	   },
	   {
		  //医生诊疗.5.检查结果查看
		  path:'/doctor/check_results',
		  name:'check_results',
		  component:()=> import('../components/doctor/Check_results.vue')
	   },
	   {
		  //医生诊疗.6.检验结果查看
		  path:'/doctor/inspection_results',
		  name:'inspection_results',
		  component:()=> import('../components/doctor/Inspection_results.vue')
	   },
	   {
		  //医生诊疗.7.门诊确诊
		  path:'/doctor/outpatient_diagnosis',
		  name:'outpatient_diagnosis',
		  component:()=> import('../components/doctor/Outpatient_diagnosis.vue')
	   },
	   {
		  //医生诊疗.8.开立处方
		  path:'/doctor/write_prescription',
		  name:'write_prescription',
		  component:()=> import('../components/doctor/Write_prescription.vue')
	   },
	   {
		  //医生诊疗.9.处置申请
		  path:'/doctor/disposal_request',
		  name:'disposal_request',
		  component:()=> import('../components/doctor/Disposal_request.vue')
	   },
	   
	   {
			// 窗口挂号
			path: '/registration/onsite',
			name: 'onsite',
			component: () => import('../components/registration/onsite_registratiion.vue')
		},
		{
			// 窗口退号
			path: '/registration/recored',
			name: 'record',
			component: () => import('../components/registration/registration_record.vue')
		},
		{
			// 费用记录查看
			path: '/registration/manage',
			name: 'manage',
			component: () => import('../components/registration/expense_manage.vue')
		},
			
		{
			// 收费
			path: '/finance/charge',
			name: 'charge',
			component: () => import('../components/finance/expense_charge.vue')
		},
		{
			// 退费
			path: '/finance/refund',
			name: 'refund',
			component: () => import('../components/finance/expense_refund.vue')
		},
		
		{
			path:'/setdrugs/setdrug',
			name:'setdrug',
			component:()=>import('../components/setdrugs/setdrug.vue')
		},
		{
			path:'/setdrugs/setsolve',
			name:'setsolve',
			component:()=>import('../components/setdrugs/setsolve.vue')
		}

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
