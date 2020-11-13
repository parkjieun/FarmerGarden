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
              <v-tabs v-model="tab[index - 1]" active-class="nbn--tab-active">
                <v-tab href="#nbn--info">
                  <v-icon>$vuetify.icons.book</v-icon>
                  <span> 정보</span>
                </v-tab>
                <v-tab href="#nbn--recipe">
                  <v-icon>$vuetify.icons.fork</v-icon>
                  <span>요리법</span>
                </v-tab>
              </v-tabs>

              <v-card-text class="pa-0">
                <v-tabs-items v-model="tab[index - 1]">
                  <v-tab-item id="nbn--info" class="text-body-1 px-1">
                    <div v-html="item.plant_explanation"></div>
                  </v-tab-item>
                  <v-tab-item id="nbn--recipe">
                    <SeedRecipeList :recipes="youtubeItems[item.plant_id]" />
                  </v-tab-item>
                </v-tabs-items>
              </v-card-text>
            </div>
          </v-expand-transition>
        </v-card>
      </v-col>
      <v-col cols="12" style="background-color: #2bc77e13">
        <div class="nbn--list-font text-h6 text-center py-3">
          새로운 새싹들을 연구 중입니다
        </div>
        <v-img
          class="mx-auto"
          width="300px"
          :src="require('@/assets/연구.png')"
        />
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

      http
        .post("/api/choice?plant_id=" + sprout, this.config)
        .then(() => {
          this.setPlantCharInfo(plantCharInfo);
          this.$router.push({ name: "Tutorial" });
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created() {
    http
      .get("api/plant", this.config)
      .then((res) => {
        this.listItems = res.data;
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
          {
            url: "MKbMp55BiaY",
            title:
              "[완치 비결] 단 4가지로 질병 완치는 물론 예방까지 가능하다? • 암 완치 • 식이요법 • 밀싹효능 • 밀싹주스 만들기 • 밀싹즙",
          },
          {
            url: "p65Vb3S_LHQ",
            title: '궁극의 청혈제 "밀싹"',
          },
          {
            url: "QvqHONKe3QI",
            title: "밀싹 프렌치토스트",
          },
        ],
        1001: [
          {
            url: "iZJMp9g8628",
            title:
              "6시 내고향 (Hometown Report) - 싹으로 먹으면 더 좋은 메밀 메밀싹!.20150324",
          },
          {
            url: "EdqQNys3STc",
            title: "메밀의 놀라운 효능과 부작용, 메밀차, 메밀싹 메밀 루틴 효능",
          },
          {
            url: "JjCxAg9bVuc",
            title:
              "6시 내고향 - 오감만족 건강한 맛, 메밀싹 - 강원 평창.20160215",
          },
          {
            url: "GU5xzK1PQFE",
            title: '돌복숭아효소를이용한 "메밀싹돈피무침"간편요리(발효밥상)',
          },
          {
            url: "bqh9fcr1FWM",
            title:
              "[SBS먹킷_#평창] 9월초 활짝 만개한 메밀꽃 오늘은 메밀막국수, 메밀싹비빔밥, 메밀전병을 만나보자! / Mukbang Eating show",
          },
        ],
        1002: [
          {
            url: "eh0sgeCXR4M",
            title:
              "[준쿡] 루꼴라 좋아하시는 분 이 영상 꼭 보세요 | 루꼴라샐러드와 썬드라이 토마토 드레싱 | Arugula Salad [JUNCOOK]",
          },
          {
            url: "9TjW4ipw3Mo",
            title:
              "현실요리 #8 [SUB] 루꼴라키우기. 초당옥수수요리! 새로운 토스트만들기.",
          },
          {
            url: "lprZrMYDJ9w",
            title: "씨앗부터 키운 루꼴라 수확 & 활용하기",
          },
          {
            url: "bbipKg6ADXA",
            title: "비건 루꼴라 알리오 올리오 🌿🧄🍝",
          },
          {
            url: "Cn00ThyABcg",
            title: "참치김밥 아루굴라(루꼴라)를 넣어 더욱 맛있는 김밥",
          },
          {
            url: "3ckICy867sQ",
            title:
              "🌱홈가드닝 #루꼴라 씨앗 발아부터 루꼴라 또띠아 피자 만들기! 새벽빛네 베란다텃밭 관찰일지☆*",
          },
        ],
        1003: [
          {
            url: "B7UmUX68KtE",
            title: "Pöpcørn | Recipes with The Swedish Chef | The Muppets",
          },
          {
            url: "LSPQw6PCbsc",
            title: "How to make Popcorn Sprout Tea",
          },
        ],
        1004: [
          {
            url: "u1ArASs_Rzo",
            title: "무순겉절이 너무 간단하쟈나!!!!!! [만개의레시피]",
          },
          {
            url: "_vvXaTgRt8o",
            title:
              "[요리]쌈무말이 만들기(ssammumali) /Mep81 : 손님상 메뉴의 비주얼 담당,예쁘고 맛있는 쌈무말이 #파티음식#특별한요리",
          },
          {
            url: "RXVvDGhJPlU",
            title:
              "무순팽이버섯 장아찌ㅣ추석요리ㅣ고기와 함께 먹으면 좋은음식ㅣ장아찌담그기ㅣ무순요리",
          },
          {
            url: "j92_01toxL4",
            title:
              "[김밥만들기] 무순을 넣은 꼬마김밥 만드는 방법, 연겨자 소스로 매콤하게 즐기는 꼬마김밥 만들기 Korean Food mini kimbap recipe",
          },
          {
            url: "46UrMcyFUlE",
            title:
              "날치알 요리, 날치알과 무순만 넣은 간단한 데마끼 김마끼 만들기 : ceramicdo 세라믹도",
          },
          {
            url: "vNbb68Mcp-g",
            title: "연어 무순 말이 만들어서 먹어 봤습니다! 연어롤?/ 연어말이",
          },
          {
            url: "d_iWpGBmsJA",
            title:
              "소고기 야채말이 만들기_ 간단하고 고급진 특별한 날 추천 요리",
          },
          {
            url: "HstezNJHfLk",
            title: "간단하고 예쁜 무쌈말이 만드는 방법 !",
          },
        ],
        1005: [
          {
            url: "d_iWpGBmsJA",
            title:
              "소고기 야채말이 만들기_ 간단하고 고급진 특별한 날 추천 요리",
          },
          {
            url: "j92_01toxL4",
            title:
              "[김밥만들기] 무순을 넣은 꼬마김밥 만드는 방법, 연겨자 소스로 매콤하게 즐기는 꼬마김밥 만들기 Korean Food mini kimbap recipe",
          },
          {
            url: "HstezNJHfLk",
            title: "간단하고 예쁜 무쌈말이 만드는 방법 !",
          },
          {
            url: "u1ArASs_Rzo",
            title: "무순겉절이 너무 간단하쟈나!!!!!! [만개의레시피]",
          },
          {
            url: "RXVvDGhJPlU",
            title:
              "무순팽이버섯 장아찌ㅣ추석요리ㅣ고기와 함께 먹으면 좋은음식ㅣ장아찌담그기ㅣ무순요리",
          },
          {
            url: "46UrMcyFUlE",
            title:
              "날치알 요리, 날치알과 무순만 넣은 간단한 데마끼 김마끼 만들기 : ceramicdo 세라믹도",
          },
          {
            url: "vNbb68Mcp-g",
            title: "연어 무순 말이 만들어서 먹어 봤습니다! 연어롤?/ 연어말이",
          },
          {
            url: "_vvXaTgRt8o",
            title:
              "[요리]쌈무말이 만들기(ssammumali) /Mep81 : 손님상 메뉴의 비주얼 담당,예쁘고 맛있는 쌈무말이 #파티음식#특별한요리",
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

.v-tab--active {
  fill: var(--primary-color);
}
</style>
