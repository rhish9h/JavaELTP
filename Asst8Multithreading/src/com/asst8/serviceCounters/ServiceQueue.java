package com.asst8.serviceCounters;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceQueue {
	Queue <String[]> serviceQueue;
	
	public ServiceQueue() {
		serviceQueue = new LinkedList <>();
	}
	
	public synchronized void createOrder(String counterName, String foodItem) {
		serviceQueue.offer(new String[] {counterName, foodItem});
		System.out.println(foodItem + " ordered " + " at Counter " + counterName);
	}
	
	public synchronized void service(String counterName) throws InterruptedException {
		String servedOrder[] = serviceQueue.poll();
		if (servedOrder != null) {
			System.out.println("Counter " + counterName + " serviced " + servedOrder[1] + " ordered by " + servedOrder[0]);
		}
	}
}