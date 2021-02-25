package com.exception.contact;

import java.util.Date;

public class Contact {
	String firstName, middleName, lastName, gender, address, area, city, state, country, email, website;   
	Date dob, anniversary;
	int pincode;
	long telephoneNumber, mobileNumber;
	
	//TODO create objects for name (firstName, middleName, lastName), address (...), otherDetails(...) to avoid billion parameters
	// not doing that because timeline is too short, too many assignments
	public Contact(String firstName, String middleName, String lastName, String gender, String address, String area, String city, String state, String country, String email, String website, Date dob, Date anniversary, int pincode, long telephoneNumber, long mobileNumber) throws ContactException {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.email = email;
		this.website = website;
		this.dob = dob;
		this.anniversary = anniversary;
		this.telephoneNumber = telephoneNumber;
		this.mobileNumber = mobileNumber;
		
		this.validate();
		
	}
	
	private void validate() throws ContactException {
		if (firstName.isEmpty()) {
			throw new CompulsoryException("firstName");
		}
		if (lastName.isEmpty()) {
			throw new CompulsoryException("lastName");
		}
		if (dob == null) {
			throw new CompulsoryException("dob");
		}
		if (email.isEmpty()) {
			throw new CompulsoryException("email");
		}
		if (! isEmailValid()) {
			throw new FormatException("email");
		}
		if (telephoneNumber == 0 && mobileNumber == 0) {
			throw new SpecifyException();
		}
	}
	
	private boolean isEmailValid() {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}
	
	public static void main(String [] args) throws ContactException {
		Date dob = new Date(), anniversary = null;
		try {
			// String firstName, String middleName, String lastName, String gender, String address, String area, String city, String state, String country, String email, String website, Date dob, Date anniversary, int pincode, long telephoneNumber, long mobileNumber
			
			// first name 
//			Contact testContact = new Contact("", "middleName", "lastName", "gender", "address", "area", "city", "state", "country", "email", "website", dob, anniversary, 1234, 23412, 213);

			// email
			Contact testContact = new Contact("firstName", "middleName", "lastName", "gender", "address", "area", "city", "state", "country", "email", "website", dob, anniversary, 1234, 23412, 213);

			// telephone and mobile number
//			Contact testContact = new Contact("firstName", "middleName", "lastName", "gender", "address", "area", "city", "state", "country", "rhish@gmail.com", "website", dob, anniversary, 023, 0, 0);
			
			//normal 
//			Contact testContact = new Contact("firstName", "middleName", "lastName", "gender", "address", "area", "city", "state", "country", "rhish@gmail.com", "website", dob, anniversary, 023, 230, 3240);
		}
		catch (ContactException e) {
			System.out.println(e);
		} 
//		catch (Exception e) {
//			e.getMessage();
//		}
		
	}
}
