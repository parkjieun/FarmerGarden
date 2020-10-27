import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import router from "./router";

Vue.config.productionTip = false;
window.Kakao.init(process.env.VUE_APP_KAKAO_APP_KEY);
new Vue({
  vuetify,
  router,
  render: (h) => h(App),
}).$mount("#app");
