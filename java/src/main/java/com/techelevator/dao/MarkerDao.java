package com.techelevator.dao;

import com.techelevator.model.Marker;

import java.util.List;

public interface MarkerDao {

    Marker getMarkerByUserId(int userId);

    Marker getMarkerByPlaydateId(int playdateId);

    List<Marker> getAllPlaydateMarkers();
}
