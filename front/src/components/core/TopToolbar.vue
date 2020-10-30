<template>
  <div>
    <v-app-bar app fixed dark color="primary">
      <v-spacer/>
      <v-toolbar-title><v-img :src="require('@/assets/nong-typo-logo.svg')" width="100px"/></v-toolbar-title>
      <v-spacer/>
    </v-app-bar>
  </div>
</template>

<script>
export default {
  data() {
    return {
      showMenu: false,
    };
  },
  methods: {
    toggleMenu() {
      this.showMenu = !this.showMenu;
    },
  },
};
</script>

<style>
</style>