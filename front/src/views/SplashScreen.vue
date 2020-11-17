<template>
  <v-container fluid class="fill-height">
    <v-row class="my-auto">
      <v-col cols="12">
        <v-img :src="require('@/assets/농부네텃밭.gif')" />
      </v-col>
    </v-row>
    <v-row class="mt-auto mb-4">
      <v-col cols="8" class="mx-auto pt-0">
        <v-img :src="require('@/assets/슬기로운.png')" contain />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  computed: {
    ...mapGetters(["isLoggedIn"]),
  },
  created() {
    if (this.isLoggedIn) {
      setTimeout(() => this.$router.push({ name: "PlantMain" }), 3000);
    } else {
      setTimeout(() => this.$router.push({ name: "Login" }), 3000);
    }
  },
};
</script>

<style>
</style>