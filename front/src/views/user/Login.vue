<template>
  <div>
    <div class="text-h5 text-center pb-5" style="margin-top: calc(40vh - 220px);"><v-img :src="require('@/assets/nong-typo-logo.svg')" width="150px" class="mx-auto mb-5"/></div>

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
       <v-btn @click="testLogin" color="yellow"  width="100%" class="mt-5">테스트계정 로그인</v-btn>
    </v-form>
  </div>
</template>


<script>
import { mapActions } from 'vuex'
import http from '@/utils/http-common'
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
    ...mapActions(['setAuth', 'setUser', 'setSocial']),
    checkForm() {
      if (this.$refs.form.validate()) {
        // 로그인 메소드 호출
        http.get('user', )
      }
    },
    testLogin() {
      console.log("회원정보가져오기")
      const jwt = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIzNzRlNjkzYTMxMGM0NTA0MTJjMjkxYjgwODY1MTEyMCJ9.IFUT0sKvVtwcskUKbq1xgNUk4GEgSa9l2sLaYYOGRIA"
      http.get("/api/user" , {
        headers: {
            Authorization: "Bearer "+jwt
        }
      })
      .then(res => {
        console.log("test 계정:"+JSON.stringify(res.data));
        this.setUser(res.data)
        this.setAuth("Bearer "+jwt)
        // 등록된 기기가 없으면
        if (res.data.user_pot == null) {
          this.$router.push({name: 'PlantEmpty'})
        }
        // 등록된 기기가 있으면
        else {this.$router.push({name: "PlantMain"})}
        
      })    
      .catch(res => {
          console.log("회원정보 catch"+res.data)
      })
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
        http.post("/api/oauth/kakao", {}, {headers: {accessToken: authInfo.access_token}})
        .then(response => {
          const data = response.data
          console.log(data)
          if (data.isOlder>0) {
            //회원정보 가져오기 
            console.log("로그인은 했고.")
              http.get("/api/user" , {
                headers: {
                    Authorization: "Bearer "+data.accessToken
                }
              })
              .then(res => {
                this.setUser(res.data)
                this.setAuth("Bearer "+data.accessToken)
                // 등록된 기기가 없으면
                if (res.data.user_pot == null) {
                  this.$router.push({name: 'PlantEmpty'})
                }
                // 등록된 기기가 있으면
                else {this.$router.push({name: "PlantMain"})}
                
              })    
              .catch(res => {
                  console.log("회원정보 catch"+res.data)
              })

          } else {
              //회원가입 시키기
              console.log(data)
              this.setSocial(data)
              this.$router.push({name: "AddressForm"})
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
