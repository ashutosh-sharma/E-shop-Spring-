package com.epam.eshop.exceptions;

/**
 * The Class PasswordIncorrect.
 */
public class PasswordIncorrect extends BusinessException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new password incorrect.
     *
     * @param code    the code
     * @param message the message
     */
    public PasswordIncorrect(int code, String message) {
	super(code, message);
    }
}
