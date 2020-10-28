import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import router from "./router";
import Vuex from 'vuex';
import store from "./store";

Vue.use(Vuex)

Vue.config.productionTip = false;
window.Kakao.init(process.env.VUE_APP_KAKAO_APP_KEY);
new Vue({
  vuetify,
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
