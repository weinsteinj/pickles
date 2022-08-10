package com.techelevator.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Playdate {
    private int playdateId;
    private String location;
    private Timestamp dateTime;
    private String details;
    private int rating;
    private String status;
    private int hostUserId;
    private int visitingUserId;
    List<Integer> petId;

    public int getPlaydateId() {
        return playdateId;
    }

    public void setPlaydateId(int playdateId) {
        this.playdateId = playdateId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHostUserId() {
        return hostUserId;
    }

    public void setHostUserId(int hostUserId) {
        this.hostUserId = hostUserId;
    }

    public int getVisitingUserId() {
        return visitingUserId;
    }

    public void setVisitingUserId(int visitingUserId) {
        this.visitingUserId = visitingUserId;
    }

    public List<Integer> getPetId() {
        return petId;
    }

    public void setPetId(List<Integer> petId) {
        this.petId = petId;
    }
}
