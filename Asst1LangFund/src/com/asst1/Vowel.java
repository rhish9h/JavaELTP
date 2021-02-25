package com.asst1;

public class Vowel {

	static boolean checkAlpha(char alph) {
		char [] vowels = {'a', 'e', 'i', 'o', 'u'};
		boolean isVowel = false;
		
		for (char letter : vowels) {
			if (letter == alph) {
				isVowel = true;
			}
		}
		
		return isVowel;
	}
	
	public static void main(String[] args) {
		System.out.println("Are these letters vowels ? :");
		System.out.println("a ? " + checkAlpha('a'));
		System.out.println("b ? " + checkAlpha('b'));
		System.out.println("z ? " + checkAlpha('z'));
		System.out.println("u ? " + checkAlpha('u'));
	}

}
