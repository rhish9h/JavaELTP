package com.asst8.calculation;

public class Average extends Thread {
	private int[] randomArr;
	
	public Average(int[] randomArr) {
		this.randomArr = randomArr;
		start();
	}
	
	@Override
	public void run() { 
		int avg = 0;
		
		for (int i = 0; i < randomArr.length; i++) {
			avg += randomArr[i];
		}
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		avg /= randomArr.length;
		
		System.out.println("Average = " + avg);
	}
	
}
