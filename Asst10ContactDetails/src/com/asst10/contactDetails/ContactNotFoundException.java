package com.asst10.contactDetails;

public class ContactNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	ContactNotFoundException(Contact contact) {
		System.err.println("Contact " + contact.getContactId() + " not found - " + contact);
	}
}
