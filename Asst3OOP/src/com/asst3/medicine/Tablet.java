package com.asst3.medicine;

public class Tablet extends Medicine {
	Tablet() {
		super();
	}
	
	Tablet(String name, String address) {
		super(name, address);
	}
	
	@Override
	public void displayLabel() {
		super.displayLabel();
		System.out.println("Store tablet in a cool dry place.");
	}
}
