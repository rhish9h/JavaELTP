package com.asst2;

import java.util.LinkedList;
import java.util.List;

public class Combination {
	
	static List <String> combinations;

	static String[] getCombinations(String input) {
		combinations = new LinkedList <String> ();
		
		helper(input, 0, input.length() - 1);
		
		String [] combFound = combinations.toArray(new String[combinations.size()]); 
		return combFound;
	}

	private static void helper(String input, int left, int right) {
		if (left == right) {
			combinations.add(input);
		} else {
			for ( int i = left; i <= right; i++) {
				input = swap(input, left, i);
				helper(input, left + 1, right);
				input = swap(input, left, i);
			}
		}
	}
	
	private static String swap(String input, int left, int right) {
		char temp;
		char [] inputArray = input.toCharArray();
		temp = inputArray[left];
		inputArray[left] = inputArray[right];
		inputArray[right] = temp;
		input = String.valueOf(inputArray);
		
		return input;
	}
	
	private static void printCombinations(String [] combinations) {
		for (String cur : combinations) {
			System.out.println(cur);
		}
	}
	
	public static void main(String[] args) {
		String [] combinations = getCombinations("abcd");
		printCombinations(combinations);

	}

}
