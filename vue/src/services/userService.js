import axios from 'axios';

export default {
// will not write create method for user here--pls see AuthServices

    
    getAllUsers() {
    return axios.get('/user/');
    },
    
    getById(userId) {
        return axios.get(`/user/${userId}`);
    },
    //POST-update
    updateUser(userId) {
        return axios.put(`/user/${userId}`);
    },
    deleteUser(userId) {
        return axios.delete(`/user/${userId}`);
    },


}