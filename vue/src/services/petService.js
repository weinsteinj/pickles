import axios from 'axios';

export default {
// will not write create method for user here--pls see AuthServices

    
    createPet() {
        return axios.post('/pet');
    },    

    getAllPets() {
    return axios.get('/pet/');
    },
    
    getPetById(petId) {
        return axios.get(`/pet/${petId}`);
    },
    //POST-update
    updatePet(petId) {
        return axios.put(`/pet/${petId}`);
    },
    deletePet(petId) {
        return axios.delete(`/pet/${petId}`);
    },


}