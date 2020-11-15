<template>
<div style="background-color: #2bc77e13;">
    <v-btn v-if="!isShow" text small @click="showMonth" width="100%" class="mt-5"><v-icon small>mdi-chevron-down</v-icon></v-btn>
    <v-btn v-else text small @click="showMonth" width="100%" class="mt-5"><v-icon small>mdi-chevron-up</v-icon></v-btn>
    <div  style="position:absolute; top: 50px; z-index: 10; width:100%;">
      <PlantMonthCalendar id="monthCalendar" :calendarInfo="calendarInfo"/>
    </div>
    <div style="position: absolute; top: 49px; width:100%;">
      <PlantWeekCalendar @day="(val) => day=val" @selectDay="selectDay=true"/>
    </div>
    <div style="position: absolute; top: 118px; width:100%; background-color: #2bc77e13;" >
      <div v-if="selectDay">
        <SelectDayTimeLine :day="day" @showAll="selectDay=false"/>
      </div>
      <div v-else>
        <CalendarTimeLine/>
      </div>
    </div>
    <div v-if="isShow" id="backdrop" @click="onClick"></div>
    <v-btn fab small @click="createPage" color="primary" style="z-index: 99; position: absolute; z-index: 99; bottom: 30px; right: 30px;"><v-icon>mdi-lead-pencil</v-icon></v-btn>
</div>
 
</template>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
import PlantMonthCalendar from '@/components/calendar/PlantMonthCalendar.vue'
import PlantWeekCalendar from '@/components/calendar/PlantWeekCalendar.vue'
import CalendarTimeLine from '@/components/calendar/CalendarTimeLine.vue'
import SelectDayTimeLine from '@/components/calendar/SelectDayTimeLine.vue'

import http from '@/utils/http-common'
import { mapGetters, mapState } from 'vuex'
export default {
  components: {
    PlantMonthCalendar,
    PlantWeekCalendar,
    CalendarTimeLine,
    SelectDayTimeLine
  },
  data() {
    return {
      isShow: false,
      calendarInfo: [],
      sproutCodeTable: {
        1000: "밀싹",
        1001: "메밀싹",
        1002: "루꼴라",
        1003: "옥수수싹",
        1004: "무순",
        1005: "적무순",
      },
      selectDay: false,
      day: ''
    }
  },
  computed: {
    ...mapGetters(['config']),
    ...mapState(['user'])
	},
  methods: {
    showMonth() {
      $('#monthCalendar').slideToggle()
      this.isShow = !this.isShow
    },
    onClick() {
      this.isShow = false
      $('#monthCalendar').hide()
    },
    createPage() {
      this.$router.push({name:'DiaryCreate'})
    },
    getInformation() {
      http
      .get("/api/calendar", this.config)
      .then((res) => {
        this.calendarInfo = res.data
      });
    }
  },
  mounted() {
    $('#monthCalendar').hide()
    this.getInformation();
  }
}
</script>

<style>
#backdrop {
    width:100%; 
    height:100%; 
    opacity: 0.1;
    position: absolute; 
    top: 50px; 
    right: 0; 
    z-index: 5; 
    background-color: gray;
}

</style>