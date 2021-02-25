package com.asst1;

public class Tax {

	static double calTax(int gp) {
		double tax = 0;
		
		if (gp <= 240) {
			tax = 0;
			System.out.println("Tax rate is 0 %");
		} else if (gp <= 480) {
			tax = (15 / 100d) * gp;
			System.out.println("Tax rate is 15 %");
		} else {
			tax = (28 / 200d) * gp;
			System.out.println("Tax rate is 28 %");
		}
		
		return tax;
	}
	
	public static void main(String[] args) {
		System.out.println("Tax for following pay amounts - ");
		System.out.println("100 - " + calTax(100));
		System.out.println("240 - " + calTax(240));
		System.out.println("241 - " + calTax(241));
		System.out.println("480 - " + calTax(480));
		System.out.println("481 - " + calTax(481));
		System.out.println("1000 - " + calTax(1000));

	}

}
