<template>
  <div>
    <v-card v-if="e1 == 1" class="rounded-0">
      <v-img
        src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        height="200px"
      />
      <v-card-title>
        1단계 : 씨앗 준비
      </v-card-title>
      <v-card-subtitle>
        재배할 씨앗을 준비해주세요.
      </v-card-subtitle>
    </v-card>

    <v-card v-if="e1 == 2" class="rounded-0">
      <v-img
        :src="require('@/assets/plant/tutorial/seed.jpeg')"
        height="200px"
      />
      <v-card-title>
        2단계 : 씨앗 뿌리기
      </v-card-title>
      <v-card-subtitle>
        재배판에 씨앗을 적당한 간격으로 뿌려주세요.
      </v-card-subtitle>
    </v-card>

    <v-card v-if="e1 == 3" class="rounded-0">
      <v-img
        :src="require('@/assets/plant/tutorial/water.jpg')"
        height="200px"
      />
      <v-card-title>
        3단계 : 물 주입
      </v-card-title>
      <v-card-subtitle>
        물 주입구에 물을 넣어주세요. (1리터 이상)
      </v-card-subtitle>
    </v-card>
  </div>
</template>

<script>
export default {
  props: ["e1"],
};
</script>

<style></style>
