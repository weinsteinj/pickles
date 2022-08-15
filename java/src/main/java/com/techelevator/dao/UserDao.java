package com.techelevator.dao;

import com.techelevator.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String firstName, String lastName, String username, String password, String role, String email, int zipCode, BigDecimal lat, BigDecimal lng);
}
