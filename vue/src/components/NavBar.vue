<template>
  <div id="nav-bar">
      
      <router-link v-bind:to="{name: 'home' }">
          <img class="logo" src="@/assets/images/TurtleTransparent.png" alt="cute green turtle logo">
      </router-link>
      <ul class="main-nav-list">
        <li>
          <router-link class="main-nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">logout</router-link>
      <router-link class="main-nav-link" v-bind:to="{ name: 'login' }" v-else>login</router-link>
        </li>
        <li>
          <router-link class="main-nav-link" :to="{/* TODO */}">profile</router-link>
        </li>
        <li>
          <router-link class="main-nav-link" :to="{/* TODO */}">play-dates</router-link>
        </li>
        <li>
          <router-link class="main-nav-link" :to="{/* TODO */}">about us</router-link>
        </li>
      </ul>
      

      

  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
#nav-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  /* background-color: #52B69A; */
  height: 5rem;
  position: relative;
  font-family: 'Cabin', sans-serif;

}

.logo {
  height:4rem;
  /* padding-left: .4rem; */
  flex-grow: 2;
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
</style>