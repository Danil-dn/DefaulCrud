package com.kda;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidArgumentException.class)
	public ResponseEntity<Object> handleExceptions(final InvalidArgumentException exception) {
		return new ResponseEntity<>(
				new ErrorDto("Invalid Arguments", List.of(exception.getMessage())),
				HttpStatus.BAD_REQUEST
		);
	}
}
