import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import router from "./router";
import Vuex from "vuex";
import store from "./store";
import VCalendar from "v-calendar";
import VueApexCharts from 'vue-apexcharts'

Vue.use(Vuex);
Vue.use(VCalendar, { componentPrefix: "vc", masks: { title: "YYYY MMMM" } });
Vue.use(VueApexCharts)

Vue.component('apexchart', VueApexCharts)

Vue.config.productionTip = false;
window.Kakao.init("ccef2764def2c00faa00ebd5e4583007");
new Vue({
  vuetify,
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
