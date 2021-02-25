package com.ioAsst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class WordCount {

	public int countWords(String filePath) {
		int wordCnt = 0;
		
		try (BufferedReader buf = new BufferedReader(new FileReader(new File(filePath)))) {
			
			String line = null;
			
			while ((line = buf.readLine()) != null) {
				String [] splitString = line.split(" ");
				wordCnt += splitString.length;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return wordCnt;
	}
	
	public static void main(String[] args) {
		WordCount wc = new WordCount();
		String filePath = "testFile";
		int wordCnt = wc.countWords(filePath);
		System.out.println("The number of words in the file " + filePath + " is - " + wordCnt);
		
	}

}
