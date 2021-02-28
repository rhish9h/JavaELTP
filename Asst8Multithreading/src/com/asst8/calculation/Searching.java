package com.asst8.calculation;

public class Searching extends Thread {
	private int[] randomArr;
	private int key;
	
	public Searching(int[] randomArr, int key) {
		this.randomArr = randomArr;
		this.key = key;
		start();
	}
	
	@Override
	public void run() {
		
		boolean found = false;
		int idx = -1;
		
		for (int i = 0; i < randomArr.length; i++) {
			if (randomArr[i] == key) {
				found = true;
				idx = i;
				break;
			}
		}
		
		try { 
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (found) {
			System.out.println("Searching : Key = " + key + " found at index " + idx);
		} else {
			System.out.println("Searching : Key = " + key + " not found.");
		}
		
	}
}
