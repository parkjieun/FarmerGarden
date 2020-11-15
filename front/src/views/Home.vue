<template>
    <!-- <v-content> -->
      <v-main>
       <!-- <NavBar/>    -->
       <MainImgSection/>
       <MainAboutSection/>
       <MainTeamSection/>
       <MainFeatureSection/>
       <MainTutorialSection/>
       <ScrollTop/>
        <Footer/>
     </v-main>
    <!-- </v-content> -->
</template>

<script>
// import NavBar from '@/components/layout/NavBar.vue'
import MainImgSection from '@/components/main/MainImgSection.vue'
import MainAboutSection from '@/components/main/MainAboutSection.vue'
import MainTutorialSection from '@/components/main/MainTutorialSection.vue'
import MainTeamSection from '@/components/main/MainTeamSection.vue'
import MainFeatureSection from '@/components/main/MainFeatureSection.vue'
import ScrollTop from '@/components/layout/ScrollTop.vue'
import Footer from '@/components/layout/Footer.vue'

export default {
  name: 'Home',
  components: {
    // NavBar,
    MainImgSection,
    MainAboutSection,
    MainTutorialSection,
    MainTeamSection,
    MainFeatureSection,
    ScrollTop,
    Footer,
  },
  data () {
    return {
    }
  }
}
</script>

<style scoped>
/* Google Font Import */
@import url("https://fonts.googleapis.com/css2?family=Do+Hyeon&Nanum+Gothic:wght@700;800&Noto+Sans+KR:wght@300&Black+Han+Sans&display=swap");
@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');


.nanum{
  font-family: 'Nanum Pen Script', cursive;
}

.f-green{
  color:#93c130;
}

.f-size130{
  font-size:130px;
}

.f-size80{
  font-size:80px;
}

/* * {
  font-family: "NanumSquare", "Nanum Gothic", "Do Hyeon", "Noto Sans KR",
    sans-serif;
  font-weight: 400;
} */

/* 
@font-face {
  font-family: 'NanumBarunpen';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumBarunpen.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}

.nanumbarungothic {
  font-family: 'NanumBarunGothic', sans-serif;
 } */
</style>
