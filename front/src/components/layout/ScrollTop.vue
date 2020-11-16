<template>
  <v-row>
       <v-avatar color="#fff" size="56" id="moveButton"  @click="goService">
       <v-img 
          src="@/assets/main/movebtn.png" 
          contain
          max-height="100%"
        />
      </v-avatar>
  </v-row>
</template>

<script>
export default {
  name: 'ScrollTop',
  components: {
  },
  data() {
    return {
    }
  },
  methods: {
      goService(){
        this.$router.push({ name: "SplashScreen" });
      }
  }
}
</script>

<style scoped>

 #moveButton {
   z-index: 110;
    position: fixed;
    display: block;
    bottom: 150px;
    right: 30px;
    cursor: pointer;
}
</style>
