/**
 * 
 */
package com.epam.eshop.exceptions;

/**
 * The Class ItemNotFound.
 *
 * @author Ashutosh_Sharma
 */
public class ItemNotFound extends BusinessException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new item not found.
     *
     * @param code    the code
     * @param message the message
     */
    public ItemNotFound(int code, String message) {
	super(code, message);
    }
}
