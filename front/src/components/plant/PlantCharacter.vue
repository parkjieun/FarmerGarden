<template>
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
      v-if="itemSprout[sprout][sproutType]"
      :src="require('@/assets/plant/sprout/' + itemSprout[sprout][sproutType])"
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
      v-if="itemPot[pot][potColor]"
      :src="require('@/assets/plant/pot/' + itemPot[pot][potColor])"
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
      v-if="itemCharacter[character][characterType]"
      :src="
        require('@/assets/plant/character/' +
          itemCharacter[character][characterType])
      "
      @click="changeRandomCharacterType"
    />
  </div>
</template>

<script>
import { mixinPlantCharInfo } from "@/mixins/mixinPlantCharInfo.js";

export default {
  mixins: [mixinPlantCharInfo],
  props: ["character", "pot", "potColor", "sprout", "sproutType"],
  data() {
    return {
      characterType: "평범",
    };
  },
  methods: {
    changeRandomCharacterType() {
      var keys = Object.keys(this.itemCharacter[this.character]);
      this.characterType = keys[(keys.length * Math.random()) << 0];
    },
  },
};
</script>

<style lang="scss" scoped>
</style>