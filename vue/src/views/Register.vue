<template>
  <div id="register" class="text-center">
    <div class="left-panel">
Lorem ipsum dolor sit amet consectetur adipisicing elit. Nulla tempora repudiandae necessitatibus architecto. Reiciendis adipisci at fuga aut ratione! Obcaecati deleniti architecto aliquam repellendus optio ea, dolorem voluptatum nulla fuga.      <h2>Pickles</h2>
      <p></p>

      <img src="../assets/images/woman-withdog.svg" alt="woman with dog" class="woman-with-dog">
    </div>

    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create an Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>

      <!-- <div class="first-name"> -->
        <label for="first-name" class="first-name-label">First Name</label>
        <input
          class="first-name-input"
          type="text"
          id="first-name"
          v-model="user.firstName"
          required
          autofocus
        />
      <!-- </div> -->

      <!-- <div class="last-name"> -->
        <label for="last-name" class="last-name-label">Last Name</label>
        <input
          class="last-name-input"
          type="text"
          id="last-name"
          v-model="user.lastName"
          required
          autofocus
        />
      <!-- </div> -->

      <!-- <div class="email"> -->
        <label class="email-label" for="email">Email Address</label>
        <input
          class="email-input"
          type="text"
          id="emailAddress"
          v-model="user.email"
          required
          autofocus
        />
      <!-- </div> -->

      <!-- <div class="username"> -->
        <label for="username" class="username-label">Username</label>
      <input
        type="text"
        id="username"
        class="username-input"
        v-model="user.username"
        required
        autofocus
      />
      <!-- </div> -->
      
      <!-- <div class="password"> -->
       <label for="password" class="password-label">Password</label>
      <input
        type="password"
        id="password"
        class="password-input"
        v-model="user.password"
        required
      /> 
      <!-- </div> -->
      
      <!-- <div class="confirm-password"> -->
        <label for="confirmPassword" class="confirm-password-label"
        >Confirm Password</label
      >
      <input
        type="password"
        id="confirmPassword"
        class="confirm-password-input"
        v-model="user.confirmPassword"
        required
      />
      <!-- </div> -->
      

      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>

      <div class="login-link">
        <router-link :to="{ name: 'home' }" class="already-has-account"
        >Already Have an account?</router-link
      >
      </div>
      
    </form>
    <div class="right-panel">
      
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register-view",
  data() {
    return {
      user: {
        firstName: "",
        lastName: "",
        username: "",
        password: "",
        email: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.go(-1
              //   {
              //   path: "/login",
              //   query: { registration: "success" },
              // }
              );
            }
          })
          .catch((error) => { // TODO: Figure out accurate response.messages
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>



<style>
.h3 {
  grid-area: "create-h3";
}

.first-name-label {
  grid-area: "fn-label";
}

.first-name-input {
  grid-area: "fn-input";
}

.last-name-label {
  grid-area: "ln-label";
}

.last-name-input {
  grid-area: "ln-input";
}

.email-label {
  grid-area: "e-label";
}

.email-input {
  grid-area: "e-input";
}

.username-label {
  grid-area: "u-label";
}

.username-input {
  grid-area: "u-input";
}

.password-label {
  grid-area: "pw-label";
}

.password-input {
  grid-area: "pw-input";
}

.confirm-password-label {
  grid-area: "c-pw-label";
}

.confirm-password-input {
  grid-area: "c-pw-input";
}

.btn-primary {
  grid-area: "create-btn";
}

.already-has-account {
  grid-area: "has-accnt-link";
}

.first-name {
  grid-area: "fn";
}

.last-name {
  grid-area: "ln";
}

.email {
  grid-area: "email";
}

.username {
  grid-area: 'username';
}

.password {
  grid-area: 'password';
}

.confirm-password {
  grid-area: 'confirm-password';
}
.form-register {
  display: flex;
  /* grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "create-h3 create-h3"
    "fn fn"
    "ln ln"
    "email email"
    "username username"
    "password password"
    "confirm-password confirm-password"
    "create-btn create-btn"
    "has-accnt-link has-accnt-link"; */
  flex-direction: column;
  width: 40%;
}

#register {
  display: flex;
  justify-content: space-between;
}

.left-panel {
  width: 20%;
  background-color: var(--secondary-green);
  height: 1000px;
  display: flex;
  flex-direction: column;
}

label {
  font-weight: bold;
  display: inline-block;
}

.btn {
  margin-top: .5rem;
  line-height: 2rem;
  width: 50%;
  border-radius: .5rem;
  background-color: var(--btn-green);
  font-family: 'Cabin', sans-serif; 
  color: white;
  margin-bottom: .5rem;
}

.btn:hover {
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.18);
}

.login-link {
  display: inline-block;
  

}

.already-has-account {
  text-decoration: none;
  color: var(--primary-green);
}

.already-has-account:hover {
  text-decoration: underline;
}

input {
  background-color: rgb(226, 223, 223);
  display: inline-block;
  line-height: 2rem;
  border-radius: .5rem;
  margin-bottom: 1rem;
  
}

h1 {
  margin-top: 7rem;
}

h2 {
  text-align: center;
  color: var(--primary-green);
}

p {
  padding-left: 1rem;
  color: var(--primary-green);
}

.woman-with-dog {
  width: 100%;
  justify-self: flex-end;
  flex-grow: 2;
}
</style>
