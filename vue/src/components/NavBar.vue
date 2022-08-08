<template>
  <div id="nav-bar">
      
      <router-link v-bind:to="{name: 'home' }">
          <img class="logo" src="@/assets/images/FullTurtle.png" alt="cute green turtle logo">
      </router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>

      This is our persistent Navigation Bar!

  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>