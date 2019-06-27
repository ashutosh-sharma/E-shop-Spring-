package com.epam.eshop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.epam.eshop.exceptions.BusinessException;
import com.epam.eshop.exceptions.ExceptionResponse;

/**
 * The Class GlobalExceptionHandler.
 *
 * @author Ashutosh_Sharma
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Business exception handler - Customer Already exists, customer not found
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> businessExceptionHandler(BusinessException e) {
	ExceptionResponse exceptionResponse = new ExceptionResponse();
	exceptionResponse.setCode(e.getCode());
	exceptionResponse.setMessage(e.getMessage());
	return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Exception handler.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> generalExceptionHandler(Exception e) {
	ExceptionResponse exceptionResponse = new ExceptionResponse();
	exceptionResponse.setCode(500);
	exceptionResponse.setMessage("Some error occured, contact admin.");
	return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}