<template>
  <div id="pet-register" class="text-center">
    <div class="left-panel">
      <h2>Pickles</h2>
      <p>
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Nulla tempora
        repudiandae necessitatibus architecto. Reiciendis adipisci at fuga aut
        ratione! Obcaecati deleniti architecto aliquam repellendus optio ea,
        dolorem voluptatum nulla fuga.
      </p>

      <p></p>

      <img
        src="../assets\images\playful_cat_re_ac9g.svg"
        alt="playful cat"
        class="playful-cat"
      />
    </div>
    <form class="playdate-form-register" @submit.prevent="registerPlaydate">
      <h1>
        Hi, {{ this.$store.state.user.firstName }}! Register New Playdate:
      </h1>
      <h2>You are scheduling a playdate for</h2>
      <!-- <p v-for="pet in $store.state.currentUserPetArray" v-bind:key="pet.id">{{pet.name}}</p> -->

      <multiselect
        id="pets"
        multiple="true"
        v-model="value"
        :options="options"
        :close-on-select="false"
        track-by="petId"
        label="name"
        :hide-selected="false"
      ></multiselect>

      <br>

      <label for="zip-code">Zip Code: </label>
      <input
        maxlength="5"
        type="text"
        id="zip-code"
        class="form-control"
        placeholder="Zip Code"
        v-model="playdate.zipCode"
        required
        autofocus
      />

      <label for="date">Select a date: </label>
      <input
        id="date"
        type="date"
        class="form-control"
        v-model="date"
        required
      />

      <label for="time">Time: </label>
      <input
        id="time"
        type="time"
        class="form-control"
        v-model="time"
        required
      />

      <label for="details">Details: </label>
      <textarea
        name="details"
        id="details"
        type="text"
        class="form-control"
        v-model="playdate.details"
        required
        cols="30"
        rows="10"
        maxlength="1000"
      ></textarea>

      <button type="button" id="upload_widget" class="cloudinary-button">
        Upload photo
      </button>

      <div class="addButton">
        <button id="selectBtn" class="btn" type="submit">Add Playdate</button>
      </div>
    </form>

    <!-- placeholder for uploaded image -->
    <!-- <img id="uploadedimage" src="" />  -->
    <div class="right-panel"></div>
  </div>
</template>

<script>
import playdateService from "@/services/playdateService.js";
import petService from "@/services/petService.js";
import Multiselect from "vue-multiselect";
// import NavBar from '@/components/NavBar.vue'
//import {Cloudinary} from 'cloudinary-core';

const cloudName = "picklepoints";
const uploadPreset = "uw_test";
const cloudinary = window.cloudinary;

export default {
  created() {
    //we should be able to get this from the store at this point
    petService
      .getPetsByUserId(this.$store.state.user.id)
      .then((response) => {
        if (response.status === 200) {
          this.$store.commit("ADD_PETS_TO_USER", response.data);

          for (var pet of this.$store.state.currentUserPetArray) {
            this.options.push(pet);
          }
        }
      })
      .catch((error) => {
        const response = error.response;
        if (response.status >= 400 && response.status < 500) {
          alert("Error: Bad Request!");
        }
      });
  },
  mounted() {
    const myWidget = cloudinary.createUploadWidget(
      {
        cloudName: cloudName,
        uploadPreset: uploadPreset,
        tags: ["playdate"],
      },
      (error, result) => {
        if (!error && result && result.event === "success") {
          console.log("Done! Here is the image info: ", result.info.secure_url);
          this.playdate.playdatePhoto = result.info.secure_url;
        }
      }
    );

    document.getElementById("upload_widget").addEventListener(
      "click",
      function () {
        myWidget.open();
      },
      false
    );
  },
  components: {
    Multiselect,
    // NavBar,
  },
  name: "playdate-register",
  data() {
    return {
      playdate: {
        zipCode: 0,
        dateTime: "",
        details: "",
        petId: [],
        rating: 0,
        playdatePhoto: "",
        userId: 0,
      },
      value: [],
      options: [],

      date: "",
      time: "",
    };
  },
  methods: {
    registerPlaydate() {
      if (this.$store.state.currentUserPetArray.length === 0) {
        alert("Please register a pet before scheduling a playdate!");
        this.$router.push({ name: "pet-register" });
      } else {
        this.playdate.dateTime = this.date + "T" + this.time;
        this.playdate.userId = this.$store.state.user.id;
        this.playdate.zipCode = Number.parseInt(this.playdate.zipCode);
        for (var i of this.value) {
          this.playdate.petId.push(i.petId);
        }
        playdateService.createPlaydate(this.playdate).then((response) => {
          if (response.status === 200) {
            playdateService.getAllPlaydates().then((response) => {
              if (response.status === 200) {
                this.$store.commit("ADD_ALL_PLAYDATE", response.data);
              }
            });
            this.$router.push("/");
            this.$router.go(0);
          }
        });
      }
    },
    detailsMaxLengthAlert(myDetails) {
      let maxLength = 1000;
      if (myDetails.details.value.length >= maxLength) {
        let msg =
          "You have reached your maximum limit of characters allowed (1000).";
        alert(msg);
      }
    },
  },
  computed: {},
};
</script>

<style>
#personality {
  width: 150px;
}
</style>

<style scoped>
.addButton {
  display: flex;
  justify-content: center;
}
h1 {
  text-align: center;
}
#pet-register {
  display: flex;
  justify-content: space-between;
}

.playdate-form-register {
  display: flex;
  flex-direction: column;
  width: 40%;
}

#petName {
  /* margin-left: 50px; */
  /* width: 170px;
   margin-bottom: 0px;
   margin-left: 0; */
}

/* #petSpecies {
    
  
     height:  2rem;
     margin-left: 0;

} */

select,
#personality {
  background-color: rgb(226, 223, 223);
  display: inline-block;
  line-height: 2rem;
  border-radius: 0.5rem;
  margin-bottom: 1rem;
  margin-left: 0;
  height: 2rem;
}

.multiselect__tag {
  background-color: var(--primary-green);
}

/* #petSex {
    margin-left: 67px;
    width: 175px;
    height: 25px;
} */

/* #birthDate {
    margin-top: 10px;
    margin-left: 34px;
    margin-bottom: 10px;
    width: 175px;
}
 #petFixed {
     width: 175px;
     height: 25px;
     margin-left: 57px;
    }

#petVac { 
     height: 25px;
     width: 175px;
     margin-top: 10px;
     margin-left: 18px;
    }


#petSize {
     width: 175px;
     height: 25px;
     margin-left: 63px;
     margin-top: 10px;
     margin-bottom: 10px;
    }

.multiselect {
    width: 400px;
    margin-bottom: 50px;;
    margin-top: 10px;
}

#selectBtn {
    margin-left: 95px;
    width: 170px;
}


.multiselect {
    width: 400px;
    margin-bottom: 50px;;
    margin-top: 10px;
}

#selectBtn {
    margin-left: 95px;
    width: 170px;
} */
.left-panel {
  display: flex;
  flex-direction: column;
}
.playful-cat {
  width: 100%;
  justify-self: flex-end;
  flex-grow: 2;
}
.form {
  display: flex;
  flex-direction: column;
}
.pet-form-register {
  /* grid-area: form; */
  display: flex;
  flex-direction: column;
  width: 40%;
}
.left-panel {
  /* grid-area: left-panel; */
}
.right-panel {
  /* grid-area: right-panel; */
  /* width: 20%; */
}
div.text-center {
  /* display: flex;

  display: grid;
  grid-template-areas: "left-panel form right-panel";
  grid-template-columns: 1fr, 1fr, 1fr; */
}

#details {
  background-color: rgb(226, 223, 223);
  margin-bottom: 1rem;
  border-radius: 0.5rem;
}

.multiselect__tags {
  background-color: rgb(226, 223, 223);
  font-size: 1rem;
  background: rgb(226, 223, 223);
}
</style>
