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
            :btn="item.btn"
            :src="item.src"
            @click.native="$set(sheet, index - 1, true)"
          />
        </v-col>
      </v-row>
    </v-container>

    <CoreBottomNav />
  </div>
</template>

<script>
import CoreBottomNav from "@/components/core/BottomNav.vue";
import CoreInfoCard from "@/components/core/InfoCard.vue";

export default {
  name: "SeedList",
  components: {
    CoreBottomNav,
    CoreInfoCard,
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
  methods: {
    youtubeLink(video) {
      return "https://www.youtube.com/watch?v=" + video;
    },
    youtubeThumbnailLink(video) {
      return "https://img.youtube.com/vi/" + video + "/sddefault.jpg";
    },
  },
};
</script>

<style scoped>
</style>