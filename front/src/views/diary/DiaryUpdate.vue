<template>
<div>
	<!-- 네브바 -->
	<v-app-bar
		color="primary"
		dense
		dark
	>
		<v-app-bar-nav-icon @click="cancelForm"><v-icon>mdi-chevron-left</v-icon></v-app-bar-nav-icon>
    <v-spacer></v-spacer>
		<v-toolbar-title>{{createDate}}</v-toolbar-title>
		<v-spacer></v-spacer>
		<v-btn color="primary" @click="checkForm" style="min-width:48px;" class="pa-0">수정</v-btn>
	</v-app-bar>
  
	<v-form ref="form" style="width: 300px;" class="mx-auto">
		<div v-if="selectedImage" style="height: 200px;" class="rounded-lg my-5" @click="showPhoto=true"><v-img :src="selectedImage" alt="selected_image" width="300" class="rounded-lg"/></div>
		<v-row v-else style="height: 200px; border: lightgray 2px solid; width: 300px;" class="rounded-lg my-5 mx-auto" align="center" justify="center">
      <v-icon size="60" color="lightgray" @click="showPhoto=true">mdi-camera-outline</v-icon>
    </v-row>
		<v-text-field
			label="제목"
			name="title"
			type="text"
			hint="100자 이내로 작성해주세요."
			v-model="post.post_title"
			required
			dense
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
			v-model="post.post_contents"
			required
			dense
			outlined
			:rules="contentRules"
			autocapitalize="off"
			autocorrect="off"
			autocomplete="off"
		/>
		
  </v-form>
  <div v-if="showPhoto" style="position:absolute; left:0; top:0;">
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
			post: [],
			createDate: '',
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
					post_id: this.post.post_id,
					post_title: this.post.post_title,
					post_contents: this.post.post_contents,
					post_img: this.selectImage
				}
				http.put('/api/post', data, this.config)
				.then(res => {
					if (res.data == "success") {
            this.setPosts()
            this.$router.push({name: "PlantCalendar2"})
					}
				})
				.catch(err => console.log(err))	
			}
		},
		getPostInfo() {
			http.get(`/api/post/${this.$route.params.id}`, this.config)
			.then(res => {
				this.post = res.data
        this.selectedImage = res.data.post_img
        this.createDate = res.data.post_create.substring(0,4)+'년 '+res.data.post_create.substring(5,7)+'월 '+res.data.post_create.substring(8,10)+'일'
			})
		}
	},
	created() {
    this.getPostInfo()
	}
}
</script>

<style>
#div {
	background-color: rgba(#ffffff, 0,7);
	color:lightgray
}
</style>