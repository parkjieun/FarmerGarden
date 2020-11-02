<template>
  <v-container
    fluid
    class="fill-height nbn--bgimage"
    :style="{
      backgroundImage:
        'url(' +
        require('@/assets/plant/bgimage/' + itemBGImage[bgimage]) +
        ')',
    }"
  >
    <v-row class="d-flex align-self-start">
      <v-col cols="12" class="pb-0">
        <v-img src="@/assets/icon/info.svg" contain>
          <v-row>
            <v-col cols="2" />
            <v-col cols="2" class="text-right">
              <div class="nbn--info nbn--info-subtitle text-left">온도</div>
              <div class="nbn--info">100˚C</div>
            </v-col>
            <v-col cols="2" />
            <v-col cols="2" class="pl-0">
              <div class="nbn--info nbn--info-subtitle text-left">습도</div>
              <div class="nbn--info">100%</div>
            </v-col>
            <v-col cols="1"> </v-col>
            <v-col cols="3" class="text-left">
              <div class="nbn--info nbn--info-subtitle text-left">자동급수</div>
              <div class="nbn--info">13:06</div>
            </v-col>
          </v-row>
        </v-img>
      </v-col>
    </v-row>
    <v-row class="d-flex align-self-start justify-end">
      <v-col cols="2" class="py-0">
        <v-img src="@/assets/icon/paper.svg" class="mb-2" contain />
        <router-link :to="{ name: 'PlantChoice' }">
          <v-img src="@/assets/icon/change.svg" class="mb-2" contain />
        </router-link>
      </v-col>
    </v-row>
    <v-row class="d-flex align-self-stretch">
      <v-col cols="2"></v-col>
      <v-col>
        <PlantCharacter v-if="plantCharInfo" v-bind="plantCharInfo" />
      </v-col>
      <v-col cols="2"></v-col>
    </v-row>
    <v-row>
      <v-col cols="1"></v-col>
      <v-col cols="9">
        <v-progress-linear
          value="60"
          height="25"
          :color="itemProgressColor[potColor]"
        ></v-progress-linear>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters } from "vuex";

import { mixinPlantCharInfo } from "@/mixins/mixinPlantCharInfo";

// import CoreInfoCard from "@/components/core/InfoCard.vue";
import PlantCharacter from "@/components/plant/PlantCharacter.vue";

export default {
  name: "PlantMain",
  mixins: [mixinPlantCharInfo],
  components: {
    // CoreInfoCard,
    PlantCharacter,
  },
  created() {
    // if (!this.isLoggedIn) {
    //   this.$router.push({ name: "Login" });
    // }
    if (!this.plantCharInfo) {
      this.$router.push({ name: "PlantEmpty" });
    }
  },
  mounted() {
    this.bgimage = this.plantCharInfo.bgimage;
    this.potColor = this.plantCharInfo.potColor;
  },
  data() {
    return {
      plantInfo: {
        name: "밀싹",
        sprout: "밀",
        dday: "11월 7일",
        percent: "36",
      },
      bgimage: "배경1.jpg",
      potColor: "orange",
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
      charInfo: {
        character: "기본",
        pot: "기본",
        potColor: "orange",
        sprout: "싹",
        sproutType: "1",
        bgimage: "1",
      },
    };
  },
  computed: {
    ...mapGetters(["plantCharInfo", "isLoggedIn"]),
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