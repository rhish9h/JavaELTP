package com.asst1;

public class Loan {

	static float calLoan(int age, char gender, String job, int asset) {
		float payback = 0;
		
		if (asset <= 500) {
			payback = 0.0025f * asset;
		} else if (asset <= 1500) {
			payback = 0.0025f * 500 + (asset - 500) * 0.005f;
		} else if (asset <= 2500) {
			payback = 0.0025f * 500 + 1000 * 0.005f + (asset - 1500) * 0.0075f;
		} else {
			payback = 0.0025f * 500 + 1000 * 0.005f + 1000 * 0.0075f + (asset - 2500) * 0.001f;
		}
		
		return payback;
	}
	
	public static void main(String[] args) {
		System.out.println("Calculating loan payback amount - ");
		System.out.println("400 -> " + calLoan(12, 'x', "xyz", 400));
		System.out.println("1400 -> " + calLoan(12, 'x', "xyz", 1400));
		System.out.println("2000 -> " + calLoan(12, 'x', "xyz", 2000));
		System.out.println("2600 -> " + calLoan(12, 'x', "xyz", 2600));

	}

}
