package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.PetByUserDTO;
import com.techelevator.model.PetDTO;

import java.util.Date;
import java.util.List;

public interface PetDao {

    Pet create(PetDTO newPetDto, int userId);

    Pet getPetById(int petId);

    List<Pet> listAllPets();

    Integer[] getPersonalitiesForPet(int petId);

<<<<<<< HEAD
    List<Pet> getPetsByUserId(PetByUserDTO petByUserDTO);

    Pet updatePet(Pet pet, int petId);
=======
    List<Pet> getPetsByUserId(int userId);
>>>>>>> 73e8a4f90a7ce021d54c61104c29c06fd2e42b8b
}
//    List<Pet> getPetsByUserId(PetByUserDTO petByUserDTO);

