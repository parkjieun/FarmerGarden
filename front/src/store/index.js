import Vue from 'vue'
import Vuex from 'vuex'
// import router from '../router';

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: JSON.parse(sessionStorage.getItem('user')),
    authorization: sessionStorage.getItem("authorization"),
    
  },
  getters: {
    config: (state) => ({headers: {Authorization: state.authorization}}),
  },
  mutations: {
    SET_USER(state, value) {
      sessionStorage.setItem("user", JSON.stringify(value))
      state.user = value
    },
    SET_AUTH(state, value) {
      sessionStorage.setItem("authorization", value)
      state.authorization = value
    },
  
  },
  actions: {
    setUser({ commit }, value) {
      commit('SET_USER', value)
    },
    setAuth({commit}, value) {
      commit('SET_AUTH', value)
    },
  }

})
