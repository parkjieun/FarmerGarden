<template>
  <v-row>
    <v-avatar color="" size="56" id="moveButton"  @click="goService">
       <v-img 
          src="@/assets/main/movebtn.png" 
          contain
          max-height="100%"
        />
    </v-avatar>

    <v-img src="@/assets/top-arrow.png" id="scrollButton" @click="scrollToTop"></v-img>
  </v-row>
</template>

<script>
export default {
  name: 'ScrollTop',
  components: {
  },
  data() {
    return {
      windowTop: 0,
    }
  },
  watch: {
    windowTop: function() {
        if (this.windowTop > 700) {
            let btn = document.getElementById('scrollButton')
            let btn2 = document.getElementById('moveButton')

            btn.style.display = 'block'
            btn2.style.display = 'block'
        }
        else {
            let btn = document.getElementById('scrollButton')
            let btn2 = document.getElementById('moveButton')

            btn.style.display = 'none'
            btn2.style.display = 'none'
        }
    }
  },
  mounted() {
      window.addEventListener("scroll", this.onScroll)
  },
  beforeDestroy() {
      window.removeEventListener("scroll", this.onScroll);
  },
  methods: {
      scrollToTop() {
          window.scroll({top: 0, left: 0, behavior: 'smooth'})
      },
      onScroll(e) {
          this.windowTop = e.target.documentElement.scrollTop;
      },
      goService(){
        this.$router.push({ name: "SplashScreen" });
      }
  }
  
}
</script>

<style scoped>
 #scrollButton {
   z-index: 100;
    position: fixed;
    display: none;
    bottom: 150px;
    right: 30px;
    cursor: pointer;
}
 #moveButton {
   z-index: 100;
    position: fixed;
    display: none;
    bottom: 230px;
    right: 30px;
    cursor: pointer;
}
</style>
