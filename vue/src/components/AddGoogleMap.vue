<template>
  <div>
    <div>
      <h2>Vue Js Search and Add Marker</h2>
      <label>
        <gmap-autocomplete @place_changed="initMarker"></gmap-autocomplete>
        <button @click.prevent="getGeocode15217">Get 15217</button>
         <button @click.prevent="getGeocodeByZip">Get Geocode by Zip</button>
        <button @click="addLocationMarker">Add</button>
      </label>
      <label>Please enter your zip code below!
        
        <button @click="addLocationMarkerByZipcode">Show Nearby Playdates</button>
      </label>
      <br/>
 
    </div>
    <br>
    <gmap-map
        :zoom="14"    
        :center="center"
        style="width:100%;  height: 600px;"
      >
      <gmap-marker
        :key="index"
        v-for="(m, index) in locationMarkers"
        :position="m.position"
        @click="center=m.position"
      ></gmap-marker>
    </gmap-map>
    <div>
      <form >
        <label for="zipCode">Please enter your 5-digit Zipcode below: </label>
        <input type="text" minlength="5" maxlength="5" v-model="currentPlace.zipCode">
        <button type="submit" @click.prevent="getGeocodeByZip"> Submit </button>
      </form>
      
    </div>
  </div>
</template>
 
<script>
import geocodeService from '@/services/geocodeService.js'

export default {
  name: "AddGoogleMap",
  data() {
    return {
      center: { 
        lat: 39.7837304,
        lng: -100.4458825
      },
      locationMarkers: [],
      locPlaces: [],
      existingPlace: null,
      // place15217: null,
      currentPlace: {
        zipCode: '',
        lat: null,
        lng: null,
      },
      newPlaceByZip: null,
      placeHolder: null,
      
    };
  },
 
  mounted() {
    this.locateGeoLocation();
  },
 
  methods: {
    // getGeocode15217() {
    //   geocodeService.getLatLngZip15217()
    //   .then(response => {
    //     this.place15217 = response.data;
        
    //   })
    // },
    getGeocodeByZip() {
      geocodeService.getLatLngByZip(this.currentPlace.zipCode)
      .then(response => {
        this.newPlaceByZip = response.data;
        this.placeHolder = this.newPlaceByZip.results[0];
        this.currentPlace.lat = (Math.round(this.placeHolder.geometry.location.lat*1000000))/1000000;
        this.currentPlace.lng = (Math.round(this.placeHolder.geometry.location.lng*1000000))/1000000;
        // const newMarker = {
        //     lat: this.placeHolder.geometry.location.lat(),
        //     lng: this.placeHolder.geometry.location.lng(),
        // };
        // this.locationMarkers.push({ position: newMarker });
        // this.center = newMarker;
      })
    },
    addLocationMarkerByZipcode() {
      if (this.currentPlace) {
        const marker = {
          lat: this.currentPlace.lat,
          lng: this.currentPlace.lng
        };
        this.locationMarkers.push({ position: marker });
        this.locPlaces.push(this.currentPlace);
        this.center = marker;
        // this.currentPlace = null;
      }
    },
    initMarker(loc) {
      this.existingPlace = loc;
    },
    addLocationMarker() {
      if (this.existingPlace) {
        const marker = {
          lat: this.existingPlace.geometry.location.lat(),
          lng: this.existingPlace.geometry.location.lng()
        };
        this.locationMarkers.push({ position: marker });
        this.locPlaces.push(this.existingPlace);
        this.center = marker;
        this.existingPlace = null;
      }
    },
    locateGeoLocation: function() {
      navigator.geolocation.getCurrentPosition(res => {
        this.center = {
          lat: res.coords.latitude,
          lng: res.coords.longitude
        };
      });
    }
  }
};
</script>