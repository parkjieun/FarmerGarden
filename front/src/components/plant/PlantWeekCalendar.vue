<template>
<div class="d-flex align-center">
    
  <v-btn fab text small @click="prev"><v-icon small>mdi-chevron-left</v-icon></v-btn>
  <v-calendar-weekly ref="calendarWeek"/>
  <v-btn fab text small @click="next"><v-icon small>mdi-chevron-right</v-icon></v-btn>
  </div>
</template>

<script>
export default {
    data() {
        return {
            events: [],
            today: new Date()
        }
    },
    methods: {
      prev () {
        this.$refs.calendarWeek.start = this.today.setDate(this.today.getDate() - 7)
      },
      next () {
        this.$refs.calendarWeek.start = this.today.setDate(this.today.getDate() + 7)
      },
      
    },
    mounted() {

    }
    

}
</script>

<style>

</style>