package com.asst1;

public class MultiplicationMatrix {

	static int [][] mat = new int[13][13];
	
	static void populateMultiplicationMatrix() {
		for (int i = 1; i < 13; i++) {
			mat[0][i] = i;
			mat[i][0] = i;
		}
		
		for (int i = 1; i < 13; i++) {
			for (int j = 1; j < 13; j++) {
				mat[i][j] = i * j;
			}
		}
	}
	
	static void displayMultiplicationMatrix() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) { 
				System.out.printf("%5d", mat[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		populateMultiplicationMatrix();
		displayMultiplicationMatrix();

	}

}
