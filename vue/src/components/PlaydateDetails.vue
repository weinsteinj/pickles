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
  created() {
    playdateService.getById(this.$route.params.playdateId)
      .then(response => {
        this.playdate = response.data;
        this.pets = this.playdate.petId;
      })
  },
  data() {
    return {
      playdate: {},
      pets: []
    }
  }
};
</script>