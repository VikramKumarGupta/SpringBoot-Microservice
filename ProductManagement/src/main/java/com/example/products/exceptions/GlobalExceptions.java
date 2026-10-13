package com.example.products.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public String productNotFoundException(ProductNotFoundException exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public String orderNotFoundException(OrderNotFoundException exception) {
		return exception.getMessage();
	}
}
