import axios from 'axios';

export default {
// will not write create method for user here--pls see AuthServices

    
    getAllPlaydates() {
    return axios.get('/playdate/');
    },
    
    getById(playdateId) {
        return axios.get(`/playdate/${playdateId}`);
    },
    //POST-update
    updatePlaydate(playdateId) {
        return axios.put(`/playdate/${playdateId}`);
    },
    deletePlaydate(playdateId) {
        return axios.delete(`/playdate/${playdateId}`);
    },


}