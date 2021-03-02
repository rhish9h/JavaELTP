package com.asst8.serviceCounters;

public class ServiceCounter extends Thread {
	String name;
	ServiceQueue serviceQueue;
	
	public ServiceCounter(String name, ServiceQueue serviceQueue) {
		this.name = name;
		this.serviceQueue = serviceQueue;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				serviceQueue.service(name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
