package com.techelevator.model;

import java.math.BigDecimal;

public class Place {

    private String zipcode;
    private BigDecimal lat;
    private BigDecimal lng;

    public Place (String zipcode, BigDecimal lat, BigDecimal lng) {
        this.zipcode = zipcode;
        this.lat = lat;
        this.lng = lng;

    }
    public Place () {

    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }
}
