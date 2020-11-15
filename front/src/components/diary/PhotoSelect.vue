<template>
<div style="width: 100vw;">
  <v-app-bar
		color="primary"
		dense
		dark
	>
		<v-app-bar-nav-icon @click="closeForm"><v-icon>mdi-chevron-left</v-icon></v-app-bar-nav-icon>
    <v-spacer></v-spacer>
		<v-toolbar-title>작물사진 선택</v-toolbar-title>
		<v-spacer></v-spacer>
		<v-btn color="primary" @click="select">완료</v-btn>
	</v-app-bar>
  <div style="height: calc(100vh - 104px); overflow-y:scroll; background-color:white;">
    <div v-if="selectedImage">
      <v-img :src="'http://k3a105.p.ssafy.io:8001/'+selectedImage.rb_img"/>
    </div>
    <div v-else>
      <v-img :src="'http://k3a105.p.ssafy.io:8001/'+images[0].rb_img"/>
    </div>
    <v-row class="ma-0">
      <v-col cols="4" sm="3" md="2" v-for="(image, index) in images" :key="index" class="pa-0">
        <v-img
          aspect-ratio="1.5"
          :src="'http://k3a105.p.ssafy.io:8001/'+image.rb_img" alt="image" 
          :lazy-src="image.src"
          @click="selectImage(index)" 
          :id="'image-'+index"
        >
          <template v-slot:placeholder>
            <v-row
              class="fill-height ma-0"
              align="center"
              justify="center"
            >
              <v-progress-circular
              indeterminate
              color="primary lighten-5"
              ></v-progress-circular>
            </v-row>
          </template>
          <template v-slot:default>
            <v-row
              v-if="selectedImage==image"
              class="fill-height ma-0"
              align="center"
              justify="center"
              style="background-color:rgba(255, 255, 255, 0.5); "
            >
              <v-icon
              color="primary" size="2rem"
              >mdi-check-circle-outline</v-icon>
            </v-row>
          </template>
        </v-img>
      </v-col>
    </v-row>
  </div>
</div>
</template>

<script>
export default {
  props: ['images'],
  data() {
		return {
			post: [],
			titleRules: [
				(value) => !!value || "제목을 입력해주세요",
				(value) => (value && value.length) < 100 || '제목의 길이가 100자 이내여야 합니다.'
			],
			contentRules: [
				(value) => !!value || "내용을 입력해주세요",
			],
      selectedImage: null,
		}
  },
  methods: {
		selectImage(index) {
			if (this.selectedImage == this.images[index]) {   
				this.selectedImage = null
			}
			else {
				this.selectedImage = this.images[index]
			}
    },
    closeForm() {
      this.$emit('closePhoto')
    },
    select() {
      this.$emit('selectPhoto', this.selectedImage.rb_img)
      this.closeForm()
    },
  }

}
</script>

<style>
#div {
  color: #41ffd6
}
</style>