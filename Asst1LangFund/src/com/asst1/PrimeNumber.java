package com.asst1;

public class PrimeNumber {

	static boolean isPrimeNumber(int num) {
		if (num < 2) {
			return false;
		}
		
		if (num == 2) {
			return true;
		}
		
		if (num % 2 == 0) {
			return false;
		}
		
		boolean isPrime = true;
		
		for (int i = 3; i * i <= num; i+=2) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
	}
	
	public static void main(String[] args) {
		System.out.println("Checking whether numbers are prime - ");
		System.out.println("1 ? " + isPrimeNumber(1));
		System.out.println("2 ? " + isPrimeNumber(2));
		System.out.println("10 ? " + isPrimeNumber(10));
		System.out.println("13 ? " + isPrimeNumber(13));
		System.out.println("12341 ? " + isPrimeNumber(12341));
	}

}
