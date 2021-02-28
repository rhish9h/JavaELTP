package com.asst8.files;

import java.io.File;

public class TenFiles {

	private static void setupDirHelper(File dir) {
		if (! dir.exists()) {
			dir.mkdir();
		} else {
			for (File file : dir.listFiles()) {
				file.delete();
			}
		}
	}
	
	public static void setupDirectories() {
		File dir1 = new File("dir1");
		File dir2 = new File("dir2");
		File dir3 = new File("dir3");
		File dir4 = new File("dir4");
		
		setupDirHelper(dir1);
		setupDirHelper(dir2);
		setupDirHelper(dir3);
		setupDirHelper(dir4);
	}
	
	public static void main(String[] args) {
		setupDirectories();
		
		Thread thread1 = new Thread(new FileCreator("dir1"));
		Thread thread2 = new Thread(new FileCreator("dir2"));
		Thread thread3 = new Thread(new FileCreator("dir3"));
		Thread thread4 = new Thread(new FileCreator("dir4"));
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
