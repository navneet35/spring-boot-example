package com.springboot.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.models.User;
import com.springboot.example.service.UserService;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser() {
        LOGGER.debug("Received request to get User");
        User user = userService.getUser();
        return user;
    }

}
