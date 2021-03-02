package com.movieDetails.exceptions;

public class IncorrectValueCountException extends Exception {

	public IncorrectValueCountException() {
		// TODO Auto-generated constructor stub
	}

	public IncorrectValueCountException(int buflen) {
		System.err.println("The number of values is " + buflen + ". It should be 8.");
		// TODO Auto-generated constructor stub
	}

}
