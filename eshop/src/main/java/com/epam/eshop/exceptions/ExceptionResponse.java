package com.epam.eshop.exceptions;

/**
 * The Class ExceptionResponse.
 */
public class ExceptionResponse {

    /** The code. */
    private int code;

    /** The message. */
    private String message;

    /**
     * Gets the code.
     *
     * @return the code
     */
    public int getCode() {
	return code;
    }

    /**
     * Sets the code.
     *
     * @param code the code to set
     */
    public void setCode(int code) {
	this.code = code;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
	return message;
    }

    /**
     * Sets the message.
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
	this.message = message;
    }

}
