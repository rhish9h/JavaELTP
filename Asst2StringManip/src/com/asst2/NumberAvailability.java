package com.asst2;

public class NumberAvailability {
	
	static int[] generateNos() {
		int [] nos = new int [50];
		int v = 0;
		
		for (int i = 0; i < 50; i++) {
			nos[i] = v;
			v += 2;
		}
		
		return nos;
	}
	
	static void printNos(int[] nos) {
		for (int elem : nos) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
	
	static int findPosition(int num, int[] nos) {
		int position = -1;
		
		for ( int i = 0; i < nos.length; i++ ) {
			if ( nos[i] == num ) {
				position = i;
				break;
			}
		}
		
		return position;
	}
	
	public static void main(String[] args) {
		System.out.println("Generating numbers - ");
		int [] nos = NumberAvailability.generateNos();
		NumberAvailability.printNos(nos);
		
		System.out.println("Are these numbers present in the array ?, if yes print idx, else -1 -");
		
		System.out.println("13 ? : " + NumberAvailability.findPosition(13, nos));
		System.out.println("14 ? : " + NumberAvailability.findPosition(14, nos));
		System.out.println("16 ? : " + NumberAvailability.findPosition(16, nos));
		System.out.println("61 ? : " + NumberAvailability.findPosition(61, nos));

	}

}
