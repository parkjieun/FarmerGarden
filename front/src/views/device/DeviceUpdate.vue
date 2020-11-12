<template>
 <div class="nbn--font" style="padding-top:20px">
    <v-text-field
      v-model="deviceName"
      :rules="deviceNameRules"
      :counter="20"
      label="디바이스명을 입력해주세요"
      required
    ></v-text-field>

    <v-spacer style="padding-top:30px"></v-spacer>
    <v-btn color="primary" outlined rounded block elevation="11" @click="addDevice" v-show="deviceAddFlag">등  록</v-btn>
    <v-btn color="primary"  outlined rounded block elevation="5" @click="chageDevice" v-show="!deviceAddFlag">변  경</v-btn>
    <p style="height:650px"></p>
  </div>
</template>

<script>
import http from '@/utils/http-common'

import { mapGetters } from "vuex";

export default {
  name: "DeviceUpdate",
  data() {
    return {
      deviceName: "",
      deviceNameRules: [
        v => !!v || '디바이스명은 필수 입니다',
        v => (v && v.length >= 5) || '디바이스명은 5글자 이상입니다',
      ],
      deviceAddFlag : true,
    }
  },
  components: {
  },
  computed: {
     ...mapGetters(["config"]),
  },
  created() {
    //디바이스 정보불러오기
    http.get("/api/device", this.config)
    .then(res => {
      let device = res.data.device_id
      if(device!=null){
        this.deviceName=device
        this.deviceAddFlag=false
      }else{
        this.deviceAddFlag=true
      }
    })
  },
  methods: {
    close(){
    },
    chageDevice(){
      if(this.deviceName.length>=5){
        const frm = new FormData();
        frm.append("device_id",this.deviceName)

        http.put("/api/device", frm, this.config)
        .then(() => {
        })
      }
    },
    addDevice(){
      if(this.deviceName.length>=5){
        const frm = new FormData();
        frm.append("device_id",this.deviceName)

        http.post("/api/device", frm, this.config)
        .then(() => {
           this.deviceAddFlag=false
        })
      }
    },
  },
};
</script>

<style lang="scss" scoped>

.nbn--font {
  font-family: "Handon3gyeopsal300g";
}
</style>