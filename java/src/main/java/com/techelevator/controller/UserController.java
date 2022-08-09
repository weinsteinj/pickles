package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Pet;
import com.techelevator.model.PetNotFoundException;
import com.techelevator.model.User;
import com.techelevator.model.UserNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    //TODO ADD matching @Mapping methods to connect with userService.js at FRONT-END

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(path = "/user/{user_id}", method = RequestMethod.GET)
    public User getPetById(@PathVariable int user_id) {
        User user = new User();
        try {
            user = userDao.getUserById(user_id);
        } catch (UserNotFoundException e) {

        }
        return user;
    }

//    getAllUsers() {
//        return axios.get('/user/');
//    },
//
//    getById(userId) {
//        return axios.get(`/user/${userId}`);
//    },
//    //POST-update
//    updateUser(userId) {
//        return axios.put(`/user/${userId}`);
//    },
//    deleteUser(userId) {
//        return axios.delete(`/user/${userId}`);
//    },

}
