package com.techelevator.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestPhotoDao implements PhotoDao {

    @Override
    public String getAllPhotoUrls() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://576356229922848:ohRGYseZ2p7IlOO_m0nIxeUvF_g@api.cloudinary.com/v1_1/picklepoints/resources/image";
        String response = restTemplate.getForObject(uri, String.class);
        //String photoUrls = new ArrayList<>();
        //profit
        return response;
    };
}
