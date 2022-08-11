<template>

  <div id = "pet-register" class="text-center">
  
    <div class="left-panel">
      <h2>Pickles</h2>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nulla tempora repudiandae necessitatibus architecto. Reiciendis adipisci at fuga aut ratione! Obcaecati deleniti architecto aliquam repellendus optio ea, dolorem voluptatum nulla fuga.</p>
      
      <p></p>

      <img src="../assets\images\playful_cat_re_ac9g.svg" alt="playful cat" class="playful-cat">
    </div>
      <form class="pet-form-register" @submit.prevent="registerPet">
          
      <h1>Register New Pet: </h1>
      <label for="petName">Name: </label>
      <input type="text"
      id="petName"
      class="form-control"
      placeholder="Name"
      v-model="pet.name"
      required
      autofocus
      >

      
       <div></div>

      <label for="Species">Species:</label>
      <select id="petSpecies" class="form-control" v-model="pet.species" required>
        <option value="Dog">Dog</option>
        <option value="Cat">Cat</option>
        <option value="Rabbit">Rabbit</option>
        <option value="Reptile">Reptile</option>
        <option value="Other">Other</option>
      </select>
      <div></div>

    <label for="Sex">Sex:</label>
      <select id="petSex" class="form-control" v-model="pet.sex" required>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
      </select>

        <div></div>

      <label for="birthDate">Birthday: </label>
      <input id="birthDate" type="date" class="form-control" v-model="pet.birthDate" required>
        
        <div></div>

        <label for="petFixed">Fixed:</label>
      <select id="petFixed" class="form-control" v-model="pet.fixed" required>
        <option value="true">Yes</option>
        <option value="false">No</option>
      </select>
      <div></div>

      <div></div>

       <div></div>

        <label for="petVac">Vaccinated:</label>
      <select id="petVac" class="form-control" v-model="pet.hasVaccinations" required>
        <option value="true">Yes</option>
        <option value="false">No</option>
      </select>
      <div></div>

        <label for="petSize">Size:</label>
      <select id="petSize" class="form-control" v-model="pet.size" required>
        <option value="1"> Up to 15 pounds</option>
        <option value="2">15 - 30 pounds</option>
        <option value="3">30 - 50 pounds</option>
        <option value="4">50-90 pounds</option>
        <option value="5">Bigger than 90 pounds</option>
      </select>
      <div></div>


        <label for="Personalities">Personalities:</label>
       <multiselect id="personality" v-model="value" :options="options" :close-on-select="false" track-by="id" label="personality" :hide-selected="true" multiple=true></multiselect> 
       
      <div></div>
        
       <button 
      id="upload_widget" 
      class="cloudinary-button">
        Upload photo
      </button>
      
    
    <!-- placeholder for uploaded image -->
      <img id="uploadedimage" src="" /> 

      <button id="selectBtn" class="btn" type="submit">
          Add Pet
      </button>
        
      </form>
      <div class="right-panel"></div>
  </div>
</template>

<script>
import Multiselect from 'vue-multiselect'
import petService from '@/services/petService.js'
// import NavBar from '@/components/NavBar.vue'
//import {Cloudinary} from 'cloudinary-core';

const cloudName = "picklepoints"; 
const uploadPreset = "uw_test"; 
const cloudinary = window.cloudinary;

export default {
     mounted() {
       const myWidget = cloudinary.createUploadWidget(
        {

          cloudName: cloudName,
          uploadPreset: uploadPreset,
        },
        (error, result) => {
          if (!error && result && result.event === "success") {
            console.log("Done! Here is the image info: ", result.info);
            document
              .getElementById("uploadedimage")
              .setAttribute("src", result.info.secure_url);
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
    name: 'pet-register',
    data() {
        return {
            pet: {
                name: '',
                species: '',
                sex: '',
                birthDate: '',
                personality: [],
                fixed: false,
                hasVaccinations: false,
                size:''   
            },
             value: [],
        options: [
          {
            "id" : 1,
           "personality":'Timid',  
          },
          
           {
            "id" : 2,
           "personality":'Tires Quickly',   
          },
          
           {
            "id" : 3,
           "personality":'Independent',
          },

           {
            "id" : 4,
           "personality":'Playful', 
          },

           {
            "id" : 5,
           "personality":'Toy Sharing', 
          },

           {
            "id" : 6,
           "personality": 'Confident', 
          },

           {
            "id" : 7,
           "personality":'High Energy', 
          },

           {
            "id" : 8,
           "personality":'Toy Possessive'
          }
          ]         
        }
    },
    methods: {
      registerPet() {

        for (var i of this.value) {
          this.pet.personality.push(i.id)
        }

        if (this.pet.fixed === "true") {
          this.pet.fixed = true;
        } else if (this.pet.fixed === "false") {
          this.pet.fixed = false;
        }


        if (this.pet.hasVaccinations === "true") {
          this.pet.hasVaccinations = true;
        } else if (this.pet.hasVaccinations === "false") {
          this.pet.hasVaccinations = false;
        }

        // this.pet.isFixed = Boolean(this.pet.isFixed);
        // this.pet.hasVaccinations = Boolean(this.pet.hasVaccinations);

        petService.createPet(this.pet)
         .then(response => {
           if (response.status === 200) 
            return;  // add commit mutation to update the $store.state
         })
      },
    },
}
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css">
 
#personality {
    width: 150px;
}

</style>

<style scoped>
#pet-register {
  display: flex;
  justify-content: space-between;
}
 
.pet-form-register {
  display: flex;
  flex-direction: column;
  width: 40%;
  justify-content: center;
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
  border-radius: .5rem;
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
  justify-content: center;
  
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

#upload_widget {
  margin-top: 15px;
  margin-bottom: 10px;
  background-color: #76C893;
  color: white;
  border-radius: 10px;
}

 #selectBtn{
  display: flex;
  justify-content: center;
  
} 

</style>