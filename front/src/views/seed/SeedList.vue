<template>
  <v-container
    class="fill-height align-start pa-0"
    style="background-color: #efefef"
  >
    <v-row no-gutters>
      <v-col v-for="(item, index) in items" :key="index" cols="12">
        <CoreInfoCard
          :subtitle="item.subtitle"
          :title="item.title"
          :src="item.src"
          @click.native="$set(sheet, index - 1, true)"
        >
          <template #btn>
            <v-btn
              v-if="choice"
              dark
              class="px-5 ml-2 font-weight-black"
              color="#00B17B"
              v-text="'선택'"
              @click.stop="choicePlant(item.title)"
            />
          </template>
        </CoreInfoCard>

        <!-- dialog start -->
        <v-dialog
          v-model="sheet[index - 1]"
          scrollable
          fullscreen
          hide-overlay
          transition="dialog-bottom-transition"
        >
          <v-card class="rounded-0">
            <!-- dialog title start -->
            <v-app-bar flat dark dense color="primary">
              <v-btn icon @click="$set(sheet, index - 1, false)">
                <v-icon>mdi-chevron-left</v-icon>
              </v-btn>
              <v-toolbar-title
                class="text-body-1 nbn--list-font-bold"
                v-text="item.title"
              >
              </v-toolbar-title>
              <template v-slot:extension>
                <v-tabs v-model="tab">
                  <v-tab href="#nbn--info">
                    <span>정보</span>
                  </v-tab>
                  <v-tab href="#nbn--recipe">
                    <span>요리법</span>
                  </v-tab>
                </v-tabs>
              </template>
            </v-app-bar>
            <!-- dialog title end -->
            <v-card-text class="pa-0">
              <v-tabs-items v-model="tab">
                <v-tab-item id="nbn--info" class="text-body-1">
                  <div v-html="item.info.text"></div>
                </v-tab-item>
                <v-tab-item id="nbn--recipe">
                  <!-- recipe part of tab start -->
                  <SeedRecipeList :recipes="item.recipes" />
                </v-tab-item>
              </v-tabs-items>
            </v-card-text>
          </v-card>
        </v-dialog>
        <!-- dialog end -->
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions } from "vuex";

import CoreInfoCard from "@/components/core/InfoCard.vue";

import SeedRecipeList from "@/components/seed/SeedRecipeList.vue";

export default {
  name: "SeedList",
  components: {
    CoreInfoCard,
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
    async choicePlant(plantname) {
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
      await this.setPlantCharInfo(plantCharInfo);
      await this.delay(500);
      await this.$router.push({ name: "PlantMain" });
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
      tab: null,
      sheet: [],
      items: [
        {
          title: "밀싹",
          info: {
            image: "",
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
          info: {
            image: "",
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
          info: {
            image: "",
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
          info: {
            image: "",
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