package com.asst10.contactDetails;

import java.util.ArrayList;
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
		return String.valueOf(Math.random() * ((9999999999l - 1000000000l) + 1) + 1000000000); 
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
	
	public static void main(String[] args) {
		ContactService cs = new ContactService();
		List <Contact> contacts = new ArrayList<>();
		
		cs.displayHeading("Add contact in contacts");
		cs.addContact(cs.getDummyContact(), contacts);
		cs.displayContactList(contacts);

	}

}
