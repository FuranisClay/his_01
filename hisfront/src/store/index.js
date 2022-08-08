import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        num: 1000,
        emp: {},
		user:{},
		register:{
			departments:'0',
			registlevel:'0',
			user:'0',
			settlecategory:'0',
			sex:'男'
		}
    },
    getters: {},
    mutations: {
        num(state, r) {
            state.num = r
        },
        emp(state, e) {
            state.emp = e
        },
		user(state,r){
			state.user = r
		},
		register(state,r){
			state.register = r
		}
		
    },
    actions: {},
    modules: {}
})
