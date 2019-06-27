/**
 * 
 */
package com.epam.eshop.exceptions;

/**
 * The Class BusinessException.
 *
 * @author Ashutosh_Sharma
 */
public class BusinessException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The code. */
    private final int code;

    /** The message. */
    private final String message;

    /**
     * Instantiates a new business exception.
     *
     * @param code    the code
     * @param message the message
     */
    public BusinessException(int code, String message) {
	super();
	this.code = code;
	this.message = message;
    }

    /**
     * @return the code
     */
    public int getCode() {
	return code;
    }

    /**
     * @return the message
     */
    @Override
    public String getMessage() {
	return message;
    }

}
