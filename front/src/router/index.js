import Vue from "vue";
import VueRouter from "vue-router";

import Test from "../views/Test.vue";

// user
import Login from "../views/user/Login.vue";
import Signup from "../views/user/Signup.vue";

// plant
import PlantChoice from "../views/plant/PlantChoice.vue";
import PlantMain from "../views/plant/PlantMain.vue";
import PlantCalendar from "../views/plant/PlantCalendar.vue";

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
  // user start
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
  },
  // user end

  // plant start
  {
    path: "/main",
    name: "PlantMain",
    component: PlantMain,
  },
  {
    path: "/choice",
    name: "PlantChoice",
    component: PlantChoice,
  },
  {
    path: "/calendar",
    name: "PlantCalendar",
    component: PlantCalendar,
  },
  // plant end
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
