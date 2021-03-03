package com.asst10.contactDetails;

public class ContactNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	ContactNotFoundException(Contact contact) {
		System.err.println("Contact " + contact.getContactName() + " not found - " + contact);
	}

	public ContactNotFoundException(String name) {
		System.err.println("Contact " + name + " not found");
	}

	public ContactNotFoundException(String number, int i) {
		System.err.println("Contact with number " + number + " not found");
	}
}
