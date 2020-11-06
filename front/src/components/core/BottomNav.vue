<template>
  <v-bottom-navigation app fixed grow v-model="activeItem" color="primary">
    <v-btn value="home" :to="{ name: 'PlantMain' }">
      <v-icon>mdi-home</v-icon>
    </v-btn>

    <v-btn value="diary" :to="{ name: 'PlantCalendar2' }">
      <v-icon>mdi-newspaper</v-icon>
    </v-btn>

    <v-btn
      value="faq"
      href="https://frogue.danbee.ai/?chatbot_id=8ac8ca73-ec86-4dd1-ba66-388919215cf5"
    >
      <v-icon>mdi-message-processing</v-icon>
    </v-btn>

    <v-btn value="account" :to="{ name: 'Mypage' }">
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

<style scoped>
</style>