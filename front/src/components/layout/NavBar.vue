<template>
    <v-app-bar 
      app
      color="white"
      height="100"
    >
      <v-avatar
        class="mr-3"
        color="grey lighten-5"
        size="70"
      >
        <v-img
          contain
          max-height="100%"
          src="@/assets/logo2.png" 
        ></v-img>
      </v-avatar>

      <v-toolbar-title class="font-weight-black headline">
        농부네 텃밭
      </v-toolbar-title>
    </v-app-bar>
</template>

<script>
export default {
  name: "NavBar",
}
</script>

<style scoped>

</style>