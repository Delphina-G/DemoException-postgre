package com.example.exceptions;

public class NullValueException extends Exception{

	private static final long serialVersionUID = -470180507998010368L;
	
	public NullValueException() {
		super();
	}
	
    public NullValueException(final String message) {
		super(message);
	}
}
