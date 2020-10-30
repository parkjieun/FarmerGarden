<template>
  <v-card class="elevation-0">
    <v-card-text
      class="pa-0 rounded-0"
      style="overflow: auto"
      :style="'height: ' + ($vuetify.breakpoint.height - 196) + 'px'"
    >
      <v-card
        class="mt-3 rounded-0"
        style="border-top: 1px solid #666666; border-bottom: 1px solid #666666"
        width="100%"
        target="_blank"
        v-for="(recipe, index) in recipes"
        :key="index"
        :href="youtubeLink(recipe.url)"
      >
        <v-img :src="youtubeThumbnailLink(recipe.url)" height="200px"></v-img>

        <v-card-title class="pa-0">
          <v-col cols="10" class="text-truncate">{{ recipe.title }}</v-col>
          <v-col cols="2">
            <v-icon class="text-h4 grey--text">mdi-chevron-right</v-icon>
          </v-col>
        </v-card-title>
      </v-card>
    </v-card-text>
  </v-card>
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

<style>
</style>