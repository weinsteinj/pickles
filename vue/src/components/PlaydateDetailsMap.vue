<template>
  <div>
    <div>
      <h2></h2>
      <h5></h5>
      <br/>
 
    </div>
    <br>
    <gmap-map
        :zoom="14"    
        :center="center"
        style="width:30%;  height: 400px;"
      >
      <gmap-marker
        :key="index"
        v-for="(m, index) in locationMarkers"
        :position="m.position"
        @click="center=m.position"
      ></gmap-marker>
    </gmap-map>
  </div>
</template>
 
<script>
import geocodeService from '@/services/geocodeService.js'

export default {
  name: "playdate-details-map",
    created(){
    geocodeService.getMarkerByPlaydateId(Number.parseInt(this.$route.params.playdateId))
     .then(response => {
       if(response.status === 200) {
         let currentPlaydatePosition = response.data;  
         this.locationMarkers.push(currentPlaydatePosition);
         this.currentPlaydatePosition = response.data;
         this.center.lat = this.currentPlaydatePosition.position.lat;
         this.center.lng = this.currentPlaydatePosition.position.lng;

     }
     })
  },
  data() {
    return {
      center: { 
          //center on current playdate being viewed
        lat: 41.039068,
        //this.$store.currentUserMarker.lat
        lng: -73.815439
        //this.$store.currentUserMarker.lng
      },
      locationMarkers: [],
      locPlaces: [],
      existingPlace: null,
      simulatedMarkerArrayViaDB: [
        {position: {lat: 41.021447 , lng: -73.812498}}, 
        {position: {lat: 41.039068 , lng: -73.815439}}, 
        {position: {lat: 40.031013 , lng: -80.019956}}
        ],
        tempArray: [],
        currentPlaydatePosition: {},
        currentPlaydate: this.activePlaydate ,
    };
  },
  
  mounted() {
    this.locateGeoLocation();
  },
  
 
  methods: {
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

<style scoped>
h5 {
  text-align: center;
}
</style>
