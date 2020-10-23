<template>
  <div style="background-color: #fff8f3">
    <v-container>
      <v-row dense>
        <v-col cols="12">
          <div class="pl-3 text-h6">내 작물</div>
        </v-col>

        <v-col cols="12">
          <PlantCard :plant="plant" />
        </v-col>
        <v-col cols="12">
          <div class="pl-3 text-h6">살펴보기</div>
        </v-col>

        <v-col v-for="(item, index) in items" :key="index" cols="12">
          <CoreInfoCard
            :subtitle="item.subtitle"
            :title="item.title"
            :btn="item.btn"
            :src="item.src"
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
import PlantCard from "@/components/plant/PlantCard.vue";

export default {
  name: "PlantMain",
  components: {
    CoreBottomNav,
    CoreInfoCard,
    PlantCard,
  },
  data() {
    return {
      plant: {
        name: "밀싹",
        sprout: "밀",
        dday: "11월 7일",
        percent: "36",
      },
      items: [
        {
          subtitle: "새싹 채소란?",
          title: "새싹 알아보기",
          btn: "더보기",
        },
        {
          subtitle: "어떻게 사용하나요?",
          title: "가이드",
          btn: "더보기",
        },
      ],
    };
  },
};
</script>

<style scoped>
</style>