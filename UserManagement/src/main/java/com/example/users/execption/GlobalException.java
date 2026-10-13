package com.example.users.execption;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(InvalidUserIdException.class)
	public String UserNotFoundException(InvalidUserIdException exception) {
		return exception.getMessage();
	}
}
