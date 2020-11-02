<template>
  <v-app>
    <v-main width="100%">
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
// import CoreTopToolbar from "@/components/core/TopToolbar.vue";

export default {
  name: "App",
  components: {
    // CoreTopToolbar,
  },

  data() {
    return {};
  },
  beforeMount() {
    this.delay(100);
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

<style lang="scss">
@import url("https://fonts.googleapis.com/css2?family=Jua&display=swap");
</style>
