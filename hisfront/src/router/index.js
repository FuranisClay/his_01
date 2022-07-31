import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
// import ReferVeiw from '../views/ReferView.vue'
// import RegistrationView from '../views/RegistrationView.vue'
// import BackId from '../views/BackId.vue'
// import GainId from '../views/GainId.vue'
// import App from '../App.vue'

Vue.use(VueRouter)

const routes = [{
		path: '/',
		name: 'home',
		component: HomeView
	},
	{
		path: '/registrationview',
		name: 'registrationview',
		component: () => import('../views/RegistrationView.vue'),
		children: [{
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
				// 收费
				path: '/registration/charge',
				name: 'charge',
				component: () => import('../components/registration/expense_charge.vue')
			},
			{
				// 退费
				path: '/registration/refund',
				name: 'refund',
				component: () => import('../components/registration/expense_refund.vue')
			},
			{
				// 费用记录查看
				path: '/registration/manage',
				name: 'manage',
				component: () => import('../components/registration/expense_manage.vue')
			}
		]
	}

]

const router = new VueRouter({
	routes
})

export default router
