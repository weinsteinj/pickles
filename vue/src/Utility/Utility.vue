<template>
  <body>
      
      <div id="zipcode-form">
        <div>Insert clickable geocode method buttons here!!</div>
        <form v-on:submit.prevent="grabGeocodesForArrayOfZips">
          <div>
            <label for=""> Pls enter a 5-digit Zipcode</label>
            <input  pattern="[0-9]+" minlength="5" maxlength="5" v-model="zipCode">
            <button @click.prevent="addZipToArray">Click to add the Zipcode to the Queue</button>  
          </div>
          <div>
            <label for="submit">Ready to submit your Zipcodes for Geocoding? Pls Click Below!</label>
            <button type="submit"> Submit</button>  
          </div>
        </form>
      </div>
  </body>
</template>

<script>
import geocodeService from '@/services/geocodeService.js'

export default {
  data() {
    return {
      zipCodeArray: [],
      zipCode: '',
      insertStringArray: [],

    }
  },
  methods: {
    addZipToArray() {
      this.zipCodeArray.push(Number.parseInt(this.zipCode));
    },
    grabGeocodesForArrayOfZips () {
      geocodeService.getInsertStringsFromArrayZips(this.zipCodeArray)
      .then (response => {
        if(response.status === 200) {
          this.insertStringArray = response.data;
        }
      })
      .catch (() => {
        alert("Sorry, an error has occurred in your geocode request.")
      })

    },

  }

}
</script>

<style>
#zipcode-form {
  display: flex;
  flex-direction: column;
}

#zipcode-form div button, #zipcode-form div button, label  {
  margin: 10px;
  
}
</style>