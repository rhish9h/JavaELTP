package com.exception.contactStack;

public class StackUnderflowException extends Exception {
	public StackUnderflowException() {
		System.out.println("Stack is empty, cannot pop contact.");
	}
}
