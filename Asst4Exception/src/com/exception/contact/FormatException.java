package com.exception.contact;

public class FormatException extends ContactException {

	public FormatException() {
		super();
	}

	public FormatException(String field) {
		super(field);
		message = field + " is in incorrect format, display correct format.";
	}
}
