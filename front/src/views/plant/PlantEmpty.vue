<template>
  <v-container
    fluid
    class="fill-height"
    style="
      background-image: url(https://i.pinimg.com/564x/77/7b/07/777b07a784b619eb9840734261133cbd.jpg);
      background-position: center;
      background-attachment: fixed;
      background-repeat: no-repeat;
      background-size: 100% 100%;
    "
  >
    <v-row>
      <v-col cols="12">
        <v-img src="@/assets/icon/infoempty.svg" contain>
          <v-row>
            <v-col cols="2" />
            <v-col cols="10">
              <div class="nbn--info">작물을 심어보세요 !</div>
            </v-col>
          </v-row>
        </v-img>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="2"></v-col>
      <v-col cols="8">
        <router-link :to="{ name: 'SeedList' }">
          <v-img
            style="
              position: relative;
              z-index: 3;
              left: 0;
              right: 0;
              margin-left: auto;
              margin-right: auto;
            "
            width="200px"
            :src="require('@/assets/plant/choice.png')"
          />
        </router-link>
      </v-col>
      <v-col cols="2" class="py-0"> </v-col>
    </v-row>
    <v-row> </v-row>
    <CoreBottomNav />
  </v-container>
</template>

<script>
import CoreBottomNav from "@/components/core/BottomNav.vue";

export default {
  name: "PlantMain",
  components: {
    CoreBottomNav,
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

<style lang="scss" scoped>
@import url("https://fonts.googleapis.com/css2?family=Jua&display=swap");

.nbn--info {
  color: #5b3016;
  font-size: 20px;
  font-family: "Jua", sans-serif;

  &-subtitle {
    font-size: 12px;
  }
}
</style>