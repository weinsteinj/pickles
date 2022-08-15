package com.techelevator.controller;

import com.techelevator.dao.MarkerDao;
import com.techelevator.dao.PlaydateDao;
import com.techelevator.dao.UserDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

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


}
