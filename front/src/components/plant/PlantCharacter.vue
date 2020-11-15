<template>
  <!-- sprout layer -->
  <v-img
    style="position: relative; bottom: 5%"
    class="mx-auto"
    :class="{ 'bounce animated': animated }"
    @animationend="animated = false"
    :width="width"
    v-if="itemSprout[sprout][sproutType]"
    :src="require('@/assets/plant/sprout/' + itemSprout[sprout][sproutType])"
  >
    <!-- pot layer -->
    <v-img
      :class="{ 'bounce animated': animated }"
      @animationend="animated = false"
      style="position: relative; z-index: 2"
      :width="width"
      v-if="itemPot[pot][potColor]"
      :src="require('@/assets/plant/pot/' + itemPot[pot][potColor])"
    >
      <!-- character layer -->
      <v-img
        :class="{ 'bounce animated': animated }"
        @animationend="animated = false"
        style="position: relative; z-index: 3"
        :width="width"
        v-if="itemCharacter[character][characterType]"
        :src="
          require('@/assets/plant/character/' +
            itemCharacter[character][characterType])
        "
        @click="changeRandomCharacterType"
      />
    </v-img>
  </v-img>
</template>

<script>
import { mixinPlantCharInfo } from "@/mixins/mixinPlantCharInfo.js";

export default {
  mixins: [mixinPlantCharInfo],
  props: {
    character: String,
    pot: String,
    potColor: String,
    sprout: String,
    sproutType: String,
    width: {
      type: String,
      default: "200px",
    },
  },
  data() {
    return {
      animated: false,
      characterType: "평범",
    };
  },
  methods: {
    changeRandomCharacterType() {
      this.animated = true;

      var keys = Object.keys(this.itemCharacter[this.character]);
      this.characterType = keys[(keys.length * Math.random()) << 0];
    },
  },
};
</script>

<style lang="scss" scoped>
.bounce {
  transform-origin: bottom;
  animation: bounce 0.5s;
}

@keyframes bounce {
  0% {
    transform: scale(1);
  }
  50% {
    transform: scale(1.05);
  }
  100% {
    transform: scale(1);
  }
}
</style>