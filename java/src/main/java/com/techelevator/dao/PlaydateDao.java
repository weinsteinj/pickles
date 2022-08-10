package com.techelevator.dao;

import com.techelevator.model.Playdate;

import java.security.Timestamp;
import java.util.List;

public interface PlaydateDao {

    void create(int playdateId, String location, Timestamp dateTime, String details, int rating, String status, int hostUserId, int visitingUserId, List<Integer> petId);

    Playdate getPlaydateById(int playdateId);

    List<Playdate> listAllPlaydates();
}
