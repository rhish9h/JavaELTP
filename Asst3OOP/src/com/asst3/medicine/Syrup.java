package com.asst3.medicine;

public class Syrup extends Medicine {
	
	Syrup() {
		super();
	}
	
	Syrup(String name, String address) {
		super(name, address);
	}
	
	@Override
	public void displayLabel() {
		super.displayLabel();
		System.out.println("High fructose syrup. Keep refrigerated.");
	}
}
