<template>
  <v-container
    class="fill-height pa-0 align-start"
    style="background-color: #efefef"
  >
    <v-row no-gutters>
      <v-col v-for="(item, index) in listItems" :key="index" cols="12">
        <v-card class="rounded-0" outlined>
          <v-list-item
            two-line
            @click="$set(sheet, index - 1, !sheet[index - 1])"
          >
            <v-list-item-avatar tile size="80">
              <v-img
                :src="`http://k3a105.p.ssafy.io/static/image/${item.plant_img}`"
                contain
              ></v-img>
            </v-list-item-avatar>
            <v-list-item-content>
              <v-list-item-title
                class="nbn--list-font-bold mb-1"
                v-text="item.plant_name"
              />
              <v-list-item-subtitle
                class="nbn--list-font"
                v-text="item.plant_eat_days + '일'"
              />
            </v-list-item-content>
            <v-list-item-action>
              <v-btn
                v-if="choice"
                outlined
                @click.stop="choicePlant(item.plant_name)"
              >
                선택
              </v-btn>
              <v-btn icon class="ml-auto">
                <v-icon>{{
                  sheet[index - 1] ? "mdi-chevron-up" : "mdi-chevron-down"
                }}</v-icon>
              </v-btn>
            </v-list-item-action>
          </v-list-item>

          <v-expand-transition>
            <div v-show="sheet[index - 1]">
              <v-divider></v-divider>
              <v-tabs v-model="tab[index - 1]">
                <v-tab href="#nbn--info">
                  <span>정보</span>
                </v-tab>
                <v-tab href="#nbn--recipe">
                  <span>요리법</span>
                </v-tab>
              </v-tabs>

              <v-card-text class="pa-0">
                <v-tabs-items v-model="tab[index - 1]">
                  <v-tab-item id="nbn--info" class="text-body-1 px-1">
                    <div v-html="item.plant_explanation"></div>
                  </v-tab-item>
                  <v-tab-item id="nbn--recipe">
                    <!-- recipe part of tab start -->
                    <div class="ma-0 pa-0">
                      <SeedRecipeList :recipes="youtubeItems[item.plant_id]" />
                    </div>
                  </v-tab-item>
                </v-tabs-items>
              </v-card-text>
            </div>
          </v-expand-transition>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
import http from "@/utils/http-common";

import SeedRecipeList from "@/components/seed/SeedRecipeList.vue";

export default {
  name: "SeedList",
  components: {
    SeedRecipeList,
  },
  props: {
    choice: {
      type: Boolean,
      default: false,
    },
  },
  computed: {
    ...mapGetters(["config"]),
  },
  methods: {
    ...mapActions(["setPlantCharInfo"]),
    choicePlant(plantname) {
      var sprout;

      if (plantname == "밀싹") {
        sprout = "1000";
      } else if (plantname == "메밀싹") {
        sprout = "1001";
      } else if (plantname == "루꼴라") {
        sprout = "1002";
      } else if (plantname == "옥수수싹") {
        sprout = "1003";
      } else if (plantname == "무순") {
        sprout = "1004";
      } else if (plantname == "적무순") {
        sprout = "1005";
      }

      var plantCharInfo = {
        character: "기본",
        pot: "기본",
        potColor: "orange",
        sprout: sprout,
        sproutType: "1",
        bgimage: "1",
      };
      this.setPlantCharInfo(plantCharInfo);
    },
  },
  created() {
    http
      .get("api/plant", this.config)
      .then((res) => {
        this.listItems = res.data;
        console.log(this.listItems);
      })
      .catch((err) => {
        console.log(err);
      });
  },
  data() {
    return {
      tab: [],
      sheet: [],
      listItems: [],
      youtubeItems: {
        1000: [
          {
            url: "0VAtKhN87aI",
            title:
              "미모원정대 - Ep.02 : 밀싹주스, 젊음을 위한 싱그러운 레시피!",
          },
          {
            url: "baiyoFb7CMg",
            title: "절대미모팁TIP 7. 뷰티박사 지윤의 밀싹 주스 레시피",
          },
        ],
        1001: [
          {
            url: "HC9Cdv0ZJLY",
            title:
              "구수한 새싹보리된장국 맛있게 끓이는 법, 된장국 맛있게 끓이기",
          },
          {
            url: "uMEyOOXsXOI",
            title: "새싹요리법(보리새싹주스)",
          },
          {
            url: "pYmCc0UNeW8",
            title:
              "보리새싹 초특급 레시피!🍴 달콤하고 고소한 샐러드와 에그스크램블❣️",
          },
          {
            url: "Ni2_ZrmADMQ",
            title: "면역력에 최고 새싹보리 겉절이",
          },
        ],
        1002: [
          {
            url: "0VAtKhN87aI",
            title:
              "미모원정대 - Ep.02 : 밀싹주스, 젊음을 위한 싱그러운 레시피!",
          },
        ],
        1003: [
          {
            url: "0VAtKhN87aI",
            title:
              "미모원정대 - Ep.02 : 밀싹주스, 젊음을 위한 싱그러운 레시피!",
          },
        ],
        1004: [
          {
            url: "0VAtKhN87aI",
            title:
              "미모원정대 - Ep.02 : 밀싹주스, 젊음을 위한 싱그러운 레시피!",
          },
        ],
        1005: [
          {
            url: "0VAtKhN87aI",
            title:
              "미모원정대 - Ep.02 : 밀싹주스, 젊음을 위한 싱그러운 레시피!",
          },
        ],
      },
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