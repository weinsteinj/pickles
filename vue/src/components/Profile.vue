<template>
  <div>
      <h1>Welcome to {{$store.state.user.firstName}}'s Profile. Your pets:</h1>
      <div v-for="pet in $store.state.currentUserPetArray" v-bind:key="pet.petId" > {{pet.name}} </div>
  </div>
</template>

<script>
//import userService from '@/services/userService.js';
import petService from '@/services/petService.js';
export default {
    name: 'profile-component',

    data() {
        return {
            user: {},
            pets: [],
            playdateArray: []
        }
    },

    created() {
      petService.getPetsByUserId(this.$store.state.user.id).then((response) => {
          if(response.status === 200) {
            this.pets = response.data;
            this.$store.commit('ADD_PETS_TO_USER', response.data )
            }
          });
       // this.pets = ;
        // for (var playdate of this.$store.state.playdateArray) {
        //     if (playdate.user.)
        // }

    },
    mounted () {
        
    }

    //need:
    // - this user's playdates
    //to make this editable

}
</script>

<style>

</style>