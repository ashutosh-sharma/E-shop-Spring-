package com.epam.eshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Model Class - User.
 *
 * @author Ashutosh_Sharma
 */
@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = { "password" })
public class User {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    /** The Name. */
    private String name;

    /** The address. */
    private String address;

    /** The email. */
    @Column(unique = true)
    private String email;

    /** The password. */
    private String password;

    /** The role. */
    private Role role;

    /**
     * Instantiates a new user.
     */
    public User() {
    }

    /**
     * Instantiates a new user.
     *
     * @param name     the name
     * @param email    the email
     * @param password the password
     * @param address  the address
     */
    public User(String name, String email, String password, String address) {
	this.name = name;
	this.email = email;
	this.password = password;
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
     * Sets the name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
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
     * Sets the address.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
	this.address = address;
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
     * Sets the email.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * Gets the role.
     *
     * @return the role
     */
    public Role getRole() {
	return role;
    }

    /**
     * Sets the role.
     *
     * @param role the role to set
     */
    public void setRole(Role role) {
	this.role = role;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
	return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
    }

}