package com.asst1;

public class ElectricityBill {

	private double domestic(double units) {
		double bill = 0;
		
		if (units <= 100) {
			bill = Math.max(250, units * 4);
		} else if (units <= 300) {
			bill = units * 4.5;
		} else if (units <= 500) {
			bill = units * 4.75;
		} else {
			bill = units * 5;
		}
		
		return bill;
	}
	
	private double commercial(double units) {
		double bill = 0;
		
		if (units <= 100) {
			bill = Math.max(units * 4.25, 350);
		} else if (units <= 300) {
			bill = units * 4.75;
		} else if (units <= 500) {
			bill = units * 5;
		} else {
			bill = units * 5.25;
		}
		
		return bill;
	}
	
	public double calculateBill(char type, double units) {
		double bill = 0;
		
		if (type == 'd') {
			bill = domestic(units);
		} else {
			bill = commercial(units);
		}
		
		return bill;
	}
	
	public static void main(String[] args) {
		ElectricityBill ebill = new ElectricityBill();
		System.out.println("Calculating bill for given units -");
		System.out.println("50 -> " + ebill.calculateBill('d', 50));
		System.out.println("100 -> " + ebill.calculateBill('d', 100));
		System.out.println("500 -> " + ebill.calculateBill('d', 500));
		System.out.println("50 -> " + ebill.calculateBill('c', 50));
		System.out.println("100 -> " + ebill.calculateBill('c', 100));
		System.out.println("500 -> " + ebill.calculateBill('c', 500));
		System.out.println("5001 -> " + ebill.calculateBill('c', 5001));
	}

}
