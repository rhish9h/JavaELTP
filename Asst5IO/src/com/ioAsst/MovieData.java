package com.ioAsst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ioAsst.IncorrectValueCountException;
import com.ioAsst.InvalidLanguage;
import com.ioAsst.InvalidMovieIdException;

public class MovieData {

	enum languages {
		English, Hindi, Marathi
	}
	
	public List<Movie> readMovieData(String filename) {
		List <Movie> movies = new ArrayList<Movie>();
		
		try(BufferedReader buf = new BufferedReader(new FileReader(new File(filename)))) {
			
			String line = null;
			
			while ((line = buf.readLine()) != null) {
				try {
					int id;
					String name, language, date;
					String [] splitLine = line.split(",");
					int buflen = splitLine.length;
					
					if (buflen != 4) {
						throw new IncorrectValueCountException(buflen);
					}
					
					try {
						id = Integer.parseInt(splitLine[0]);
					} catch (Exception e) {
						throw new InvalidMovieIdException(splitLine[0]);
					}
					
					name = splitLine[1];
					
					if (! inLanguagesEnum(splitLine[2])) {
						throw new InvalidLanguage(splitLine[2]);
					} 
					
					language = splitLine[2];
					date = splitLine[3];
					
					movies.add(new Movie(id, name, language, date));
					
					System.out.println(line);
					
				} catch (IncorrectValueCountException | InvalidMovieIdException | InvalidLanguage e) {
					System.out.println("^^^");
				}	
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return movies;
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
		MovieData md = new MovieData();
		String filename = "movies.txt";
		List <Movie> movies = md.readMovieData(filename);
		
		System.out.println("---------------------");
		System.out.println("Printing from retrieved list.");
		System.out.println("---------------------");
		System.out.println(movies);
		
	}

}
