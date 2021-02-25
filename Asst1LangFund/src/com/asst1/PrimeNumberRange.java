package com.asst1;

import java.util.LinkedList;
import java.util.List;

public class PrimeNumberRange {

	public int[] findPrime(int start, int end) {
		if (start < 2) {
			start = 2;
		}
		
		if (start > end || end < 2) {
			return new int[] {};
		}
		
		List<Integer> primes = new LinkedList<Integer>();
		int curelem;
		boolean isPrime = true;
		
		if (start <= 2 && end >= 2) {
			primes.add(start);
		}
		
		if (start % 2 == 0) {
			start += 1;
		}
		
		for (curelem = start; curelem <= end; curelem += 2) {
			isPrime = true;
			
			for (int modwith = 2; (modwith * modwith) < curelem; modwith ++) {
				if (curelem % modwith == 0) {
					isPrime = false;
				}
			}
			
			if (isPrime) {
				primes.add(curelem);
			}
		}
		
		int [] primesArray = primes.stream().mapToInt(i->i).toArray(); 
		return primesArray;
	}
	
	private void printArray(int[] nos) {
		for (int num : nos) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		PrimeNumberRange primeNum = new PrimeNumberRange();
		
		System.out.println("Prime numbers between 0 and 12 (inclusive) - ");
		primeNum.printArray(primeNum.findPrime(0, 12));
		
		System.out.println("Prime numbers between 10 and 20 (inclusive) - ");
		primeNum.printArray(primeNum.findPrime(10, 20));
		
	}

}
