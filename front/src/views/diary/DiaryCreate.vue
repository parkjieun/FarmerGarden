<template>
<div>
  <div class="text-h5 text-center pb-5" style="margin-top: calc(40vh - 220px);">재배일기 작성</div>
  <v-form ref="form" style="width: 300px;" class="mx-auto">
		<v-text-field
			label="제목"
			name="title"
			type="text"
			v-model="title"
			required
			autofocus
			outlined
			:rules="titleRules"
			autocapitalize="off"
			autocorrect="off"
			autocomplete="off"
		/>
		<v-textarea
			label="내용"
			name="content"
			hint="100자 이내로 작성해주세요."
			v-model="content"
			required
			outlined
			:rules="contentRules"
			autocapitalize="off"
			autocorrect="off"
			autocomplete="off"
		/>
		<div class="text-subtitle-1 mb-3">작물 사진 선택</div>
		<div style="overflow-x: scroll; display:flex; margin-bottom: 30px; height: 100px;">
			<v-img v-for="(image, index) in images" :key="index" 
				:src="image.src" :alt="image.alt" 
				:lazy-src="image.src"
				width="150" 
				@click="selectImage(index)" 
				class="mr-2 rounded-lg" 
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
		</div>
		<div class="text-right">
			<v-btn color="secondary" @click="cancelForm">취소</v-btn>
			<v-btn color="primary" class="ml-1" @click="checkForm">작성완료</v-btn>
		</div>
  </v-form>
</div>
</template>

<script>
import http from '@/utils/http-common'
import { mapGetters } from 'vuex'
export default {  
	data() {
		return {
			title: null,
			content: null,
			image: null,
			initialSelected: [],
			titleRules: [
				(value) => !!value || "제목을 입력해주세요",
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
					src:"https://picsum.photos/300/200",
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
			selectedImage: null ,
		}
	},
	computed: {
		...mapGetters(['config']),
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
		cancelForm() {
			this.$router.go(-1)
		},
		checkForm() {
			if (this.$refs.form.validate()) {
				const data = {
					post_title: this.title,
					post_contents: this.content,
					post_img: this.selectImage
				}
				http.post('/api/post', data, this.config)
				.then(res => {
					if (res.data == "success") {
						this.router.push({name: "PlantCalendar2"})
					}
				})
				.catch(err => console.log(err))
					
			}
		}
	}
}
</script>

<style>
</style>