import Vue from "vue";
import Vuex from "vuex";

import cookies from "vue-cookies";
import router from "@/router";
import http from "@/utils/http-common";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: cookies.get("user"),
    socialData: JSON.parse(sessionStorage.getItem("socialData")),
    authorization: cookies.get("authorization"),
    plantCharInfo: cookies.get("plantCharInfo"),
    posts: JSON.parse(cookies.get("posts")),
  },
  getters: {
    config: (state) => ({ headers: { Authorization: state.authorization } }),
    user(state) {
      return state.user;
    },
    plantCharInfo(state) {
      return state.plantCharInfo;
    },
    isLoggedIn(state) {
      return !!state.authorization;
    },
  },
  mutations: {
    SET_USER(state, value) {
      cookies.set("user", value, 60 * 60 * 60);
      state.user = value;
    },
    SET_AUTH(state, value) {
      cookies.set("authorization", value, 60 * 60 * 60);
      state.authorization = value;
    },
    SET_SOCIAL(state, value) {
      sessionStorage.setItem("socialData", value);
      state.socialData = value;
    },
    SET_PLANTCHARINFO(state, value) {
      cookies.set("plantCharInfo", value, 60 * 60 * 60);
      state.plant = value;
    },
    SET_POSTS(state, value) {
      cookies.set("posts", JSON.stringify(value), 60 * 60 * 60);
      state.posts = value;
    },
  },
  actions: {
    setUser({ commit }, value) {
      commit("SET_USER", value);
    },
    setAuth({ commit }, value) {
      commit("SET_AUTH", value);
    },
    setSocial({ commit }, value) {
      commit("SET_SOCIAL", value);
    },
    setPlantCharInfo({ commit, getters }, value) {
      console.log(getters.config);
      http
        .post("/api/choice?plant_id=" + value.sprout, getters.config)
        .then((res) => {
          console.log(res);
          http
            .put(
              "/api/user/pot",
              { user_pot: JSON.stringify(value) },
              getters.config
            )
            .then(() => {
              commit("SET_PLANTCHARINFO", value);
              router.push({ name: "PlantMain" });
              location.reload();
            });
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setPosts( { commit, getters }) {
      http.get("/api/post", getters.config)
      .then((res) => {
        commit("SET_POSTS", res.data.reverse())
      })
      .catch(err => console.log(err))
    },

  },
});
