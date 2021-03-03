package com.asst10.contactDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ContactService {

	public void addContact(Contact contact, List<Contact> contacts) {
		contacts.add(contact);
	}
	
	public void displayContactList(List<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		System.out.println();
	}
	
	public void displayHeading(String heading) {
		System.out.println("\n******************************************************");
		System.out.println(heading);
		System.out.println("******************************************************\n");
	}
	
	public String getRandomPhoneNumber() {
		return String.valueOf((long)(Math.random() * 9999999999l) + 1000000000l); 
	}
	
	public Contact getDummyContact() {
		int contactId;
		String contactName;
		String emailAddress;
		List<String> contactNumber;
		Random random = new Random();
		String names[] = new String[] {"Tom", "Bob", "Kat", "Tina", "Sage", "Hillary", "Modi"};
		String emails[] = new String[] {"asfd@sdf.com", "rocker@sdf.com", "megaBoost@sdf.com", "hellToy@xcv.com", "sdfa@vbb.com"};
		
		
		
		contactId = random.nextInt(10000);
		contactName = names[random.nextInt(names.length)];
		emailAddress = emails[random.nextInt(emails.length)];
		contactNumber = new ArrayList<String>();
		int numOfContacts = random.nextInt(4);
		for (int i = 0; i < numOfContacts; i++) {
			contactNumber.add(getRandomPhoneNumber());
		}
		
		
		Contact dummyContact = new Contact(contactId, contactName, emailAddress, contactNumber);
		
		return dummyContact;
	}
	
	public void removeContact(Contact contact, List<Contact> contacts) throws ContactNotFoundException {
		Iterator<Contact> iter = contacts.iterator();
		boolean found = false;
		
		while(iter.hasNext()) {
			if (iter.next().equals(contact)) {
				iter.remove();
				found = true;
			}
		}
		
		if (! found) {
			throw new ContactNotFoundException(contact);
		}
	}
	
	public static void main(String[] args) {
		ContactService cs = new ContactService();
		List <Contact> contacts = new ArrayList<>();
		
		// Add contact in contacts
		cs.displayHeading("Add contact in contacts");
		cs.addContact(cs.getDummyContact(), contacts);
		cs.addContact(cs.getDummyContact(), contacts);
		cs.addContact(cs.getDummyContact(), contacts);
		
		Contact toRemoveLater = cs.getDummyContact();
		cs.addContact(toRemoveLater, contacts);
		cs.displayContactList(contacts);

		// Remove contact from contacts - contact exists
		cs.displayHeading("Remove contact from contacts - " + toRemoveLater.getContactName() + " contact exists");
		try {
			cs.removeContact(toRemoveLater, contacts);
		} catch (ContactNotFoundException e) {
			e.printStackTrace();
		}
		cs.displayContactList(contacts);
		
		// Remove contact from contacts - contact doesn't exists	
		Contact nonExistentContact = cs.getDummyContact();
		cs.displayHeading("Remove contact from contacts - " + nonExistentContact.getContactName() + " contact doesn't exists");
		try {
			cs.removeContact(nonExistentContact, contacts);
		} catch (ContactNotFoundException e) {
			e.printStackTrace();
		}
		cs.displayContactList(contacts);
		
	}

}
