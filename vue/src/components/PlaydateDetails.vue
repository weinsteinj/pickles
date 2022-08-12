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
      pets: []
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
        // for (var petid of this.playdate.petId) {
        //     this.pets.push(this.$store.state.petArray.filter(x => {
        //         x.petId === petid;
        //     });
        // }
        return this.pets;
      }
   
  }
  
};
</script>