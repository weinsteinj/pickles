////package com.techelevator.dao;
////
////public class RestGeocodeDaoV2 {
////}
//
//package com.techelevator.dao;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.techelevator.model.GeocodeResponse;
//import com.techelevator.model.Marker;
//import com.techelevator.model.Place;
//import com.techelevator.model.ZipCodeNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
////@Component
//public class RestGeocodeDaoV2 implements GeocodeDao{
//
//    private final String API_KEY = "AIzaSyCbMJBc_MS9mlIMfrzc96ZgSAZWe-ZvpnA";
//    private final String BASE_API_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
//
//
//    @Override
//    public Marker getGeocodeByZip(int zipCode) throws JsonProcessingException, ZipCodeNotFoundException {
//        RestTemplate restTemplate = new RestTemplate();
//        Place place = new Place();
//        String uri = BASE_API_URL + zipCode + API_KEY;
//        GeocodeResponse response = restTemplate.getForObject(uri, GeocodeResponse.class);
//        BigDecimal lat = (response.getResults().get(2).getGeometry().getLocation().getLat());
//        BigDecimal lng = (response.getResults().get(2).getGeometry().getLocation().getLng());
//
//        Marker userMarker = new Marker(zipCode, lat, lng);
//
//        return userMarker;
//    }
////mapper.readValue(node.get("vendor").getTextValue(), Vendor.class);
//
//    @Override
//    public String getGeocodeTest15217() {
//        RestTemplate restTemplate = new RestTemplate();
//        Place playPlace = new Place();
//        String uri = "https://maps.googleapis.com/maps/api/geocode/json?address=15217&key=AIzaSyCbMJBc_MS9mlIMfrzc96ZgSAZWe-ZvpnA";
//
//        String stringPlace = restTemplate.getForObject(uri, String.class);
//
//        return stringPlace;
//    }
//
//    @Override
//    public ArrayList<String> getMarkerInsertsByZipArray(int[] zipsToGeocode) throws JsonProcessingException, ZipCodeNotFoundException {
//        ArrayList<String> insertStrings = new ArrayList<>();
//        try {
//            for (int zip : zipsToGeocode) {
//                Marker zipMarker = getGeocodeByZip(zip);
//                String insertString = "INSERT into markers (zip_code, lat, lng) VALUES ( " +
//                        zipMarker.getZipCode() + ", " + zipMarker.getLat() + ", " + zipMarker.getLng() + ");";
//                insertStrings.add(insertString);
//            }
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return insertStrings;
//    }
//}
//
