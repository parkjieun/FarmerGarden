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
};
</script>
