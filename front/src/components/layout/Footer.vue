<template>
  <v-footer
    class="justify-center"
    color=""
    height=""
    style="border-top:1px solid #ccc;"
  >
  <v-row class="font-weight-light  text--lighten-1 text-center" style="color:#676767">
    <v-col cols="3">
      <span style="font-weight:bold">INFORMATION</span>
      <v-spacer style="padding-bottom:10px"></v-spacer>
       농부네 텃밭👨‍🌾
    </v-col>

    <v-col cols="3">
      <span style="font-weight:bold">LOCATION</span>
      <v-spacer style="padding-bottom:10px"></v-spacer>
      서울 강남구 테헤란로 212(역삼동)<br>
      멀티캠퍼스 역삼 12층
    </v-col>

    <v-col cols="3">
      <span style="font-weight:bold">Team</span>
      <v-spacer style="padding-bottom:10px"></v-spacer>
      슬기로운 재배생활<br>
    </v-col>

    <v-col cols="3">
      <span style="font-weight:bold">MEMBER</span>
      <v-spacer style="padding-bottom:10px"></v-spacer>
        <v-avatar  color="primary" size="45"  class="mr-3" tile> 
          <v-img   src="@/assets/main/footer/j.png"></v-img>
        </v-avatar>
        <v-avatar  color="primary" size="45"  class="mr-3" tile> 
          <v-img   src="@/assets/main/footer/p.png" ></v-img>
        </v-avatar>
        <v-avatar  color="primary" size="45"  class="mr-3" tile> 
          <v-img   src="@/assets/main/footer/p2.png" ></v-img>
        </v-avatar>
        <v-avatar  color="primary" size="45"  class="mr-3" tile> 
          <v-img   src="@/assets/main/footer/s.png" ></v-img>
        </v-avatar>
        <v-avatar  color="primary" size="45"  class="mr-3" tile> 
          <v-img   src="@/assets/main/footer/o.png" ></v-img>
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