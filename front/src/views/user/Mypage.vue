<template>
  <v-container
    class="fill-height px-0 align-start"
    style="background-color: #efefef"
  >
    <v-list width="100%">
      <v-subheader>내메뉴</v-subheader>
      <v-divider></v-divider>
      <v-list-item-group>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title>기기등록 및 변경</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title>FAQ 챗봇</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title>로그아웃</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>
    <v-list width="100%">
      <v-subheader>기기관리</v-subheader>
      <v-divider></v-divider>
      <v-list-item-group>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title>수동급수</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title>LED ON / OFF</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title>사진찍기</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </v-container>
</template>

<script>
export default {
  name: "Mypage",
  data() {
    return {};
  },
};
</script>

<style lang="scss" scoped>
</style>