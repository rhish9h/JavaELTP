package com.exception.contact;

public class ContactException extends Exception {

	private static final long serialVersionUID = 1L;
	protected String field;
	protected String message;
	
	public ContactException() {
		this.field = "";
		this.message = "";
	}
	
	public ContactException(String field) {
		this.field = field;
		this.message = "";
	}
	
	public String getMessage() {
		return message;
	}

}
