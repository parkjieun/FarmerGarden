<template>
  <v-container
    fluid
    class="fill-height"
    :style="{ backgroundColor: '#2bc77e13' }"
  >
    <v-row no-gutters>
      <v-col cols="4"></v-col>
      <v-col cols="4" class="mx-auto d-flex justify-center">
        <span class="nbn--font align-self-center">튜토리얼</span>
      </v-col>
      <v-spacer></v-spacer>
      <v-col cols="2">
        <v-btn
          text
          v-text="el == 2 ? '완료' : 'skip'"
          :to="{ name: 'PlantEmpty' }"
        ></v-btn>
      </v-col>
    </v-row>
    <v-carousel
      v-model="el"
      :hide-delimiter-background="true"
      :show-arrows="false"
      :continuous="false"
      delimiter-icon="mdi-minus"
      light
    >
      <v-carousel-item>
        <TutorialCard :el="0" />
      </v-carousel-item>
      <v-carousel-item>
        <TutorialCard :el="1" />
      </v-carousel-item>
      <v-carousel-item>
        <TutorialCard :el="2" />
      </v-carousel-item>
    </v-carousel>
  </v-container>
</template>

<script>
import TutorialCard from "@/components/plant/TutorialCard.vue";
export default {
  components: {
    TutorialCard,
  },
  data() {
    return {
      el: 0,
    };
  },
};
</script>

<style lang="scss" scoped>
.nbn--font {
  font-size: 28px;
  font-family: "Jua", sans-serif;

  &-bold {
    font-weight: 900;
  }
}
</style>
