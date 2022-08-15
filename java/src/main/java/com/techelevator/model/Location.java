package com.techelevator.model;

import java.math.BigDecimal;

public class Location {
    private BigDecimal lat;
    private BigDecimal lng;

    public Location(BigDecimal lat, BigDecimal lng) {
        this.lat = lat;
        this.lng = lng;
    }
    public Location(){}

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
