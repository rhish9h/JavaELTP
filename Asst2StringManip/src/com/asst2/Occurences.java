package com.asst2;

public class Occurences {

	static int check(String sentence, String word) {
		int count = 0;
		int lastIdx = 0;
		int wlen = word.length();
		
		while (lastIdx != -1) {
			lastIdx = sentence.indexOf(word, lastIdx);
			if (lastIdx != -1) {
				count += 1;
				lastIdx += wlen;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println("Finding occurences of word in sentences - ");
		
		String sentence = "Hello how are you?";
		String word = "Hello";
		System.out.println(sentence + " - " + word + " - " + check(sentence, word));
		
		sentence = "She sells sea shells on the sea shore.";
		word = "sea";
		System.out.println(sentence + " - " + word + " - " + check(sentence, word));
		
		sentence = "sdfsfsdfgdfhdfghdffghdfgdsgdfg";
		word = "dfg";
		System.out.println(sentence + " - " + word + " - " + check(sentence, word));
		
		sentence = "yo yoy yo yo yo yo yo yoyoyoyoyooyy";
		word = "yoyo";
		System.out.println(sentence + " - " + word + " - " + check(sentence, word));

	}

}
