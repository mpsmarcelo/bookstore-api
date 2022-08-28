package com.marcelo.bookstore.resource.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.marcelo.bookstore.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResouseExceptionHandler{

	@ExceptionHandler(ObjectNotFoundException.class)
	ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
		StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
