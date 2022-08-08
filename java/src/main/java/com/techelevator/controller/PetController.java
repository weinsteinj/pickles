package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import com.techelevator.model.PetAlreadyExistsException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public class PetController {
    private PetDao petDao;

    @RequestMapping(path = "/user/{user_id}/register-pet", method = RequestMethod.POST)
    public void registerPet(@Valid @RequestBody Pet newPet, @PathVariable int user_id) {
        try {
            petDao.create(newPet.getName(), newPet.getSpecies(), newPet.getSex(), newPet.getBirthDate(), newPet.getPersonality(), newPet.isFixed(), newPet.isHasVaccinations(), newPet.getWeight(), user_id);
        } catch (PetAlreadyExistsException e) {

        }
    }
}
