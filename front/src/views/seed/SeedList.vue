<template>
  <div style="background-color: #fff8f3">
    <v-container>
      <v-row dense>
        <v-col cols="12">
          <div class="pl-3 text-h6">새싹 목록</div>
        </v-col>

        <v-col v-for="(item, index) in items" :key="index" cols="12">
          <CoreInfoCard
            :subtitle="item.subtitle"
            :title="item.title"
            :src="item.src"
          >
            <template #btn>
              <v-btn
                dark
                class="px-5 ml-2 font-weight-black"
                color="#00B17B"
                v-text="'선택'"
                @click.native="choicePlant(item.title)"
              />
              <v-btn
                dark
                class="px-5 ml-2 font-weight-black"
                color="#00B17B"
                v-text="'정보'"
                @click.native="$set(sheet, index - 1, true)"
              />
            </template>
          </CoreInfoCard>
          <!-- bottom sheet start -->
          <v-bottom-sheet v-model="sheet[index - 1]">
            <v-sheet class="rounded-t-xl" :height="$vuetify.breakpoint.height">
              <!-- bottom sheet title start -->
              <v-row>
                <v-col cols="2"></v-col>
                <div
                  class="headline align-self-center teal--text font-weight-bold"
                >
                  {{ item.title }}
                </div>
                <v-spacer></v-spacer>
                <v-btn
                  class="mr-3"
                  fab
                  text
                  @click="$set(sheet, index - 1, false)"
                >
                  <v-icon>mdi-close</v-icon>
                </v-btn>
              </v-row>
              <!-- bottom sheet title end -->
              <v-tabs v-model="tab">
                <v-tab href="#nbn--info">
                  <span>정보</span>
                </v-tab>
                <v-tab href="#nbn--recipe">
                  <span>요리법</span>
                </v-tab>
              </v-tabs>
              <v-tabs-items v-model="tab">
                <v-tab-item
                  id="nbn--info"
                  class="pa-3 text-body-1"
                  v-html="item.info.text"
                />
                <v-tab-item id="nbn--recipe">
                  <!-- recipe part of tab start -->
                  <SeedRecipeList :recipes="item.recipes" />
                </v-tab-item>
              </v-tabs-items>
            </v-sheet>
          </v-bottom-sheet>
          <!-- bottom sheet end -->
        </v-col>
      </v-row>
    </v-container>

    <CoreBottomNav />
  </div>
</template>

<script>
import { mapActions } from "vuex";

import CoreBottomNav from "@/components/core/BottomNav.vue";
import CoreInfoCard from "@/components/core/InfoCard.vue";

import SeedRecipeList from "@/components/seed/SeedRecipeList.vue";

export default {
  name: "SeedList",
  components: {
    CoreBottomNav,
    CoreInfoCard,
    SeedRecipeList,
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
      await this.$router.push({ name: "PlantMain" });
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

<style scoped>
</style>