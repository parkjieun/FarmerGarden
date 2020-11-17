<template>
  <v-container fluid class="fill-height pt-0" style="background: #2bc77e13">
    <v-btn
      fab
      small
      text
      color="white"
      style="position: absolute; top: 20px; left: 16px; z-index: 3"
      :to="{ name: 'PlantMain' }"
    >
      <v-icon v-text="'mdi-chevron-left'"></v-icon>
    </v-btn>
    <div class="nbn--report-header"></div>
    <v-row class="d-flex align-self-start w-100">
      <div class="nbn--wave-wrapper-border">
        <div class="nbn--wave-wrapper">
          <div class="nbn--wave">
            <div
              class="nbn--wave-before"
              :style="{ top: 80 - 1.4 * plantInfo.percent + 'px' }"
            ></div>
            <div
              class="nbn--wave-after"
              :style="{ top: 80 - 1.4 * plantInfo.percent + 'px' }"
            ></div>
          </div>
        </div>
        <div style="position: absolute; top: 160px; right: 20px">
          <span class="nbn--percent nbn--percent-black">
            {{ plantInfo.percent }}
          </span>
          <span class="nbn--percent">%</span>
          <div
            class="nbn--percent nbn--percent-sm"
            v-if="plantInfo.percent < 100"
          >
            {{ getFormatMonthDay(plantInfo.calendar_eat_day) }} 예정
          </div>
          <div class="nbn--percent" v-else>수확하세요!</div>
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
                  {{ sproutCodeTable[plantInfo.sprout] }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>
            <v-list-item>
              <v-list-item-content class="pb-0">
                <v-list-item-subtitle class="text-caption text--secondary">
                  재배 시작일
                </v-list-item-subtitle>
                <v-list-item-title class="nbn--list-font font-weight-bold">
                  {{ plantInfo.calendar_start_day }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>
            <v-list-item>
              <v-list-item-content class="pb-0">
                <v-list-item-subtitle class="text-caption text--secondary">
                  수확 예정일
                </v-list-item-subtitle>
                <v-list-item-title class="nbn--list-font font-weight-bold">
                  {{ plantInfo.calendar_eat_day }}
                </v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-col>
        </v-row>
      </v-card>
      <v-card class="mt-4" width="100%" height="160px">
        <v-row no-gutters>
          <v-col
            cols="2"
            class="pl-4 nbn--list-font-sm font-weight-bold d-flex align-content-space-between flex-wrap"
            style="color: #d17451"
          >
            <v-card-title
              class="nbn--list-font font-weight-bold pa-0 pt-1 mx-2"
            >
              온도
            </v-card-title>
            <div class="mx-2">50</div>
            <div class="mx-3">-</div>
            <div class="mx-3">-</div>
            <div class="mx-3">-</div>
            <div class="mx-3">0</div>
            <div class="mx-3">˚C</div>
          </v-col>
          <v-col cols="10" class="pr-4">
            <v-card-title class="nbn--list-font-sm pa-0 pt-1 text--secondary">
              <span class="mx-auto">{{ dateTerm() }}</span>
            </v-card-title>
            <v-slide-group v-model="temp" style="width: 90vw">
              <v-slide-item
                v-for="(data, index) in iotData"
                :key="index"
                :value="index"
              >
                <div
                  class="text-center nbn--list-font font-weight-bold"
                  @click="focusTempSlider(index)"
                >
                  <v-card
                    class="mx-3 my-1 rounded-md"
                    height="80"
                    width="16"
                    color="#F19471"
                    elevation="0"
                  >
                    <v-img
                      class="rounded-0"
                      :height="80 - 1.6 * data.rb_temperature"
                      src="@/assets/mask.svg"
                    />
                  </v-card>
                  <span style="color: #e2623b">{{ data.rb_temperature }}</span>
                </div>
              </v-slide-item>
            </v-slide-group>
          </v-col>
        </v-row>
      </v-card>
      <v-card class="mt-4" width="100%" height="160px">
        <v-row no-gutters>
          <v-col
            cols="2"
            class="pl-4 nbn--list-font-sm font-weight-bold d-flex align-content-space-between flex-wrap"
            style="color: #0ba75e"
          >
            <v-card-title
              class="nbn--list-font font-weight-bold pa-0 pt-1 mx-2"
            >
              습도
            </v-card-title>
            <div class="mx-2">100</div>
            <div class="mx-3">-</div>
            <div class="mx-3">-</div>
            <div class="mx-3">-</div>
            <div class="mx-3">0</div>
            <div class="mx-3">%</div>
          </v-col>
          <v-col cols="10" class="pr-4">
            <v-card-title class="nbn--list-font-sm pa-0 pt-1 text--secondary">
              <span class="mx-auto">{{ dateTerm() }}</span>
            </v-card-title>
            <v-slide-group v-model="hum" mandatory style="width: 90vw">
              <v-slide-item
                v-for="(data, index) in iotData"
                :key="index"
                :value="index"
              >
                <div
                  class="text-center nbn--list-font font-weight-bold"
                  @click="focusHumSlider(index)"
                >
                  <v-card
                    class="mx-3 my-1 rounded-md"
                    height="80"
                    width="16"
                    color="#2bc77eaa"
                    elevation="0"
                  >
                    <v-img
                      class="rounded-0"
                      :height="80 - 0.8 * data.rb_humidity"
                      src="@/assets/mask.svg"
                    />
                  </v-card>
                  <span style="color: #2bc77e">{{ data.rb_humidity }}</span>
                </div>
              </v-slide-item>
            </v-slide-group>
          </v-col>
        </v-row>
      </v-card>
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
      iotData: [{ rb_create: null, rb_temperature: null, rb_humidity: null }],
      temp: null,
      hum: null,
      plantInfo: {
        sprout: "",
        calendar_start_day: "",
        calendar_eat_day: "",
        percent: 0,
      },
      sproutCodeTable: {
        1000: "밀싹",
        1001: "메밀싹",
        1002: "루꼴라",
        1003: "옥수수싹",
        1004: "무순",
        1005: "적무순",
      },
      weekName: ["일", "월", "화", "수", "목", "금", "토"],
    };
  },
  created() {
    http
      .get("iot/temp-and-hum?choice_id=" + this.user.choice_id)
      // .get("iot/temp-and-hum?choice_id=1000")
      .then((res) => {
        this.iotData = res.data;
        this.temp = res.data.length;
        this.hum = res.data.length;
      });

    http
      .get("api/calendar/" + this.user.choice_id, this.config)
      // .get("api/calendar/1000", this.config)
      .then((res) => {
        this.plantInfo.sprout = res.data.plant_id;
        this.plantInfo.calendar_start_day = res.data.calendar_start_day;
        this.plantInfo.calendar_eat_day = res.data.calendar_eat_day;
        var today = new Date();
        var start = new Date(this.plantInfo.calendar_start_day);
        var end = new Date(this.plantInfo.calendar_eat_day);
        this.plantInfo.percent = Math.floor(
          (100 * (today - start)) / (end - start)
        );
      });
  },
  components: {
    PlantCharacter,
  },
  computed: {
    ...mapGetters(["plantCharInfo", "user", "config"]),
  },
  methods: {
    focusTempSlider(key) {
      this.temp = key;
    },
    focusHumSlider(key) {
      this.hum = key;
    },
    dateTerm() {
      var dateF = new Date(this.iotData[0].rb_create);
      var yearF = dateF.getFullYear();
      var monthF = dateF.getMonth() + 1;
      var dayF = dateF.getDate();
      var hourF = dateF.getHours();
      var minF = dateF.getMinutes();
      if (minF < 10) {
        minF = "0" + minF;
      }

      var dateE = new Date(this.iotData[this.iotData.length - 1].rb_create);
      var yearE = dateE.getFullYear();
      var monthE = dateE.getMonth() + 1;
      var dayE = dateE.getDate();
      var hourE = dateE.getHours();
      var minE = dateE.getMinutes();
      if (minE < 10) {
        minE = "0" + minE;
      }

      var result = `${yearF}-${monthF}-${dayF} ${hourF}:${minF}`;
      var result2;

      if (yearF != yearE) {
        result2 = ` ~ ${yearE}-${monthE}-${dayE} ${hourE}:${minE}`;
      } else if (monthF != monthE) {
        result2 = ` ~ ${monthE}-${dayE} ${hourE}:${minE}`;
      } else if (dayF != dayE) {
        result2 = ` ~ ${dayE} ${hourE}:${minE}`;
      } else if (hourF != hourE || minF != minE) {
        result2 = ` ~ ${hourE}:${minE}`;
      } else {
        result2 = "";
      }

      return result + result2;
    },

    getFormatMonthDay(dateString) {
      var date = new Date(dateString);
      var month = 1 + date.getMonth();
      var day = date.getDate();

      return month + "월 " + day + "일";
    },
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

  &-sm {
    font-family: "Handon3gyeopsal300g";
    font-size: 12px;
  }

  &-xs {
    font-family: "Handon3gyeopsal300g";
    font-size: 10px;
  }

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
