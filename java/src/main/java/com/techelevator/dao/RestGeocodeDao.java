package com.techelevator.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Marker;
import com.techelevator.model.Place;
import com.techelevator.model.ZipCodeNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class RestGeocodeDao implements GeocodeDao{

//    private final String API_KEY = "AIzaSyCbMJBc_MS9mlIMfrzc96ZgSAZWe-ZvpnA";
//    private final String BASE_API_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";


    @Override
    public Marker getGeocodeByZip(int zipCode) throws JsonProcessingException, ZipCodeNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        Place place = new Place();
        String uri = "https://maps.googleapis.com/maps/api/geocode/json?address="
        + zipCode + "&key=AIzaSyCbMJBc_MS9mlIMfrzc96ZgSAZWe-ZvpnA";
//        GeocodeResponse response = restTemplate.getForObject(uri, GeocodeResponse.class);
         String stringPlace = restTemplate.getForObject(uri, String.class);
         ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(stringPlace);
        List<JsonNode> geoLatitudes = new ArrayList<>();
        geoLatitudes = rootNode.findValues("lat");
        if (geoLatitudes.isEmpty()) {
            throw new ZipCodeNotFoundException();
        }
        BigDecimal lat = BigDecimal.valueOf(Double.parseDouble(String.valueOf(geoLatitudes.get(2))));
        List<JsonNode> geoLongitudes = new ArrayList<>();
        geoLongitudes = rootNode.findValues("lng");

        BigDecimal lng = BigDecimal.valueOf(Double.parseDouble(String.valueOf(geoLongitudes.get(2))));
        Marker userMarker = new Marker(zipCode, lat, lng);

//        GeocodeResponse response = new ObjectMapper().readValue(stringPlace, GeocodeResponse.class);
        return userMarker;
    }
//mapper.readValue(node.get("vendor").getTextValue(), Vendor.class);

    @Override
    public String getGeocodeTest15217() {
        RestTemplate restTemplate = new RestTemplate();
        Place playPlace = new Place();
        String uri = "https://maps.googleapis.com/maps/api/geocode/json?address=15217&key=AIzaSyCbMJBc_MS9mlIMfrzc96ZgSAZWe-ZvpnA";

        String stringPlace = restTemplate.getForObject(uri, String.class);

        return stringPlace;
    }
}
