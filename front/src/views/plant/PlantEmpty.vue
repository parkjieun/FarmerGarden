<template>
  <v-container
    fluid
    class="fill-height nbn--bgimage"
    style="
      background-image: url(https://i.pinimg.com/564x/77/7b/07/777b07a784b619eb9840734261133cbd.jpg);
    "
  >
    <v-row class="d-flex align-self-start">
      <v-col cols="12" class="py-0 px-3">
        <v-row
          no-gutters
          style="
            border-radius: 30px;
            background-color: rgba(255, 255, 255, 0.5);
          "
        >
          <v-col cols="2" class="d-flex align-center">
            <v-img src="@/assets/icon/sprout.svg" height="36px" contain />
          </v-col>
          <v-col cols="10">
            <div class="nbn--info">작물을 심어보세요 !</div>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <v-img
          style="position: relative; bottom: 5%"
          class="mx-auto"
          width="200px"
          :src="require('@/assets/plant/choice.png')"
          @click="dialog.seedList = !dialog.seedList"
        />

        <v-dialog
          v-model="dialog.seedList"
          scrollable
          fullscreen
          hide-overlay
          transition="dialog-bottom-transition"
        >
          <v-card class="rounded-0">
            <!-- dialog title start -->
            <v-toolbar flat dark dense color="primary">
              <v-btn icon @click="dialog.seedList = !dialog.seedList">
                <v-icon>mdi-chevron-left</v-icon>
              </v-btn>
              <v-toolbar-title class="text-body-1 nbn--list-font-bold">
                재배작물 심기
              </v-toolbar-title>
            </v-toolbar>
            <!-- dialog title end -->
            <v-card-text class="pa-0">
              <SeedList v-if="dialog.seedList" :choice="true" />
            </v-card-text>
          </v-card>
        </v-dialog>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters } from "vuex";

import SeedList from "@/views/seed/SeedList.vue";

export default {
  mounted() {
    if (this.plantCharInfo && this.plantCharInfo != "null") {
      console.log(this.plantCharInfo)
      this.$router.push({ name: "PlantMain" });
    }
  },
  components: {
    SeedList,
  },
  computed: {
    ...mapGetters(["plantCharInfo"]),
  },
  data() {
    return {
      dialog: {
        seedList: false,
      },
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
.nbn--info {
  color: #5b3016;
  font-size: 20px;
  font-family: "Jua", sans-serif;

  &-subtitle {
    font-size: 12px;
  }
}

.nbn--bgimage {
  background-position: center;
  background-attachment: fixed;
  background-repeat: no-repeat;
  background-size: 100% 100%;
}
</style>