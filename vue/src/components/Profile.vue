<template>
  <div>
      <h1>Welcome to {{user.firstName}}'s Profile. Your pets:</h1>
      <div v-for="pet in pets" v-bind:key="pet.petId" > {{pet.name}} </div>
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
            pets: []
        }
    },

    created() {
        this.user = this.$store.state.user;
        petService.getPetsByUserId(this.user.id).then((response) => {
            this.pets = response.data;
        });
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