package com.rover.RoverBot.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rover.RoverBot.DTO.CustomException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DirectionNotFoundException.class)
	protected ResponseEntity<Object> directionNotFoundException(DirectionNotFoundException ex, WebRequest request) {

		CustomException customException = new CustomException(ex.getMessage(), request.getDescription(false),
				new Date(), ex.errorCode);

		return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RotationNotFoundException.class)
	protected ResponseEntity<Object> rotationNotFoundException(RotationNotFoundException ex, WebRequest request) {

		CustomException customException = new CustomException(ex.getMessage(), request.getDescription(false),
				new Date(), ex.errorCode);

		return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
	}

}
