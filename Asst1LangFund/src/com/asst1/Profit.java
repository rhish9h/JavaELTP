package com.asst1;

public class Profit {

	static float calculateProfit(int numAttendees) {
		float profit = 0;
		float cost = 20 + numAttendees * 0.5f;
		float earnings = numAttendees * 5;
		profit = earnings - cost;
		
		return profit;
	}
	
	public static void main(String[] args) {
		System.out.println("Profit earned for number of attendees -");
		System.out.println("1 -> " + calculateProfit(1));
		System.out.println("10 -> " + calculateProfit(10));
		System.out.println("4 -> " + calculateProfit(4));
		System.out.println("31 -> " + calculateProfit(31));

	}

}
