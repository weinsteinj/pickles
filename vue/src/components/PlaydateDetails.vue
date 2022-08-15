<template>
  <div>
    <div>
      <h1>Welcome to Playdate</h1>
      <h2>Details:</h2>
      <p>{{ activePlaydate.details }}</p>
      <h2>Time:</h2>
      <p>{{ activePlaydate.dateTime }}</p>
      <h2>Host:</h2>
      <p>{{ activePlaydate.hostUsername }}</p>
      <h2>Pets:</h2>
      <p v-for="pet in pets" v-bind:key="pet.id">{{pet.name}}</p> 
     <img v-if="activePlaydate.playdatePhoto!==''" :src="activePlaydate.playdatePhoto" />
     <div v-if="activePlaydate.status=='Posted'">
     <h2>Want to come to this playdate? Request an invitation!</h2>
     <button class="btn" @click="requestInvite"> Request an Invite </button>
     </div>
     <div v-if="activePlaydate.status=='Pending'">
       <h2>An invite has been requested, check back soon!</h2>
       </div>
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
      this.pets(unique); //is this doing anything - keep getting errors
    }
    });
    
  },
  methods: {
    requestInvite() {
      this.activePlaydate.visitingUserId = this.$store.state.user.id;
      this.activePlaydate.status = "Pending";
      playdateService.updatePlaydate(this.activePlaydate.playdateId,this.activePlaydate)
      .then((response) => {
      console.log(response.data);})
     //commit this to the store?
      .catch((err)=>console.error(err));
    }
  }
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