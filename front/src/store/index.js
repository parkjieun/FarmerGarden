import Vue from "vue";
import Vuex from "vuex";
// import router from '../router';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: JSON.parse(sessionStorage.getItem("user")),
    authorization: sessionStorage.getItem("authorization"),
    plantCharInfo: JSON.parse(sessionStorage.getItem("plantCharInfo")),
  },
  getters: {
    config: (state) => ({ headers: { Authorization: state.authorization } }),
    plantCharInfo(state) {
      return state.plantCharInfo;
    },
    isLoggedIn(state) {
      return !!state.authorization;
    },
  },
  mutations: {
    SET_USER(state, value) {
      sessionStorage.setItem("user", JSON.stringify(value));
      state.user = value;
    },
    SET_AUTH(state, value) {
      sessionStorage.setItem("authorization", value);
      state.authorization = value;
    },
    SET_PLANTCHARINFO(state, value) {
      sessionStorage.setItem("plantCharInfo", JSON.stringify(value));
      state.plant = value;
    },
  },
  actions: {
    setUser({ commit }, value) {
      commit("SET_USER", value);
    },
    setAuth({ commit }, value) {
      commit("SET_AUTH", value);
    },
    async setPlantCharInfo({ commit }, value) {
      commit("SET_PLANTCHARINFO", value);
    },
  },
});
