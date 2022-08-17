package com.techelevator.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface PhotoDao {

    List<JsonNode> getAllPhotoUrls() throws JsonProcessingException;

}
