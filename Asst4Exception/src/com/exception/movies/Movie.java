package com.exception.movies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Movie {

	String [][] movies;
	enum languages {
		English, Hindi, Marathi
	}
	String movieFilePath = "C:\\\\Users\\\\Rhishabh\\\\eclipse-workspace\\\\Asst4Exception\\\\src\\\\com\\\\exception\\\\movies\\\\movies.txt";
	
	Movie() {
		try(BufferedReader buf = new BufferedReader(new FileReader(movieFilePath))) {
			
			String line = null;
			
			while ((line = buf.readLine()) != null) {
				try {
					String [] splitLine = line.split(",");
					int buflen = splitLine.length;
					
					if (buflen != 4) {
						throw new IncorrectValueCountException(buflen);
					}
					
					try {
						Integer.parseInt(splitLine[0]);
					} catch (Exception e) {
						throw new InvalidMovieIdException(splitLine[0]);
					}
					
					if (! inLanguagesEnum(splitLine[2])) {
						throw new InvalidLanguage(splitLine[2]);
					}
					
					System.out.println(line);
				} catch (IncorrectValueCountException | InvalidMovieIdException | InvalidLanguage e) {
					System.out.println("^^^");
				}	
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private boolean inLanguagesEnum(String language) {
		boolean present = false;
		
		for (languages l : languages.values()) {
			if (l.toString().equals(language)) {
				present = true;
				break;
			}
		}
		
		return present;
	}
	
	public static void main(String[] args) {
		Movie movie = new Movie();

	}

}
