package com.asst2;

public class FindAndReplace {

	static String findAndReplace(String haystack, String needle, String replaceWith) {
		String replaced = "";
		
		replaced = haystack.replace(needle, replaceWith);
		
		return replaced;
	}
	
	public static void main(String[] args) {
		System.out.println("Finding and replacing needle from haystack - ");
		String haystack = "";
		String needle = "";
		String replaceWith = "";
		
		haystack = "Hello there, General Kenobi!";
		needle = "there";
		replaceWith = "here";
		System.out.println(haystack + " - " + needle + " - " + replaceWith + " - " + findAndReplace(haystack, needle, replaceWith));
		
		haystack = "Noone expects the Spanish Inquisition!";
		needle = "there";
		replaceWith = "here";
		System.out.println(haystack + " - " + needle + " - " + replaceWith + " - " + findAndReplace(haystack, needle, replaceWith));
		
		haystack = "Noone expects the Spanish Inquisition!";
		needle = "Spanish";
		replaceWith = "Indian";
		System.out.println(haystack + " - " + needle + " - " + replaceWith + " - " + findAndReplace(haystack, needle, replaceWith));

	}

}
