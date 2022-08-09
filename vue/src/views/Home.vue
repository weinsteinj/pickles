<template>
<div class="root">
  <div class="home">
    <div class="playdate-panel">
      PLAYDATE STUFF
      <br>
      PLAYDATE STUFF
      <br>
      PLAYDATE STUFF
      <br>
      PLAYDATE STUFF
      <br>
      PLAYDATE STUFF
      <br>
      </div>
    <div class="login-panel">
    <login v-if="$store.state.token == ''"></login>
    </div>
</div>

    <div class="pet-spotlight">
      <pet-spotlight></pet-spotlight>
      </div>


  </div>
</template>

<script>
import Login from '@/components/Login.vue';
import PetSpotlight from '@/components/PetSpotlight.vue';

export default {
  name: "home",
  components: {
    Login,
    PetSpotlight
  

  }
};
</script>

<style scoped>
.home {
  display: flex;
  justify-content: space-around;
}
.login-panel,.playdate-panel{
  /* flex-grow: 1 */
  flex-basis: 40%;
  
}
.login-panel {
  background-color: var(--primary-green);
  border-radius: 15px 0 0 0;
}
.playdate-panel{
  background-color: var(--secondary-green);
}


</style>
