import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
	  num:1000
  },
  getters: {
  },
  mutations: {
	  num(state,r){
		  state.num=r
	  }
  },
  actions: {
  },
  modules: {
  }
})
