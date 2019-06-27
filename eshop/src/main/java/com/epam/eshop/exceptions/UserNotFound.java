package com.epam.eshop.exceptions;

/**
 * The Class UserNotFound.
 */
public class UserNotFound extends BusinessException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new user not found.
     *
     * @param code    the code
     * @param message the message
     */
    public UserNotFound(int code, String message) {
	super(code, message);
    }
}