package com.exception.contactStack;

public class StackOverflowException extends Exception {
	public StackOverflowException() {
		System.out.println("Stack is full, cannot push contact.");
	}
}
