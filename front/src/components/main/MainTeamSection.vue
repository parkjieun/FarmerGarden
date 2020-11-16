<template>
  <section id="stats">
    <v-parallax
      :height="$vuetify.breakpoint.smAndDown ? 700 : 500" 
      src="@/assets/main/team/iot.png"
      style="width:100% !important"
    >
      <v-container fill-height>
        <v-row class="mx-auto " style="text-align:center !important">
         

          <v-col cols="12" md="12" >
            <div>
              <div class="display-3 font-weight-black mb-4" >        
                <!-- <v-img  contain src="@/assets/word.png"></v-img> -->
              </div>
            </div>
          </v-col> 

        </v-row>
      </v-container>
    </v-parallax>
  </section>
</template>


<script>
export default {
  name: "MainStateSection",
  data () {
    return {
    }
  },
}
</script>

<style scoped>
.nbp{
  font-family: NanumBarunpen; 
}
</style>  