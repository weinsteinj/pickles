package com.techelevator.model;

public class InsertMarkerString {
    private Marker marker;
    private String zipCode;

    public InsertMarkerString () {

    }

    public InsertMarkerString(Marker marker, String zipCode) {
        this.marker = marker;
        this.zipCode = zipCode;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
