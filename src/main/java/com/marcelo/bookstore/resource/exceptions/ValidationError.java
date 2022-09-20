package com.marcelo.bookstore.resource.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError {

	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError() {
		 super();
	}
	
	public ValidationError(Long timetamp, Integer status, String error) {
		super(timetamp, status, error);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	
	
	

}
