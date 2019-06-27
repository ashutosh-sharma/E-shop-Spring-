/**
 * 
 */
package com.epam.eshop.exceptions;

/**
 * The Class NoItemsFound.
 *
 * @author Ashutosh_Sharma
 */
public class NoItemsFound extends BusinessException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new no items found.
     *
     * @param code the code
     * @param message the message
     */
    public NoItemsFound(int code, String message) {
	super(code, message);
    }

}
