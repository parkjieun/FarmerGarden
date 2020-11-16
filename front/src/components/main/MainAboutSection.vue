<template>
      <section id="about-me" class="nbp">
        <div class="py-12"></div>

        <v-container class="text-center">
          <h2 class="display-3 font-weight-bold mb-3 ">
            <v-img 
                  src="@/assets/main/about/head2.png" 
                  contain
                  max-height="100%"
                />
          </h2>

          <v-responsive
            class="mx-auto mb-8"
            width="56"
          >
            <v-divider class="mb-1"></v-divider>

            <v-divider></v-divider>
          </v-responsive>

          <v-responsive
            class="mx-auto title font-weight-light mb-8"
            max-width="900"
          >

            <h2 style="">
              <v-img 
                  src="@/assets/main/about/vision5.png" 
                  contain
                  max-height="100%"
                />
            </h2>
            <v-spacer style="padding-bottom:100px"></v-spacer>

            <v-row>
              <v-col cols="12" md="12">            
                 <v-img 
                  src="@/assets/main/about/checkpoint.png" 
                  contain
                  max-height="100%"
                />
              </v-col>
              <v-col cols="6" md="6">            
                <v-img 
                  src="@/assets/main/about/sprout.jpg" 
                  contain
                  max-height="100%"
                />
              </v-col>
              <v-col cols="6" md="6">
                <v-img 
                  src="@/assets/main/about/point1.png" 
                  contain
                  max-height="100%"
                />
              </v-col>

              <v-col cols="6" md="6" style="">
                <v-img 
                  src="@/assets/main/about/point2.png" 
                  contain
                  max-height="100%"
                />
              </v-col>
              <v-col cols="6" md="6" >
                <v-img 
                  src="@/assets/main/about/iot2.jpg" 
                  contain
                  max-height="100%"
                />
              </v-col>

              <v-col cols="6" md="6" >
                <v-img 
                  src="@/assets/main/about/busy.jpg" 
                  contain
                  max-height="100%"
                />
              </v-col>
              <v-col cols="6" md="6" >
                <v-img 
                  src="@/assets/main/about/point3.png" 
                  contain
                  max-height="100%"
                />
              </v-col>
              
              <v-col cols="12" md="12">
                <v-img 
                  src="@/assets/main/about/iot3.png" 
                  contain
                  max-height="100%"
                />
              </v-col>
            </v-row>
              <v-img 
                  src="@/assets/main/about/word2.png" 
                  contain
                  max-height="100%"
                />

          </v-responsive>

          <!-- <v-avatar
            class="mb-12"
            tile
            size="128"
          >
            <v-img 
              src="@/assets/main/about/logo3.gif" 
              contain
              max-height="100%"
            >
            </v-img>
          </v-avatar> -->
          
          <div></div>
          
          <v-btn
            color="grey"
            outlined
            large
            href="/instruction_manual.pdf" download
          >
            <span class="grey--text text--darken-1 font-weight-bold">
              취급설명서 다운로드
            </span>
          </v-btn>

          <!-- <v-btn
            color="grey"
            outlined
            large
            href="/nongbunae.apk" download
          >
            <span class="grey--text text--darken-1 font-weight-bold">
              모바일앱 다운로드
            </span>
          </v-btn> -->

        </v-container>

        <div class="py-12"></div>
      </section>
</template>


<script>
// import axios from 'axios';

export default {
  name: "MainAboutSection",
   methods: {
     download(){

     }
    },
}
</script>

<style scoped>
.nbp{
  font-family: NanumBarunpen; 
}
</style>  