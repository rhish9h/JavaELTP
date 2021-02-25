package com.exception.contact;

public class CompulsoryException extends ContactException {

	private static final long serialVersionUID = 1L;

	public CompulsoryException() {
		super();
	}

	public CompulsoryException(String field) {
		super(field);
		message = field + " is a compulsory field.";
	}
}
