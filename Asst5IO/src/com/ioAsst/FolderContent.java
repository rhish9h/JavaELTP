package com.ioAsst;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FolderContent {

	public void displayFolderContents(String path) throws IOException {		
		try {
			File file = new File(path);
			File [] pathnames = file.listFiles();
			
			for (File curfile : pathnames) {
				if (curfile.isFile()) {
					System.out.println(curfile.getAbsolutePath());
				} else {
					displayFolderContents(curfile.getAbsolutePath());
				}
			}
		} catch (NullPointerException npe) {
			System.err.println("Make sure to pass directory path and not file path.");
		}
	}
	
	public static void main(String[] args) throws IOException {
		FolderContent fc = new FolderContent();
		
		String path = "testFolder";
		System.out.println("The contents of " + path + " : \n");
		fc.displayFolderContents(path);
		
		path = "testFile";
		System.out.println("The contents of " + path + " : \n");
		fc.displayFolderContents(path);

	}

}
