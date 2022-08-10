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
    <div class="login-panel" v-if="$store.state.token == ''">
    <login></login>
    </div>
</div>
    <div>
    <app-intro></app-intro>
    </div>
    <div class="pet-spotlight">
      <pet-spotlight></pet-spotlight>
      </div>


  </div>
</template>

<script>
import Login from '@/components/Login.vue';
import PetSpotlight from '@/components/PetSpotlight.vue';
import AppIntro from '@/components/AppIntro.vue';

export default {
  name: "home",
  components: {
    Login,
    PetSpotlight,
    AppIntro,
  

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
  border-radius: 15px 15px 15px 15px;
  
  margin: 0 1rem 0 1rem;
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.18);
  height: 45vh;
  transition: box-shadow 10ms;
}

.login-panel:hover,
.playdate-panel:hover {
  box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.18);
  
}

.playdate-panel{
  background-color: var(--secondary-green);
  flex-grow: 1;
  margin: 0 1rem 0 1rem;
  border-radius: 15px 15px 15px 15px;
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.18);
  height: 45vh;
  
}


</style>
