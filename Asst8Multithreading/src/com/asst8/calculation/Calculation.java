package com.asst8.calculation;

import java.util.Random;

public class Calculation {

	public static int[] getRandomIntArray() {
		Random rd = new Random(); // creating Random object
		int[] arr = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(100); // storing random integers in an array
			// System.out.println(arr[i]); // printing each array element
		}		
		
		return arr;
	}
	
	public static String arrToString(int [] intArr) {
		String arrStr = "";
		
		for (int i = 0; i < intArr.length; i++) {
			arrStr += intArr[i] + " ";
		}

		return arrStr;
	}
	
	public static void main(String[] args) throws InterruptedException {
		int[] randomArr = getRandomIntArray();
		System.out.println("Random Array --> " + arrToString(randomArr) + "\n");
		Random rand = new Random();
		int randIdx = rand.nextInt(randomArr.length);

		Sum sum = new Sum(randomArr);
		Average avg = new Average(randomArr);
		Sorting sort = new Sorting(randomArr);
		Searching search = new Searching(randomArr, randomArr[randIdx]);
		
		sum.join();
		avg.join();
		sort.join();
		search.join();
		System.out.println();
		
		sum = new Sum(randomArr);
		sum.join();
		avg = new Average(randomArr);
		avg.join();
		sort = new Sorting(randomArr);
		sort.join();
		search = new Searching(randomArr, randomArr[randIdx]);
		search.join();
	}

}
