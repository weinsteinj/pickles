package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.techelevator.dao.GeocodeDao;
import com.techelevator.model.GeocodeResponse;
import com.techelevator.model.Marker;
import com.techelevator.model.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class GeocodeController {
    private GeocodeDao geocodeDao;

    public GeocodeController (GeocodeDao geocodeDao) {
        this.geocodeDao = geocodeDao;

    }

    @RequestMapping(path = "/geocode", method = RequestMethod.GET)
    public String geocodeTest15217() {

        return geocodeDao.getGeocodeTest15217();
    }
    @RequestMapping(path = "/geocode/{zipCode}", method = RequestMethod.GET)
    public Marker geocodebyZip(@PathVariable int zipCode) throws JsonProcessingException {

        return geocodeDao.getGeocodeByZip(zipCode);
    }



}
//    @PathVariable int zipcode
//path = "/geocode/{zipcode}"