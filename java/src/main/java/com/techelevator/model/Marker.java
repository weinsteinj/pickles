package com.techelevator.model;

import java.math.BigDecimal;

public class Marker {
    private String zipCode;
    private BigDecimal lat;
    private BigDecimal lng;

    public Marker(String zipCode, BigDecimal lat, BigDecimal lng){
        this.zipCode = zipCode;
        this.lat = lat;
        this.lng = lng;
    }
    public Marker () {}

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
