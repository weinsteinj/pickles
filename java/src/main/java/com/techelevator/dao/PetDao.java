package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.util.Date;

public interface PetDao {

    boolean create(String name, int species, int sex, Date birthDate, String personality, boolean isFixed, boolean hasVaccinations, double weight, int userId);

    Pet getPetById(int petId);



}
