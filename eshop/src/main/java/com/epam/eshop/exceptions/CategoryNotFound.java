/**
 * 
 */
package com.epam.eshop.exceptions;

/**
 * The Class CategoryNotFound.
 *
 * @author Ashutosh_Sharma
 */
public class CategoryNotFound extends BusinessException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new category not found.
     *
     * @param code    the code
     * @param message the message
     */
    public CategoryNotFound(int code, String message) {
	super(code, message);
    }

}
