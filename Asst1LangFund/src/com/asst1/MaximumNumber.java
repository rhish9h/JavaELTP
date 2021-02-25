package com.asst1;

public class MaximumNumber {

	static int calMax(int x, int y, int z) {
		int maxVal = Integer.MIN_VALUE;
		
		if (x > maxVal) {
			maxVal = x;
		}
		
		if (y > maxVal) {
			maxVal = y;
		}
		
		if (z > maxVal) {
			maxVal = z;
		}
		
		return maxVal;
	}
	
	public static void main(String[] args) {
		System.out.println("Max value in 0, 1, 2 -> " + calMax(0, 1, 2));
		System.out.println("Max value in 10, 123, 22 -> " + calMax(10, 123, 22));
		System.out.println("Max value in 1044, 123, 422 -> " + calMax(1044, 123, 422));

	}

}
