<template>
  <v-card class="rounded-0" outlined>
    <v-list-item two-line>
      <v-list-item-content>
        <v-list-item-title class="nbn--list-font-bold mb-1" v-text="title" />
        <v-list-item-subtitle class="nbn--list-font" v-text="subtitle" />
      </v-list-item-content>

      <v-list-item-avatar tile size="80">
        <v-img :src="src" contain></v-img>
      </v-list-item-avatar>
    </v-list-item>

    <v-card-actions>
      <v-spacer></v-spacer>

      <v-btn icon @click="show = !show">
        <v-icon>{{ show ? "mdi-chevron-up" : "mdi-chevron-down" }}</v-icon>
      </v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>
          I'm a thing. But, like most politicians, he promised more than he
          could deliver. You won't have time for sleeping, soldier, not with all
          the bed making you'll be doing. Then we'll go with that data file!
          Hey, you add a one and two zeros to that or we walk! You're going to
          do his laundry? I've got to find a way to escape.
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>
</template>

<script>
export default {
  props: ["subtitle", "title", "btn", "src"],
  data() {
    return {
      show: false,
    };
  },
};
</script>

<style lang="scss" scoped>
.nbn--list-font {
  font-family: "Handon3gyeopsal300g";
  font-size: 15px;

  &-bold {
    font-family: "Handon3gyeopsal600g";
  }
}
</style>