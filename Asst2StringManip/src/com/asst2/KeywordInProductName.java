package com.asst2;

public class KeywordInProductName {

	static String[] initProductNames() {
		return new String[] { "disney+", "instant pot duo", "11s robot vacuum", "innogear upgraded essential oil diffuser", "nectar mattress", "home chef" };
	}
	
	static boolean isPresent(String[] productNames, String keyword) {
		boolean present = false;
		
		for (String product : productNames) {
			if (product.contains(keyword)) {
				present = true;
				break;
			}
		}
		
		return present;
	}
	
	public static void main(String[] args) {
		String productNames[] = KeywordInProductName.initProductNames();
		System.out.println("Are these keywords available in products ? :");
		System.out.println("disney ? " + KeywordInProductName.isPresent(productNames, "disney"));
		System.out.println("oil ? " + KeywordInProductName.isPresent(productNames, "oil"));
		System.out.println("toolkit ? " + KeywordInProductName.isPresent(productNames, "toolkit"));
	}

}
