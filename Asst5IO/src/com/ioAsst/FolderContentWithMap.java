package com.ioAsst;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FolderContentWithMap {

	public Map<String, ArrayList> displayFolderContectsHelper(String path) {
		Map <String, ArrayList> folderMap = new HashMap <String, ArrayList> ();
		
		try {
			File file = new File(path);
			File [] pathnames = file.listFiles();
			ArrayList<Object> filesInCurDir = new ArrayList<Object>();
			
			for (File curfile : pathnames) {
				String curAbsPath = curfile.getAbsolutePath();
				
				if (curfile.isFile()) {
					filesInCurDir.add(curAbsPath);
				} else {
					filesInCurDir.add(displayFolderContectsHelper(curAbsPath));
				}
			}
			
			folderMap.put(path, filesInCurDir);
			
		} catch (NullPointerException npe) {
			System.err.println("Make sure to pass directory path and not file path.");
		}
		
		return folderMap;
	}
	
	public void displayFolderContents(String path) throws IOException {		
		Map <String, ArrayList> folderMap = displayFolderContectsHelper(path);
		
		System.out.println(folderMap);
	}
	
	public static void main(String[] args) throws IOException {
		FolderContentWithMap fc = new FolderContentWithMap();
		
		String path = "testFolder";
		System.out.println("The contents of " + path + " : \n");
		fc.displayFolderContents(path);
		
		path = "testFile";
		System.out.println("The contents of " + path + " : \n");
		fc.displayFolderContents(path);

	}

}
