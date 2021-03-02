package com.movieDetails.exceptions;

public class InvalidLanguageException extends Exception {

	public InvalidLanguageException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidLanguageException(String message) {
		System.err.println(message + " is an invalid language. Language should be either English, Hindi or Marathi.");
	}

}
