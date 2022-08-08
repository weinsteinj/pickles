package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import com.techelevator.model.PetAlreadyExistsException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PetController {
    private PetDao petDao;

    public PetController(PetDao petDao) {
        this.petDao = petDao;
    }


    @RequestMapping(path = "/user/{user_id}/register", method = RequestMethod.POST)
    public void registerPet(@Valid @RequestBody Pet newPet, @PathVariable int user_id) {
        try {
            petDao.create(newPet.getName(), newPet.getSpecies(), newPet.getSex(), newPet.getBirthDate(), newPet.getPersonality(), newPet.isFixed(), newPet.isHasVaccinations(), newPet.getWeight(), user_id);
        } catch (PetAlreadyExistsException e) {

        }
    }
}
