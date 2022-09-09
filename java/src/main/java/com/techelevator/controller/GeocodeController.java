package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.techelevator.dao.GeocodeDao;
import com.techelevator.model.GeocodeResponse;
import com.techelevator.model.Marker;
import com.techelevator.model.Pet;
import com.techelevator.model.ZipCodeNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public Marker geocodebyZip(@PathVariable String zipCode) throws JsonProcessingException, ZipCodeNotFoundException {

        return geocodeDao.getGeocodeByZip(zipCode);
    }

    @RequestMapping(path = "/geocode/insert", method = RequestMethod.POST)
    public ArrayList<String> geocodebyZip(@RequestBody String[] zipsToGeocode) throws JsonProcessingException, ZipCodeNotFoundException {
        return geocodeDao.getMarkerInsertsByZipArray(zipsToGeocode);
    }



}
//    @PathVariable int zipcode
//path = "/geocode/{zipcode}"

//  /geocode/insert