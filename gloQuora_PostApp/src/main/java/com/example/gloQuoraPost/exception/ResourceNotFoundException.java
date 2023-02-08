package com.example.gloQuoraPost.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	private String message;
	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
}