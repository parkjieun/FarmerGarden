<template>
  <div>
      <v-card>
          <div v-if="e1==1">
            <v-img :src="require('@/assets/plant/tutorial/seed.jpeg')"></v-img>
            <v-card-text>
                씨앗을 뿌려주세요.
            </v-card-text>
          </div>
          <div v-if="e1==2">
            <v-img :src="require('@/assets/plant/tutorial/water.jpg')"></v-img>
            <v-card-text>
                물주입구에 물을 넣어주세요.
            </v-card-text>
          </div>
          <div v-if="e1==3">
            <v-img :src="require('@/assets/plant/tutorial/water.jpg')"></v-img>
            <v-card-text>
                모든 과정이 끝났습니다.<br/> 수확일은 7일 이후입니다.
            </v-card-text>
          </div>
      </v-card>
      
  </div>
</template>

<script>
export default {
    props: ['e1']

}
</script>

<style>

</style>