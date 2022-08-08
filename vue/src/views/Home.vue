<template>
  <div class="home">
    <div>PLAYDATE STUFF</div>
    <div>
    <login></login>
    </div>
  
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
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
}
</style>
