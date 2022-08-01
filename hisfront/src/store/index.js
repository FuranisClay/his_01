import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        num: 1000,
        emp: {}
    },
    getters: {},
    mutations: {
        num(state, r) {
            state.num = r
        },
        emp(state, e) {
            state.emp = e
        }
    },
    actions: {},
    modules: {}
})
