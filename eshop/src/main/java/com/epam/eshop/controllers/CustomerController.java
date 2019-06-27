package com.epam.eshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eshop.dto.UserDTO;
import com.epam.eshop.models.User;
import com.epam.eshop.services.UserService;

/**
 * The Class CustomerRestController.
 *
 * @author Ashutosh_Sharma
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Adds the.
     *
     * @param newUser the new user
     * @return the response entity
     */
    @PostMapping("/register")
    public ResponseEntity<UserDTO> add(@RequestBody UserDTO newUser) {
	UserDTO userResponse = userService.signUpAsCustomer(newUser);
	return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    /**
     * Gets the all customers.
     *
     * @return the all customers
     */
    @GetMapping("/all")
    public List<User> getAll() {
	return userService.getAllCustomers();
    }

    /**
     * Gets the.
     *
     * @param customerId the customer id
     * @return the user DTO
     */
    @GetMapping("/{customerId}")
    public UserDTO get(@PathVariable String customerId) {
	return userService.getCustomer(Integer.parseInt(customerId));
    }

    /**
     * Removes the customer using customer Id.
     *
     * @param customerId the customer id
     * @return true, if successful
     */
    @DeleteMapping("/delete/{cutomerId}")
    public boolean remove(@PathVariable int customerId) {
	return userService.removeUser(customerId);
    }

}
