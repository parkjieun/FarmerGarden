<template>
  <div>
    <transition name="bounce">
      <!-- sprout layer -->
      <v-img
        style="position: relative; bottom: 5%"
        class="mx-auto"
        :width="width"
        v-if="show && itemSprout[sprout][sproutType]"
        :src="
          require('@/assets/plant/sprout/' + itemSprout[sprout][sproutType])
        "
      >
        <!-- pot layer -->
        <v-img
          style="position: relative; z-index: 2"
          :width="width"
          v-if="itemPot[pot][potColor]"
          :src="require('@/assets/plant/pot/' + itemPot[pot][potColor])"
        >
          <!-- character layer -->
          <v-img
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
    </transition>
  </div>
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
      show: true,
      characterType: "평범",
    };
  },
  methods: {
    async changeRandomCharacterType() {
      this.show = false;
      var keys = Object.keys(this.itemCharacter[this.character]);

      this.characterType = keys[(keys.length * Math.random()) << 0];

      this.show = true;
    },
  },
};
</script>

<style lang="scss" scoped>
.bounce-enter-active {
  animation: bounce-in 0.5s;
}
.bounce-leave-active {
  animation: bounce-in 0.5s reverse;
}
@keyframes bounce-in {
  0% {
    transform: scale(0);
  }
  50% {
    transform: scale(1.2);
  }
  100% {
    transform: scale(1);
  }
}
</style>