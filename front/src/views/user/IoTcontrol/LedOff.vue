<template>
 <div class="nbn--font d-flex flex-column justify-space-between align-center" style="padding-top:20px">
    <v-img 
      src="@/assets/IoTcontrol/led_off.png"
      width="50%"
      v-show="!ledFlag"
    />

    <v-img 
      src="@/assets/IoTcontrol/loading.gif"
      width="80%"
      v-show="ledFlag"
    />

    <v-spacer style="padding-top:30px"></v-spacer>
    <v-btn color="primary" outlined rounded block elevation="7" @click="onLED" :disabled="ledFlag">LED 끄기</v-btn>
    <v-col
      cols="12"
      sm="6"
      md="3"
    >
      <v-text-field
        v-show="ledFlag"
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
      ledFlag: false,
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
    onLED() {
      this.ledFlag=true
      if(this.user.choice_id == null){
        this.message = "재배 중인 작물이 없습니다."
        setTimeout(() => {
          this.ledFlag=false
        }, 5000);
      }else if(this.user.user_id == '54c2018801dafce76b6aedafd47d3305'){
        this.message = "LED를 끄고 있습니다."
        http
          .get("/iot/iot-actions?action=ledoff&choice_id="+this.user.choice_id)
          .then(() => {
            this.ledFlag=false
            this.isDone = true
            this.message = "LED가 꺼졌습니다."
            setTimeout(() => {
              this.isDone = false
            }, 5000);
          })
          .catch(() => {});
      }else {
        this.message = "기기를 구입해 주세요."
        setTimeout(() => {
          this.ledFlag=false
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