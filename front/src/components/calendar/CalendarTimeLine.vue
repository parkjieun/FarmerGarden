<template>
  <v-timeline align-top dense class="mt-3" style="">
    <v-timeline-item small v-for="(item, index) in items" :key="index" :color="colors[index%2]">
      <v-row class="pt-1">
        <v-col cols="3">
          <strong>{{item.day}}</strong>
        </v-col>
        <v-col>
          <strong>{{item.title}}</strong>
          <div class="caption">{{item.content}}</div>
        </v-col>
      </v-row>
    </v-timeline-item>
      
      
      <v-timeline-item color="pink" small>
        <v-row class="pt-1">
          <v-col cols="3">
            <strong>5pm</strong>
          </v-col>
          <v-col>
            <strong>New Icon</strong>
            <div class="caption">Mobile App</div>
          </v-col>
        </v-row>
      </v-timeline-item>

      <v-timeline-item color="teal lighten-3" small>
        <v-row class="pt-1">
          <v-col cols="3">
            <strong>3-4pm</strong>
          </v-col>
          <v-col>
            <strong>Design Stand Up</strong>
            <div class="caption mb-2">Hangouts</div>
            <v-avatar>
              <v-img
                src="https://avataaars.io/?avatarStyle=Circle&topType=LongHairFrida&accessoriesType=Kurt&hairColor=Red&facialHairType=BeardLight&facialHairColor=BrownDark&clotheType=GraphicShirt&clotheColor=Gray01&graphicType=Skull&eyeType=Wink&eyebrowType=RaisedExcitedNatural&mouthType=Disbelief&skinColor=Brown"
              ></v-img>
            </v-avatar>
            <v-avatar>
              <v-img
                src="https://avataaars.io/?avatarStyle=Circle&topType=ShortHairFrizzle&accessoriesType=Prescription02&hairColor=Black&facialHairType=MoustacheMagnum&facialHairColor=BrownDark&clotheType=BlazerSweater&clotheColor=Black&eyeType=Default&eyebrowType=FlatNatural&mouthType=Default&skinColor=Tanned"
              ></v-img>
            </v-avatar>
            <v-avatar>
              <v-img
                src="https://avataaars.io/?avatarStyle=Circle&topType=LongHairMiaWallace&accessoriesType=Sunglasses&hairColor=BlondeGolden&facialHairType=Blank&clotheType=BlazerSweater&eyeType=Surprised&eyebrowType=RaisedExcited&mouthType=Smile&skinColor=Pale"
              ></v-img>
            </v-avatar>
          </v-col>
        </v-row>
      </v-timeline-item>

      <v-timeline-item color="pink" small>
        <v-row class="pt-1">
          <v-col cols="3">
            <strong>12pm</strong>
          </v-col>
          <v-col>
            <strong>Lunch break</strong>
          </v-col>
        </v-row>
      </v-timeline-item>

      <v-timeline-item color="teal lighten-3" small>
        <v-row class="pt-1">
          <v-col cols="3">
            <strong>9-11am</strong>
          </v-col>
          <v-col>
            <strong>Finish Home Screen</strong>
            <div class="caption">Web App</div>
          </v-col>
        </v-row>
      </v-timeline-item>
    </v-timeline>
</template>

<script>
export default {
  data() {
    return {
      colors: ['pink', 'teal lighten-3'],
      items: [
        { 
          day: '10월 10일',
          title: '씨앗심기',
          content: '무순 씨앗을 심음'
        },
        {
          day: '10월 11일',
          title: '새싹이 돋아났다!',
          content: '씨앗이 충분히 불려져서 새싹이 돋아났다!'
        },
        {
          day: '10월 13일',
          title: '성장 중',
          content: '무순 성장이 많이 진행됨'
        },
        {
          day: '10월 14일',
          title: '수확까지 4일',
          content: '이제 반밖에 안남았네~'
        },
        {
          day: '10월 15일',
          title: '무슨 요리를 할까',
          content: '요리페이지에서 요리법을 확인해 보자'
        },
        {
          day: '10월 16일',
          title: 'D-day -1',
          content: '내일이 바로 수확일입니다~'
        },
        {
          day: '10월 17일',
          title: 'D-day',
          content: '오늘은 바로 수확날 . 무순 요리를 해볼까?'
        }

      ]
    }
  }

}
</script>

<style>

</style>