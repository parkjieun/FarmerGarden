<template>
  <div>
    <div class="text-h5 text-center pb-5 login" style="margin-top: calc(40vh - 155px);">로그인</div>

    <v-form ref="form" style="width: 300px;" class="mx-auto">
      <v-text-field
        label="아이디"
        name="email"
        type="text"
        v-model="loginData.username"
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
        v-model="loginData.password"
        :rules="passwordRules"
        @keydown.enter.prevent="checkForm()"
        @click:append="isShowPW = !isShowPW"
        @focus="isWrong = false"
        required
        autocomplete="off"
        :append-icon="isShowPW ? 'mdi-eye' : 'mdi-eye-off'"
        append-outer-icon
      />
      <v-btn @click="checkForm()" color="primary" width="100%" class="mt-5"> 로그인 </v-btn>
      <v-btn @click="signup()" color="secondary" width="100%" class="my-5"> 회원가입 </v-btn>
      <v-divider class="my-3"/>
      <v-btn @click="kakaoLogin" color="yellow"  width="100%" class="mt-5">카카오톡 로그인</v-btn>
    </v-form>
  </div>
</template>


<script>
import axios from 'axios'
import { mapActions } from 'vuex'
export default {
  name: "Login",
  data() {
    return {
      loginData: {
        username: null,
        password: null,
      },
      isShowPW: false,
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
    };
  },
  methods: {
    ...mapActions(['setAuth', 'setUser']),
    checkForm() {
      if (this.$refs.form.validate()) {
        // 로그인 메소드 호출
      }
    },
    kakaoLogin() {
      window.Kakao.Auth.login({
          success: this.getKaKaoInfo,
          fail: function(error) {
              console.log(error);
          },
      })
    },
    getKaKaoInfo(authInfo) {
        axios.post("http://k3a105.p.ssafy.io/api/oauth/kakao", {}, {headers: {accessToken: authInfo.access_token}})
        .then(response => {
          this.setAuth("JWT " + response.data.accessToken)
          if (response.data.isOlder=="1") {
            this.setUser(response.data)
          }
          else {
            // 주소입력 폼으로 연결
            console.log("you have to signup")
          }
        })
    },
    signup() {
      this.$router.push({name: 'Signup'})
    }
  },
  created() {
    
  }

};
</script>

<style scoped>
</style>
