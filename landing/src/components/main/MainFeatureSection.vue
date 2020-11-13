<template>
  <section id="blog"  class="grey lighten-3">
    <div class="py-12"></div>

    <v-container>
      <h2 class="display-2 font-weight-bold mb-3 text-uppercase text-center">‘농부네 텃밭’ 기능소개</h2>

      <v-responsive
        class="mx-auto mb-12"
        width="56"
      >
        <v-divider class="mb-1"></v-divider>

        <v-divider></v-divider>
      </v-responsive>

      <v-row>
        <v-col cols="12"  md="4">
          <v-img src="@/assets/main/feature/water_led.gif"
           class="mb-4" height="275" contain max-width="100%"
          ></v-img>

          <h2 class="font-weight-black mb-4 text-uppercase">전자동관리 서비스</h2>

          <!-- <div class="title font-weight-light mb-5"  style="font-size:1.1rem !important"> -->
          <div class="">
            농부네 텃밭의 전자동관리 서비스는 적은 시간 투자로 전문가처럼 능숙하게 새싹을 재배할 수 있는 서비스입니다.             
            IOT기기를 자동 관리하여, 주기적으로 급수가 주입되며 새싹의 성장을 기록합니다. 
            물 부족시 외관에 불이 켜지며 주입 시간을 알려줍니다.
          </div>
        </v-col>
        <v-col cols="12"  md="4">
          <v-img src="@/assets/main/feature/led.gif"
           class="mb-4" height="275" contain max-width="100%"
          ></v-img>

          <h2 class="font-weight-black mb-4 text-uppercase">재배기 환경 제어 서비스</h2>

          <!-- <div class="title font-weight-light mb-5"  style="font-size:1.1rem !important"> -->
          <div class="">
            농부네 텃밭은 모바일 서비스를 이용해 언제 어디서든 `LED·급수·카메라` 제어가 가능합니다.<br>
            수경재배기 내의 자동온도 조절장치는 새싹이 자라기 적합한 물 온도 환경을 유지해줍니다.
          </div>
        </v-col>
        <v-col cols="12"  md="4">
          <v-img src="@/assets/main/feature/app.gif"
           class="mb-4" height="275" contain max-width="100%"
          ></v-img>

          <h2 class="font-weight-black mb-4 text-uppercase ">다양한 모바일 서비스 제공</h2>

          <!-- <div class="title font-weight-light mb-5" style="font-size:1.1rem !important"> -->
          <div class="">
            사용자마다 새싹 아이콘 커스텀이 가능하여 키우는 재미를 제공합니다.
            재배기 환경의 온습도 분석이 가능하며, 새싹의 예상 수확 일정 등 다양한 기능을 확인할 수 있습니다.
            또한, 어려움을 느낄 경우, 챗봇서비스를 통해 도움을 드립니다.
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