package com.epam.eshop.exceptions;

/**
 * The Class CustomerAlreadyExists exception.
 * 
 * @author Ashutosh_Sharma
 */
public class CustomerAlreadyExists extends BusinessException {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new customer already exists exception.
     *
     * @param code    the code
     * @param message the message
     */
    public CustomerAlreadyExists(int code, String message) {
	super(code, message);
    }
}
