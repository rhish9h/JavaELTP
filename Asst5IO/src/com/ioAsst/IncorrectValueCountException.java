package com.ioAsst;

public class IncorrectValueCountException extends Exception {

	public IncorrectValueCountException() {
		// TODO Auto-generated constructor stub
	}

	public IncorrectValueCountException(int buflen) {
		System.out.println("The number of values is " + buflen + ". It should be 4.");
		// TODO Auto-generated constructor stub
	}

}
