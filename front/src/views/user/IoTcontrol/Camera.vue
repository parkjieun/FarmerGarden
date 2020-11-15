<template>
  <v-container>
    <div class="nbn--font d-flex flex-column justify-space-between align-center" style="padding-top:20px">
        <v-img 
          src="@/assets/IoTcontrol/camera.png"
          width="50%"
          v-show="!camFlag"
        />

        <v-img 
          src="@/assets/IoTcontrol/loading.gif"
          width="80%"
          v-show="camFlag"
        />

        <v-spacer style="padding-top:30px"></v-spacer>
        <v-btn color="primary" outlined rounded block elevation="7" @click="takePicture" :disabled="camFlag">사진 찍기</v-btn>
        <v-col
          cols="12"
          sm="6"
          md="3"
        >
          <v-text-field
            v-show="camFlag"
            :value="message"
            color="success"
            readonly
            class="centered-input text--darken-3 mt-3"
          ></v-text-field>
        </v-col>
        <v-col cols="12">
          <div
            v-show="isDone"
            class="centered-input text--darken-3 mt-3"
            style="color: green; font-size: 1rem; font-weight: 700; text-align: center;"
          >
            {{ message }}
          </div>
          <v-spacer style="padding-top:30px"></v-spacer>
          <v-card
            v-show="isDone"
          >
            <v-img
              :src="'http://k3a105.p.ssafy.io/iot'+currentPicture"
              max-height="200"
              class="grey darken-4"
            ></v-img>
          </v-card>
        </v-col>
        <p style="height:300px"></p>
      </div>
  </v-container>
</template>

<script>
import http from "@/utils/http-common";
import { mapGetters } from "vuex";

export default {
  name: "Watering",
  data() {
    return {
      camFlag: false,
      isDone: false,
      message: '',
      currentPicture: '',
    }
  },
  computed: {
    ...mapGetters(["user"]),
  },
  watch: {
    
  },
  methods: {
    takePicture() {
      this.camFlag=true
      this.isDone = false
      if(this.user.choice_id == null){
        this.message = "재배 중인 작물이 없습니다."
        setTimeout(() => {
          this.camFlag=false
        }, 5000);
      }else if(this.user.user_id == '54c2018801dafce76b6aedafd47d3305'){
        this.message = "사진을 찍고 있습니다."
        http
          .get("/iot/iot-actions?action=camera&choice_id="+this.user.choice_id)
          .then(() => {
            this.camFlag=false
            this.isDone = true
            this.message = "촬영 사진이 저장되었습니다."
            this.getCurrentPicture();
          })
          .catch(() => {});
      }else {
        this.message = "기기를 구입해 주세요."
        setTimeout(() => {
          this.camFlag=false
        }, 5000);
      }
    },
    getCurrentPicture() {
      http
        .get("/iot/pictured-img?choice_id="+this.user.choice_id)
        .then((res) => {
          console.log(res.data)
          this.currentPicture = res.data.rb_img
        })
        .catch(() => {});
    }
  },
};
</script>

<style lang="scss" scoped>
.nbn--font {
  font-family: "Handon3gyeopsal300g";
}
.centered-input >>> input {
  text-align: center
}
</style>