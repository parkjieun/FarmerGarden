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
      <v-img :src="selectedImage.src" aspect-ratio="1.5"/>
    </div>
    <div v-else>
      <v-img :src="images[0].src"/>
    </div>
    <v-row class="ma-0">
      <v-col cols="4" sm="3" md="2" v-for="(image, index) in images" :key="index" class="pa-0">
        <v-img
          aspect-ratio="1.5"
          :src="image.src" :alt="image.alt" 
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
			images: [
				{   
					id: 1,
					src:"https://picsum.photos/300/200",
					alt: "sample_image1"
				},
				{
					id: 2,
					src:"https://picsum.photos/seed/picsum/200/300",
					alt: "sample_image2"
				},
				{
					id: 3,
					src:"https://picsum.photos/300/200",
					alt: "sample_image3"
				},
				{
					id: 4,
					src:"https://picsum.photos/300/200",
					alt: "sample_image4"
				},
				{
					id: 5,
					src:"https://picsum.photos/300/200",
					alt: "sample_image5"
        },
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
      this.$emit('selectPhoto', this.selectedImage)
      this.closeForm()
    }
  }

}
</script>

<style>
#div {
  color: #41ffd6
}
</style>