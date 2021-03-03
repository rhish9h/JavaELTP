package com.movieDetails.exceptions;

import java.util.Arrays;
import com.movieDetails.MovieEnums.Language;

public class InvalidLanguageException extends Exception {

	public InvalidLanguageException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidLanguageException(String message) {
		System.err.println(message + " is an invalid language. Language should be either " + Arrays.asList(Language.values()));
	}

}
