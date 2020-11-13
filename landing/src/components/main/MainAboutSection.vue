<template>
      <section id="about-me">
        <div class="py-12"></div>

        <v-container class="text-center">
          <h2 class="display-2 font-weight-bold mb-3 ">ABOUT ‘농부네 텃밭’</h2>

          <v-responsive
            class="mx-auto mb-8"
            width="56"
          >
            <v-divider class="mb-1"></v-divider>

            <v-divider></v-divider>
          </v-responsive>

          <v-responsive
            class="mx-auto title font-weight-light mb-8"
            max-width="720"
          >

            <h2 style="">“<span style="color:#AFD485;font-weight:bold">씨앗</span>과 <span style="color:#58CCFF;font-weight:bold">물</span>만 있으면 우리가 키워드립니다”</h2>
             <v-spacer style="padding-bottom:20px"></v-spacer>
            씨앗을 심고 새싹을 기다려보세요.
            <v-spacer></v-spacer>
            물이 훑고 간 자리에서
            <v-spacer></v-spacer>
            새싹이 싹트는 식탁 위 작은 농장으로 
            <v-spacer></v-spacer>
            새로운 삶의 가치를 선사합니다.  
          </v-responsive>

          <v-avatar
            class="mb-12"
            tile
            size="128"
          >
            <v-img 
              src="@/assets/main/logo3.gif" 
              contain
              max-height="100%"
            >
            </v-img>
          </v-avatar>

          
          <div></div>
          
          <v-btn
            color="grey"
            outlined
            large
            href="/instruction_manual.pdf" download
            style="margin-right:20px"
          >
            <span class="grey--text text--darken-1 font-weight-bold">
              Manual Download
            </span>
          </v-btn>

          <v-btn
            color="grey"
            outlined
            large
            href="/nongbunae.apk" download
          >
            <span class="grey--text text--darken-1 font-weight-bold">
              app Download
            </span>
          </v-btn>

        </v-container>

        <div class="py-12"></div>
      </section>
</template>


<script>
// import axios from 'axios';

export default {
  name: "MainAboutSection",
   methods: {
     download(){

     }
    },
}
</script>

<style>

</style>  