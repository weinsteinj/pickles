package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {
    @JsonProperty("address_components")
    private Object[] addressComponents;
    private String formattedAddress;
    private Geometry geometry;
    private String placeId;
    private String[] postcodeLocalities;
    private String[] types;

    public Results (Geometry geometry) {
        this.geometry = geometry;
    }
    public Results () {}

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Object[] getAddressComponents() {
        return addressComponents;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String[] getPostcodeLocalities() {
        return postcodeLocalities;
    }

    public String[] getTypes() {
        return types;
    }
}
