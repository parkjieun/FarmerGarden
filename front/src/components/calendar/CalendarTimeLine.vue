<template>
  <v-timeline align-top dense class="mt-3" style="overflow: scroll; height: calc(100vh - 200px); width: 100%;">
    <v-timeline-item v-for="(post, index) in posts" :key="index" :color="colors[index%2]" v-if="post.del_flag==false" icon="mdi-sprout">
      <v-card @click.prevent="detailPage(post.post_id)" class="mr-3">
        <v-card-title style="font-family: 'Jua', sans-serif!important;">{{post.post_title}}</v-card-title>
        <v-card-subtitle style="font-family: 'Jua', sans-serif!important;">{{post.post_create}}</v-card-subtitle>
        <v-img v-if="post.post_img" :src="'http://k3a105.p.ssafy.io:8001/'+post.post_img" alt="post_img"/>
      </v-card>
    </v-timeline-item>
      
    </v-timeline>
</template>

<script>
import { mapState } from 'vuex'
export default {
  data() {
    return {
      colors: ['primary', 'secondary'],
    }
  },
  computed: {
    ...mapState(['posts']),
  },
  filters: {
    
  },
  methods: {
    detailPage(post_id) {
      this.$router.push({name: 'DiaryDetail', params: {id: post_id}})
    },
    dateFormat: function(value) {
      // value = value.toString()
      return value
    },
    showOptions() {
      console.log("gh")
    }
  }

}
</script>

<style>

</style>