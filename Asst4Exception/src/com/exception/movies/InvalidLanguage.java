package com.exception.movies;

public class InvalidLanguage extends Exception {

	public InvalidLanguage() {
		// TODO Auto-generated constructor stub
	}

	public InvalidLanguage(String message) {
		System.out.println(message + " is an invalid language. Language should be either English, Hindi or Marathi.");
	}

}
