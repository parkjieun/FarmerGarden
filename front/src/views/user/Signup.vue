<template>
  <div>
    <div class="text-h5 text-center pb-5" style="margin-top: calc(40vh - 155px);">회원가입</div>

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
      <v-btn @click="checkForm()" color="primary" width="100%" class="mt-5"> 회원가입 </v-btn>
    </v-form>
  </div>
</template>

<script>
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
        // 회원가입 메소드 호출
      }
    },
  },
};
</script>

<style>
</style>