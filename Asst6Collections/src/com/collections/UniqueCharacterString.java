package com.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueCharacterString {

	HashMap <String, Integer> charCountCache;
	
	public UniqueCharacterString() {
		charCountCache = new HashMap <> ();
	}
	
	public Integer uniqueCharacters(String str) {
		if (charCountCache.containsKey(str)) {
			System.out.println("Calling cache.");
			return charCountCache.get(str);
		}
		
		HashSet<Character> strSet = new HashSet<Character>();
		char[] strCharArr = str.toCharArray(); 
		int charCnt = 0;
		
		for (int i = 0; i < strCharArr.length; i++) {
			strSet.add(strCharArr[i]);
		}
		
		charCnt = strSet.size(); 
		
		charCountCache.put(str, charCnt);
		return charCnt;
	}
	
	public static void main(String[] args) {
		UniqueCharacterString ucs = new UniqueCharacterString();
		String str;
		
		str = "hello there!";
		System.out.println("Count of string : \"" + str + "\" --> " + ucs.uniqueCharacters(str));
		
		str = "hello there!";
		System.out.println("Count of string : \"" + str + "\" --> " + ucs.uniqueCharacters(str));
		
		str = "hello there!";
		System.out.println("Count of string : \"" + str + "\" --> " + ucs.uniqueCharacters(str));
		
		str = "general kenobi!";
		System.out.println("Count of string : \"" + str + "\" --> " + ucs.uniqueCharacters(str));

		str = "general kenobi!";
		System.out.println("Count of string : \"" + str + "\" --> " + ucs.uniqueCharacters(str));
		
	}

}
