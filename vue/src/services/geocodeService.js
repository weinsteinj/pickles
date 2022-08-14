import axios from 'axios';

export default {

    getLatLngZip15217 () {
        return axios.get('/geocode');
    },
    // getLatLngByZipHardCoded() {
    //     return axios.get("https://maps.googleapis.com/maps/api/geocode/json?address=15217key=AIzaSyCbMJBc_MS9mlIMfrzc96ZgSAZWe-ZvpnA");
    // },
   
    getLatLngByZip(zipCode) {
        return axios.get(`/geocode/${zipCode}`);
    },

}