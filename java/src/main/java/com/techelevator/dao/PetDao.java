package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.util.Date;
import java.util.List;

public interface PetDao {

    boolean create(String name, int species, int sex, Date birthDate, int personality, boolean isFixed, boolean hasVaccinations, int size, int userId);

    Pet getPetById(int petId);

    List<Pet> listAllPets();



}