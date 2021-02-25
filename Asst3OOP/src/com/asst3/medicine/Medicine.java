package com.asst3.medicine;

public class Medicine {
	String name, address;
	
	Medicine() {
		name = "";
		address = "";
	}
	
	Medicine(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public void displayLabel() {
		System.out.println("Name : " + name + " - " + "Address : " + address);
	}
}
