<template>
  <v-main>
    <router-view />
    <CoreBottomNav v-if="bottomnav" />
  </v-main>
</template>


<script>
import CoreBottomNav from "@/components/core/BottomNav.vue";

export default {
  name: "Layout",
  components: {
    CoreBottomNav,
  },
  props: {
    bottomnav: {
      type: Boolean,
      default: true,
    },
  },
};
</script>

<style lang="scss" scoped>
</style>