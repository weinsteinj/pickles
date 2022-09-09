package com.techelevator.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RestPhotoDao implements PhotoDao {

    @Override
    public List<JsonNode> getAllPhotoUrls() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.cloudinary.com/v1_1/picklepoints/resources/image";

        //this code is from an answer on stack exchange https://stackoverflow.com/questions/21920268/basic-authentication-for-rest-api-using-spring-resttemplate
        String plainCreds = "576356229922848:ohRGYseZ2p7IlOO_m0nIxeUvF_g";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);

        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
        //end stack exchange snippet

       // List<String> photoUrls = new ArrayList<String>();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.getBody());
        List<JsonNode> photoUrls = new ArrayList<>();
        photoUrls = rootNode.findValues("secure_url");
        return photoUrls;
    };
}
