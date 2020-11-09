<template>
  <div>
    <v-card v-if="e1 == 1" class="rounded-lg">
      <v-img
        :src="require('@/assets/plant/tutorial/튜토애니메이션1.gif')"
        height="360px"
        contain
      />
      <v-card-title> 씨앗 뿌리기 </v-card-title>
      <v-card-subtitle>
        재배할 씨앗을 수경 재배기에 골고루 뿌리세요.
      </v-card-subtitle>
    </v-card>

    <v-card v-if="e1 == 2" class="rounded-lg">
      <v-img
        :src="require('@/assets/plant/tutorial/튜토애니메이션2.gif')"
        height="360px"
        contain
      />
      <v-card-title> 물 넣기 </v-card-title>
      <v-card-subtitle> 물 주입구를 통해 물을 넣어주세요 </v-card-subtitle>
    </v-card>
  </div>
</template>

<script>
export default {
  props: ["e1"],
};
</script>

<style></style>
