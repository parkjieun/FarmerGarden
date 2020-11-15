<template>
    <!-- <v-content> -->
      <v-main>
       <MainImgSection/>
       <MainAboutSection/>
       <MainTeamSection/>
       <MainFeatureSection/>
       <MainTutorialSection/>
       <ScrollTop/>
     </v-main>
    <!-- </v-content> -->
</template>

<script>
import MainImgSection from '@/components/main/MainImgSection.vue'
import MainAboutSection from '@/components/main/MainAboutSection.vue'
import MainTutorialSection from '@/components/main/MainTutorialSection.vue'
import MainTeamSection from '@/components/main/MainTeamSection.vue'
import MainFeatureSection from '@/components/main/MainFeatureSection.vue'
import ScrollTop from '@/components/layout/ScrollTop.vue'

export default {
  name: 'Home',
  components: {
    MainImgSection,
    MainAboutSection,
    MainTutorialSection,
    MainTeamSection,
    MainFeatureSection,
    ScrollTop,
  },
  data () {
    return {
    }
  }
}
</script>
