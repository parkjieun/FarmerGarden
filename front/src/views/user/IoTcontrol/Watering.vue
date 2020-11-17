<template>
 <div class="nbn--font d-flex flex-column justify-space-between align-center" style="padding-top:20px">
    <v-img 
      src="@/assets/IoTcontrol/watering.png"
      width="60%"
      v-show="!wateringFlag"
    />

    <v-img 
      src="@/assets/IoTcontrol/loading.gif"
      width="80%"
      v-show="wateringFlag"
    />

    <v-spacer style="padding-top:30px"></v-spacer>
    <v-btn color="primary" outlined rounded block elevation="7" @click="watering" :disabled="wateringFlag">수동 급수하기</v-btn>
    <v-col
      cols="12"
      sm="6"
      md="3"
    >
      <v-text-field
        v-show="wateringFlag"
        :value="message"
        color="success"
        readonly
        class="centered-input text--darken-3 mt-3"
      ></v-text-field>
      <div
        v-show="isDone"
        class="centered-input text--darken-3 mt-3"
        style="color: green; font-size: 1rem; font-weight: 700; text-align: center;"
      >
        {{ message }}
      </div>
    </v-col>
    <p style="height:600px"></p>
  </div>
</template>

<script>
import http from "@/utils/http-common";
import { mapGetters } from "vuex";

export default {
  name: "Watering",
  data() {
    return {
      wateringFlag: false,
      isDone: false,
      message: '',
    }
  },
  computed: {
    ...mapGetters(["user"]),
  },
  watch: {
    
  },
  methods: {
    watering() {
      this.wateringFlag=true
      console.log(this.user.choice_id + " dkdkdkdkdk ")
      if(this.user.choice_id == null){
        this.message = "재배 중인 작물이 없습니다."
        setTimeout(() => {
          this.wateringFlag=false
        }, 5000);
      }else if(this.user.user_id == '54c2018801dafce76b6aedafd47d3305'){
        this.message = "새싹 채소에 물을 주고 있습니다."
        http
          .get("/iot/iot-actions?action=water&choice_id="+this.user.choice_id)
          .then(() => {
            this.wateringFlag=false
            this.isDone = true
            this.message = "급수가 완료되었습니다."
            setTimeout(() => {
              this.isDone = false
            }, 5000);
          })
          .catch(() => {});
      }else {
        this.message = "테스트 계정으로는 수동 조작이 불가능합니다."
        setTimeout(() => {
          this.wateringFlag=false
        }, 5000);
      }
    },
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