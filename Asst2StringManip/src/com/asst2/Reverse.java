package com.asst2;

public class Reverse {

	static String makeReverse(String str) {
		String reverse = "";
		
		String [] words = str.split(" ");
		
		for (String word : words) {
			reverse += new StringBuilder(word).reverse().toString() + " ";
		}
		
		reverse = reverse.trim();
		return reverse;
	}
	
	public static void main(String[] args) {
		System.out.println("Reversed sentences - ");
		
		String sentence = "To be or not to be, that is the question.";
		System.out.println(sentence + " - " + makeReverse(sentence));
		
		sentence = "Hello there, General Kenobi!";
		System.out.println(sentence + " - " + makeReverse(sentence));
		
		sentence = "Noone expects the Spanish Inquisition!";
		System.out.println(sentence + " - " + makeReverse(sentence));

	}

}
