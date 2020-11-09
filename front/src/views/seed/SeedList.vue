<template>
  <v-container
    class="fill-height pa-0 align-start"
    style="background-color: #efefef"
  >
    <v-row no-gutters>
      <v-col v-for="(item, index) in items" :key="index" cols="12">
        <v-card class="rounded-0" outlined>
          <v-list-item
            two-line
            @click="$set(sheet, index - 1, !sheet[index - 1])"
          >
            <v-list-item-avatar tile size="80">
              <v-img
                :src="require(`@/assets/plant/info/${item.info.image}`)"
                contain
              ></v-img>
            </v-list-item-avatar>
            <v-list-item-content>
              <v-list-item-title
                class="nbn--list-font-bold mb-1"
                v-text="item.title"
              />
              <v-list-item-subtitle
                class="nbn--list-font"
                v-text="item.subtitle"
              />
            </v-list-item-content>
            <v-list-item-action>
              <v-btn
                v-if="choice"
                outlined
                @click.stop="choicePlant(item.title)"
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
                  <v-tab-item id="nbn--info" class="text-body-1">
                    <div v-html="item.info.text"></div>
                  </v-tab-item>
                  <v-tab-item id="nbn--recipe">
                    <!-- recipe part of tab start -->
                    <div class="ma-0">
                      <SeedRecipeList :recipes="item.recipes" />
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
import { mapActions } from "vuex";

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
  methods: {
    ...mapActions(["setPlantCharInfo"]),
    choicePlant(plantname) {
      var sprout;

      if (plantname == "옥수수싹") {
        sprout = "옥";
      } else if (plantname == "무순") {
        sprout = "무";
      } else if (plantname == "밀싹") {
        sprout = "싹";
      } else if (plantname == "보리싹") {
        sprout = "싹";
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
    delay(ms) {
      const startPoint = new Date().getTime();
      while (new Date().getTime() - startPoint <= ms) {
        /* wait */
      }
    },
  },
  data() {
    return {
      tab: [],
      sheet: [],
      items: [
        {
          title: "밀싹",
          subtitle: "7~14일",
          info: {
            image: "info_밀싹.png",
            text:
              "<div>밀싹에는 각종 미네랄이 풍부하게 들었습니다. " +
              "밀이 싹을 틔우는 과정에서 다양한 영양분이 싹 부위에 응축됐기 때문입니다.</div>" +
              "<div>2015년 한국식품영양학회지에 실린 ‘밀싹 분말 첨가 머핀의 품질 특성’이란 보고서에 따르면 " +
              "밀싹 100ｇ에는 ▷단백질 29ｇ ▷식이섬유 37ｇ ▷기타엽록소 918㎎이 들었습니다. 이 밖에도 칼슘, 엽산, 철분과 각종 아미노산도 있습니다.</div>" +
              "<div>항산화물질도 풍부합니다. 몸속의 활성산소를 줄여 세포를 보호하는 글루타티온(glutathione), 비타민 C 같은 것들이죠. " +
              "다수 연구에 따르면 이런 항산화물질은 심장 질환, 관절염, 퇴행성질환 등을 막아주는 역할을 한다고 합니다.</div>",
          },
          recipes: [
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
        },
        {
          title: "보리싹",
          subtitle: "7~14일",
          info: {
            image: "info_보리싹.png",
            text: "",
          },
          recipes: [
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
        },
        {
          title: "무순",
          subtitle: "7~14일",
          info: {
            image: "info_무.png",
            text: "",
          },
          recipes: [
            {
              url: "0VAtKhN87aI",
              title:
                "미모원정대 - Ep.02 : 밀싹주스, 젊음을 위한 싱그러운 레시피!",
            },
          ],
        },
        {
          title: "옥수수싹",
          subtitle: "7~14일",
          info: {
            image: "info_옥수수싹.png",
            text: "",
          },
          recipes: [
            {
              url: "0VAtKhN87aI",
              title:
                "미모원정대 - Ep.02 : 밀싹주스, 젊음을 위한 싱그러운 레시피!",
            },
          ],
        },
      ],
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