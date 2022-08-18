<template>
  <div id="nav-bar">
      
      <div>
          <img class="logo" src="@/assets/images/TurtleTransparent.png" alt="cute green turtle logo" @click="homeReload">
      </div>
      <h1 class="title" @click="homeReload">Pickles</h1>
      <ul class="main-nav-list">
        
        

        <li>
          <router-link class="main-nav-link" :to="{name:'pet-register'}" v-if="$store.state.token != ''">register a pet</router-link>
        </li>

        <li class="li-first">
          <router-link class="main-nav-link" v-bind:to="{ name:'logout' }" v-if="$store.state.token != ''">logout</router-link>
           <router-link class="main-nav-link" v-bind:to="{ name:'register' }" v-else>register</router-link>
        </li>
        
        <li>
          <router-link class="main-nav-link" :to="{name: 'register-playdate'}">schedule a playdate</router-link>
        </li>

        <li>
          <router-link class="main-nav-link" :to="{path: '/profile/'+this.$store.state.user.id}">profile</router-link>
        </li>
      </ul>
      
      

      

  </div>
</template>

<script>
//import userService from '@/services/userService.js';
export default {
  name: 'nav-bar',
  data() {
    return {
      user: {}
    }
  },
  methods: {
    homeReload() {
      this.$router.push({name:'home'});
      this.$router.go(0);

    },
  },
  created() {
    //should just go to the store to get the current user? there is not necessarily a userId parameter in the path so this usually won't work
    // userService.getById(this.$route.params.userId)
    //   .then(response => {
    //     this.user = response.data;

    //   })
    this.user = this.$store.user;
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
  cursor: pointer; 
}
.title:hover {
  line-height: 4.05rem;
  cursor: pointer; 
}

.main-nav-list {
  list-style: none;
  display: flex;
  gap: 1.5rem;
  padding-right: 2.4rem;
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

.title {
  flex-grow: 1;
  color: var(--primary-green);
  margin: 0;
  padding-left: 1rem;
}

</style>