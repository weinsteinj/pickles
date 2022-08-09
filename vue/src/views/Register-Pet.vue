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

        <label for="Personalities">Personalities:</label>
       <multiselect id ="personality" v-model="value" :options="options" :close-on-select="false" multiple=true></multiselect>
       
      <div></div>
        
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
 
</style>

<style>
 #tag {
     width: 150px;
     height: 25px;
}

 #petName {
    margin-left: 20px;
}

#petSpecies {
    margin: 10px;
     width: 175px;
     height: 25px;
}

#petSex {
    margin-left: 37px;
    width: 175px;
    height: 25px;
}

</style>