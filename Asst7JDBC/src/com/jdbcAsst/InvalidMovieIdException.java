package com.jdbcAsst;

public class InvalidMovieIdException extends Exception {

	public InvalidMovieIdException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidMovieIdException(String message) {
		System.out.println(message + " is an invalid movieId. It should be an Integer.");
	}

}
