package com.asst8.files;

import java.io.File;
import java.io.IOException;

public class FileCreator implements Runnable {

	String dirName;
	
	public FileCreator (String dirName) {
		this.dirName = dirName;
	}
	
	@Override
	public void run() {
		File file = new File(dirName);
		String dirPath = file.getAbsolutePath();
		String newFile;
		
		for (int i = 1; i <= 10; i++) {
			newFile = dirPath + "/file" + i;
			
			File myNewFile = new File(newFile);
			try {
				myNewFile.createNewFile();
				System.out.println("Created file - " + newFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
