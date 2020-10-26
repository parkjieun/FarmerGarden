<template>
  <v-app>
    <CoreTopToolbar />
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import CoreTopToolbar from "@/components/core/TopToolbar.vue";

export default {
  name: "App",
  components: {
    CoreTopToolbar,
  },

  data() {
    return {};
  },
  beforeMount() {
    this.delay(2000);
  },
  methods: {
    delay(ms) {
      const startPoint = new Date().getTime();
      console.log("test");
      while (new Date().getTime() - startPoint <= ms) {
        /* wait */
      }
    },
  },
};
</script>
