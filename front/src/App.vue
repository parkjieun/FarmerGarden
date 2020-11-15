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
</style>
