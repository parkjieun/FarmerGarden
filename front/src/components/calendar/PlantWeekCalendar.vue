<template>
<div class="d-flex align-center" id="weekCalendar" style="z-index: 1;">
  <v-btn fab text small @click="prev()"><v-icon small>mdi-chevron-left</v-icon></v-btn>
  <transition mode="out-in" name="out-in-translate-fade" v-on:beforeEnter="beforeEnter" v-on:enter="enter" >
    <v-calendar-weekly v-if="isToday" key="this" :weekday-format="myWeekdayFormat" :month-format="myMonthFormat" :start="startday" @click:date="dayClick"/>
    <v-calendar-weekly v-else key="next" ref="calendarWeek" :weekday-format="myWeekdayFormat" :month-format="myMonthFormat" :start="startday" @click:date="dayClick"/>
  </transition>
  <v-btn fab text small @click="next()"><v-icon small>mdi-chevron-right</v-icon></v-btn>
</div>
</template>

<script>
import velocity from 'velocity-animate';
export default {
    data() {
        return {
            today: new Date(),
            isToday: true,
            leftTransition: 1,
        }
    },
    computed: {
      startday() {
        return new Date(this.today.setDate(this.today.getDate() - this.today.getDay()))
      }
    },  
    methods: {
      prev () {
        this.leftTransition = -1
        this.startday.setDate(this.startday.getDate() - 7)
        this.isToday = !this.isToday
      },
      next () {
        this.startday.setDate(this.startday.getDate() + 7)
        this.isToday = !this.isToday
        this.leftTransition = 1
      },
      beforeEnter(el) {
        velocity(el, {opacity:0, translateX: `${this.leftTransition * 30}px`})
      },
      enter(el, done) {
        velocity(el, {opacity: 1, translateX: '0px'}, {complete: done})
      },
      myWeekdayFormat(i) {
        const days = ['일', '월', '화', '수', '목', '금', '토']
        return days[i.weekday]
      },
      myMonthFormat(m) {
        return m.month + ' /'
      },
      dayClick(date) {
        this.$emit('day', date.date)
        this.$emit('selectDay')
      }
    },
    mounted() {


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
  padding-top: 5px;
  border-right: none;
  color: #000000 !important;
  font-family: 'Jua', sans-serif!important;
}
.theme--light.v-calendar-weekly .v-calendar-weekly__day {
  border-right: none;
  border-bottom: none;
  color: #000000;
  font-family: 'Jua', sans-serif!important;
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
/* transition */
.out-in-translate-fade-enter-active, .out-in-translate-fade-leave-active {
  transition: all .1s;
}
.out-in-translate-fade-enter, .out-in-translate-fade-leave-active {
  opacity: 0;
}

</style>