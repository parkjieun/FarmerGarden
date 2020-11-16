<template>
  <v-app>
    <router-view />
  </v-app>
</template>

<script>
export default {
  name: "App",
};
</script>

<style lang="scss">
@import url("https://fonts.googleapis.com/css2?family=Jua&display=swap");
@font-face {
  font-family: "Handon3gyeopsal300g";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_seven@1.2/Handon3gyeopsal300g.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}
@font-face {
  font-family: "Handon3gyeopsal600g";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_seven@1.2/Handon3gyeopsal600g.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}

:root {
  --primary-color: #56c156;
  --white-color: #ffffff;

  --font1-color: #5b3016;
}
.vc-grid-cell  {
	font-family: 'Jua', sans-serif!important;
}
.vc-day-content {
	font-family: 'Jua', sans-serif!important;
}

@import url("https://fonts.googleapis.com/css2?family=Do+Hyeon&Nanum+Gothic:wght@700;800&Noto+Sans+KR:wght@300&Black+Han+Sans&display=swap");
@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');
@font-face {
  font-family: 'NanumBarunpen';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumBarunpen.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
@font-face {
    font-family: 'Cafe24Oneprettynight';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Oneprettynight.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
.main-default {
  font-family: "NanumSquare", "Nanum Gothic", "Do Hyeon", "Noto Sans KR",
    sans-serif;
  font-weight: 400;
}

</style>
