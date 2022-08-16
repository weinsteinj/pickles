<template>
  <div>
    <div>
      <!-- <h2>Check Out the Scheduled Playdates in Your Area!</h2>
      <h5>Zoom Out or Move the Map to Explore</h5>
      <br/> -->
 
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
  </div>
</template>
 
<script>
import geocodeService from '@/services/geocodeService.js'

export default {
  name: "AddGoogleMap",
  data() {
    return {
      center: { 
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
        currentUserPosition: {},
    };
  },
  created(){
    geocodeService.getAllPlaydateMarkers()
     .then(response => {
       if(response.status === 200) {
         this.locationMarkers = response.data;
         geocodeService.getMarkerByUserId(this.$store.state.user.id)
          .then(reply => {
       if(reply.status === 200) {
         this.currentUserPosition = reply.data;
         this.center.lat = this.currentUserPosition.position.lat;
         this.center.lng = this.currentUserPosition.position.lng;
            }
         })
        }
     })
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
