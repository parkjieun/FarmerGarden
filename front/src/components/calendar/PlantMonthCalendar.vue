<template>
<div>
	<vc-calendar is-expanded :attributes="attributes"/>
</div>
</template>


<script>

export default {
	props: ['calendarInfo'],
	data() {
		return {
			colors: ['red', 'orange', 'yellow', 'green', 'teal', 'blue', 'indigo', 'purple', 'pink', 'gray'],
		}
	},
	computed: {
		attributes() {
			const attr = []
			for (var i = 0; i < this.calendarInfo.length; i ++) {
				const start_day = this.calendarInfo[i].calendar_start_day
				var end_day = ''
				if (this.calendarInfo[i].calendar_stop_day) {
					end_day = this.calendarInfo[i].calendar_stop_day
				}
				else {
					end_day = this.calendarInfo[i].calendar_eat_day
				}
				const label = this.calendarInfo[i].plant_name
				attr.push({
					highlight: this.colors[i],
					dates: {start: start_day, end: end_day},
					popover: {
						label: label,
						visibility: 'click'
					}
				})
			}
			return attr
		}

	},

}
</script>

<style>
</style>