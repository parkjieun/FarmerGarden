<template>
<div class="d-flex align-center">
    
  <v-btn fab text small @click="prev"><v-icon small>mdi-chevron-left</v-icon></v-btn>
  <v-calendar-weekly ref="calendarWeek" id="this-week"/>
  <v-btn fab text small @click="next"><v-icon small>mdi-chevron-right</v-icon></v-btn>
  </div>
</template>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
export default {
    data() {
        return {
            today: new Date(2020, 9, 30),
        }
    },
    computed: {
      nextWeek() {
        var next = this.today
        next.setDate(next.getDate() + 7)
        return next
      },
      lastWeek() {
        var last = this.today
        last.setDate(last.getDate() - 7)
        return last
      }
    },
    methods: {
      prev () {
        this.$refs.calendarWeek.start = this.today.setDate(this.today.getDate() - 7)
        // $("#this-week").toggle()
      },
      next () {
        this.$refs.calendarWeek.start = this.today.setDate(this.today.getDate() + 7)
        this.today = this.nextWeek
        // $("#this-week").toggle()
      },
      
    },
    mounted() {

    }
    

}
</script>

<style>

</style>