package com.ioAsst;

import java.io.File;

public class SearchFile {

	public Boolean searchFile(String path, String filename) {
		Boolean found = false;
		File file = new File(path);
//		System.out.println(path + " : " + filename + " : " + file.getName() + " : " + file.isFile() + " : " + (file.getName() == filename));
		
		if (file.isFile() && file.getName().equals(filename)) {
			found = true;
		} else if (file.isDirectory()) {
			
			File [] filesInDir = file.listFiles();
			
			for (File curFile : filesInDir) {
//				System.out.println(curFile.getName() + " : " + curFile.isFile() + " : " + curFile.getName().equals(filename));
				if (curFile.isFile() && curFile.getName().equals(filename)) {
					found = true;
					break;
				} else if (curFile.isDirectory()) {
					found = searchFile(curFile.getAbsolutePath(), filename);
					if (found) {
						break;
					}
				}
			}
			
		}
		
//		System.out.println();
		return found;
	}
	
	public static void main(String[] args) {
		SearchFile sf = new SearchFile();
		String path, filename;
		
		// folder exists, file exists, no nesting
		path = "testFolder";
		filename = "test1";
		System.out.println(path + " - " + filename + " - found? : " + sf.searchFile(path, filename));
		
		// folder exists, file exists, with nesting
		path = "testFolder";
		filename = "innerFile1";
		System.out.println(path + " - " + filename + " - found? : " + sf.searchFile(path, filename));
		
		// folder exists, file does not exist
		path = "testFolder";
		filename = "test3";
		System.out.println(path + " - " + filename + " - found? : " + sf.searchFile(path, filename));
		
		// direct file given, target does not match
		path = "test1";
		filename = "test3";
		System.out.println(path + " - " + filename + " - found? : " + sf.searchFile(path, filename));
		
		// direct file given, path doesn't exist
		path = "test3";
		filename = "test3";
		System.out.println(path + " - " + filename + " - found? : " + sf.searchFile(path, filename));
		
		// direct file given, target matches
		path = "testfile";
		filename = "testfile";
		System.out.println(path + " - " + filename + " - found? : " + sf.searchFile(path, filename));

	}

}
