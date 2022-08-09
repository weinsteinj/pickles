<template>
  <div id = "pet-register" class="text-center">
      <form class="pet-form-register" @submit.prevent>
          
      <h1>Register New Pet: </h1>
      <label for="petName">Name: </label>
      <input type="text"
      id="petName"
      class="form-control"
      placeholder="Name"
      v-model="pet.name"
      required
      autofocus
      />


      
      <div></div>

      <label for="Species">Species:</label>
      <select id="petSpecies" class="form-control" v-model="pet.species" required>
        <option value="1">Dog</option>
        <option value="2">Cat</option>
        <option value="3">Rabbit</option>
        <option value="4">Reptile</option>
        <option value="5">Other</option>
      </select>
      <div></div>

    <label for="Sex">Sex:</label>
      <select id="petSex" class="form-control" v-model="pet.sex" required>
        <option value="1">Male</option>
        <option value="2">Female</option>
      </select>

        <div></div>

      <label for="birthDate">Birthday: </label>
      <input id="birthDate" type="date" class="form-control" v-model="pet.birthDate" required>
        
        <div></div>

        <label for="petFixed">Fixed:</label>
      <select id="petFixed" class="form-control" v-model="pet.isFixed" required>
        <option value="1">Yes</option>
        <option value="2">No</option>
      </select>
      <div></div>

      <div></div>

       <div></div>

        <label for="petVac">Vaccinated:</label>
      <select id="petVac" class="form-control" v-model="pet.hasVaccinations" required>
        <option value="1">Yes</option>
        <option value="2">No</option>
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
       <multiselect id="personality" v-model="value" :options="options" :close-on-select="false" :hide-selected="true" multiple=true></multiselect>
       
      <div></div>

      <button id="selectBtn" type="submit">
          Add Pet
      </button>
        
      </form>
      
  </div>
</template>

<script>
import Multiselect from 'vue-multiselect'

export default {
     components: {
    Multiselect
  },
    name: 'pet-register',
    data() {
        return {
            pet: {
                name: '',
                species: '',
                sex: '',
                birthDate: '',
                personality: '',
                isFixed: '',
                hasVaccinations: '',
                size:''   
            },
             value: '',
      options: ['Timid', 'Tires Quickly', 'Independent', 'Playful', 'Toy Sharing', 'Confident', 'High Energy', 'Toy Possessive']
            
        }
    }

}
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css">
 
#personality {
    width: 150px;
}

</style>

<style>
 


 #petName {
   margin-left: 50px;
   width: 170px;
   height: 30px;
   margin-bottom: 0px;
}

#petSpecies {
    margin: 10px;
     width: 175px;
     height: 25px;
     margin-left: 40px;

}

#petSex {
    margin-left: 67px;
    width: 175px;
    height: 25px;
}

#birthDate {
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


</style>