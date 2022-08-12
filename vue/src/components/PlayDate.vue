<template>
  <div>
    <div class="pet-card" v-for="pet in $store.state.petArray" v-bind:key="pet.id"> 
      {{`Click here to learn more about ${pet.name}`}}. {{ pet.sex == 'Male' ? 'He' : 'She' }} is a {{pet.species.toLowerCase()}}.
      </div>
      <div>
        <playdate-card v-for="playdate in $store.state.playdateArray" v-bind:key="playdate.id" 
        v-bind:playdate="playdate"></playdate-card>
      </div>
  </div>
</template>

<script>
import playdateService from '@/services/playdateService.js'

export default {
  name: "play",
  components: {
  },
  created () {
    this.savePlaydatesToStore;
  },
  data () {
    return {
    
    }
  },
  methods: {
    savePlaydatesToStore() {
      playdateService.getAllPlaydates()
       .then(response => {
         if(response.status === 200) {
           let playdateArray = response.data;
           this.$store.commit('ADD_ALL_PLAYDATE', playdateArray);
         }
       })
       .catch(() => {
           alert("Sorry. An error occurred.")
         })
    },
  }
}
</script>

<style>

</style>