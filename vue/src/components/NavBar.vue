<template>
  <div id="nav-bar">
      
      <router-link v-bind:to="{name: 'home' }">
          <img class="logo" src="@/assets/images/TurtleTransparent.png" alt="cute green turtle logo">
      </router-link>
      <ul class="main-nav-list">
        <li>
          <router-link class="main-nav-link" :to="{name:'pet-register'}" v-if="$store.state.token != ''">register a pet</router-link>
        </li>
        <li>
          <router-link class="main-nav-link" v-bind:to="{ name:'logout' }" v-if="$store.state.token != ''">logout</router-link>
      <router-link class="main-nav-link" v-bind:to="{ name:'register' }" v-else>register</router-link>
        </li>
        <li>
          <router-link class="main-nav-link" :to="{name: 'profile', params: {userId: user.userId}}">profile</router-link>
        </li>
        <li>
          <router-link class="main-nav-link" :to="{/* TODO */}">schedule a playdate</router-link>
        </li>
        <li>
          <router-link class="main-nav-link" :to="{/* TODO */}">about us</router-link>
        </li>
      </ul>
      
      

      

  </div>
</template>

<script>
import userService from '@/services/userService.js';
export default {
  name: 'nav-bar',
  data() {
    return {
      user: {}
    }
  },

  created() {
    userService.getById(this.$route.params.userId)
      .then(response => {
        this.user = response.data;
      })
  }
}
</script>

<style scoped>
#nav-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  /* background-color: #52B69A; */
  height: 5rem;
  font-family: 'Cabin', sans-serif;
  width: 100%;
  background-color: white;
  position: fixed;
  top: 0;
  z-index: 100;
  

}

.logo {
  height:4rem;
  /* padding-left: .4rem; */
  flex-grow: 2;
}

.logo:hover {
  height: 4.05rem;
}

.main-nav-list {
  list-style: none;
  display: flex;
  gap: 1.5rem;
  padding-right: 1rem;
  align-items: center;
  justify-content: space-around;
  
  
}

.main-nav-link {
  text-decoration: none;
  display: inline-block;
  font-weight: 400;
  font-size: 1.2rem;
  color: #52B69A;
}

.main-nav-link:hover {
  text-decoration: underline;
}
</style>