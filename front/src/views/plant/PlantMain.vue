<template>
  <v-container
    fluid
    class="fill-height nbn--bgimage"
    :style="{
      backgroundImage: itemBGImage[bgimage]
        ? 'url(' +
          require('@/assets/plant/bgimage/' + itemBGImage[bgimage]) +
          ')'
        : '',
    }"
  >
    <v-btn
      fab
      small
      :text="isHidden"
      style="position: absolute; right: 16px; border-radius: 50%; z-index: 3"
      :style="{ top: isHidden ? '20px' : '80px' }"
      @click="isHidden = !isHidden"
    >
      <v-icon
        v-text="isHidden ? 'mdi-close' : '$vuetify.icons.camera'"
      ></v-icon>
    </v-btn>
    <v-btn
      fab
      small
      :disabled="isHidden"
      :to="{ name: 'PlantChoice' }"
      style="position: absolute; right: 16px; top: 140px; border-radius: 50%"
      :style="{ opacity: isHidden ? 0 : 1 }"
    >
      <v-img
        src="@/assets/icon/change.svg"
        width="42px"
        height="42px"
        contain
      />
    </v-btn>

    <v-row
      class="d-flex align-self-start"
      :style="{ opacity: isHidden ? 0 : 1 }"
    >
      <v-col cols="12" class="py-0 px-3">
        <v-row
          no-gutters
          style="
            border-radius: 30px;
            background-color: rgba(255, 255, 255, 0.5);
          "
        >
          <v-col cols="1" class="d-flex align-center ml-auto">
            <v-img src="@/assets/icon/thermometer.svg" height="36px" contain />
          </v-col>
          <v-col cols="2" class="pl-2">
            <div class="nbn--info nbn--info-subtitle text-left">온도</div>
            <div class="nbn--info">{{ headerInfo.temp }}˚C</div>
          </v-col>
          <v-col cols="1" class="d-flex align-center">
            <v-img src="@/assets/icon/hygrometer.svg" height="36px" contain />
          </v-col>
          <v-col cols="2" class="pl-2">
            <div class="nbn--info nbn--info-subtitle text-left">습도</div>
            <div class="nbn--info">{{ headerInfo.hum }}%</div>
          </v-col>
          <v-col cols="1" class="d-flex align-center">
            <v-img src="@/assets/icon/watering.svg" height="36px" contain />
          </v-col>
          <v-col cols="4" class="mr-auto pl-2">
            <div class="nbn--info nbn--info-subtitle text-left">
              다음 자동급수
            </div>
            <div
              class="nbn--info"
              style="
                word-break: nowrap;
                display: inline-block;
                text-overflow: clip;
                overflow: hidden;
                white-space: nowrap;
              "
            >
              {{ headerInfo.waterTime }}
            </div>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <PlantCharacter v-if="plantCharInfo" v-bind="plantCharInfo" />
      </v-col>
    </v-row>
    <div
      @click="
        plantInfo.percent < 100 ? $router.push({ name: 'PlantReport' }) : null
      "
      class="nbn--progress py-2 pl-2"
      :style="{ opacity: isHidden ? 0 : 1 }"
    >
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
      </div>

      <span v-if="plantInfo.percent < 100" class="ml-1">
        <div class="nbn--info-subtitle nbn--info-bold">
          {{ getFormatMonthDay(plantInfo.calendar_eat_day) }}
        </div>
        <div class="nbn--info-subtitle nbn--info-bold">예정</div>
      </span>
      <span v-else class="ml-1 mr-2">
        <div class="nbn--info-lg nbn--info-bold">수확</div>
      </span>
      <v-icon>mdi-chevron-right</v-icon>
    </div>
  </v-container>
</template>

<script>
import http from "@/utils/http-common";

import { mapGetters, mapMutations } from "vuex";

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
    if (!this.isLoggedIn) {
      this.$router.push({ name: "Login" });
    }
    if (!this.plantCharInfo || this.plantCharInfo == "null") {
      console.log("여기왔냐");
      this.$router.push({ name: "PlantEmpty" });
    }
    http
      .get("iot/supply-water-logs?choice_id=" + this.user.choice_id)
      // .get("iot/supply-water-logs?choice_id=1000")
      .then((res) => {
        var dt = new Date(res.data.watering_time);
        dt.setHours(dt.getHours() + 6);
        this.headerInfo.waterTime = this.getFormatDate(dt);
      });
    http
      .get("iot/recent-temp?choice_id=" + this.user.choice_id)
      // .get("iot/recent-temp?choice_id=1000")
      .then((res) => {
        this.headerInfo.temp = res.data.rb_temperature;
      });
    http
      .get("iot/recent-hum?choice_id=" + this.user.choice_id)
      // .get("iot/recent-hum?choice_id=1000")
      .then((res) => {
        this.headerInfo.hum = res.data.rb_humidity;
      });
    http
      .get("api/calendar/" + this.user.choice_id, this.config)
      // .get("api/calendar/1000", this.config)
      .then((res) => {
        this.plantInfo.calendar_start_day = res.data.calendar_start_day;
        this.plantInfo.calendar_eat_day = res.data.calendar_eat_day;
        var today = new Date();
        var start = new Date(this.plantInfo.calendar_start_day);
        var end = new Date(this.plantInfo.calendar_eat_day);
        this.plantInfo.percent = Math.floor(
          (100 * (today - start)) / (end - start)
        );

        // if (isNaN(this.plantInfo.percent)) {
        //   this.$router.push({ name: "PlantEmpty" });
        // }
        this.SET_SPROUTTYPE(
          (1 + Math.floor(this.plantInfo.percent / 25)).toString()
        );
      });
  },
  mounted() {
    if (this.plantCharInfo) {
      this.bgimage = this.plantCharInfo.bgimage;
      this.potColor = this.plantCharInfo.potColor;
    }
  },
  data() {
    return {
      headerInfo: {
        waterTime: null,
        temp: null,
        hum: null,
      },
      isHidden: false,
      dialFab: true,
      plantInfo: {
        calendar_start_day: "",
        calendar_eat_day: "",
        percent: 0,
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
    ...mapGetters(["plantCharInfo", "isLoggedIn", "user", "config"]),
  },
  methods: {
    ...mapMutations(["SET_SPROUTTYPE"]),
    getFormatDate(date) {
      var month = 1 + date.getMonth();
      var day = date.getDate();
      var hour = date.getHours();
      var min = date.getMinutes();

      return month + "월 " + day + "일 " + hour + ":" + min;
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
.nbn--harvest {
  color: #5b3016;
  font-size: 28px;
  font-weight: 900;
  font-family: "Jua", sans-serif;

  &:hover {
    font-size: 30px;
  }

  &-btn {
    border-radius: 50%;
    background-color: rgba(255, 255, 255, 0.2);

    &:hover {
      background-color: rgba(255, 255, 255, 1);
    }
  }

  &-disable {
    border-radius: 50%;
    background-color: rgba(255, 255, 255, 0.2);
  }
}

.nbn--info {
  color: #5b3016;
  font-size: 16px;
  font-family: "Jua", sans-serif;

  &-subtitle {
    font-size: 12px;
    color: #5c3016;
  }

  &-lg {
    color: #5b3016;
    font-size: 24px;
    font-family: "Jua", sans-serif;
  }

  &-bold {
    font-weight: 900;
  }
}

.nbn--bgimage {
  background-repeat: no-repeat;
  background-size: 100% 100%;
}

.nbn--progress {
  width: 130px;
  position: absolute;
  bottom: 20px;
  left: 20px;
  background-color: rgba(255, 255, 255, 0.7);
  border-radius: 30px;
  display: flex;

  &:hover {
    background-color: rgba(255, 255, 255);
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
    width: 32px;
    height: 32px;
    top: 2px;
    left: 2px;
    background: #ccc;
    mask-image: url("~@/assets/leaf.svg");
  }
  &-wrapper-border {
    position: relative;
    width: 36px;
    height: 36px;
    background: #468b54;
    mask-image: url("~@/assets/leaf-border.svg");
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
    animation: animate 5s linear infinite;
  }

  &-after {
    border-radius: 40%;
    background: rgba(255, 255, 255, 0.5);
    animation: animate 10s linear infinite;
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
