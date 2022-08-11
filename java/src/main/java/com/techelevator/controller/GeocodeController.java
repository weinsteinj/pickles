package com.techelevator.controller;

import com.techelevator.dao.GeocodeDao;
import com.techelevator.model.Pet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeocodeController {
    private GeocodeDao geocodeDao;

    public GeocodeController (GeocodeDao geocodeDao) {
        this.geocodeDao = geocodeDao;

    }

    @RequestMapping(path = "/geocode", method = RequestMethod.GET)
    public String geocodebyZip() {

        return geocodeDao.getGeocodeByZip();
    }

}
//    @PathVariable int zipcode
//path = "/geocode/{zipcode}"