<template>
  <v-container
    fluid
    class="fill-height"
    style="
      background-image: url(https://i.pinimg.com/564x/77/7b/07/777b07a784b619eb9840734261133cbd.jpg);
      background-position: center;
      background-attachment: fixed;
      background-repeat: no-repeat;
      background-size: 100% 90%;
    "
  >
    <v-row style="border: 1px solid #ff0000">
      <v-col cols="3" style="border: 1px solid #ff0000">온도</v-col>
      <v-col cols="3" style="border: 1px solid #ff0000">습도</v-col>
      <v-spacer> </v-spacer>
      <v-col cols="3" style="border: 1px solid #ff0000">다음물줄시간</v-col>
    </v-row>
    <v-row style="border: 1px solid #ff0000">
      <v-col style="border: 1px solid #ff0000">여백</v-col>
    </v-row>
    <v-row style="border: 1px solid #ff0000">
      <v-col cols="2" style="border: 1px solid #ff0000">사이드여백</v-col>
      <v-col style="border: 1px solid #ff0000"
        ><PlantCharacter :hidden="true" />
      </v-col>
      <v-col cols="2" style="border: 1px solid #ff0000">사이드여백</v-col>
    </v-row>
    <v-row style="border: 1px solid #ff0000">
      <v-col cols="9" style="border: 1px solid #ff0000">재배 예정일</v-col>

      <v-col cols="3" style="border: 1px solid #ff0000">화분꾸미기</v-col>
    </v-row>
    <!-- <v-row dense>

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
    </v-row> -->
    <CoreBottomNav />
  </v-container>
</template>

<script>
import CoreBottomNav from "@/components/core/BottomNav.vue";
// import CoreInfoCard from "@/components/core/InfoCard.vue";
import PlantCharacter from "@/components/plant/PlantCharacter.vue";

export default {
  name: "PlantMain",
  components: {
    CoreBottomNav,
    // CoreInfoCard,
    PlantCharacter,
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