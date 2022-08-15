<template>
  <div>
    <div>
      <h1>Welcome to Playdate</h1>
      <h2>Details:</h2>
      <p>{{ activePlaydate.details }}</p>
      <h2>Time:</h2>
      <p>{{ activePlaydate.dateTime }}</p>
      <h2>Host:</h2>
      <p>{{ activePlaydate.hostUserId }}</p>
      <h2>Pets:</h2>
      <p v-for="pet in pets" v-bind:key="pet.id">{{pet.name}}</p>
      <h2>Playdate Image</h2>
     <img v-if="activePlaydate.playdatePhoto!==''" :src="activePlaydate.playdatePhoto" />
    </div>
  </div>
</template>

<script>
import playdateService from "@/services/playdateService.js";

export default {
  name: "playdate-details",
  data() {
    return {
      pets: [{
        
      }],
      activePlaydate: [],
    };
  },
  // created() {

  //   },
  created() {
    playdateService.getById(this.$route.params.playdateId).then((response) => {
      this.activePlaydate = response.data;
      this.$store.commit("SET_ACTIVE_PLAYDATE", this.activePlaydate);

      const unique = (value, index, self) => {
      return self.indexOf(value) === index;
    };

    let allPetsArray = this.$store.state.petArray;
    let playdatePets = this.activePlaydate.petId;

    for (let i = 0; i < allPetsArray.length; i++) {
      playdatePets.forEach((element) => {
        allPetsArray.forEach((pet) => {
          let petIdHere = pet.petId;

          if (element == petIdHere) this.pets.push(pet);
        })
      })
      this.pets(unique);
    }
    });
    
  },
  // computed: {
  //     getPetsForPlaydateDetails() {
  //       console.log(this.playdate);
  //       for (var petid of this.playdate.petId) {
  //           for (var pet of this.$store.state.petArray) {
  //               if (pet.petId===petid) {
  //                 //  this.pet.push(pet); //this is what is not working!
  //               }
  //           }
  //       }
  //       return this.pets; //next try to move this back to created
  //     }

  // }
};
</script>