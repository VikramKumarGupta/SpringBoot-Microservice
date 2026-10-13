package com.example.users.execption;

public class InvalidUserIdException extends RuntimeException{

	public InvalidUserIdException(String message) {
		super(message);
	}
	
}
