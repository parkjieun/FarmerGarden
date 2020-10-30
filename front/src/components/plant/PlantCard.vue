<template>
  <v-card color="#6CEB8F">
    <!-- <PlantCharacter /> -->
    <div class="d-flex flex-no-wrap justify-space-between my-2">
      <div>
        <v-card-title class="headline font-weight-black" v-text="plant.name" />
        <v-card-subtitle
          class="text-subtitle-2 font-weight-bold"
          v-text="plant.dday + ' 예정'"
        />
        <v-card-text class="headline" v-text="plant.percent + '%'" />
      </div>
    </div>
  </v-card>
</template>

<script>
// import PlantCharacter from "@/components/plant/PlantCharacter.vue";
export default {
  props: ["plant"],
  components: {
    // PlantCharacter,
  },
  data() {
    return {};
  },
};
</script>

<style>
</style>