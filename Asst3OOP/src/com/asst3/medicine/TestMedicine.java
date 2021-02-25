package com.asst3.medicine;

import java.util.Random;

public class TestMedicine {
	
	public static Medicine[] populateMedicines(Medicine[] medArray) {
		String [] companyNames = {"Cipla", "Pfizer", "Syngene", "GSK", "AstraZeneca"};
		String [] addresses = {"Pune", "Mumbai", "Hyderabad", "Delhi", "Goa"};
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			int randomArrIdx = random.nextInt(4);
			int randomCompIdx = random.nextInt(5);
			int randomAddrIdx = random.nextInt(5);
			
			switch(randomArrIdx) {
				case 0:
					medArray[i] = new Tablet(companyNames[randomCompIdx], addresses[randomAddrIdx]); 
					break;
				case 1:
					medArray[i] = new Syrup(companyNames[randomCompIdx], addresses[randomAddrIdx]);
					break;
				case 2:
					medArray[i] = new Ointment(companyNames[randomCompIdx], addresses[randomAddrIdx]);
					break;
				case 3:
					medArray[i] = new Medicine(companyNames[randomCompIdx], addresses[randomAddrIdx]);
					break;
			}
		}
		
		return medArray;
	}
	
	public static void displayMedArray(Medicine[] medArray) {
		for (Medicine med : medArray) {
			med.displayLabel();
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Medicine [] medArray = new Medicine[10];

		medArray = populateMedicines(medArray);
		displayMedArray(medArray);
		
	}
	
}
