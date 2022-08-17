package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.techelevator.dao.GeocodeDao;
import com.techelevator.dao.PhotoDao;
import com.techelevator.model.GeocodeResponse;
import com.techelevator.model.Marker;
import com.techelevator.model.Pet;
import com.techelevator.model.ZipCodeNotFoundException;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PhotoController {
    private PhotoDao photoDao;

    public PhotoController (PhotoDao photoDao) {
        this.photoDao = photoDao;

    }

    @RequestMapping(path = "/photos", method = RequestMethod.GET)
    public String getAllPhotos() {

        return photoDao.getAllPhotoUrls();
    }
}