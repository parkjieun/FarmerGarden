<template>
  <section id="hero">   
    <v-row no-gutters>
      <v-img
        :min-height="'calc(100vh - ' + $vuetify.application.top + 'px)'"
        src="@/assets/main/h5.png"
      >
        <v-theme-provider dark>
          <v-container fill-height>
            <v-row
              align="center"
              class="white--text mx-auto"
              justify="center"
            >
              <v-col
                class="white--text text-center"
                cols="12"
                tag="h1"
              >
                <!-- <span
                :class="[$vuetify.breakpoint.smAndDown ? 'display-1' : 'display-2']"
                  class="font-weight-light"
                  style="color:#333333"
                >
                  WELCOME TO
                </span>  
                <br>
                
                -->
                <span
                  class="font-weight-black "
                  :class="[$vuetify.breakpoint.smAndDown ? 'f-size80': 'f-size130']"
                >
                  <span class="nanum " >농부네 텃밭</span> 
                </span>

              </v-col>

              <v-btn
                class="align-self-end"
                fab
                color="#333333"
                @click="$vuetify.goTo('#about-me')"
              >
                <v-icon>mdi-chevron-double-down</v-icon>
              </v-btn>
              
            </v-row>
          </v-container>
        </v-theme-provider>
      </v-img>
    </v-row>
  </section>
</template>


<script>
export default {
  name: "MainImgSection",
}
</script>

<style>

</style>  