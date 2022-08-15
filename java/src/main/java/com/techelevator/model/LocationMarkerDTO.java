package com.techelevator.model;

public class LocationMarkerDTO {
    private Position position;

    public LocationMarkerDTO(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
