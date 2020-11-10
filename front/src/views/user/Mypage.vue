<template>
  <v-container
    class="fill-height px-0 align-start"
    style="background-color: #efefef"
  >
    <v-list width="100%" class="nbn--list-font pb-0">
      <div class="nbn--list-font-bold text-overline text--disabled px-4">
        내메뉴
      </div>
      <div class="px-4"><v-divider></v-divider></div>

      <v-list-item-group>
        <v-list-item @click="goDevice()">
          <v-list-item-content>
            <v-list-item-title class="nbn--list-font font-weight-bold">
             기기등록 및 변경
            </v-list-item-title>
          </v-list-item-content>
          <v-list-item-action>
            <v-icon color="grey lighten-1">mdi-chevron-right</v-icon>
          </v-list-item-action>
          <device-update :dialogDevice="dialogDevice"  @closeForm="typeUpdate" />



        </v-list-item>
        <v-list-item
          href="https://frogue.danbee.ai/?chatbot_id=8ac8ca73-ec86-4dd1-ba66-388919215cf5"
        >
          <v-list-item-content>
            <v-list-item-title class="nbn--list-font font-weight-bold">
              FAQ 챗봇
            </v-list-item-title>
          </v-list-item-content>
          <v-list-item-action>
            <v-icon color="grey lighten-1">mdi-chevron-right</v-icon>
          </v-list-item-action>
        </v-list-item>
        <v-list-item :to="{ name: 'Tutorial' }">
          <v-list-item-content>
            <v-list-item-title class="nbn--list-font font-weight-bold">
              튜토리얼
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title class="nbn--list-font font-weight-bold">
              로그아웃
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>

    <v-list width="100%" class="mt-3 pb-0">
      <div class="nbn--list-font-bold text-overline text--disabled px-4">
        작물관리
      </div>
      <div class="px-4"><v-divider></v-divider></div>

      <v-list-item-group>
        <v-list-item :to="{ name: 'PlantCalendar2' }">
          <v-list-item-content>
            <v-list-item-title class="nbn--list-font font-weight-bold">
              재배일기
            </v-list-item-title>
          </v-list-item-content>
          <v-list-item-action>
            <v-icon color="grey lighten-1">mdi-chevron-right</v-icon>
          </v-list-item-action>
        </v-list-item>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title class="nbn--list-font font-weight-bold">
              재배작물 정보
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item v-if="!plantCharInfo">
          <v-list-item-content>
            <v-list-item-title class="nbn--list-font font-weight-bold">
              재배작물 심기
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item v-if="plantCharInfo">
          <v-list-item-content>
            <v-list-item-title 
              class="nbn--list-font font-weight-bold"
              @click.prevent="stopGrowPlant"  
            >
              재배작물 취소
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-dialog
          v-model="dialog.seedList"
          scrollable
          fullscreen
          hide-overlay
          transition="dialog-bottom-transition"
        >
          <template #activator="{ attrs, on }">
            <v-list-item v-bind="attrs" v-on="on">
              <v-list-item-content>
                <v-list-item-title class="nbn--list-font font-weight-bold">
                  새싹정보
                </v-list-item-title>
              </v-list-item-content>
              <v-list-item-action>
                <v-icon color="grey lighten-1">mdi-chevron-right</v-icon>
              </v-list-item-action>
            </v-list-item>
          </template>
          <v-card class="rounded-0">
            <!-- dialog title start -->
            <v-toolbar flat dark dense color="primary">
              <v-btn icon @click="dialog.seedList = !dialog.seedList">
                <v-icon>mdi-chevron-left</v-icon>
              </v-btn>
              <v-toolbar-title class="text-body-1 nbn--list-font-bold">
                새싹정보
              </v-toolbar-title>
            </v-toolbar>
            <!-- dialog title end -->
            <v-card-text class="pa-0">
              <SeedList v-if="dialog.seedList" />
            </v-card-text>
          </v-card>
        </v-dialog>
      </v-list-item-group>
    </v-list>

    <v-list width="100%" class="mt-3 pb-0">
      <div class="nbn--list-font-bold text-overline text--disabled px-4">
        장비관리
      </div>
      <div class="px-4"><v-divider></v-divider></div>

      <v-list-item-group>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title class="nbn--list-font font-weight-bold"
              >수동급수</v-list-item-title
            >
          </v-list-item-content>
        </v-list-item>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title class="nbn--list-font font-weight-bold"
              >LED ON / OFF</v-list-item-title
            >
          </v-list-item-content>
        </v-list-item>
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title class="nbn--list-font font-weight-bold"
              >사진찍기</v-list-item-title
            >
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>

    <v-list width="100%" class="mt-3 pb-0">
      <div class="nbn--list-font-bold text-overline text--disabled px-4">
        팀소개
      </div>
      <div class="px-4"><v-divider></v-divider></div>

      <v-list-item v-for="(item, index) in teamListItems" :key="index">
        <v-list-item-content>
          <v-list-item-subtitle
            class="text-caption text--secondary"
            v-text="item.title"
          />
          <v-list-item-title
            class="nbn--list-font font-weight-bold"
            v-text="item.content"
          />
        </v-list-item-content>
      </v-list-item>
    </v-list>

    <v-list width="100%" class="mt-3 py-0">
      <v-list-item-group>
        <v-dialog
          v-model="dialog.privacy"
          scrollable
          fullscreen
          hide-overlay
          transition="dialog-bottom-transition"
        >
          <template #activator="{ attrs, on }">
            <v-list-item v-bind="attrs" v-on="on">
              <v-list-item-content>
                <v-list-item-title class="nbn--list-font font-weight-bold"
                  >이용약관</v-list-item-title
                >
              </v-list-item-content>
              <v-list-item-action>
                <v-icon color="grey lighten-1">mdi-chevron-right</v-icon>
              </v-list-item-action>
            </v-list-item>
          </template>
          <v-card class="rounded-0">
            <!-- dialog title start -->
            <v-toolbar flat dark dense color="primary">
              <v-btn icon @click="dialog.privacy = !dialog.privacy">
                <v-icon>mdi-chevron-left</v-icon>
              </v-btn>
              <v-toolbar-title class="text-body-1 nbn--list-font-bold">
                이용 약관
              </v-toolbar-title>
            </v-toolbar>
            <!-- dialog title end -->
            <v-card-text>
              <PrivacyPolicy v-if="dialog.privacy" />
            </v-card-text>
          </v-card>
        </v-dialog>
      </v-list-item-group>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-subtitle class="text-caption text--secondary">
            앱 정보
          </v-list-item-subtitle>
          <v-list-item-title class="nbn--list-font font-weight-bold">
            2.0.0
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-container>
</template>

<script>
import http from '@/utils/http-common';
import { mapGetters } from "vuex";

import PrivacyPolicy from "@/views/user/PrivacyPolicy.vue";
import SeedList from "@/views/seed/SeedList.vue";
import DeviceUpdate from "@/views/device/DeviceUpdate.vue"

export default {
  name: "Mypage",
  data() {
    return {
      dialogDevice: false,
      dialog: {
        privacy: false,
        seedList: false,
      },
      teamListItems: [
        {
          title: "팀명",
          content: "슬기로운 재배생활",
        },
        {
          title: "팀원",
          content: "진슬기(팀장), 박지은, 박태록, 서정하, 오지수",
        },
        {
          title: "홈페이지",
          content: "www.nongbunae.com",
        },
        {
          title: "팀코드",
          content: "S03P31A105",
        },
      ],
    };
  },
  components: {
    PrivacyPolicy,
    SeedList,
    DeviceUpdate,
  },
  computed: {
    ...mapGetters(["plantCharInfo", "user", "config"]),
  },
  methods: {
    goDevice(){
       this.dialogDevice = true;
    },
    typeUpdate() {
      this.dialogDevice = false;
    },
    stopGrowPlant(){
      let params = new URLSearchParams();
      params.append('choice_id', this.user.choice_id);
      http.put('/api/choice', params, this.config)
        .then(() => {
          alert("success")
        })
        .catch(() => {
          alert("fail")
        })
    }
  },
};
</script>

<style lang="scss" scoped>
.nbn--list-font {
  font-family: "Handon3gyeopsal300g";
  font-size: 15px;

  &-bold {
    font-family: "Handon3gyeopsal600g";
  }
}
</style>