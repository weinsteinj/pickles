package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Date;
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

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/pet", method = RequestMethod.POST)
    public ResponseEntity<Pet> registerPet(Principal principal, @Valid @RequestBody PetDTO newPetDTO) {
        String userName = principal.getName();
        User currentUser = userDao.findByUsername(userName);
        Pet newPet = new Pet();

        try {
            newPet = petDao.create(newPetDTO, currentUser.getId());
            } catch (PetAlreadyExistsException e) {
        }
        newPet.setName(newPetDTO.getName());
        newPet.setSpecies(newPetDTO.getSpecies());
        newPet.setSex(newPetDTO.getSex());
        newPet.setBirthDate(newPetDTO.getBirthDate());
        newPet.setPersonality(newPetDTO.getPersonality());
        newPet.setFixed(newPetDTO.isFixed());
        newPet.setHasVaccinations(newPetDTO.isHasVaccinations());
        newPet.setSize(newPetDTO.getSize());
        newPet.setUserId(currentUser.getId());

        HttpHeaders responseHeaders = new HttpHeaders();
        ResponseEntity<Pet> responseEntity = new ResponseEntity<Pet>(newPet, responseHeaders, HttpStatus.CREATED);

        return responseEntity;
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

    // TODO get pets by user
    @RequestMapping(path = "/pet/user/{userId}", method = RequestMethod.GET)
    public List<Pet> getPetsByUserId(@PathVariable int userId) {
        return petDao.getPetsByUserId(userId);
    }

//    @RequestMapping(path = "/pet/user", method = RequestMethod.GET)
//    public List<Pet> getPetsByUserId(@RequestBody PetByUserDTO petByUserDTO) {
//        return petDao.getPetsByUserId(petByUserDTO);
//    }
}
