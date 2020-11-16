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
