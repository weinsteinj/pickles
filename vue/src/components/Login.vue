<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h2 class="h3 mb-3 font-weight-normal">Please Sign In</h2>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      
      <input
        type="password"
        id="password"
        class="form-control"
        v-model="user.password"
        required
      />
      <div class="homePageButtons">
      <button class="btn" type="submit">Sign in</button>
      <router-link :to="{ name: 'register' }" class="need-account">Need an account?</router-link>  
      </div>
      
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import petService from "../services/petService.js";
import geocodeService from "@/services/geocodeService.js";

export default {
  name: "login-component",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);    
          petService.getPetsByUserId(this.$store.state.user.id)
          .then(response => {
            if(response.status === 200) {
            this.$store.commit('ADD_PETS_TO_USER', response.data )
            }
          });
          geocodeService.getMarkerByUserId(this.$store.state.user.id)
          .then(response => {
            if(response.status === 200) {
              this.$store.commit("SET_USER_MARKER", response.data) 
            }
          })
            this.$router.push("/");
            this.$router.go(0);
          }
          })
        .catch(error => {
          const response = error.response;
          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-signin {
  display: flex;
  flex-direction: column;
  width: 80%;
  flex-grow: 1;
  flex-basis: 100%;
  margin: 10%

}

h2 {
  color: black;
  line-height: 0;
}

label {
  display: inline-block;
  
}

input {
  margin: 0px;
  display: inline-block;
  margin-bottom: 1rem;
  
}
#login {
    width: 100%;

}

.btn {
  max-width: 50%;
  
}

label {
  font-weight: bold;
}

.need-account {
  text-decoration: none;
  color: black;
}

.need-account:hover {
  text-decoration: underline;
}
.homePageButtons{
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}


</style>
