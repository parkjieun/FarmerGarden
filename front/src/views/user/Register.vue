<template>
  <div style="width: 300px;" class="mx-auto mt-5">
    <div class="text-h5 text-center pb-5" style="margin-top: calc(40vh - 155px);">기기등록</div>
    <v-form ref="form" class="my-5">
      <v-text-field
        v-model="registerNum"
        label="기기번호"
      ></v-text-field>
    </v-form>
    <div class="text-center">
        <v-btn class="my-5" fab color="primary" @click="nextStep"><v-icon>mdi-arrow-right-thick</v-icon></v-btn><br/>
        <v-btn @click="goMain">나중에 등록할게요</v-btn>
    </div>
  </div>
</template>

<script>
export default {
    data() {
        return {
            registerNum: ''
        }
    },
    methods: {
        nextStep() {
            this.$router.push({name: 'PlantChoice'})
        },
        goMain() {
            this.$router.push({name:'PlantMain'})
        }
    }

}
</script>

<style>

</style>