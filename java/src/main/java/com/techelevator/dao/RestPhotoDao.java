package com.techelevator.dao;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class RestPhotoDao {

    List<String> getAllPhotoUrls() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://576356229922848:576356229922848@api.cloudinary.com/v1_1/picklepoints/resources/image";
        String response = restTemplate.getForObject(uri, String.class);
        List<String> photoUrls = new ArrayList<>();
        //profit
        return photoUrls;
    };
}
