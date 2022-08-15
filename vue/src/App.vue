<template>
  <div id="app">
    <div id="nav">
      <nav-bar></nav-bar>
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
    </div>
    <router-view />
  </div>
</template>

<script>
import NavBar from '@/components/NavBar.vue'
import petService from '@/services/petService.js';
import playdateService from '@/services/playdateService.js'


export default {
  components: {
    NavBar,
  },
  created () {
         petService.getAllPets()
       .then(response => {
         if(response.status === 200) {
         this.$store.commit('ADD_ALL_PETS', response.data )
         }
       });
      playdateService.getAllPlaydates()
       .then(response => {
         if(response.status === 200) {
           this.$store.commit('ADD_ALL_PLAYDATE', response.data);
           
         }
       })
       .catch(() => {
           alert("Sorry. An error occurred.")
         })
    },
  }


</script>

<style>
#app {
  font-family: 'Cabin', sans-serif;
}
</style>
