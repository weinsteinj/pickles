import axios from 'axios';

export default {

    
    createPet(pet) {
        return axios.post('/pet', pet);
    },    
    getAllPets() {
    return axios.get('/pet');
    },
    getPetById(petId) {
        return axios.get(`/pet/${petId}`);
    },
    getPetsByUserId(userId) {
        return axios.get(`/pet/user/${userId}`);
    },
    getPetsByPlaydateId(playdateId) {
        return axios.get(`/pets/playdate/${playdateId}`);
    },
    updatePet(pet, petId) {
        return axios.put(`/pet/${petId}`, pet);
    },
    deletePet(petId) {
        return axios.delete(`/pet/${petId}`);
    },


}