<template>
  <div>
    <div>
      <v-img
        style="
          position: absolute;
          left: 0;
          right: 0;
          margin-left: auto;
          margin-right: auto;
        "
        width="200px"
        :src="require('@/assets/plant/sprout/' + sprout + '-' + sproutType)"
      />
      <v-img
        style="
          position: absolute;
          z-index: 2;
          left: 0;
          right: 0;
          margin-left: auto;
          margin-right: auto;
        "
        width="200px"
        :src="require('@/assets/plant/pot/' + pot + '-' + potColor)"
      />
      <v-img
        style="
          position: relative;
          z-index: 3;
          left: 0;
          right: 0;
          margin-left: auto;
          margin-right: auto;
        "
        width="200px"
        :src="
          require('@/assets/plant/character/' + character + '-' + characterType)
        "
        @click="changeRandomCharacterType"
      />
    </div>
    <div v-if="!hidden">
      <v-select v-model="character" :items="Object.keys(itemCharacter)" />
      <v-select v-model="characterType" :items="itemCharacter[character]" />
      <v-select v-model="pot" :items="Object.keys(itemPot)" />
      <v-select v-model="potColor" :items="itemPot[pot]" />
      <v-select v-model="sprout" :items="Object.keys(itemSprout)" />
      <v-select v-model="sproutType" :items="itemSprout[sprout]" />
    </div>
  </div>
</template>

<script>
export default {
  props: {
    hidden: {
      type: Boolean,
      default: false,
    },
  },
  data() {
    return {
      animating: false,
      character: "기본",
      characterType: "평범.gif",
      pot: "기본",
      potColor: "orange.png",
      sprout: "싹",
      sproutType: "1.gif",
      itemCharacter: {
        기본: [
          "기쁨.png",
          "놀람.png",
          "뽀.png",
          "슬픔.png",
          "잠.png",
          "죽음.png",
          "평범.gif",
        ],
        전자: [
          "기쁨.png",
          "놀람.png",
          "뽀.gif",
          "슬픔.png",
          "잠.gif",
          "죽음.gif",
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
        고양이: ["orange.gif"],
        토끼: ["orange.gif"],
      },
      itemSprout: {
        무: ["1.gif", "2.gif", "3.gif", "4.gif"],
        싹: ["1.gif", "2.gif", "3.gif", "4.gif"],
        옥: ["1.gif", "2.gif", "3.gif", "4.gif"],
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

<style lang="scss" scoped>
</style>