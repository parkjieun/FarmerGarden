<template>
<div class="d-flex align-center" id="weekCalendar">
    
  <v-btn fab text small @click="prev()"><v-icon small>mdi-chevron-left</v-icon></v-btn>
  <v-calendar-weekly ref="calendarWeek" :weekday-format="myWeekdayFormat" :month-format="myMonthFormat"/>
  <v-btn fab text small @click="next()"><v-icon small>mdi-chevron-right</v-icon></v-btn>

</div>
</template>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
export default {
    data() {
        return {
            today: new Date(),
        }
    },
   
    methods: {
      prev () {
        this.today.setDate(this.today.getDate() - 7 - this.today.getDay())
        this.computeStart()
      },
      next () {
        this.today.setDate(this.today.getDate() + 7 - this.today.getDay())
        this.computeStart()
      },
      computeStart() {
        this.$refs.calendarWeek.start = new Date(this.today).setDate(this.today.getDate() - this.today.getDay())
        this.$refs.calendarWeek.today = this.$refs.calendarWeek.start 
      },
      
      myWeekdayFormat(i) {
        const days = ['일', '월', '화', '수', '목', '금', '토']
        return days[i.weekday]
      },
      myMonthFormat(m) {
        return m.month + ' /'
      }
    },
    mounted() {
      console.log(this.$refs.calendarWeek)

    }
    

}
</script>

<style>
.theme--light.v-calendar-weekly .v-calendar-weekly__head-weekday.v-outside {
  background-color: white;
}
.theme--light.v-calendar-weekly .v-calendar-weekly__day.v-outside {
  background-color: white;
}
.theme--light.v-calendar-weekly .v-calendar-weekly__head-weekday {
  border-right: none;
  color: #000000;
}
.theme--light.v-calendar-weekly .v-calendar-weekly__day {
  border-right: none;
  border-bottom: none;
  color: #000000;
}
.theme--light.v-calendar-weekly {
  /* highlight background-color */
  background-color: #FFFFFF;
  border-top: none;
  border-left: none
}
#weekCalendar {
  border-top: #e0e0e0 1px solid;
  border-bottom: #e0e0e0 1px solid;
}
</style>