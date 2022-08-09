package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import com.techelevator.model.PetAlreadyExistsException;
import com.techelevator.model.PetNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class PetController {
    private PetDao petDao;

    public PetController(PetDao petDao) {
        this.petDao = petDao;
    }

// consider packaging up user_id as part of Pet object / Pet DTO instead of path variable
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/pet", method = RequestMethod.POST)
    public void registerPet(@Valid @RequestBody Pet newPet) {
        try {
            petDao.create(newPet.getName(), newPet.getSpecies(), newPet.getSex(), newPet.getBirthDate(), newPet.getPersonality(), newPet.isFixed(), newPet.isHasVaccinations(), newPet.getSize(), newPet.getUserId());
        } catch (PetAlreadyExistsException e) {

        }

    }


    @RequestMapping(path = "/pet/{pet_id}", method = RequestMethod.GET)
    public Pet getPetById(@PathVariable int pet_id) {
        Pet newPet = new Pet();
        try {
            newPet = petDao.getPetById(pet_id);
        } catch (PetNotFoundException e) {

        }
        return newPet;
    }

    @RequestMapping(path = "/pets", method = RequestMethod.GET)
    public List<Pet> petList() {
        return petDao.listAllPets();
    }

    //get pets by user
}
