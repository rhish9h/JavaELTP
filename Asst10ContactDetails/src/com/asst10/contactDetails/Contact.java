package com.asst10.contactDetails;

import java.util.List;

public class Contact {
	
	int contactId;
	String contactName;
	String emailAddress;
	List<String> contactNumber;
	
	public Contact(int contactId, String contactName, String emailAddress, List<String> contactNumber) {
		this.contactId = contactId;
		this.contactName = contactName;
		this.emailAddress = emailAddress;
		this.contactNumber = contactNumber;
	}
	
	@Override
	public String toString() {
		return contactName + " [contactId=" + contactId + ", contactName=" + contactName + ", emailAddress=" + emailAddress
				+ ", contactNumber=" + contactNumber + "]";
	}
	
	public int getContactId() {
		return contactId;
	}
	
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	
	public String getContactName() {
		return contactName;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public List<String> getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(List<String> contactNumber) {
		this.contactNumber = contactNumber;
	}
}
