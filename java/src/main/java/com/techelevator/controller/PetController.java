package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Pet;
import com.techelevator.model.PetAlreadyExistsException;
import com.techelevator.model.PetNotFoundException;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class PetController {
    private PetDao petDao;
    private UserDao userDao;

    public PetController(PetDao petDao,UserDao userDao) {
        this.petDao = petDao;
        this.userDao = userDao;
    }

// consider packaging up user_id as part of Pet object / Pet DTO instead of path variable
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/pet", method = RequestMethod.POST)
    public void registerPet(Principal principal, @Valid @RequestBody Pet newPet) {
        String userName = principal.getName();
        User currentUser = userDao.findByUsername(userName);
        try {
            petDao.create(newPet.getName(), newPet.getSpecies(), newPet.getSex(), newPet.getBirthDate(), newPet.getPersonality(), newPet.isFixed(), newPet.isHasVaccinations(), newPet.getSize(), currentUser.getId());
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

    @RequestMapping(path = "/pet", method = RequestMethod.GET)
    public List<Pet> petList() {
        return petDao.listAllPets();
    }

    //get pets by user
}
