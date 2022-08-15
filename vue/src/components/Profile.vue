<template>
  <div>
    <h1>Welcome to {{ $store.state.user.firstName }}'s Profile.</h1>
    <h2>{{ $store.state.user.username }}'s Pets:</h2>
    <div
      v-for="pet in $store.state.currentUserPetArray"
      v-bind:key="pet.petId"
      class="user-pets"
    >
      <div><img :src="pet.petPhoto" alt="pet photo" class="pet-img" /></div>
      <div class="pet-info">
        <!-- <li>Name: {{pet.name}} </li> -->

        <div>
          <label for="pet-name">Name:</label>
          <input
            name="pet-name"
            type="text"
            v-model="pet.name"
            :disabled="!isEditing"
            :class="{ view: !isEditing }"
          />
        </div>

        <!-- <li>Species: {{pet.species}}</li> -->
        <div v-if="!isEditing">
          <label for="pet-species">Species:</label>
          <input v-model="pet.species" :disabled="!isEditing" :class="{ view: !isEditing }"/>
        </div>


        <div v-if="isEditing">
          <label for="pet-species">Species:</label>
          <select
            v-model="pet.species"
            :disabled="!isEditing"
            :class="{ view: !isEditing }"
          >
            <option value="Dog">Dog</option>
            <option value="Cat">Cat</option>
            <option value="Rabbit">Rabbit</option>
            <option value="Reptile">Reptile</option>
            <option value="Other">Other</option>
          </select>
        </div>

        <!-- <li>Sex: {{pet.sex}}</li> -->
        <div v-if="!isEditing">
          <label for="pet-sex">Sex:</label>
          <input v-model="pet.sex" :disabled="!isEditing" :class="{ view: !isEditing }"/>
        </div>

        <div v-if="isEditing">
          <label for="pet-sex">Sex:</label>
          <select
            v-model="pet.sex"
            :disabled="!isEditing"
            :class="{ view: !isEditing }"
          >
            <option value="Male">Male</option>
            <option value="Female">Female</option>
          </select>
        </div>

        <!-- <li>Age: {{getAge(pet.birthDate)}}</li> -->
        <div v-if="!isEditing">
          <label for="pet-age">Age:</label>
          <input
            type="text"
            :placeholder="getAge(pet.birthDate)"
            :disabled="true"
            :class="{ view: !isEditing }"
          />
        </div>

        <div v-if="isEditing">
          <label for="pet-age">Birthday:</label>
          <input
            type="date"
            v-model="pet.birthDate"
            :class="{ view: !isEditing }"
          />
        </div>

        <!-- <li>Spayed/Neutered: {{pet.fixed.toString()}}</li> -->
        <div v-if="!isEditing">
          <label for="pet-fixed">Spayed/Neutered:</label>
          <input
            type="text"
            v-model="pet.fixed"
            :disabled="!isEditing"
            :class="{ view: !isEditing }"
          />
        </div>

        <div v-if="isEditing">
          <label for="pet-fixed">Spayed/Neutered:</label>
          <select
            v-model="pet.fixed"
            :disabled="!isEditing"
            :class="{ view: !isEditing }"
          >
            <option value="true">Yes</option>
            <option value="false">No</option>
          </select>
        </div>

        <!-- <li>Vaccinations: {{ pet.hasVaccinations.toString() }}</li> -->
        <div v-if="!isEditing">
          <label for="pet-vaccinations">Vaccinated:</label>
          <input
            type="text"
            v-model="pet.hasVaccinations"
            :disabled="!isEditing"
            :class="{ view: !isEditing }"
          />
        </div>

        <div v-if="isEditing">
          <label for="pet-vaccinations">Vaccinated:</label>
          <select
            v-model="pet.hasVaccinations"
            :disabled="!isEditing"
            :class="{ view: !isEditing }"
          >
            <option value="true">Yes</option>
            <option value="false">No</option>
          </select>
        </div>

        <!-- <li>Size: {{ pet.size }}</li> -->
        <div v-if="!isEditing">
          <label for="pet-size">Size:</label>
          <input
            type="text"
            v-model="pet.size"
            :disabled="!isEditing"
            :class="{ view: !isEditing }"
          />
        </div>

        <div v-if="isEditing">
          <label for="pet-size">Size:</label>
          <select
            v-model="pet.size"
            :disabled="!isEditing"
            :class="{ view: !isEditing }"
          >
            <option value="1">Up to 15 pounds</option>
            <option value="2">15 - 30 pounds</option>
            <option value="3">30 - 50 pounds</option>
            <option value="4">50-90 pounds</option>
            <option value="5">Bigger than 90 pounds</option>
          </select>
        </div>

        <!-- <li>Personality: {{pet.personality}}</li> -->
        <div v-if="!isEditing">
          <label for="pet-personality">Personality:</label>
          <input
            type="text"
            v-model="pet.personality"
            :disabled="!isEditing"
            :class="{ view: !isEditing }"
          />
        </div>

        <div v-if="isEditing">
          <label for="pet-personality">Personality:</label>
          <multiselect
            id="personality"
            v-model="value"
            :options="options"
            :close-on-select="false"
            track-by="id"
            label="personality"
            :hide-selected="true"
            multiple="true"
          ></multiselect>
        </div>

        <button @click="savePet(pet)" v-if="isEditing">
          Save
        </button>

        <button @click="isEditing = !isEditing" v-if="!isEditing">
          Edit
        </button>

        <button v-if="isEditing" @click="isEditing = false">Cancel</button>
      </div>
    </div>

    <h2>Playdates you're hosting:</h2>
    <div
      v-for="playdate in playdateArray"
      v-bind:key="playdate.playdateId"
      class="user-playdates"
    >
      <div>
        <img
          :src="playdate.playdatePhoto"
          alt="playdate photo"
          class="playdate-img"
        />
      </div>
      <p>Details: <br />{{ playdate.details }}</p>
      <p>Time: <br />{{ playdate.dateTime }}</p>
      <p>Pets (Ids): <br />{{ playdate.petId[0] }} {{ playdate.petId[1] }}</p>
      <p>Status: <br />{{ playdate.status }}</p>
      <div v-if="playdate.status === 'Pending'">
      <p> User requesting an invitation: {{playdate.visitingUserId}} </p>
      <button @click="acceptInvite(playdate)"> Accept </button>
      <button @click="rejectInvite(playdate)"> Reject </button>
    
    </div>

    </div>

    <h2>Playdates you may attend:</h2>
    <div
      v-for="playdate in visitingPlaydateArray"
      v-bind:key="playdate.playdateId"
      class="user-playdates"
    >
      <div>
        <img
          :src="playdate.playdatePhoto"
          alt="playdate photo"
          class="playdate-img"
        />
      </div>
      <p>Details: <br />{{ playdate.details }}</p>
      <p>Time: <br />{{ playdate.dateTime }}</p>
      <p>Pets (Ids): <br />{{ playdate.petId[0] }} {{ playdate.petId[1] }}</p>
      <p>Status: <br />{{ playdate.status }}</p>
     
    </div>

    <!-- <button @click="test">Test</button> -->
  </div>
</template>

<script>
//import userService from '@/services/userService.js';
import petService from "@/services/petService.js";
import playdateService from "@/services/playdateService.js";
import Multiselect from "vue-multiselect";
export default {
  name: "profile-component",
  components: {
    Multiselect,
  },
  data() {
    return {
      isEditing: false,
      // user: {},
      pets: [],
      playdateArray: {},
      visitingPlaydateArray: {},
    };
  },

  methods: {
    getAge(birthDate) {
      let today = new Date();
      let birthday = new Date(birthDate);
      let age = today.getFullYear() - birthday.getFullYear();
      let month = today.getMonth() - birthday.getMonth();
      if (month < 0 || (month === 0 && today.getDate() < birthday.getDate())) {
        age--;
      }
      return age;
    },
    savePet(pet) {
        this.isEditing = false;
        petService.updatePet(pet, pet.petId)
            .then((response) => {
                if (response.status === 200 || response.status === 204) {
                    console.log(response);
                }
                
            })
    },
    acceptRequest(playdate) {
        playdate.status = "Accepted";
        playdateService.updatePlaydate(playdate.playdateId,playdate)
        .then((response) => {
             if (response.status === 200 || response.status === 204) {
                    console.log(response);
                } 
        })

    },
    rejectInvite(playdate) {
        playdate.status = "Pending";
        playdate.visitingUserId = null;
    },
    rejectRequest(playdate) {
        playdate.status = "Rejected";
        //playdate.visitingUserId = null;
        playdateService.updatePlaydate(playdate.playdateId,playdate)
        .then((response) => {
             if (response.status === 200 || response.status === 204) {
                    console.log(response);
                } 
        })

    }
  },

  created() {
    playdateService.getAllPlaydates()
      .then(response => {
       if(response.status===200) {
         this.$store.commit("ADD_ALL_PLAYDATE",response.data);
       }
      petService.getPetsByUserId(this.$store.state.user.id).then((response) => {
      if (response.status === 200) {
        this.pets = response.data;
        this.$store.commit("ADD_PETS_TO_USER", response.data);
        this.playdateArray = this.$store.state.playdateArray.filter(
          (playdate) => playdate.hostUserId === this.$store.state.user.id
        );
        this.visitingPlaydateArray = this.$store.state.playdateArray.filter(
          (playdate) => playdate.visitingUserId === this.$store.state.user.id
        );
      }
    });
  });
   
     
  },
  

  mounted() {},

  //need:
  // - this user's playdates
  //to make this editable
};
</script>

<style scoped>
.user-pets {
  background-color: #52b69a;
  display: flex;
  border-radius: 10px;
  margin-top: 1rem;
}

.pet-img {
  width: 25rem;
  height: 100%;
  border-radius: 10px;
}

.playdate-img {
  width: 25rem;
  height: 100%;
  border-radius: 10px;
}

.pet-info {
  flex-grow: 1;
}

li {
  list-style: none;
}

.user-playdates {
  background-color: #d9ed92;
  display: flex;
  border-radius: 10px;
  margin-top: 1rem;
}

h1 {
  margin-top: 0;
}

.view {
  border-color: transparent;
  background-color: initial;
  color: initial;
  font-family: "Cabin", sans-serif;
  font-size: initial;
}
</style>

