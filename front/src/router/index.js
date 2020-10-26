import Vue from "vue";
import VueRouter from "vue-router";

import Test from "../views/Test.vue";

// user
import Login from "../views/user/Login.vue";
import Signup from "../views/user/Signup.vue";
import Register from "../views/user/Register.vue";

// plant
import PlantChoice from "../views/plant/PlantChoice.vue";
import PlantMain from "../views/plant/PlantMain.vue";

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
  {
    path: "/register",
    name: "Register",
    component: Register,
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
