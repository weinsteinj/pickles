package com.techelevator.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Playdate {
    private Pet hostPet;
    private List<Pet> visitingPet;
    private String location;
    private Date date;
    private Time time;
    private String details;
    private int rating;
    private int status;

    public Pet getHostPet() {
        return hostPet;
    }

    public void setHostPet(Pet hostPet) {
        this.hostPet = hostPet;
    }

    public List<Pet> getVisitingPet() {
        return visitingPet;
    }

    public void setVisitingPet(List<Pet> visitingPet) {
        this.visitingPet = visitingPet;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
