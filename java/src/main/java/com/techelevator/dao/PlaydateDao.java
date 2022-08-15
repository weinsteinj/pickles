package com.techelevator.dao;

import com.techelevator.model.Playdate;

import java.time.LocalDateTime;
import java.util.List;

public interface PlaydateDao {

    Playdate create(int hostUserId, int zipCode, LocalDateTime dateTime, String details, int rating, String status, String playdatePhoto, List<Integer> petId);
    Playdate getPlaydateById(int playdateId);

    List<Playdate> listAllPlaydates();

    Playdate updatePlaydate(Playdate playdate);
}
