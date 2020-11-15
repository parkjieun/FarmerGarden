<template>
  <section id="blog"  class=" lighten-3">
    <div class="py-12"></div>

    <v-container>
      <h2 class="display-3 font-weight-bold mb-3 text-uppercase text-center">서비스 소개</h2>

      <v-responsive
        class="mx-auto mb-12"
        width="56"
      >
        <v-divider class="mb-1"></v-divider>

        <v-divider></v-divider>
      </v-responsive>

      <v-row>
        <v-col cols="12"  md="4">
          <v-img src="@/assets/main/feature/water.gif"
           class="mb-4" height="350" contain max-width="100%"
          ></v-img>

          <h2 class="font-weight-black mb-4 text-uppercase">전자동관리 서비스</h2>

          <!-- <div class="title font-weight-light mb-5"  style="font-size:1.1rem !important"> -->
          <div class="">           
            농부네 텃밭은 시스템이 IOT기기를 자동 관리하여, 새싹의 성장을 도와줍니다. <br>
          </div>
        </v-col>
        
        <v-col cols="12"  md="4">
          <v-img src="@/assets/main/feature/led.gif"
           class="mb-4" height="350" contain max-width="100%"
          ></v-img>

          <h2 class="font-weight-black mb-4 text-uppercase">환경 제어 서비스</h2>

          <!-- <div class="title font-weight-light mb-5"  style="font-size:1.1rem !important"> -->
          <div class="">
            농부네 텃밭은 모바일 서비스를 이용해 재배기 내의 환경 제어가 가능합니다.<br>
          </div>
        </v-col>
        <v-col cols="12"  md="4">
          <v-img src="@/assets/main/feature/app.gif"
           class="mb-4" height="350" contain max-width="100%"
          ></v-img>

          <h2 class="font-weight-black mb-4 text-uppercase ">모바일 서비스 제공</h2>

          <div class="">
            예상 수확 일정, 챗봇, 온·습도 분석 그래프 등 다양한 기능을 제공합니다.
          </div>
        </v-col>
      </v-row>
    </v-container>

    <div class="py-12"></div>
  </section>
</template>


<script>
export default {
  name: "MainFeatureSection",
  data () {
    return {
    }
  }
}
</script>

<style>

</style>  