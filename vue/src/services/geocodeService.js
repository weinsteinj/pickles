import axios from 'axios';

export default {

    getLatLngZip15217 () {
        return axios.get('/geocode');
    },
   
    getLatLngByZip(zipCode) {
        return axios.get(`/geocode/${zipCode}`);
    },
    getMarkerByUserId(userId) {
        return axios.get(`/geocode/user/${userId}`)
    },
    getMarkerByPlaydateId(playdateId) {
        return axios.get(`/geocode/playdate/${playdateId}`)
    },
    getAllPlaydateMarkers() {
        return axios.get('/geocode/playdate')
    },
}