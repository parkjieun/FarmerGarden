<template>
    <v-dialog 
      v-model="dialogDevice"
      persistent
      max-width="290"
    >
      <v-card>
        <v-card-title class="headline">연결 가능 디바이스</v-card-title>

        <v-card-text>
          <v-radio-group v-model="tempDevice" row >             
            <v-radio  row  v-for="(v,index) in devices" :key="v" 
                :label=v color="primary" :value=devices_hash[index] class="selectDevice"
              >
            </v-radio>
          </v-radio-group>
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="primary"   @click="close">취소</v-btn>
          <v-btn color="primary"   @click="addDevice" v-show="deviceAddFlag">등록</v-btn>
          <v-btn color="primary"   @click="chageDevice" v-show="!deviceAddFlag">수정</v-btn>
        </v-card-actions>

      </v-card>
    </v-dialog>
</template>

<script>
import http from '@/utils/http-common'
import { mapGetters } from "vuex";

export default {
  name: "DeviceUpdate",
  props: ['dialogDevice'],
  data() {
    return {
      tempDevice: "",
      selectDevice : "",
      devices : ["NBP317MKBT23","NBP420MKBT20","NBP117MKBT21"],
      devices_hash :["bfb83a75a5e823be0da9377da7b40731", "4653b2ca93ccb85d35bfe597cb02d3de", "fe2a7f30aad93187a860f1106dfa1709"],
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
        //console.log(device)
        this.selectDevice=device
        this.tempDevice = this.selectDevice
        this.deviceAddFlag=false
      }else{
        this.deviceAddFlag=true
      }
    })
  },
  methods: {
    close(){
      this.tempDevice = this.selectDevice
      this.$emit("closeForm", "cancel")
    },
    selectIndex(){
      for (let i=0; i<this.devices_hash.length; i++) {
          if (this.tempDevice == this.devices_hash[i]) {  //바로 key속성 가져오는법?????????
              return i; 
          }
      }
    },
    chageDevice(){
      const frm = new FormData();
      frm.append("device_id",this.devices[this.selectIndex()])

      http.put("/api/device", frm, this.config)
      .then(() => {
        this.selectDevice = this.tempDevice
        this.close()
      })

    },
    addDevice(){
      const frm = new FormData();
      frm.append("device_id",this.devices[this.selectIndex()])

      http.post("/api/device", frm, this.config)
      .then(() => {
        this.selectDevice = this.tempDevice
        this.deviceAddFlag = false
        this.close()
      })

    },
  },
};
</script>

<style lang="scss" scoped>
</style>