package com.asst3.medicine;

public class Ointment extends Medicine {

	public Ointment() {
		super();
	}

	public Ointment(String name, String address) {
		super(name, address);
	}

	@Override
	public void displayLabel() {
		super.displayLabel();
		System.out.println("Ointment For external use only.");
	}

}
