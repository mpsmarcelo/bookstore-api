package com.marcelo.bookstore.resource.exceptions;

public class DataIntegrityConstraintViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityConstraintViolationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataIntegrityConstraintViolationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
