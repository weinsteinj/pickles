<template>
<div class="root">
  <div class="home">
      <div class="playdate-panel">
        
          <add-google-map></add-google-map>
      
        <div class="playdate-list"> 
          <play></play>
        </div>
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
import play from '../components/PlayDate.vue';
import AddGoogleMap from '@/components/AddGoogleMap.vue';

export default {
  name: "home",
  components: {
    Login,
    PetSpotlight,
    AppIntro,
    play,
    AddGoogleMap,
  

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
  flex-basis: 33%;
  
}
.login-panel {
  background-color: var(--primary-green);
  border-radius: 15px 15px 15px 15px;
  flex-grow: 1;
  margin: 0 1rem 0 1rem;
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.18);
  height: 40vh;
  transition: box-shadow 10ms;
}

.login-panel:hover,
.playdate-panel:hover {
  box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.18);
  
}

.playdate-panel{
  display: flex;
  background-color: var(--secondary-green);
  flex-grow: 90;
  margin: 0 1rem 0 1rem;
  border-radius: 15px 15px 15px 15px;
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.18);
  height: 40vh;
  
}
.playdate-map{
  height: 10%;
  width: 10%;
}

.playdate-list{}

body {
  padding-top: 1rem;
}


</style>
