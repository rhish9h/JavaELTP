package com.exception.contact;

public class SpecifyException extends ContactException {

	public SpecifyException() {
		super();
		message = "Either telephone or mobile number must be specified.";
	}

	public SpecifyException(String field) {
		super(field);
		message = "Either telephone or mobile number must be specified.";
	}
}
