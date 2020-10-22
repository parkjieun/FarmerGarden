<template>
  <v-bottom-navigation app fixed grow v-model="activeItem" color="primary">
    <v-btn value="top">
      <span>Top Stories</span>
      <v-icon>mdi-thumb-up</v-icon>
    </v-btn>

    <v-btn value="code">
      <span>Code Examples</span>
      <v-icon>mdi-code</v-icon>
    </v-btn>

    <v-btn value="favorites">
      <span>Favorites</span>
      <v-icon>mdi-favorite</v-icon>
    </v-btn>
  </v-bottom-navigation>
</template>

<script>
export default {
  data() {
    return { activeItem: "top" };
  },
};
</script>

<style scoped>
</style>