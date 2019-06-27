package com.epam.eshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class UserDTO.
 */
@JsonIgnoreProperties(value = { "password" })
public class UserDTO {
    /** The Name. */
    private String name;

    /** The email. */
    private String email;

    /** The password. */
    private String password;

    /** The address. */
    private String address;

    /**
     * Instantiates a new user DTO.
     *
     * @param name    the name
     * @param email   the email
     * @param address the address
     */
    public UserDTO(String name, String email, String address) {
	this.name = name;
	this.email = email;
	this.address = address;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
	return address;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
	return password;
    }

}
