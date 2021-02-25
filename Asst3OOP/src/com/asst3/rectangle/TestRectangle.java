package com.asst3.rectangle;

import java.util.Scanner;

public class TestRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length, breadth;
		
		// Rectangle 1 - passing values as parameters
		System.out.println("Enter length of rectangle - ");
		length = sc.nextInt();
		System.out.println("Enter breadth of rectangle - ");
		breadth = sc.nextInt();
		Rectangle test1 = new Rectangle(length, breadth);
		System.out.println("The following rectangle has been created - " + test1.toString());
		System.out.println("The area of the rectangle is -> " + test1.calcArea());
		
		// Rectangle 2 - using setters and getters
		Rectangle test2 = new Rectangle();
		System.out.println("Enter length of rectangle - ");
		length = sc.nextInt();
		System.out.println("Enter breadth of rectangle - ");
		breadth = sc.nextInt();
		test2.setLength(length);
		test2.setBreadth(breadth);
		System.out.println("The following rectangle has been created - " + test1.toString());
		System.out.println("The area of the rectangle is -> " + test2.calcArea());
		
		// Rectangle 3 - passing values as parameters
		System.out.println("Enter length of rectangle - ");
		length = sc.nextInt();
		System.out.println("Enter breadth of rectangle - ");
		breadth = sc.nextInt();
		Rectangle test3 = new Rectangle(length, breadth);
		System.out.println("The following rectangle has been created - " + test3.toString());
		System.out.println("The area of the rectangle is -> " + test3.calcArea());

	}

}
