package com.techelevator.dao;

import com.techelevator.model.Playdate;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface PlaydateDao {

    void create(int hostUserId, String location, LocalDateTime dateTime, String details, int rating, String status, List<Integer> petId);
    Playdate getPlaydateById(int playdateId);

    List<Playdate> listAllPlaydates();
}
