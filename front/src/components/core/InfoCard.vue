<template>
  <v-card>
    <div class="d-flex flex-no-wrap justify-space-between my-2">
      <div>
        <v-card-subtitle
          class="pb-0 teal--text font-weight-bold"
          v-text="subtitle"
        />
        <v-card-title class="pt-0 headline font-weight-black" v-text="title" />

        <v-card-actions>
          <slot name="btn">
            <v-btn
              dark
              class="px-5 ml-2 font-weight-black"
              color="#00B17B"
              v-if="btn"
              v-text="btn"
            />
          </slot>
        </v-card-actions>
      </div>

      <v-avatar class="ma-3" size="125" tile>
        <v-img :src="'@/assets/logo.png'"></v-img>
      </v-avatar>
    </div>
  </v-card>
</template>

<script>
export default {
  props: ["subtitle", "title", "btn", "src"],
};
</script>

<style>
</style>