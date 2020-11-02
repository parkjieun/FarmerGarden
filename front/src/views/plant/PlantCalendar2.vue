<template>
<div class="mt-5">
    <PlantMonthCalendar id="monthCalendar"/>
    <v-btn v-if="!isShow" text small @click="showMonth" width="100%"><v-icon small>mdi-chevron-down</v-icon></v-btn>
    <v-btn v-else text small @click="showMonth" width="100%"><v-icon small>mdi-chevron-up</v-icon></v-btn>
    <PlantWeekCalendar/>
    <CalendarTimeLine/>
</div>
  
</template>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
import PlantMonthCalendar from '@/components/calendar/PlantMonthCalendar.vue'
import PlantWeekCalendar from '@/components/calendar/PlantWeekCalendar.vue'
import CalendarTimeLine from '@/components/calendar/CalendarTimeLine.vue'
export default {
    components: {
        PlantMonthCalendar,
        PlantWeekCalendar,
        CalendarTimeLine
    },
    data() {
        return {
            isShow: false,
        }
    },
    methods: {
        showMonth() {
            
            $('#monthCalendar').slideToggle()
            this.isShow = !this.isShow

        }
    },
    mounted() {
        $('#monthCalendar').hide()
    }
}
</script>

<style>

</style>