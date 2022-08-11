package com.techelevator.dao;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.techelevator.model.Place;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestGeocodeDao implements GeocodeDao{

//    private final String API_KEY = "AIzaSyCbMJBc_MS9mlIMfrzc96ZgSAZWe-ZvpnA";
//    private final String BASE_API_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";


    @Override
    public String getGeocodeByZip() {
        RestTemplate restTemplate = new RestTemplate();
        Place playPlace = new Place();
        String uri = "https://maps.googleapis.com/maps/api/geocode/json?address=15217&key=AIzaSyCbMJBc_MS9mlIMfrzc96ZgSAZWe-ZvpnA";
        String stringPlace = restTemplate.getForObject(uri, String.class);
        return stringPlace;
    }
}

//
//    private static void getEmployees()
//    {
//        final String uri = "http://localhost:8080/springrestexample/employees.xml";
//
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);
//
//        System.out.println(result);
//    }