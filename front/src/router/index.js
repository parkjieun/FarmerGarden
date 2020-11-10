import Vue from "vue";
import VueRouter from "vue-router";

import Layout from "../views/Layout.vue";

import Test from "../views/Test.vue";
import SplashScreen from "../views/SplashScreen.vue";

// user
import Login from "../views/user/Login.vue";
import Signup from "../views/user/Signup.vue";
import Register from "../views/user/Register.vue";
import Mypage from "../views/user/Mypage.vue";
import AddressForm from "../views/user/AddressForm.vue";

// plant
import PlantChoice from "../views/plant/PlantChoice.vue";
import PlantMain from "../views/plant/PlantMain.vue";
import PlantEmpty from "../views/plant/PlantEmpty.vue";
import Tutorial from "../views/plant/Tutorial.vue";
import PlantCalendar from "../views/plant/PlantCalendar.vue";
import PlantCalendar2 from "../views/plant/PlantCalendar2.vue";

// seed
import SeedList from "../views/seed/SeedList.vue";

// diary
import DiaryCreate from "../views/diary/DiaryCreate.vue";
import DiaryUpdate from "../views/diary/DiaryUpdate.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/bottom",
    name: "default",
    component: Layout,
    children: [
      {
        path: "/about",
        name: "About",
        component: () => import("../views/About.vue"),
      },
      {
        path: "/test",
        name: "Test",
        component: Test,
      },
      {
        path: "/mypage",
        name: "Mypage",
        component: Mypage,
      },
      {
        path: "/tutorial",
        name: "Tutorial",
        component: Tutorial,
      },
      // plant start
      {
        path: "/main",
        name: "PlantMain",
        component: PlantMain,
      },
      {
        path: "/empty",
        name: "PlantEmpty",
        component: PlantEmpty,
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
      {
        path: "/calendar2",
        name: "PlantCalendar2",
        component: PlantCalendar2,
      },
      // plant end
      // seed start
      {
        path: "/list",
        name: "SeedList",
        component: SeedList,
      },
      // seed end
      // diary start
      {
        path: "/diary/create",
        name: "DiaryCreate",
        component: DiaryCreate
      },
      {
        path: "/diary/update/:id",
        name: "DiaryUpdate",
        component: DiaryUpdate
      },
    ],
  },
  {
    path: "/",
    component: Layout,
    props: { bottomnav: false },
    children: [
      {
        path: "/",
        name: "SplashScreen",
        component: SplashScreen,
      },
      // user start
      {
        path: "/login",
        name: "Login",
        component: Login,
        props: { bottomnav: false },
      },
      {
        path: "/signup",
        name: "Signup",
        component: Signup,
      },
      {
        path: "/address",
        name: "AddressForm",
        component: AddressForm
      },
      {
        path: "/register",
        name: "Register",
        component: Register,
        props: { bottomnav: false },
      },
      // user end
    ],
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
