<template>
  <div>
    <div>
      <h1>Welcome to Playdate</h1>
      <p></p>
    </div>

  </div>
</template>

<script>
import playdateService from '@/services/playdateService.js';

export default {
  name: "playdate-details",
  data() {
    return {
      playdate: {},
    }
  },
  created() {
    playdateService.getById(this.$route.params.playdateId)
      .then(response => {
        this.playdate = response.data;
      });
  },
  computed: {
      getPetsForPlaydateDetails() {
        console.log(this.playdate);
        for (var petid of this.playdate.petId) {
            for (var pet of this.$store.state.petArray) {
                if (pet.petId===petid) {
                  //  this.pet.push(pet); //this is what is not working!
                }
            }
        }
        return this.pets; //next try to move this back to created
      }
   
  }
  
};
</script>