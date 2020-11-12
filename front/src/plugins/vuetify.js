import Vue from "vue";
import Vuetify from "vuetify/lib";
import { preset } from "vue-cli-plugin-vuetify-preset-crane/preset";

import Book from "@/assets/icon/custom/Book.vue";
import Calendar from "@/assets/icon/custom/Calendar.vue";
import Camera from "@/assets/icon/custom/Camera.vue";
import Faq from "@/assets/icon/custom/Faq.vue";
import Fork from "@/assets/icon/custom/Fork.vue";
import Home from "@/assets/icon/custom/Home.vue";
import Magnifier from "@/assets/icon/custom/Magnifier.vue";

Vue.use(Vuetify);

export default new Vuetify({
  preset,
  icons: {
    values: {
      book: {
        component: Book,
      },
      calendar: {
        component: Calendar,
      },
      camera: {
        component: Camera,
      },
      faq: {
        component: Faq,
      },
      fork: {
        component: Fork,
      },
      home: {
        component: Home,
      },
      magnifier: {
        component: Magnifier,
      },
    },
  },
});
