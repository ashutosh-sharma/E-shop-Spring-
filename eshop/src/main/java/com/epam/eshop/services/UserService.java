package com.epam.eshop.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.epam.eshop.dto.UserDTO;
import com.epam.eshop.exceptions.CustomerAlreadyExists;
import com.epam.eshop.exceptions.CustomerNotFound;
import com.epam.eshop.exceptions.PasswordIncorrect;
import com.epam.eshop.exceptions.UserNotFound;
import com.epam.eshop.models.Role;
import com.epam.eshop.models.User;
import com.epam.eshop.repositories.UserRepository;

/**
 * The Class UserService.
 * 
 * @author Ashutosh_Sharma
 */
@Service
@PropertySource("classpath:exception.properties")
public class UserService {

    /** The Constant logger. */
    private static final Logger logger = LogManager.getLogger(UserService.class);

    /** The environment. */
    @Autowired
    private Environment env;

    /** The user repository. */
    @Autowired
    UserRepository userRepository;

    /**
     * Gets the user with email.
     *
     * @param email the email
     * @return the user with email
     */
    private Optional<User> getUserWithEmail(String email) {
	return userRepository.findByEmail(email).stream().findFirst();
    }

    /**
     * Sign up as customer.
     *
     * @param newUser the new user
     * @return the user
     */
    public UserDTO signUpAsCustomer(UserDTO newUser) {
	Optional<User> existingUser = getUserWithEmail(newUser.getEmail());

	if (!existingUser.isPresent()) {
	    User user = new User(newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getAddress());
	    user.setRole(Role.CUSTOMER);
	    userRepository.save(user);
	    logger.info("New Customer saved.");
	    return newUser;
	} else {
	    logger.error("Not saved. Customer already exists.");
	    throw new CustomerAlreadyExists(Integer.parseInt(env.getProperty("CustomerAlreadyExists.code")),
		    env.getProperty("CustomerAlreadyExists.message"));
	}
    }

    /**
     * Login.
     *
     * @param inputEmail    the input email
     * @param inputPassword the input password
     * @return the user DTO
     */
    public UserDTO login(String inputEmail, String inputPassword) {
	UserDTO fetchedUser = null;
	Optional<User> existingUser = getUserWithEmail(inputEmail);

	if (existingUser.isPresent()) {
	    if (existingUser.get().getPassword().equals(inputPassword)) {
		User user = existingUser.get();
		fetchedUser = new UserDTO(user.getName(), user.getEmail(), user.getAddress());
	    } else {
		logger.error("User password is Incorrect.");
		throw new PasswordIncorrect(Integer.parseInt(env.getProperty("PasswordIncorrect.code")),
			env.getProperty("PasswordIncorrect.message"));
	    }
	} else {
	    logger.error("User with email not found.");
	    throw new UserNotFound(Integer.parseInt(env.getProperty("UserNotFound.code")),
		    env.getProperty("UserNotFound.message"));
	}

	return fetchedUser;
    }

    /**
     * Gets the customer.
     *
     * @param customerId the customer id
     * @return the customer
     */
    public UserDTO getCustomer(int customerId) {
	User user = userRepository.findById(customerId)
		.orElseThrow(() -> new CustomerNotFound(Integer.parseInt(env.getProperty("CustomerNotFound.code")),
			env.getProperty("CustomerNotFound.message")));
	return new UserDTO(user.getName(), user.getEmail(), user.getAddress());
    }

    /**
     * Gets the all customers.
     *
     * @return the all customers
     */
    public List<User> getAllCustomers() {
	Role customer = Role.CUSTOMER;
	List<User> customerList = userRepository.findByRole(customer);

	if (customerList.isEmpty()) {
	    throw new CustomerNotFound(Integer.parseInt(env.getProperty("CustomerNotFound.code")),
		    env.getProperty("CustomerNotFound.message"));
	}
	return customerList;
    }

    /**
     * Removes the user.
     *
     * @param userId the user id
     * @return true, if successful
     */
    public boolean removeUser(int userId) {
	boolean result = false;
	try {
	    userRepository.deleteById(userId);
	    result = true;
	} catch (EmptyResultDataAccessException exe) {
	    result = false;
	}
	return result;
    }
}
