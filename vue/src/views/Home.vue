<template>
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
</template>

<script>
import Login from '@/components/Login.vue'

export default {
  name: "home",
  components: {
    Login,
  

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
  background-color: aqua
}
.playdate-panel{
  background-color: burlywood;
}


</style>
