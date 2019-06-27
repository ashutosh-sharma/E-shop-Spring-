package com.epam.eshop.exceptions;

/**
 * The Class ProductNotFound.
 */
public class ProductNotFound extends BusinessException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    public ProductNotFound(int code, String message) {
	super(code, message);
    }
}
