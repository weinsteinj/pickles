package com.techelevator.dao;

import com.techelevator.model.Place;
import org.springframework.context.annotation.Bean;


public interface GeocodeDao {

        String getGeocodeByZip(int zipCode);

        String getGeocodeTest15217();





}




