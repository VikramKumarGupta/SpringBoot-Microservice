package com.example.inventory.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(InventoryNotFoundException.class)
	public String inventoryNotFoundException(InventoryNotFoundException exception) {
		return exception.getMessage();
	}
}
