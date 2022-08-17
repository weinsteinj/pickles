package com.techelevator.model;

public class InsertMarkerString {
    private Marker marker;
    private int zipCode;

    public InsertMarkerString () {

    }

    public InsertMarkerString(Marker marker, int zipCode) {
        this.marker = marker;
        this.zipCode = zipCode;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
