<template>
  <v-form ref="form">
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
    <v-btn @click="checkForm()"> 로그인 </v-btn>
  </v-form>
</template>

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
  },
};
</script>

<style>
</style>