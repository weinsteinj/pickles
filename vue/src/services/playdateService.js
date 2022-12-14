import axios from 'axios';

export default {
// will not write create method for user here--pls see AuthServices

    
    getAllPlaydates() {
    return axios.get('/playdate');
    },
    
    getById(playdateId) {
        return axios.get(`/playdate/${playdateId}`);
    },
    createPlaydate(playdate) {
        return axios.post('/playdate',playdate);
    },
    //POST-update
    updatePlaydate(playdateId, playdate) {
        return axios.put(`/playdate/${playdateId}`,playdate);
    },
    deletePlaydate(playdateId) {
        return axios.delete(`/playdate/${playdateId}`);
    },


}