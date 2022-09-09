package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.techelevator.dao.GeocodeDao;
import com.techelevator.dao.PhotoDao;
import com.techelevator.model.GeocodeResponse;
import com.techelevator.model.Marker;
import com.techelevator.model.Pet;
import com.techelevator.model.ZipCodeNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;
@CrossOrigin
@RestController
public class PhotoController {
    private PhotoDao photoDao;

    public PhotoController (PhotoDao photoDao) {
        this.photoDao = photoDao;

    }

    @RequestMapping(path = "/photos", method = RequestMethod.GET)
    public List<JsonNode> getAllPhotos() throws IOException {

        return photoDao.getAllPhotoUrls();
    }
}