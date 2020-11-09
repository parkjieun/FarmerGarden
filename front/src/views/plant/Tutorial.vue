<template>
  <v-container
    fluid
    class="fill-height"
    :style="{ backgroundColor: '#dddddd' }"
  >
    <v-row no-gutters>
      <v-col cols="4" class="mx-auto">
        <span class="text-h5 align-self-center pb-5">튜토리얼</span>
      </v-col>
    </v-row>
    <v-carousel
      :hide-delimiter-background="true"
      :show-arrows="false"
      :continuous="false"
      delimiter-icon="mdi-minus"
      light
    >
      <v-carousel-item>
        <TutorialCard :e1="1" />
      </v-carousel-item>
      <v-carousel-item>
        <TutorialCard :e1="2" />
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
      e1: 1,
    };
  },
};
</script>

<style lang="scss" scoped></style>
