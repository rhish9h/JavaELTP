package com.asst10.contactDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		int numOfContacts = random.nextInt(4) + 1;
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
	
	public Contact searchContactByName(String name, List<Contact> contacts) throws ContactNotFoundException {
		Contact contact = null;
		
		for (Contact curContact : contacts) {
			if (curContact.getContactName().equals(name)) {
				contact = curContact;
				break;
			}
		}
		
		if (contact == null) {
			throw new ContactNotFoundException(name);
		}
		
		return contact;
	}
	
	public List<Contact> searchContactByNumber(String number, List<Contact> contacts) throws ContactNotFoundException {
		List <Contact> matchedContacts = new ArrayList<>();
		
		for (Contact contact : contacts) {
			for (String curNumber : contact.getContactNumber()) {
				if (curNumber.contains(number)) {
					matchedContacts.add(contact);
					break;
				}
			}
		}
		
		if (matchedContacts.isEmpty()) {
			throw new ContactNotFoundException(number, 1);
		}
		return matchedContacts;
	}
	
	public void addContactNumber(int keyContactId, String newContactNumber, List<Contact> contacts) {
		for (Contact contact : contacts) {
			if (contact.getContactId() == keyContactId) {
				contact.getContactNumber().add(newContactNumber);
				break;
			}
		}
	}
	
	private void sortContactsByName(List<Contact> contacts) {
		Collections.sort(contacts);
		
	}
	
	public static void main(String[] args) {
		ContactService cs = new ContactService();
		List <Contact> contacts = new ArrayList<>();
		
		// Add contact in contacts
		cs.displayHeading("Add contact in contacts");
		cs.addContact(cs.getDummyContact(), contacts);
		cs.addContact(cs.getDummyContact(), contacts);
		
		Contact toBeSearchedLater = cs.getDummyContact();
		cs.addContact(toBeSearchedLater, contacts);
		
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
		
		// Search contact in contacts - contact exists
		cs.displayHeading("Search contact in contacts - " + toBeSearchedLater.getContactName() + " - contact exists");
		try {
			cs.searchContactByName(toBeSearchedLater.getContactName(), contacts);
		} catch (ContactNotFoundException e) {
			e.printStackTrace();
		}
		cs.displayContactList(contacts);
		
		// Search contact in contacts - contact doesn't exist
		String nameNotExists = "randomName";
		cs.displayHeading("Search contact in contacts - " + nameNotExists + " - contact doesn't exist");
		try {
			cs.searchContactByName(nameNotExists, contacts);
		} catch (ContactNotFoundException e) {
			e.printStackTrace();
		}
		cs.displayContactList(contacts);
		
		// Search contact by number - number exists
		Random random = new Random();
		String numberExists = toBeSearchedLater.getContactNumber().get(0);
		numberExists = numberExists.substring(random.nextInt(numberExists.length()));
		cs.displayHeading("Search contact by number " + numberExists + " - number exists");
		List<Contact> matchedContacts = new ArrayList<>();
		try {
			matchedContacts = cs.searchContactByNumber(numberExists, contacts);
		} catch (ContactNotFoundException e) {
			e.printStackTrace();
		}
		cs.displayContactList(matchedContacts);
		
		// Search contact by number - number doesn;t exists
		String numberNotExists = "-1";
		cs.displayHeading("Search contact by number " + numberNotExists + " - number doesn't exist");
		matchedContacts = new ArrayList<>();
		try {
			matchedContacts = cs.searchContactByNumber(numberNotExists, contacts);
		} catch (ContactNotFoundException e) {
			e.printStackTrace();
		}
		cs.displayContactList(matchedContacts);
		
		// Add contact number
		int keyContactId = toBeSearchedLater.getContactId();
		String newContactNumber = cs.getRandomPhoneNumber();
		cs.displayHeading("Add contact number - " + newContactNumber + " to contact with id - " + keyContactId);
		cs.addContactNumber(keyContactId, newContactNumber, contacts);
		cs.displayContactList(contacts);
		
		// Sort contacts by name
		cs.displayHeading("Sort contacts by name");
		cs.sortContactsByName(contacts);
		cs.displayContactList(contacts);
		
	}

	

	

}
