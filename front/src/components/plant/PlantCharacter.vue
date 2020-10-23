<template>
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
    <v-select v-model="pot" :items="itemPot" />
    <v-select v-model="sprout" :items="itemSprout" />
  </div>
</template>

<script>
export default {
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