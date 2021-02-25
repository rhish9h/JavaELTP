package com.exception.contactStack;

import java.util.Date;

import com.exception.contact.*;

public class ContactStack {
	Contact [] stack;
	int ptr;
	int size;
	
	ContactStack() {
		size = 5;
		stack = new Contact[size];
		ptr = 0;
	}
	
	public void push(Contact contact) throws StackOverflowException {
		if (ptr == size) {
			throw new StackOverflowException();
		}
		stack[ptr++] = contact;
	}
	
	public void pop() throws StackUnderflowException {
		if (ptr == 0) {
			throw new StackUnderflowException();
		}
		stack[--ptr] = null;
	}
	
	private Contact getDummyContact() throws ContactException {
		Date dob = new Date(), anniversary = null;
		return new Contact("firstName", "middleName", "lastName", "gender", "address", "area", "city", "state", "country", "rhish@gmail.com", "website", dob, anniversary, 023, 230, 3240);
	}
	
	public Contact getBadContact() throws ContactException {
		return new Contact("firstName", "middleName", "lastName", "gender", "address", "area", "city", "state", "country", "rhish@gmail.com", "website", null, null, 023, 230, 3240);
	}
	
	private void pushDummy() throws StackOverflowException, ContactException {
		this.push(this.getDummyContact());
	}
	
	public void printStack() {
		if (stack.length == 0) {
			System.out.println();
			return;
		}
		
		for (Contact contact : stack) {
			System.out.print(contact + " ");
		}
		
		System.out.println("| ptr = " + ptr);
		
		System.out.println();
	}
	
	public static void main(String args[]) throws StackOverflowException, ContactException, StackUnderflowException {
		ContactStack stack = new ContactStack();
		stack.printStack();
		
		// 1 0 0 0 0
		stack.pushDummy();
		stack.printStack();
		
		// 0 0 0 0 0
		stack.pop();
		stack.printStack();
		
		// underflow
//		stack.pop();
//		stack.printStack();
		// uncomment above 2 lines, comment everything below for underflow
		
		// 1 0 0 0 0
		stack.pushDummy();
		stack.printStack();
		
		// 1 1 0 0 0
		stack.pushDummy();
		stack.printStack();
		
		// 1 1 1 0 0
		stack.pushDummy();
		stack.printStack();

		// 1 1 1 1 0
		stack.pushDummy();
		stack.printStack();
		
		// 1 1 1 1 1
		stack.pushDummy();
		stack.printStack();
		
		// overflow
//		stack.pushDummy();
//		stack.printStack();
		// uncomment above 2 lines and comment all below lines for overflow
		
		// 1 1 1 1 0
		stack.pop();
		stack.printStack();
		
		// dob is compulsory exception - uncomment below code
//		stack.push(stack.getBadContact());
//		stack.printStack();
	}
}
