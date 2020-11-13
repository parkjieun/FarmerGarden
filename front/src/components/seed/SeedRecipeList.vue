<template>
  <v-slide-group style="width: 100vw;">
    <v-slide-item v-for="(recipe, index) in recipes" :key="index">
      <v-card
        class="rounded-lg ma-2"
        height="160"
        width="200"
        target="_blank"
        :href="youtubeLink(recipe.url)"
      >
        <v-img
          height="110"
          width="200"
          :src="youtubeThumbnailLink(recipe.url)"
        ></v-img>

        <v-card-actions>
          <span class="nbn--font font-weight-bold text-truncate">
            {{ recipe.title }}
          </span>
        </v-card-actions>
      </v-card>
    </v-slide-item>
  </v-slide-group>
</template>

<script>
export default {
  props: ["recipes"],
  methods: {
    youtubeLink(video) {
      return "https://www.youtube.com/watch?v=" + video;
    },
    youtubeThumbnailLink(video) {
      return "https://img.youtube.com/vi/" + video + "/sddefault.jpg";
    },
  },
};
</script>

<style lang="scss" scoped>
.nbn--font {
  font-family: "Handon3gyeopsal300g";
  font-size: 15px;

  &-bold {
    font-family: "Handon3gyeopsal600g";
  }
}
</style>
