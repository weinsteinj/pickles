package com.techelevator.model;

import java.math.BigDecimal;

public class Place {

    private int zipcode;
    private BigDecimal lat;
    private BigDecimal lng;

    public Place (int zipcode, BigDecimal lat, BigDecimal lng) {
        this.zipcode = zipcode;
        this.lat = lat;
        this.lng = lng;

    }
    public Place () {

    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
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
