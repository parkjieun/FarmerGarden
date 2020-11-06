<template>
  <div style="background-color: #efefef" class="pt-3">
    <v-card
      class="mb-3 rounded-0 elevation-0"
      width="100%"
      target="_blank"
      v-for="(recipe, index) in recipes"
      :key="index"
      :href="youtubeLink(recipe.url)"
    >
      <v-img :src="youtubeThumbnailLink(recipe.url)" height="200px"></v-img>

      <v-card-actions>
        <span class="nbn--font font-weight-bold text-truncate">{{
          recipe.title
        }}</span>
        <v-btn icon>
          <v-icon class="text-h4 grey--text">mdi-chevron-right</v-icon>
        </v-btn>
      </v-card-actions>
    </v-card>
  </div>
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