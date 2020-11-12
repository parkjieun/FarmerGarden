<template>
<div>
  <v-app-bar
		color="primary"
		dense
		dark
	>
		<v-app-bar-nav-icon @click="cancelForm"><v-icon>mdi-chevron-left</v-icon></v-app-bar-nav-icon>
    <v-spacer></v-spacer>
		<v-toolbar-title>오늘의 일기</v-toolbar-title>
		<v-spacer></v-spacer>
		<v-btn color="primary" @click="checkForm" class="px-0" style="min-width:48px;">완료</v-btn>
	</v-app-bar>
  <v-form ref="form" style="width: 300px;" class="mx-auto">
    <div v-if="selectedImage" style="height: 200px;" class="rounded-lg my-5" @click="showPhoto=true">
      <v-img :src="selectedImage" alt="selected_image" width="300" class="rounded-lg"/>
    </div>
		<v-row v-else style="height: 200px; border: lightgray 2px solid; width: 300px;" class="rounded-lg my-5 mx-auto" align="center" justify="center">
      <v-icon size="60" color="lightgray" @click="showPhoto=true">mdi-camera-outline</v-icon>
    </v-row>
		<v-text-field
			label="제목"
			name="title"
			type="text"
			hint="100자 이내로 작성해주세요."
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
			v-model="content"
			required
			outlined
			:rules="contentRules"
			autocapitalize="off"
			autocorrect="off"
			autocomplete="off"
		/>
		
		<div class="text-right">
			<v-btn color="secondary" @click="cancelForm">취소</v-btn>
			<v-btn color="primary" class="ml-1" @click="checkForm">작성완료</v-btn>
		</div>
  </v-form>
  <div v-if="showPhoto" style="position:absolute; right:0; top:0;">
    <PhotoSelect id="picture_select" @closePhoto="showPhoto=false" @selectPhoto="(val) => selectedImage = val"/>
  </div>
</div>
</template>

<script>
import http from '@/utils/http-common'
import { mapGetters, mapActions } from 'vuex'

import PhotoSelect from '@/components/diary/PhotoSelect.vue'

export default {  
	components: {
    PhotoSelect
  },
	data() {
		return {
			title: null,
			content: null,
			titleRules: [
				(value) => !!value || "제목을 입력해주세요",
				(value) => (value && value.length) < 100 || '제목의 길이가 100자 이내여야 합니다.'
			],
			contentRules: [
				(value) => !!value || "내용을 입력해주세요",
			],
      showPhoto: false,
			selectedImage: null ,
		}
	},
	computed: {
		...mapGetters(['config']),
	},
	methods: {
		...mapActions(['setPosts']),
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
						this.setPosts()
						this.$router.push({name: "PlantCalendar2"})
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