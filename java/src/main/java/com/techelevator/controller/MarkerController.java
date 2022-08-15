package com.techelevator.controller;

import com.techelevator.dao.MarkerDao;
import com.techelevator.dao.PlaydateDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Marker;
import com.techelevator.model.MarkerNotFoundException;
import com.techelevator.model.Pet;
import org.springframework.web.bind.annotation.*;

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
    public Marker getMarkerByUserId(@PathVariable int userId) {
        Marker newMarker = new Marker();
        try {
            newMarker = markerDao.getMarkerByUserId(userId);
        } catch (MarkerNotFoundException e) {

        }
        return newMarker;
    }

    @RequestMapping(path = "/geocode/playdate/{playdateId}")
    public Marker getMarkerByPlaydateId(@PathVariable int playdateId) {
        Marker newMarker = new Marker();
        try {
            newMarker = markerDao.getMarkerByUserId(playdateId);
        } catch (MarkerNotFoundException e) {

        }
        return newMarker;
    }

    @RequestMapping(path = "/geocode/playdate", method = RequestMethod.GET)
    public List<Marker> petList() {
        return markerDao.getAllPlaydateMarkers();
    }


}
