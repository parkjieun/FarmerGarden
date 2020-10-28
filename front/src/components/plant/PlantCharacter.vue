<template>
  <div>
    <v-img
      style="position: absolute"
      width="200px"
      :src="require('@/assets/plant/sprout/' + sprout + '-' + sproutType)"
    />
    <v-img
      style="position: absolute; z-index: 2"
      width="200px"
      :src="require('@/assets/plant/pot/' + pot + '-' + potColor)"
    />
    <v-img
      style="position: relative; z-index: 3"
      width="200px"
      :src="
        require('@/assets/plant/character/' + character + '-' + characterType)
      "
      @click="changeRandomCharacterType"
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
      characterType: "기쁨.png",
      pot: "기본",
      potColor: "orange.png",
      sprout: "싹",
      sproutType: "1.png",
      itemCharacter: {
        기본: [
          "기쁨.png",
          "놀람.png",
          "뽀.png",
          "슬픔.png",
          "잠.png",
          "죽음.png",
          "평범.png",
        ],
        전자: [
          "기쁨.png",
          "놀람.png",
          "뽀.png",
          "슬픔.png",
          "잠.png",
          "죽음.png",
          "평범.png",
        ],
      },
      itemPot: {
        기본: [
          "orange.png",
          "green.png",
          "pink.png",
          "purple.png",
          "welsh.png",
        ],
        슬림: [
          "orange.png",
          "green.png",
          "pink.png",
          "purple.png",
          "welsh.png",
        ],
        뚱: ["orange.png", "green.png", "pink.png", "purple.png", "welsh.png"],
        컵: ["orange.png", "green.png", "pink.png", "purple.png", "welsh.png"],
        고양이: ["orange.png"],
        토끼: ["orange.png"],
      },
      itemSprout: {
        무: ["1.png", "2.png", "3.png", "4.png"],
        싹: ["1.png", "2.png", "3.png", "4.png"],
        옥: ["1.png", "2.png", "3.png", "4.png"],
      },
    };
  },
  methods: {
    changeRandomCharacterType() {
      var itemLen = this.itemCharacter[this.character].length;
      var rndNum = this.rnd(0, itemLen - 1);
      this.characterType = this.itemCharacter[this.character][rndNum];
    },
    rnd(a, b) {
      return Math.floor((b - a + 1) * Math.random()) + a;
    },
  },
};
</script>

<style>
</style>