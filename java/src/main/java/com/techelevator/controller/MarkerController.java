package com.techelevator.controller;

import com.techelevator.dao.MarkerDao;
import com.techelevator.dao.PlaydateDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class MarkerController {
    private UserDao userDao;
    private PlaydateDao playdateDao;
    private MarkerDao markerDao;

    public MarkerController(UserDao userDao, PlaydateDao playdateDao, MarkerDao markerDao) {
        this.userDao = userDao;
        this.playdateDao = playdateDao;
        this.markerDao = markerDao;
    }

    @RequestMapping(path = "/geocode/user/{userId}")
    public LocationMarkerDTO getMarkerByUserId(@PathVariable int userId) {
        Marker newMarker = new Marker();
        try {
            newMarker = markerDao.getMarkerByUserId(userId);
        } catch (MarkerNotFoundException e) {

        }
        //map marker to position, set position in loc-marker-dto
        Position position = new Position(newMarker.getLat(), newMarker.getLng());
        LocationMarkerDTO locDTO = new LocationMarkerDTO(position);

        return locDTO;
    }

    @RequestMapping(path = "/geocode/playdate/{playdateId}")
    public LocationMarkerDTO getMarkerByPlaydateId(@PathVariable int playdateId) {
        Marker newMarker = new Marker();
        try {
            newMarker = markerDao.getMarkerByPlaydateId(playdateId);
        } catch (MarkerNotFoundException e) {

        }
        Position position = new Position(newMarker.getLat(), newMarker.getLng());
        LocationMarkerDTO locDTO = new LocationMarkerDTO(position);

        return locDTO;
    }

    @RequestMapping(path = "/geocode/playdate", method = RequestMethod.GET)
    public List<LocationMarkerDTO> petList() {
         List<Marker> markerList = markerDao.getAllPlaydateMarkers();
         List<LocationMarkerDTO> locList = new ArrayList<>();
         for(Marker newMarker : markerList) {
             Position position = new Position(newMarker.getLat(), newMarker.getLng());
             LocationMarkerDTO locDTO = new LocationMarkerDTO(position);
             locList.add(locDTO);
         }
         return locList;


    }


}
