package com.asst1;

public class DepositInterest {

	static double callInterest(int amt) {
		double interest = 0;
		
		if (amt <= 1000) {
			interest = amt * 0.04;
			System.out.println("Interest rate - 4 %");
		} else if (amt <= 5000) {
			interest = amt * 0.045;
			System.out.println("Interest rate - 4.5 %");
		} else {
			interest = amt * 0.05;
			System.out.println("Interest rate - 5%");
		}
		
		return interest;
	}
	
	public static void main(String[] args) {
		System.out.println("Calculating interests for the following amounts - ");
		System.out.println("999 -> " + callInterest(999));
		System.out.println("1000 -> " + callInterest(1000));
		System.out.println("1500 -> " + callInterest(1500));
		System.out.println("5000 -> " + callInterest(5000));
		System.out.println("5001 -> " + callInterest(5001));
		System.out.println("6000 -> " + callInterest(6000));
	}

}
