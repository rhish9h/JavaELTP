package com.asst8.syncStack;

public class PopThread extends Thread {

	MyStack stack;
	String name;
	
	public PopThread(MyStack stack, String name) {
		this.stack = stack;
		this.name = name;
	}
	
	@Override
	public void run() {
		
		while (true) {
			try {
				stack.pop(name);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
