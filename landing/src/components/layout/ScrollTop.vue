<template>
       <v-row>
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
            btn.style.display = 'block'
        }
        else {
            let btn = document.getElementById('scrollButton')
            btn.style.display = 'none'
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
      }
  }
  
}
</script>

<style scoped>
 #scrollButton {
   z-index: 10;
    position: fixed;
    display: none;
    bottom: 150px;
    right: 30px;
    cursor: pointer;
}
</style>
