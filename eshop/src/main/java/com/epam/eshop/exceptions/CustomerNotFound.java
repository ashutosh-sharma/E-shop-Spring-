package com.epam.eshop.exceptions;

/**
 * The Class CustomerNotFound.
 */
public class CustomerNotFound extends BusinessException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new customer not found.
     *
     * @param code the code
     * @param message the message
     */
    public CustomerNotFound(int code, String message) {
	super(code, message);
    }

}
