<template>
	<div>
		<v-app-bar
			color="primary"
			dense
			dark
		>
			<v-app-bar-nav-icon @click="prePage"><v-icon>mdi-chevron-left</v-icon></v-app-bar-nav-icon>
			<v-spacer></v-spacer>
			<v-toolbar-title style="font-family: 'Jua', sans-serif!important;">{{createDate}}</v-toolbar-title>
			<v-spacer></v-spacer>
			<v-btn color="primary" @click="updatePage" style="min-width:48px; font-family: 'Jua', sans-serif!important;" class="pa-0">수정</v-btn>
		</v-app-bar>
  
		<div style="width: 300px;" class="mx-auto">
			<div class="text-h5 mt-5" style="font-family: 'Jua', sans-serif!important;">{{post.post_title}}</div>
			<div class="text-caption text-right my-2" style="font-family: 'Jua', sans-serif!important;">작성일: {{post.post_create}}</div>
			<v-divider></v-divider>
			<div v-if="post.post_img != null" style="height: 200px;" class="rounded-lg my-3" @click="showPhoto=true">
        <v-img :src="'http://k3a105.p.ssafy.io:8001/'+post.post_img" alt="selected_image" width="300" height="200" class="rounded-lg"/>
        </div>
			<div v-else style="height: 200px; border: lightgray 2px solid; width: 300px;" class="rounded-lg my-3 mx-auto">
				<v-icon size="60" color="lightgray" class="mx-auto" style="width: 300px; margin-top: 50px;">mdi-camera-outline</v-icon>
				<div class="text-caption text-center" style="font-family: 'Jua', sans-serif!important;">이미지가 없습니다.</div>
			</div>
		
			
			<div class="mt-5" style="font-family: 'Jua', sans-serif!important;">{{post.post_contents}}</div>
		</div>
  </div>
</template>

<script>
import http from '@/utils/http-common'
import { mapGetters } from 'vuex'
export default {
  data() {
    return {
      post: '',
      createDate: ''
    }
  },
  computed: {
    ...mapGetters(['config'])
  },
  methods: {
    prePage() {
      this.$router.go(-1)
    },
    updatePage() {
      this.$router.push({name: 'DiaryUpdate', params: { id: this.post.post_id }})
    },
    getPost() {
      http.get('/api/post/'+this.$route.params.id, this.config)
      .then(res => {
        this.post = res.data
        this.createDate = res.data.post_create.substring(0,4)+'년 '+res.data.post_create.substring(5,7)+'월 '+res.data.post_create.substring(8,10)+'일'
      })

    }
  },
  created() {
    this.getPost()
  }

}
</script>

<style>

</style>