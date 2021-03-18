package com.tts.capstone.SmartShreveCity.service;

import com.tts.capstone.SmartShreveCity.model.User;

import java.util.List;

public interface UserService {

    User findByUsername(String username);
    List<User> findAll();
    void save(User user);
    User saveNewUser(User user);
    User getLoggedInUser();

}   // end of the User Service interface