<template>
<div>
    <PlantMonthCalendar/>
    <PlantWeekCalendar/>
</div>
  
</template>

<script>
import PlantMonthCalendar from '@/components/plant/PlantMonthCalendar.vue'
import PlantWeekCalendar from '@/components/plant/PlantWeekCalendar.vue'
export default {
    components: {
        PlantMonthCalendar,
        PlantWeekCalendar
    },

}
</script>

<style>

</style>