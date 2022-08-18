<template>
  <div>
    <h2>{{ pet.name }}'s Details</h2>
    <div class="pet-details">
      <div class="left-panel">
        <h2 class="h2">Pickles</h2>
        <p>
         Socialization is vital to your pet's quality of life but finding a playdate can be easier said than done. Whether it be dealing with scheduling conflicts, finding a pet pal that is compatible with your fur-baby, or your loved ones simply do not have pets for yours to play with. With Pickles we want to make that task stress free so you can focus on having fun with your animals. Pickles will help you find playdates in your area, schedule with other pet-parents, or create your own playdate to invite others to. Let us help you maximize your pet's fun with ease!

        </p>

        <p></p>

        <img
          src="../assets\images\playful_cat_re_ac9g.svg"
          alt="playful cat"
          class="playful-cat"
        />
      </div>
      <div class="pet-panel">
        <div class="petImage">
          <img :src="pet.petPhoto" alt="pet photo" class="pet-img" />
        </div>
        <div class="pet-info">
          <div class="pet-item" v-if="!isEditing">
            <label for="pet-name">Name:</label>
            <span>{{ pet.name }}</span>
          </div>

          <div class="pet-item-edit" v-if="isEditing">
            <label for="pet-name">Name:</label>
            <input
              class="field"
              name="pet-name"
              type="text"
              v-model="pet.name"
              :disabled="!isEditing"
              :class="{ view: !isEditing }"
            />
          </div>

          <div v-if="!isEditing" class="pet-item">
            <label for="pet-age">Age:</label>
            <span>{{ getAge(pet.birthDate) }}</span>
          </div>

          <div v-if="isEditing" class="pet-item-edit">
            <label for="pet-age">Birthday:</label>
            <input
              class="field"
              type="date"
              v-model="pet.birthDate"
              :class="{ view: !isEditing }"
            />
          </div>

          <div v-if="!isEditing" class="pet-item">
            <label for="pet-species">Species:</label>
            <span>{{ pet.species }}</span>
          </div>

          <div v-if="isEditing" class="pet-item-edit">
            <label for="pet-species">Species:</label>
            <select
              class="field"
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

          <div v-if="!isEditing" class="pet-item">
            <label for="pet-sex">Sex:</label>
            <span>{{ pet.sex }}</span>
          </div>

          <div v-if="isEditing" class="pet-item-edit">
            <label for="pet-sex">Sex:</label>
            <select
              class="field"
              v-model="pet.sex"
              :disabled="!isEditing"
              :class="{ view: !isEditing }"
            >
              <option value="Male">Male</option>
              <option value="Female">Female</option>
            </select>
          </div>

          

          <div v-if="!isEditing" class="pet-item">
            <label for="pet-fixed">Spayed/Neutered:</label>
            <span>{{ pet.fixed }}</span>
          </div>

          <div v-if="isEditing" class="pet-item-edit">
            <label for="pet-fixed">Spayed/Neutered:</label>
            <select
              class="field"
              v-model="pet.fixed"
              :disabled="!isEditing"
              :class="{ view: !isEditing }"
            >
              <option value="true">Yes</option>
              <option value="false">No</option>
            </select>
          </div>

          <div v-if="!isEditing" class="pet-item">
            <label for="pet-vaccinations">Vaccinated:</label>
            <span>{{ pet.hasVaccinations }}</span>
          </div>

          <div v-if="isEditing" class="pet-item-edit">
            <label for="pet-vaccinations">Vaccinated:</label>
            <select
              class="field"
              v-model="pet.hasVaccinations"
              :disabled="!isEditing"
              :class="{ view: !isEditing }"
            >
              <option value="true">Yes</option>
              <option value="false">No</option>
            </select>
          </div>

          <div v-if="!isEditing" class="pet-item">
            <label for="pet-size"
              >Size: <span>{{ sizeToString(pet.size) }}</span></label
            >
          </div>

          <div v-if="isEditing" class="pet-item-edit">
            <label for="pet-size">Size:</label>
            <select
              class="field"
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

          <div v-if="!isEditing" class="pet-item-last">
            <label for="pet-personality"
              >Personality:
              <span>{{ personalityToString(pet.personality) }}</span></label
            >
          </div>

          <div v-if="isEditing" class="pet-item-edit">
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
          <div></div>
          <button
            v-if="isEditing"
            @click="uploadWidget"
            type="button"
            id="upload_widget"
            class="cloudinary-button"
          >
            Upload new photo
          </button>
          <button @click="savePet(pet)" v-if="isEditing">Save</button>

          <button v-if="isEditing" @click="isEditing = false">Cancel</button>

          <div v-if="$store.state.user.id === pet.userId">
            <button
              @click="isEditing = !isEditing"
              v-if="!isEditing"
              class="edit-btn"
            >
              Edit
            </button>
          </div>
        </div>
      </div>

      <div class="right-panel"></div>
    </div>
  </div>
</template>

<script>
import petService from "@/services/petService.js";
import Multiselect from "vue-multiselect";
const cloudName = "picklepoints";
const uploadPreset = "uw_test";
const cloudinary = window.cloudinary;

export default {
  name: "pet-details",
  components: {
    Multiselect,
  },
  created() {
    petService
      .getPetById(Number.parseInt(this.$route.params.petId))
      .then((response) => {
        if (response.status === 200) {
          this.pet = response.data;
        }
      })
      .catch(() => {
        alert("There seems to have been an error fetching the pet info!");
      });
  },
  data() {
    return {
      pet: null,
      isEditing: false,
      value: [],
      options: [
        {
          id: 1,
          personality: "Timid",
        },

        {
          id: 2,
          personality: "Tires Quickly",
        },

        {
          id: 3,
          personality: "Independent",
        },

        {
          id: 4,
          personality: "Playful",
        },

        {
          id: 5,
          personality: "Toy Sharing",
        },

        {
          id: 6,
          personality: "Confident",
        },

        {
          id: 7,
          personality: "High Energy",
        },

        {
          id: 8,
          personality: "Toy Possessive",
        },
      ],
    };
  },

  mounted() {
    // document.getElementById("upload_widget").addEventListener(
    //   "click",
    //   function () {
    //     myWidget.open();
    //   },
    //   false
    // );
  },

  methods: {
    hideEdit() {
      if (!this.isEditing && this.$store.state.user.id === this.pet.userId) {
        return true;
      } else {
        return false;
      }
    },
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
      pet.personality = [];
      for (let i of this.value) {
        pet.personality.push(i.id);
      }
      this.isEditing = false;
      petService.updatePet(pet, pet.petId).then((response) => {
        if (response.status === 200 || response.status === 204) {
          console.log(response);
          petService
            .getPetsByUserId(this.$store.state.user.id)
            .then((response) => {
              if (response.status === 200) {
                this.$store.commit("ADD_PETS_TO_USER", response.data);
              }
            });
        }
      });
    },
    sizeToString(sizeNum) {
      let size = "";
      switch (sizeNum) {
        case 1:
          size = "Up to 15 pounds";
          return size;
        case 2:
          size = "15 - 30 pounds";
          return size;
        case 3:
          size = "30 - 50 pounds";
          return size;
        case 4:
          size = "50 - 90 pounds";
          return size;
        case 5:
          size = "Bigger than 90 pounds";
          return size;
      }
      return size;
    },
    personalityToString(personalityArr) {
      let personalityString = "";

      personalityArr.forEach((personalityId) => {
        if (personalityId === 1) {
          personalityString += "| Timid |";
        } else if (personalityId === 2) {
          personalityString += "| Tires Quickly |";
        } else if (personalityId === 3) {
          personalityString += "| Independent |";
        } else if (personalityId === 4) {
          personalityString += "| Playful |";
        } else if (personalityId === 5) {
          personalityString += "| Toy Sharing |";
        } else if (personalityId === 6) {
          personalityString += "| Confident |";
        } else if (personalityId === 7) {
          personalityString += "| High Energy |";
        } else if (personalityId === 8) {
          personalityString += "| Toy Possessive |";
        }
      });

      return personalityString;
    },
    uploadWidget() {
      const myWidget = cloudinary.createUploadWidget(
        {
          cloudName: cloudName,
          uploadPreset: uploadPreset,
          tags: ["pet"],
        },
        (error, result) => {
          if (!error && result && result.event === "success") {
            console.log("Done! Here is the image info: ", result.info);
            this.pet.petPhoto = result.info.secure_url;
            document
              .getElementById("uploadedimage")
              .setAttribute("src", result.info.secure_url);
          }
        }
      );
      myWidget.open();
    },
  },
};
</script>

<style scoped>
.playful-cat {
  width: 100%;
  justify-self: flex-end;
  flex-grow: 2;
}

.pet-panel {
  display: flex;
  width: 58rem;
  justify-content: space-between;
  padding-top: 4rem;
}

.left-panel {
  display: flex;
  flex-direction: column;
  height: 100vh;
  border-radius: 10px;
}

.playful-cat {
  padding-top: 20rem;
}

.h2 {
  align-self: center;
  flex-grow: 0;
}

.pet-details {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.user-pets {
  background-color: #52b69a;
  display: flex;
  border-radius: 10px;
  margin-top: 1rem;
  justify-content: space-between;
  height: auto;
}

input,
select {
  margin: 0;
  line-height: 1rem;
  display: inline-block;
  padding: 0;
  text-align: left;
  border-radius: 5px;
  width: 50%;
}

.right-panel {
  width: 5%;
  /* background-color: var(--primary-green); */
  border-radius: 10px;
}

.pet-item {
  padding-bottom: .44rem;
}

.pet-item-last {
  padding-bottom: .4rem;
}

.pet-item-edit {
  display: grid;
  grid-template-columns: 1fr 1fr;
}

#upload_widget {
  /* height: 21px; */
  width: 100%;
  line-height: initial;
  background-color: var(--btn-green);
  font-family: 'Cabin', sans-serif;
  color: black;
  font-weight: bold;
  font-size: 1rem;
}

button {
  font-size: .9rem;
  font-family: 'Cabin', sans-serif;
}


.field {
  width: 288px;
  border-width: 1px;
  padding-inline-start: 0px;
}

.multiselect {
}

.pet-img {
  display: block;
  max-width: 25rem;
  max-height: 15rem;
  align-self: center;
  border-radius: 10px;
}

.playdate-img {
  display: block;
  width: 25rem;
  height: 100%;
  border-radius: 10px;
}

.pet-info {
  flex-grow: 1;
  padding-left: 1rem;
}

button {
  border-radius: 5px;
  width: 50%;
}

li {
  list-style: none;
}

.user-playdates {
  background-color: #d9ed92;
  display: flex;
  border-radius: 10px;
  margin-top: 1rem;
  justify-content: space-between;
  flex-direction: row;
}

.hosting-info {
  display: flex;
  flex-direction: column;
  width: 40%;
  justify-content: center;
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

span {
  font-weight: normal;
  padding-left: 5px;
}

.edit-btn {
  width: 5rem;
  height: 2rem;
  font-family: "Cabin", sans-serif;
  background-color: var(--btn-green);
  font-weight: bold;
  font-size: 1rem;
  float: left;
}

.header {
  display: flex;
  justify-content: space-between;
}

h1,
h2 {
  margin: 0;
  padding: 0;
  align-self: flex-end;
}

h1 {
  text-align: center;
}

h2 {
  flex-grow: 1;
  margin-top: 1rem;
}

.btn {
  width: 10rem;
  height: 3rem;
  line-height: initial;
  color: black;
  font-weight: bold;
  font-size: 1rem;
}

.edit-btn:hover {
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.18);
}

.playdateImage {
  width: 1%;
}

label {
  text-align: left;
}
</style>