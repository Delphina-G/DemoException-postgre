package com.example.exceptions;

public class ResourceNotFoundException extends Exception {
	
	private static final long serialVersionUID = -470180507998010368L;
	
	
	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(final String message) {
		super(message);
	}


}
