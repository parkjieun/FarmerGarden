<template>
  <v-container fluid class="fill-height">
    <v-row class="my-auto">
      <v-col cols="10">
        <v-img :src="require('@/assets/농부네텃밭.png')" />
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
export default {
  created() {
    setTimeout(() => this.$router.push({ name: "Login" }), 5000);
  },
};
</script>

<style>
</style>