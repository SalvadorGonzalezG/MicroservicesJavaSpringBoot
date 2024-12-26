package com.user.service.exceptions;

public class UserNotFoundException extends RuntimeException{
	//Constructor que recibe un mensaje de error
	public UserNotFoundException(String message) {
		super(message);
	}

}
