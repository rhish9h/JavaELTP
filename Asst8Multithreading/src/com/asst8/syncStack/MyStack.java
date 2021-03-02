package com.asst8.syncStack;

import java.util.Stack;

public class MyStack {
	
	Stack <Integer> stack;
	
	public MyStack() {
		stack = new Stack<>();
	}
	
	public synchronized void push(Integer item, String name) {
		stack.push(item);
		System.out.println(item + " pushed by " + name);
		
		notify();
	}
	
	public synchronized Integer pop(String name) throws InterruptedException {
		if (stack.isEmpty()) {
			System.out.println("Stack is empty! Calling wait!");
			wait();
		}
		
		Integer item = stack.pop();
		System.out.println(item + " popped by " + name);
		return item;
	}
}
