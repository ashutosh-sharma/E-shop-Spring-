package com.epam.eshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eshop.dto.UserDTO;
import com.epam.eshop.services.UserService;

/**
 * The Class LoginController.
 * 
 * @author Ashutosh_Sharma
 */
@RestController
@RequestMapping(value = { "/", "/shopkeeper", "/customer" })
public class UserLoginController {

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Login.
     *
     * @param loggedInUser the logged in user
     * @return the response entity
     */
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO loggedInUser) {
	UserDTO userResponse = userService.login(loggedInUser.getEmail(), loggedInUser.getPassword());
	return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
