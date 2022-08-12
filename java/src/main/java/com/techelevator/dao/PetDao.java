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

    List<Pet> getPetsByUserId(int userId);

    Pet updatePet(Pet pet, int petId);
}
//    List<Pet> getPetsByUserId(PetByUserDTO petByUserDTO);

