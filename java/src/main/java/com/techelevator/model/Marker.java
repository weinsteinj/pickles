package com.techelevator.model;

import java.math.BigDecimal;

public class Marker {
    private int zipCode;
    private BigDecimal lat;
    private BigDecimal lng;

    public Marker(int zipCode, BigDecimal lat, BigDecimal lng){
        this.zipCode = zipCode;
        this.lat = lat;
        this.lng = lng;
    }
    public Marker () {}

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
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
