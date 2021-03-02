package com.asst8.syncStack;

import java.util.Random;

public class PushThread extends Thread {
	
	MyStack stack;
	String name;
	
	public PushThread(MyStack stack, String name) {
		this.stack = stack;
		this.name = name;
	}
	
	@Override
	public void run() {
		
		Random random = new Random();
		Integer item;
		
		while (true) {
			
			item = random.nextInt(1000);
			stack.push(item, name);
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
