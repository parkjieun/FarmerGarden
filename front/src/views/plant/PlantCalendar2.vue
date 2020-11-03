<template>
<div class="mt-5">
    <v-btn v-if="!isShow" text small @click="showMonth" width="100%"><v-icon small>mdi-chevron-down</v-icon></v-btn>
    <v-btn v-else text small @click="showMonth" width="100%"><v-icon small>mdi-chevron-up</v-icon></v-btn>
    <div  style="position:absolute; top: 50px; z-index: 99; width:100%;">
    <PlantMonthCalendar id="monthCalendar"/>
    </div>
    <div style="position: absolute; top: 60px; width:100%;">
    <PlantWeekCalendar/>
    </div>
    <div style="position: absolute; top: 150px; width:100%;" >
    <CalendarTimeLine/>
    </div>
    <div v-if="isShow" id="backdrop" @click="onClick"></div>
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

        },
        onClick() {
            this.isShow = false
            $('#monthCalendar').hide()
        }
    },
    mounted() {
        $('#monthCalendar').hide()
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
    z-index: 10; 
    background-color: gray;
}

</style>