package com.asst8.calculation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting extends Thread {
	private int[] randomArr;
	
	public Sorting(int[] randomArr) {
		this.randomArr = randomArr;
		start();
	}
	
	@Override
	public void run() {
		Arrays.sort(randomArr);
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Sorted Array = " + Calculation.arrToString(randomArr));
		
	}
}
