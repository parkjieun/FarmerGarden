<template>
  <v-container>
    <!-- btn toolbar start -->
    <v-row no-gutters>
      <v-col cols="1"></v-col>
      <v-col cols="5">
        <v-btn class="nbn--btn" block text :to="{ name: 'PlantMain' }">
          취소
        </v-btn>
      </v-col>
      <v-col cols="5">
        <v-btn class="nbn--btn" block text @click="savePlantCharCostume"
          >저장</v-btn
        >
      </v-col>
      <v-col cols="1"></v-col>
    </v-row>
    <!-- btn toolbar end -->

    <!-- preview image start -->
    <v-row>
      <v-col cols="7" class="mx-auto">
        <v-container
          fluid
          class="fill-height nbn--preview"
          :style="{
            backgroundImage:
              'url(' +
              require('@/assets/plant/bgimage/' +
                itemBGImage[selectPlantCharInfo.bgimage]) +
              ')',
          }"
        >
          <v-row>
            <v-col class="mx-auto">
              <PlantCharacter
                v-if="plantCharInfo"
                v-bind="selectPlantCharInfo"
                width="100px"
              />
            </v-col>
          </v-row>
        </v-container>
      </v-col>
    </v-row>
    <!-- preview image end -->

    <!-- tabs slider group start -->
    <v-row>
      <!-- tabs start -->
      <v-tabs v-model="tab" centered>
        <v-tabs-slider></v-tabs-slider>
        <v-tab href="#tab-pot" v-text="'화분'" />
        <v-tab
          href="#tab-color"
          v-if="!oneColor.includes(selectPlantCharInfo.pot)"
          v-text="'색깔'"
        />
        <v-tab href="#tab-char" v-text="'캐릭터'" />
        <v-tab href="#tab-bgimage" v-text="'배경'" />
      </v-tabs>
      <!-- tabs end -->

      <v-tabs-items v-model="tab">
        <!-- pot tab start -->
        <v-tab-item value="tab-pot">
          <v-slide-group
            v-model="selectPlantCharInfo.pot"
            class="pa-4"
            mandatory
          >
            <v-slide-item
              v-for="(value, key, index) in itemPot"
              :key="index"
              :value="key"
              v-slot="{ active }"
            >
              <v-card
                :color="active ? 'primary' : ''"
                class="ma-4"
                height="160"
                width="120"
                @click="selectPotSlider(key)"
              >
                <v-img
                  height="160"
                  width="120"
                  position="bottom"
                  :src="
                    require('@/assets/plant/pot/' +
                      itemPot[key][selectPlantCharInfo.potColor])
                  "
                />
              </v-card>
            </v-slide-item>
          </v-slide-group>
        </v-tab-item>
        <!-- pot tab end -->

        <!-- pot color tab start -->
        <v-tab-item
          value="tab-color"
          v-if="!oneColor.includes(selectPlantCharInfo.pot)"
        >
          <v-slide-group
            v-model="selectPlantCharInfo.potColor"
            class="pa-4"
            mandatory
          >
            <v-slide-item
              v-for="(value, key, index) in itemPot[selectPlantCharInfo.pot]"
              :key="index"
              :value="key"
              v-slot="{ active }"
            >
              <v-card
                :color="active ? 'primary' : ''"
                class="ma-4"
                height="160"
                width="120"
                @click="selectPlantCharInfo.potColor = key"
              >
                <v-img
                  height="160"
                  width="120"
                  position="bottom"
                  :src="
                    require('@/assets/plant/pot/' +
                      itemPot[selectPlantCharInfo.pot][key])
                  "
                />
              </v-card>
            </v-slide-item>
          </v-slide-group>
        </v-tab-item>
        <!-- pot color tab end -->

        <!-- character tab start -->
        <v-tab-item value="tab-char">
          <v-slide-group
            v-model="selectPlantCharInfo.character"
            class="pa-4"
            mandatory
          >
            <v-slide-item
              v-for="(value, key, index) in itemCharacter"
              :key="index"
              :value="key"
              v-slot="{ active }"
            >
              <v-card
                :color="active ? 'primary' : ''"
                class="ma-4"
                height="160"
                width="120"
                @click="selectPlantCharInfo.character = key"
              >
                <v-img
                  height="160"
                  width="120"
                  position="bottom"
                  :src="
                    require('@/assets/plant/character/' +
                      itemCharacter[key]['평범'])
                  "
                />
              </v-card>
            </v-slide-item>
          </v-slide-group>
        </v-tab-item>
        <!-- character tab end -->

        <!-- bgimage start -->
        <v-tab-item value="tab-bgimage">
          <v-slide-group
            v-model="selectPlantCharInfo.bgimage"
            class="pa-4"
            mandatory
          >
            <v-slide-item
              v-for="(value, key, index) in itemBGImage"
              :key="index"
              :value="key"
              v-slot="{ active }"
            >
              <v-card
                :color="active ? 'primary' : ''"
                class="ma-4"
                height="160"
                width="120"
                @click="selectPlantCharInfo.bgimage = key"
              >
                <v-img
                  height="160"
                  width="120"
                  :src="require('@/assets/plant/bgimage/' + itemBGImage[key])"
                />
              </v-card>
            </v-slide-item>
          </v-slide-group>
        </v-tab-item>
        <!-- bgimage end -->
      </v-tabs-items>
    </v-row>
    <!-- tabs slider group end -->
  </v-container>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

import { mixinPlantCharInfo } from "@/mixins/mixinPlantCharInfo";

import PlantCharacter from "@/components/plant/PlantCharacter.vue";

export default {
  name: "PlantChoice",
  mixins: [mixinPlantCharInfo],
  data() {
    return {
      selectPlantCharInfo: {
        character: "기본",
        pot: "기본",
        potColor: "orange",
        sprout: "싹",
        sproutType: "1",
        bgimage: "1",
      },
      tab: null,
    };
  },
  components: {
    PlantCharacter,
  },
  mounted() {
    if (!this.plantCharInfo) {
      this.$router.push({ name: "PlantEmpty" });
    }
    this.selectPlantCharInfo = this.plantCharInfo;
  },
  computed: {
    ...mapGetters(["plantCharInfo"]),
  },
  methods: {
    ...mapActions(["setPlantCharInfo"]),
    selectPotSlider(key) {
      this.selectPlantCharInfo.pot = key;
      if (this.oneColor.includes(this.selectPlantCharInfo.pot)) {
        this.selectPlantCharInfo.potColor = "orange";
      }
    },
    selectPotColorSilder(key) {
      this.selectPlantCharInfo.potColor = key;
    },
    savePlantCharCostume() {
      this.setPlantCharInfo(this.selectPlantCharInfo);
      this.$router.push({ name: "PlantMain" });
    },
  },
};
</script>

<style lang="scss" scoped>
.nbn--preview {
  border: 5px solid #593016;
  background-position: center;
  background-repeat: no-repeat;
  background-size: 100% 100%;
}

.nbn--btn {
  color: var(--font1-color);
  font-size: 16px;
  font-family: "Jua", sans-serif;
}
</style>