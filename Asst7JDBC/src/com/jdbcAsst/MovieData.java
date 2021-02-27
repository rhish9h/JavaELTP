package com.jdbcAsst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.jdbcAsst.IncorrectValueCountException;
import com.jdbcAsst.InvalidLanguage;
import com.jdbcAsst.InvalidMovieIdException;

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
	
	private Date parseDate(String dateToParse) {
		Date date = null;
		String sDate = "";
		
		String [] splitDate = dateToParse.split("/");
		
		if (splitDate.length == 3) {
			String monthPad = "";
			String datePad = "";
			if (splitDate[1].length() == 1) {
				monthPad = "0";
			}
			if (splitDate[0].length() == 1) {
				datePad = "0";
			}
			sDate = "20" + splitDate[2] + "-" + monthPad + splitDate[1] + "-" + datePad + splitDate[0];
			date = Date.valueOf(sDate);
		}
		
		return date;
	}
	
	public void populateMoviesInDb(List <Movie> movies) {
		Connection conn = DbConnection.getConnection();
		PreparedStatement prepStmt = null;
		
		try {
			int rowsInserted = 0;
			String query = "insert into movies values (?, ?, ?, ?)";
			prepStmt = conn.prepareStatement(query);
			
			for(Movie movie : movies) {
				prepStmt.setInt(1, movie.getId());
				prepStmt.setString(2, movie.getName());
				prepStmt.setString(3, movie.getLanguage());
				prepStmt.setDate(4, parseDate(movie.getDate()));
				
				rowsInserted += prepStmt.executeUpdate();
			}
			
			System.out.println("Inserted " + rowsInserted + " movies in the database.");
									
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MovieData md = new MovieData();
		String filename = "movies.txt";
		List <Movie> movies = md.readMovieData(filename);
		
		System.out.println("---------------------");
		System.out.println("Printing from retrieved list.");
		System.out.println("---------------------");
		System.out.println(movies);
		System.out.println("---------------------");
		
		System.out.println("Populating movies in database.");
		md.populateMoviesInDb(movies);
		
	}

}
