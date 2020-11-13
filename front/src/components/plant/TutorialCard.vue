<template>
  <div>
    <v-card class="rounded-lg">
      <v-img
        :src="require(`@/assets/plant/tutorial/튜토애니메이션${el}.gif`)"
        height="360px"
        contain
      />
      <v-card-title> {{ items[el].title }} </v-card-title>
      <v-card-subtitle>
        {{ items[el].subtitle }}
      </v-card-subtitle>
    </v-card>
  </div>
</template>

<script>
export default {
  props: ["el"],
  data() {
    return {
      items: [
        {
          title: "씨앗 뿌리기",
          subtitle: "재배할 씨앗을 수경 재배기에 골고루 뿌리세요.",
        },
        {
          title: "물 넣기",
          subtitle: "물 주입구를 통해 물을 넣어주세요.",
        },
        {
          title: "수확하기",
          subtitle: "이제 수확할 때까지 기다리면 돼요!",
        },
      ],
    };
  },
};
</script>

<style></style>
