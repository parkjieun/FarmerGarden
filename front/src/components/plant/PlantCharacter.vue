<template>
  <div>
    <v-img
      style="position: absolute"
      width="200px"
      :src="
        require('@/assets/plant/sprout/' + sprout + '-' + sproutType + '.png')
      "
    />
    <v-img
      style="position: absolute; z-index: 2"
      width="200px"
      :src="require('@/assets/plant/pot/' + pot + '-' + potColor + '.png')"
    />
    <v-img
      style="position: relative; z-index: 3"
      width="200px"
      :src="
        require('@/assets/plant/character/' +
          character +
          '-' +
          characterType +
          '.png')
      "
    />
    <v-select v-model="character" :items="Object.keys(itemCharacter)" />
    <v-select v-model="characterType" :items="itemCharacter[character]" />
    <v-select v-model="pot" :items="Object.keys(itemPot)" />
    <v-select v-model="potColor" :items="itemPot[pot]" />
    <v-select v-model="sprout" :items="Object.keys(itemSprout)" />
    <v-select v-model="sproutType" :items="itemSprout[sprout]" />
  </div>
</template>

<script>
export default {
  data() {
    return {
      character: "기본",
      characterType: "기쁨",
      pot: "기본",
      potColor: "orange",
      sprout: "싹",
      sproutType: "1",
      itemCharacter: {
        기본: ["기쁨", "놀람", "뽀", "슬픔", "잠", "죽음", "평범"],
        전자: ["기쁨", "놀람", "뽀", "슬픔", "잠", "죽음", "평범"],
      },
      itemPot: {
        기본: ["orange", "green", "pink", "purple", "welsh"],
        슬림: ["orange", "green", "pink", "purple", "welsh"],
        뚱: ["orange", "green", "pink", "purple", "welsh"],
        컵: ["orange", "green", "pink", "purple", "welsh"],
        고양이: ["orange"],
        토끼: ["orange"],
      },
      itemSprout: {
        무: ["1", "2", "3", "4"],
        싹: ["1", "2", "3", "4"],
        옥: ["1", "2", "3", "4"],
      },
    };
  },
};
</script>

<style>
</style>