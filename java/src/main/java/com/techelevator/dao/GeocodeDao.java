package com.techelevator.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.techelevator.model.GeocodeResponse;
import com.techelevator.model.Marker;
import com.techelevator.model.Place;
import org.springframework.context.annotation.Bean;


public interface GeocodeDao {

        Marker getGeocodeByZip(int zipCode) throws JsonProcessingException;

        String getGeocodeTest15217();





}




