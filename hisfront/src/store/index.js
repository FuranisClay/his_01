import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
	  num:1000,
	  //全局数据
	  user:{},
	  register:{}
  },
  getters: {
	  // 对num的数据进行封装
	  // 一般不用，一般重要数据不放在Vuex里
  },
  mutations: {
	  user(state,r){
		  state.user = r
	  },
	  register(state,r){
		  state.register = r
	  }
	  // // 同步修改数据
	  // num(state,r){
		 //  state.num = r//r代表新修改的值
	  // }
  },
  actions: {
	  // 代表异步修改
  },
  modules: {
  }
})
