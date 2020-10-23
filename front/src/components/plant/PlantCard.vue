<template>
  <v-card color="#6CEB8F">
    <div class="d-flex flex-no-wrap justify-space-between my-2">
      <div>
        <v-card-title class="headline font-weight-black" v-text="plant.name" />
        <v-card-subtitle
          class="text-subtitle-2 font-weight-bold"
          v-text="plant.dday + ' 예정'"
        />
        <v-card-text class="headline" v-text="plant.percent + '%'" />
      </div>

      <div>
        <v-img
          style="position: absolute"
          width="200px"
          :src="require('@/assets/plant/pot/' + pot + '.png')"
        />
        <v-img
          style="position: relative; z-index: 3"
          width="200px"
          :src="require('@/assets/plant/sprout/' + sprout)"
        />
      </div>
    </div>
  </v-card>
</template>

<script>
export default {
  props: ["plant"],
  data() {
    return {
      pot: "기쁨",
      sprout: "밀1.png",
      itemPot: ["기쁨", "놀람", "뽀", "슬픔", "잠", "죽음", "평범"],
      itemSprout: [
        "무1.gif",
        "무2.png",
        "무3.png",
        "무4.png",
        "밀1.png",
        "밀2.png",
        "밀3.png",
        "밀4.png",
        "옥1.png",
        "옥2.png",
        "옥3.png",
        "옥4.png",
      ],
    };
  },
};
</script>

<style>
</style>