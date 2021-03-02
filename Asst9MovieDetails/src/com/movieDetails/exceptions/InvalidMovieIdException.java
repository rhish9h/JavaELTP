package com.movieDetails.exceptions;

public class InvalidMovieIdException extends Exception {

	public InvalidMovieIdException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidMovieIdException(String message) {
		System.err.println(message + " is an invalid movieId. It should be an Integer.");
	}

}
