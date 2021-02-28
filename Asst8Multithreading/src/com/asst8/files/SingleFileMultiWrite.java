package com.asst8.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SingleFileMultiWrite {

	public static void setupFile(File file) throws IOException {
		if (file.exists()) {
			file.delete();
		}
		
		file.createNewFile();
		System.out.println("Created file : " + file.getName());
	}
	
	public static void main(String[] args) throws IOException {
		File multiWriteFile = new File("multiWriteFile.txt");
		setupFile(multiWriteFile);
		
		Thread thread1 = new Thread() {
			public void run() {
				File file = new File("multiWriteFile.txt");
				
				try (FileWriter fw = new FileWriter(file, true)) {
					
					for (int i = 0; i < 10; i++) {
						fw.write("Thread 1 - " + i + "\n");
						System.out.println("Thread 1 - " + i + "\n");
						
						try {
							sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread thread2 = new Thread() {
			public void run() {
				File file = new File("multiWriteFile.txt");
				
				try (FileWriter fw = new FileWriter(file, true)) {
					
					for (int i = 0; i < 10; i++) {
						fw.write("Thread 2 - " + i + "\n");
						System.out.println("Thread 2 - " + i + "\n");
						
						try {
							sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread3 = new Thread() {
			public void run() {
				File file = new File("multiWriteFile.txt");
				
				try (FileWriter fw = new FileWriter(file, true)) {
					
					for (int i = 0; i < 10; i++) {
						fw.write("Thread 3 - " + i + "\n");
						System.out.println("Thread 3 - " + i + "\n");
						
						try {
							sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}
