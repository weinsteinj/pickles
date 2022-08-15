<template>
  <div>
      <h1>Welcome to {{$store.state.user.firstName}}'s Profile.</h1>
      <h2>{{$store.state.user.username}}'s Pets:</h2>
      <div v-for="pet in $store.state.currentUserPetArray" v-bind:key="pet.petId" class="user-pets">
           <ul>
               <li>Name: {{pet.name}} </li>
               <li>Age: {{getAge(pet.birthDate)}}</li>
               <li>Species: {{pet.species}}</li>
               <li>Sex: {{pet.sex}}</li>
               <li>Personality: 
                   <ul>
                       <li>{{pet.personality}}</li>
                   </ul>
               </li>
               <li>Vaccinations: {{ pet.hasVaccinations.toString() }}</li>
               <li>Spayed/Neutered: {{spayedToString(pet.fixed)}}</li>
               <li>Size: {{ pet.size }}</li>
           </ul>
           <img :src="pet.petPhoto" />
        </div>
    <h2>Playdates: </h2>
    <div v-for="playdate in playdateArray" v-bind:key="playdate.playdateId" class="user-playdates">
       <p>Details: <br>{{playdate.details}}</p> 
       <p>Time: <br>{{playdate.dateTime}}</p>
    </div>
      
      <!-- <button @click="test">Test</button> -->
  </div>
</template>

<script>
//import userService from '@/services/userService.js';
import petService from '@/services/petService.js';
export default {
    name: 'profile-component',

    data() {
        return {
            // user: {},
            pets: [],
            playdateArray: {}
        }
    },

    methods: {
        getAge(birthDate) {
            let today = new Date();
            let birthday = new Date(birthDate);
            let age = today.getFullYear() - birthday.getFullYear();
            let month = today.getMonth() - birthday.getMonth();
            if (month < 0 || (month === 0 && today.getDate() < birthday.getDate())) {
                age--;
            }
            return age;
        },
        spayedToString(isFixed) {
            return isFixed.toString();
        }
    },

    created() {
      petService.getPetsByUserId(this.$store.state.user.id).then((response) => {
          if(response.status === 200) {
            this.pets = response.data;
            this.$store.commit('ADD_PETS_TO_USER', response.data )
            this.playdateArray = this.$store.state.playdateArray.filter(playdate => playdate.hostUserId === this.$store.state.user.id); // will need to adjust to allow for visitingUserId
            }
          });
       
       


    },
    mounted () {
        
    }

    //need:
    // - this user's playdates
    //to make this editable

}
</script>

<style scoped>
.user-pets {
    background-color: #52B69A;
}

</style>