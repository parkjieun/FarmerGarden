<template>
  <v-footer
    class="justify-center"
    color="#292929"
    height=""
  >
  <v-row class="font-weight-light grey--text text--lighten-1 text-center">
    <v-col cols="3">
      <span style="font-weight:bold">INFORMATION</span>
      <v-spacer style="padding-bottom:10px"></v-spacer>
       (주)농부네텃밭👨‍🌾
    </v-col>

    <v-col cols="3">
      <span style="font-weight:bold">LOCATION</span>
      <v-spacer style="padding-bottom:10px"></v-spacer>
      서울 강남구 테헤란로 212(역삼동)<br>
      멀티캠퍼스 역삼 12층
    </v-col>

    <v-col cols="3">
      <span style="font-weight:bold">CONTACT</span>
      <v-spacer style="padding-bottom:10px"></v-spacer>
      Tel  02 3429 5114<br>
      Fax  02 3429 5114
    </v-col>

    <v-col cols="3">
      <span style="font-weight:bold">MEMBER</span>
      <v-spacer style="padding-bottom:10px"></v-spacer>
        <v-avatar  color="primary" size="45"  class="mr-3" tile> 
          <v-img   src="@/assets/main/member/j.png"></v-img>
        </v-avatar>
        <v-avatar  color="primary" size="45"  class="mr-3" tile> 
          <v-img   src="@/assets/main/member/p.png" ></v-img>
        </v-avatar>
        <v-avatar  color="primary" size="45"  class="mr-3" tile> 
          <v-img   src="@/assets/main/member/p2.png" ></v-img>
        </v-avatar>
        <v-avatar  color="primary" size="45"  class="mr-3" tile> 
          <v-img   src="@/assets/main/member/s.png" ></v-img>
        </v-avatar>
        <v-avatar  color="primary" size="45"  class="mr-3" tile> 
          <v-img   src="@/assets/main/member/o.png" ></v-img>
        </v-avatar>
    </v-col>
  </v-row> 
  </v-footer>
</template>

<script>
export default {
  name: 'Footer',
}
</script>

<style>

</style>