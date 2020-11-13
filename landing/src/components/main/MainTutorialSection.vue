<template>
     <section
        id="features"
        class=" lighten-3"
      >
        <div class="py-12"></div>

        <v-container class="text-center">
          <h2 class="display-2 font-weight-bold mb-3" >‘농부네 텃밭’ 사용방법</h2>

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
                <v-card-title class="justify-center font-weight-black text-uppercase">1.씨앗을 심어주세요</v-card-title>
                <v-theme-provider dark >
                  <div>
                    <v-img src="@/assets/main/tuto/tuto1.gif" height="250px"></v-img>
                  </div>
                </v-theme-provider>
              </v-card>
            </v-col>

            <v-col cols="12" md="4">
              <v-card class="py-12 px-4" color="grey lighten-5" flat>
                <v-card-title class="justify-center font-weight-black text-uppercase">2.물을 넣어주세요</v-card-title>
                <v-theme-provider dark>
                  <div>
                    <v-img src="@/assets/main/tuto/tuto2.gif" height="250px"></v-img>
                  </div>
                </v-theme-provider>
              </v-card>
            </v-col>

            <v-col cols="12" md="4">
              <v-card class="py-12 px-4" color="grey lighten-5" flat>
                <v-card-title class="justify-center font-weight-black text-uppercase">3.수확을 확인하세요</v-card-title>
                <v-theme-provider dark>
                  <div>
                    <v-img src="@/assets/main/tuto/tuto3.gif" height="250px"></v-img>
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

<style>

</style>  