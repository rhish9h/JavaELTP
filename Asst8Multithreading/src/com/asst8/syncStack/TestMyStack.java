package com.asst8.syncStack;

public class TestMyStack {

	public static void main(String[] args) {
		
		MyStack myStack = new MyStack();
		Thread pushThread = new PushThread(myStack, "myPushThread");
		Thread popThread = new PopThread(myStack, "myPopThread");
		
		pushThread.start();
		popThread.start();
		
	}

}
