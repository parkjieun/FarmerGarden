<template>
  <div>
      <vc-calendar is-expanded :attributes="attributes"/>
  </div>
</template>


<script>

export default {
    data() {
        return {
            colors: ['red', 'orange', 'yellow', 'green', 'teal', 'blue', 'indigo', 'purple', 'pink', 'gray'],
            attributes: [
                {
                    highlight: 'blue',
                    dates: { start: new Date(2020, 9, 14), end: new Date(2020, 9, 18) }
                },
                {
                    highlight: 'teal',
                    dates: { start: new Date(2020, 9, 22), end: new Date(2020, 9, 28) }
                },     
            ]
        }
    }    

}
</script>

<style>

</style>