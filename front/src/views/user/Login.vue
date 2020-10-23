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
      <v-btn @click="kakaoLogin"  width="100%" class="mt-5">카카오톡 로그인</v-btn>
      <v-btn @click="signup()" color="secondary" width="100%" class="mt-5"> 회원가입 </v-btn>
    </v-form>
  </div>
</template>

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
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
    checkForm() {
      if (this.$refs.form.validate()) {
        // 로그인 메소드 호출
      }
    },
    kakaoLogin() {
            window.Kakao.Auth.login({
                scope: 'account_email',
                success: this.getKaKaoInfo,
                fail: function(error) {
                    console.log(error);
                },
            })
    },
    getKaKaoInfo(authInfo) {
      console.log(authInfo)
        // http.post("kakao/", { access_token: authInfo.access_token })
        // .then(response => {
        //   // response.data.token => setAuth

        //     this.setAuth("JWT " + response.data.token)
        //     this.createUserProfile(Response)
        // })
    },
    signup() {
      this.$router.push({name: 'Signup'})
    }
  },
  created() {
    if (!window.Kakao.isInitialized()) {
            Kakao.init(process.env.VUE_APP_KAKAO_APP_KEY)
        }

  }

};
</script>

<style scoped>
</style>
