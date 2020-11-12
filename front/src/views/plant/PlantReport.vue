<template>
  <v-container fluid class="fill-height pt-0" style="background: #2bc77e13">
    <div class="nbn--report-header"></div>
    <v-row class="d-flex align-self-start w-100">
      <div class="nbn--wave-wrapper-border">
        <div class="nbn--wave-wrapper">
          <div class="nbn--wave">
            <div
              class="nbn--wave-before"
              :style="{ top: 14 - plantInfo.percent / 4 + 'px' }"
            ></div>
            <div
              class="nbn--wave-after"
              :style="{ top: 14 - plantInfo.percent / 4 + 'px' }"
            ></div>
          </div>
        </div>
        <div style="position: absolute; top: 160px; right: 20px">
          <span class="nbn--percent nbn--percent-black">
            {{ plantInfo.percent }}
          </span>
          <span class="nbn--percent">%</span>
          <div class="nbn--percent nbn--percent-sm">
            {{ plantInfo.dday }} 예정
          </div>
        </div>
      </div>
    </v-row>
    <v-row class="px-4">
      <v-card class="mt-4" width="100%" height="160px">
        <v-row no-gutters>
          <v-col cols="4">
            <PlantCharacter width="100px" v-bind="plantCharInfo" />
          </v-col>
          <v-col cols="8">
            <v-list-item>
              <v-list-item-content class="pb-0">
                <v-list-item-subtitle class="text-caption text--secondary">
                  선택작물
                </v-list-item-subtitle>
                <v-list-item-title class="nbn--list-font font-weight-bold">
                  {{ sproutCodeTable[plantCharInfo.sprout] }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>
            <v-list-item>
              <v-list-item-content class="pb-0">
                <v-list-item-subtitle class="text-caption text--secondary">
                  재배 시작일
                </v-list-item-subtitle>
                <v-list-item-title class="nbn--list-font font-weight-bold">
                  2020년 11월 12일
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>
            <v-list-item>
              <v-list-item-content class="pb-0">
                <v-list-item-subtitle class="text-caption text--secondary">
                  수확 예정일
                </v-list-item-subtitle>
                <v-list-item-title class="nbn--list-font font-weight-bold">
                  2020년 11월 12일
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-col>
        </v-row>
      </v-card>
      <v-card class="mt-4" width="100%" height="160px"> test </v-card>
      <v-card class="mt-4" width="100%" height="160px"> test </v-card>
    </v-row>
  </v-container>
</template>

<script>
import http from "@/utils/http-common";

import { mapGetters } from "vuex";

import PlantCharacter from "@/components/plant/PlantCharacter.vue";

export default {
  data() {
    return {
      plantInfo: {
        name: "밀싹",
        sprout: "밀",
        dday: "11월 7일",
        percent: "50",
      },
      sproutCodeTable: {
        1000: "밀싹",
        1001: "메밀싹",
        1002: "루꼴라",
        1003: "옥수수싹",
        1004: "무순",
        1005: "적무순",
      },
    };
  },
  created() {
    http
      // .get("iot/temp-and-hum?choice_id=" + this.user.choice_id)
      .get("iot/temp-and-hum?choice_id=1000")
      .then((res) => {
        console.log(res.data);
        this.iotData = res.data;
      });
  },
  components: {
    PlantCharacter,
  },
  computed: {
    ...mapGetters(["plantCharInfo"]),
  },
};
</script>

<style lang="scss" scoped>
.nbn--report-header {
  position: absolute;
  width: 100%;
  height: 300px;
  top: 0;
  left: 0;
  background: #2bc77e98;
  background-image: linear-gradient(
      rgba(44, 200, 200, 0.6),
      rgba(44, 200, 200, 0.6)
    ),
    url("~@/assets/report-header.gif");
  background-repeat: no-repeat;
  background-size: cover;
}

.nbn--list-font {
  font-family: "Handon3gyeopsal300g";
  font-size: 15px;

  &-bold {
    font-family: "Handon3gyeopsal600g";
  }
}

.nbn--percent {
  color: #fff;
  font-family: "Jua", sans-serif;
  font-size: 20px;

  &-black {
    font-size: 40px;
    font-weight: 900;
  }

  &-sm {
    font-size: 16px;
  }
}

.nbn--wave {
  position: relative;
  width: 100%;
  height: 100%;
  background: var(--primary-color);
  box-shadow: inset 0 0 16px rgba(0, 0, 0, 0.3);

  &-wrapper {
    position: relative;
    width: 160px;
    height: 160px;
    top: 50px;
    left: -40px;
    right: 0;
    margin-left: auto;
    margin-right: auto;
    background: #ccc;
    mask-image: url("~@/assets/leaf.svg");
  }
  &-wrapper-border {
    position: relative;
    left: 0;
    right: 0;
    margin-left: auto;
    margin-right: auto;

    width: 320px;
    height: 240px;
  }

  &-before,
  &-after {
    content: "";
    position: absolute;
    width: 200%;
    height: 200%;
    left: 50%;
    transform: translate(-50%, -75%);
    background: #000;
  }

  &-before {
    border-radius: 45%;
    background: rgba(255, 255, 255, 1);
    animation: animate 10s linear infinite;
  }

  &-after {
    border-radius: 40%;
    background: rgba(255, 255, 255, 0.5);
    animation: animate 20s linear infinite;
  }
}

@keyframes animate {
  0% {
    transform: translate(-50%, -75%) rotate(0deg);
  }
  100% {
    transform: translate(-50%, -75%) rotate(360deg);
  }
}
</style>
