package com.techelevator.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.techelevator.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RestGeocodeDao implements GeocodeDao{

//    private final String API_KEY = "AIzaSyCbMJBc_MS9mlIMfrzc96ZgSAZWe-ZvpnA";
//    private final String BASE_API_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";


    @Override
    public Marker getGeocodeByZip(int zipCode) throws JsonProcessingException, ZipCodeNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://maps.googleapis.com/maps/api/geocode/json?address="
        + zipCode + "&key=AIzaSyCbMJBc_MS9mlIMfrzc96ZgSAZWe-ZvpnA";
        String jsonString = restTemplate.getForObject(uri, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonString);
        JsonNode location = rootNode.findValue("location");
        BigDecimal lat = location.get("lat").decimalValue();
        BigDecimal lng = location.get("lng").decimalValue();

        return new Marker(zipCode, lat, lng);
    }
//mapper.readValue(node.get("vendor").getTextValue(), Vendor.class);

    @Override
    public String getGeocodeTest15217() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://maps.googleapis.com/maps/api/geocode/json?address=15217&key=AIzaSyCbMJBc_MS9mlIMfrzc96ZgSAZWe-ZvpnA";
        String stringPlace = restTemplate.getForObject(uri, String.class);

        return stringPlace;
    }

    @Override
    public ArrayList<String> getMarkerInsertsByZipArray(int[] zipsToGeocode) throws JsonProcessingException, ZipCodeNotFoundException {
        ArrayList<String> insertStrings = new ArrayList<>();
        try {
            for (int zip : zipsToGeocode) {
                Marker zipMarker = getGeocodeByZip(zip);
                String insertString = "INSERT into markers (zip_code, lat, lng) VALUES ( " +
                        zipMarker.getZipCode() + ", " + zipMarker.getLat() + ", " + zipMarker.getLng() + ");";
                insertStrings.add(insertString);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return insertStrings;
    }
}
