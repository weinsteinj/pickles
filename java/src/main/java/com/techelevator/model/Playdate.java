package com.techelevator.model;

import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Playdate {
    private int playdateId;
    private int zipCode;
    private LocalDateTime dateTime;
    private String details;
    private int rating;
    private String status;
    private int hostUserId;
    private int visitingUserId;
    List<Integer> petId;
    private String playdatePhoto;

    public Playdate() {
    }

    public int getPlaydateId() {
        return playdateId;
    }

    public void setPlaydateId(int playdateId) {
        this.playdateId = playdateId;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
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

    public String getPlaydatePhoto() {
        return playdatePhoto;
    }

    public void setPlaydatePhoto(String playdatePhoto) {
        this.playdatePhoto = playdatePhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playdate playdate = (Playdate) o;
        return playdateId == playdate.playdateId && zipCode == playdate.zipCode && rating == playdate.rating && hostUserId == playdate.hostUserId && visitingUserId == playdate.visitingUserId && Objects.equals(dateTime, playdate.dateTime) && Objects.equals(details, playdate.details) && Objects.equals(status, playdate.status) && Objects.equals(petId, playdate.petId) && Objects.equals(playdatePhoto, playdate.playdatePhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playdateId, zipCode, dateTime, details, rating, status, hostUserId, visitingUserId, petId, playdatePhoto);
    }
}
