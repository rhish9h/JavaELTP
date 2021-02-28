package com.asst8.calculation;

public class Sum extends Thread {
	private int[] randomArr;
	
	public Sum(int[] randomArr) {
		this.randomArr = randomArr;
		start();
	}
	
	@Override
	public void run() { 
		int sum = 0;
		
		for (int i = 0; i < randomArr.length; i++) {
			sum += randomArr[i];
		}
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Sum = " + sum);
	}
}
