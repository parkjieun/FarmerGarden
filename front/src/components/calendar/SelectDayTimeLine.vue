<template>
  <v-timeline align-top dense class="mt-3" style="overflow: scroll; height: calc(100vh - 200px); width: 100%">
		<div v-if="selectPosts.length>0">
			<v-timeline-item v-for="(post, index) in selectPosts" :key="index" :color="colors[index%2]" class="mr-3" icon="mdi-sprout">
				<v-card @click.prevent="detailPage(post.post_id)">
					<v-card-title style="font-family: 'Jua', sans-serif!important;">{{post.post_title}}</v-card-title>
					<v-card-subtitle style="font-family: 'Jua', sans-serif!important;">{{post.post_create}}</v-card-subtitle>
					<v-img v-if="post.post_img" :src="'http://k3a105.p.ssafy.io:8001/'+post.post_img" alt="post_img"/>
				</v-card>
			</v-timeline-item>
    </div>
		<div v-else>
			<v-timeline-item icon="mdi-sprout" class="mr-3">
				<v-card>
					<div class="pa-5" style="font-family: 'Jua', sans-serif!important;">{{day}} 에는 작성한 글이 없어요</div>
				</v-card>
				<v-btn @click="showAll" class="mt-3" color="primary" style="font-family: 'Jua', sans-serif!important;" outlined rounded block>모든 글 보기</v-btn>
			</v-timeline-item>
			
		</div>
    </v-timeline>
</template>

<script>
import { mapState } from 'vuex'
export default {
	props: ['day'],
  data() {
    return {
			colors: ['primary', 'secondary'],
			
    }
  },
  computed: {
		...mapState(['posts']),
		selectPosts() {
			return this.posts.filter((post) => post.post_create.substring(0,10)==this.day && post.del_flag==false)
		}
	},
	watch: {
		day() {
			this.selectPosts = this.posts.filter((post) => post.post_create.substring(0,10)==this.day)
		}
	},
  methods: {
    detailPage(post_id) {
      this.$router.push({name: 'DiaryDetail', params: {id: post_id}})
		},
		showAll() {
			this.$emit('showAll')
		}
  }

}
</script>

<style>

</style>