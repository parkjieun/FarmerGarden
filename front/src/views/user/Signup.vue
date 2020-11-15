<template>
  <div>
    <div class="text-h5 text-center pb-5" style="margin-top: calc(40vh - 220px);"><v-img :src="require('@/assets/nong-typo-logo.svg')" width="150px" class="mx-auto mb-5"/></div>

    <v-form ref="form" style="width:300px;" class="mx-auto">
      <v-text-field
        label="아이디"
        name="email"
        type="text"
        v-model="signupData.username"
        :rules="emailRules"
        required
        autofocus
        autocapitalize="off"
        autocorrect="off"
        autocomplete="off"
      />
      <v-text-field
        label="비밀번호"
        name="password"
        :type="isShowPW ? 'text' : 'password'"
        v-model="signupData.password"
        :rules="passwordRules"
        @click:append="isShowPW = !isShowPW"
        @focus="isWrong = false"
        required
        autocomplete="off"
        :append-icon="isShowPW ? 'mdi-eye' : 'mdi-eye-off'"
        append-outer-icon
      />
      <v-text-field
        label="비밀번호 확인"
        name="passwordConfirm"
        :type="isShowPW2 ? 'text' : 'password'"
        v-model="signupData.passwordConfirm"
        :rules="[...passwordConfirmRules, isMatchPasswordConfirm]"
        append-outer-icon
        :append-icon="isShowPW2 ? 'mdi-eye' : 'mdi-eye-off'"
        @click:append="isShowPW2 = !isShowPW2"
      />
      <!-- 주소 -->
      <br/>
      <v-divider></v-divider>
      <div class="text-h6 mt-4">배송정보</div>
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

export default {
  name: "Signup",
  data() {
    return {
      isShowPW: false,
      isShowPW2: false,
      signupData: {
        email: null,
        password: null,
        passwordConfirm: null,
      },
      addressData: {
        postcode: '',
        address: '',
        detailAddress: '',
        extraAddress: '',
      },
      detailAddressRules: [
        (value) => !!value || "상세 주소를 입력해주세요."
      ],
      emailRules: [
        (value) => !!value || "이메일을 입력해주세요",
        (value) =>
          /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/.test(
            value
          ) || "올바른 양식의 이메일을 입력해주세요",
      ],
      passwordRules: [
        (value) => !!value || "비밀번호를 입력해주세요",
        (value) =>
          (value && value.length >= 8) || "비밀번호는 8글자 이상 입력해주세요",
      ],
      passwordConfirmRules: [
        (v) => !!v || "비밀번호를 다시 한번 입력해주세요.",
      ],
    };
  },
  methods: {
    isMatchPasswordConfirm() {
      return (
        this.signupData.password === this.signupData.passwordConfirm ||
        "비밀번호가 일치하지 않습니다."
      );
    },
    checkForm() {
      if (this.$refs.form.validate()) {
        var addr = this.addressData.address + ' ' +this.addressData.detailAddress
        // password가 없네..? 회원가입 연결..
        // http.post('user/signup', {user_id: this.signupData.email, user_address: addr})
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
  
    
  },
};
</script>

<style>
</style>