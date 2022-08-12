import axios from 'axios';

export default {
// will not write create method for user here--pls see AuthServices

    
    createPet(pet) {
        return axios.post('/pet', pet);
    },    

    getAllPets() {
    return axios.get('/pet');
    },
    
    getPetById(petId) {
        return axios.get(`/pet/${petId}`);
    },
    // getPetsByUserId(petByUserDTO) {
    //     return axios.get('/pet/user', petByUserDTO);
    // },
    getPetsByUserId(userId) {
        return axios.get(`/pet/user/${userId}`);
    },
    //POST-update
    updatePet(petId, pet) {
        return axios.put(`/pet/${petId}`, pet);
    },
    deletePet(petId) {
        return axios.delete(`/pet/${petId}`);
    },


}