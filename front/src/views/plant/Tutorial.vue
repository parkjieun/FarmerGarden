<template>
  <div style="max-width: 90%; min-width: 300px;" class="mx-auto mt-5">
    <div class="text-h5 text-center pb-5">튜토리얼</div>
    <div>
    <v-stepper v-model="e1">
      <v-stepper-items>
        <v-stepper-content step="1">
          <TutorialCard :e1="e1"/>
        </v-stepper-content>
        <v-stepper-content step="2">
          <TutorialCard :e1="e1"/>
        </v-stepper-content>
        <v-stepper-content step="3">
          <TutorialCard :e1="e1"/>
        </v-stepper-content>
      </v-stepper-items>

      <v-stepper-header>
        <v-stepper-step
          :complete="e1 > 1"
          step="1"
          @click="e1=1"
        >
          씨앗 준비
        </v-stepper-step>
        <v-divider></v-divider>
        <v-stepper-step
          :complete="e1 > 2"
          step="2"
          @click="e1=2"
        >
          씨앗 뿌리기
        </v-stepper-step>
        <v-divider></v-divider>
        <v-stepper-step step="3" @click="e1=3">
          물 주입
        </v-stepper-step>
      </v-stepper-header>
      
  </v-stepper>
  <v-btn @click="goMain" class="text-center mt-5">Skip</v-btn>
  </div>

  
  <v-carousel height="350px" :hide-delimiter-background="false" :continuous="false"
  delimiter-icon="mdi-minus">
    <v-carousel-item>
      <TutorialCard :e1="1"/>
    </v-carousel-item>
    <v-carousel-item>
      <TutorialCard :e1="2"/>
    </v-carousel-item>
    <v-carousel-item>
      <TutorialCard :e1="3"/>
    </v-carousel-item>
  </v-carousel>
  </div>
</template>

<script>
import TutorialCard from '@/components/plant/TutorialCard.vue'
export default {
  components: {
    TutorialCard
  },
  data () {
      return {
        e1: 1,
        items: [
          {src: require('@/assets/plant/tutorial/seed.jpeg')},
          {src: require('@/assets/plant/tutorial/water.jpg')}
        ]
      }
  },
  methods: {
    goMain() {

    }
  }
}
</script>

<style>

</style>