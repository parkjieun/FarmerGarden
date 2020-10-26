<template>
  <div style="background-color: #fff8f3">
    <v-container>
      <v-row dense>
        <v-col cols="12">
          <div class="pl-3 text-h6">새싹 목록</div>
        </v-col>

        <v-col v-for="(item, index) in items" :key="index" cols="12">
          <CoreInfoCard
            :subtitle="item.subtitle"
            :title="item.title"
            :btn="item.btn"
            :src="item.src"
            @click.native="$set(sheet, index - 1, true)"
          />
        </v-col>
      </v-row>
    </v-container>

    <CoreBottomNav />
  </div>
</template>

<script>
import CoreBottomNav from "@/components/core/BottomNav.vue";
import CoreInfoCard from "@/components/core/InfoCard.vue";

export default {
  name: "SeedList",
  components: {
    CoreBottomNav,
    CoreInfoCard,
  },
  data() {},
};
</script>

<style scoped>
</style>