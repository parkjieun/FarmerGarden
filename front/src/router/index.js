import Vue from "vue";
import VueRouter from "vue-router";

import Test from "../views/Test.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "About",
    component: () => import("../views/About.vue"),
  },
  {
    path: "/test",
    name: "Test",
    component: Test,
  },
];

const router = new VueRouter({
  scrollBehavior() {
    return { x: 0, y: 0 };
  },
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
