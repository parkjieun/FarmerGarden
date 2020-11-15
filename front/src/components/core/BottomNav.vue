<template>
  <v-bottom-navigation
    app
    fixed
    grow
    v-model="activeItem"
    color="primary"
    active-class="nbn--nav-active"
  >
    <v-btn value="home" :to="{ name: 'PlantMain' }" style="height: 100%;">
      <v-icon>$vuetify.icons.home</v-icon>
    </v-btn>

    <v-btn value="diary" :to="{ name: 'PlantCalendar2' }" style="height: 100%;">
      <v-icon>$vuetify.icons.calendar</v-icon>
    </v-btn>

    <v-btn
      value="faq"
      href="https://frogue.danbee.ai/?chatbot_id=8ac8ca73-ec86-4dd1-ba66-388919215cf5"
      style="height: 100%;"
    >
      <v-icon>$vuetify.icons.faq</v-icon>
    </v-btn>

    <v-btn value="account" :to="{ name: 'Mypage' }" style="height: 100%;">
      <v-icon>mdi-dots-horizontal</v-icon>
    </v-btn>
  </v-bottom-navigation>
</template>

<script>
export default {
  data() {
    return { activeItem: "home" };
  },
};
</script>

<style lang="scss" scoped>
.nbn--nav-active {
  fill: var(--primary-color);
}
</style>