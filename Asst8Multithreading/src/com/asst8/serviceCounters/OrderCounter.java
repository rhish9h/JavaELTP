package com.asst8.serviceCounters;

import java.util.Random;

public class OrderCounter extends Thread {
	String name;
	ServiceQueue serviceQueue;
	
	OrderCounter(String name, ServiceQueue serviceQueue) {
		this.name = name;
		this.serviceQueue = serviceQueue;
	}
	
	@Override
	public void run() {
		
		String[] foodItems = new String[] {"Pizza", "Burger", "Pav Bhaji", "Chole", "Ras Malai", "Steak"};
		Random random = new Random();
		String foodItem;
		int foodItemLen = foodItems.length;
		
		while (true) {
			foodItem = foodItems[random.nextInt(foodItemLen)];
			serviceQueue.createOrder(this.name, foodItem);
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
