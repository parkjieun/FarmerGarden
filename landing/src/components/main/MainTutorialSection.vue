<template>
     <section
        id="features"
        class=" lighten-3 grey"
      >
        <div class="py-12"></div>

        <v-container class="text-center">
          <h2 class="display-3  mb-3" >
            <span class="font-weight-bold">이렇게</span> 
            사용하세요
          </h2>

          <v-responsive
            class="mx-auto mb-12"
            width="56"
          >
            <v-divider class="mb-1"></v-divider>

            <v-divider></v-divider>
          </v-responsive>

          <v-row>
            <v-col cols="12" md="4">
              <v-card class="py-12 px-4" color="grey lighten-5" flat   >
                <v-card-title class="justify-center font-weight-black text-uppercase">
                  <span  class="step">STEP1. </span> 씨앗을 심어주세요</v-card-title>
                <v-theme-provider dark>
                  <div >
                    <v-img src="@/assets/main/tuto/tuto1.gif" height="380" contain></v-img>
                  </div>
                </v-theme-provider>
              </v-card>
            </v-col>

            <v-col cols="12" md="4">
              <v-card class="py-12 px-4" color="grey lighten-5" flat >
                <v-card-title class="justify-center font-weight-black text-uppercase">
                  <span  class="step">STEP2. </span> 물을 넣어주세요</v-card-title>
                <v-theme-provider dark  >
                  <div >
                    <v-img src="@/assets/main/tuto/tuto2.gif" height="380" contain ></v-img>
                  </div>
                </v-theme-provider>
                
              </v-card>
            </v-col>

            <v-col cols="12" md="4" >
              <!-- style="overflow-y: auto; height:500px" -->
              <v-card class="py-12 px-4" color="grey lighten-5" flat >
                <v-card-title class="justify-center font-weight-black text-uppercase">
                  <span style="" class="step">STEP3. </span> 수확을 확인하세요
                </v-card-title>
                <v-theme-provider dark >
                  <div>
                    <v-img src="@/assets/main/tuto/tuto3.gif" height="380" contain></v-img>
                  </div>
                </v-theme-provider>
              </v-card>
            </v-col>

          </v-row>
        </v-container>

        <div class="py-12"></div>
      </section>
</template>


<script>
export default {
  name: "MainTutorialSection",
  data () {
    return {
    }
  }
}
</script>

<style scoped>
.step{
  color:#9ACA7F;font-size:1.8rem;padding-right:10px;
}
</style>  