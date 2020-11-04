<template>
<div class="mx-auto" style="width: 300px; margin-top: calc(40vh - 120px)">
  <v-form ref="form">
      <div class="text-h5 my-4 text-center">추가 정보</div>
      <v-row>
        <v-col cols="7" class="py-0"><v-text-field id="postcode" label="우편번호" v-model="addressData.postcode" required @click="execDaumPostcode()"/></v-col>
        <v-col cols="5" class="py-0"><v-btn color="primary" small @click="execDaumPostcode()" class="mt-4 float-right">우편번호 찾기</v-btn></v-col>
      </v-row>

      <v-text-field id="address" v-model="addressData.address" label="주소" class="mt-0 pt-0" required @click="execDaumPostcode()"/>
      <v-row>
        <v-col cols="7" class="pt-0"><v-text-field id="detailAddress" v-model="addressData.detailAddress" label="상세주소" class="mt-0 pt-0" required :rules="detailAddressRules"/></v-col>
        <v-col cols="5" class="pt-0"><v-text-field id="extraAddress" v-model="addressData.extraAddress" label="참고항목" class="mt-0 pt-0"/></v-col>
      </v-row>
      <div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
        <img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:5px;top:-3px;z-index:1" @click="closeDaumPostcode()" alt="닫기 버튼">
      </div>
      <v-btn @click="checkForm()" color="primary" width="100%" class="mt-5"> 회원가입 </v-btn>
  </v-form>
</div>
</template>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
import http from '@/utils/http-common'
import { mapState } from 'vuex'
export default {
  data() {
      return {
        addressData: {
          postcode: '',
          address: '',
          detailAddress: '',
          extraAddress: ''
        },
        detailAddressRules: [
            (value) => !!value || "상세 주소를 입력해주세요."
        ],
      }
  },
  computed: {
      ...mapState(['socialData'])
  },
  methods: {
      checkForm() {
        if (this.$refs.form.validate()) {
            var addr = this.addressData.address + ' ' +this.addressData.detailAddress
            const data = this.socialData
            const frm = new FormData();
            frm.append("user_address", addr)
            frm.append("social_id", data.socialId)
            frm.append("user_name", data.userName)
            http.post("/user/signup", frm, {
                headers: {
                    Authorization: "Bearer "+data.accessToken
                }
            })
            .then(res => {
                console.log(res, "회원가입 결과")
                this.$router.push({name: "PlantMain"})
            })    
            .catch(res => {
                console.log("회원가입 catch"+res)
            })
        }
      },
      addressForm(data) {
      var element_layer = document.getElementById('layer');
      var addr = ''; // 주소 변수
      var extraAddr = ''; // 참고항목 변수
         
      if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
          addr = data.roadAddress;
      } else { // 사용자가 지번 주소를 선택했을 경우(J)
          addr = data.jibunAddress;
      }

      if(data.userSelectedType === 'R'){
          if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
              extraAddr += data.bname;
          }
          if(data.buildingName !== '' && data.apartment === 'Y'){
              extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
          }
          if(extraAddr !== ''){
              extraAddr = ' (' + extraAddr + ')';
          }
          this.addressData.extraAddress = extraAddr
      } else {
          this.addressData.extraAddress = ''
      }
      // 우편번호와 주소 정보를 해당 필드에 넣는다.
      this.addressData.address = addr
      this.addressData.postcode = data.zonecode
      // 커서를 상세주소 필드로 이동한다.
      document.getElementById("detailAddress").focus();
      element_layer.style.display = 'none';
    },
    closeDaumPostcode() {
      // iframe을 넣은 element를 안보이게 한다.
      var element_layer = document.getElementById('layer');
      element_layer.style.display = 'none';
    },
    execDaumPostcode() {
      
      var element_layer = document.getElementById('layer');
      new daum.Postcode({
        oncomplete: this.addressForm,
        width : '100%',
        height : '100%',
        maxSuggestItems : 5
      }).embed(element_layer);

      // iframe을 넣은 element를 보이게 한다.
      element_layer.style.display = 'block';

      // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
      this.initLayerPosition();
    },

    // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
    // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
    // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
    initLayerPosition(){
      var element_layer = document.getElementById('layer');
      var width = 330; //우편번호서비스가 들어갈 element의 width
      var height = 400; //우편번호서비스가 들어갈 element의 height
      var borderWidth = 5; //샘플에서 사용하는 border의 두께

      // 위에서 선언한 값들을 실제 element에 넣는다.
      element_layer.style.width = width + 'px';
      element_layer.style.height = height + 'px';
      element_layer.style.border = borderWidth + 'px solid';
      // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
      element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
      element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
    },
  
  }
}
</script>

<style>

</style>