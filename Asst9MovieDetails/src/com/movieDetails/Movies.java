package com.movieDetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.movieDetails.MovieEnums.Category;
import com.movieDetails.MovieEnums.Language;
import com.movieDetails.exceptions.IncorrectValueCountException;
import com.movieDetails.exceptions.InvalidLanguageException;
import com.movieDetails.exceptions.InvalidMovieIdException;

public class Movies {
	
	List<Movie> populateMovies(File file) {
		List <Movie> movieList = new ArrayList<>();
		
		try (FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)) {
			
			String line = "";
			Integer movieId;
			String movieName;
			Category movieType;
			Language language;
			Date releaseDate;
			List<String> casting;
			Double rating;
			Double totalBusinessDone;
			
			while ((line = br.readLine()) != null) {
				if (lineFromFileIsValid(line)) {
					String[] tokens = line.split(",");
					
					movieId = Integer.parseInt(tokens[0]);
					movieName = tokens[1];
					movieType = parseMovieType(tokens[2]);
					language = parseLanguage(tokens[3]);
					releaseDate = parseDate(tokens[4]);
					casting = parseCasting(tokens[5]);
					rating = Double.parseDouble(tokens[6]);
					totalBusinessDone = Double.parseDouble(tokens[7]);
					
					Movie curMovie = new Movie(movieId, movieName, movieType, language, releaseDate, casting, rating, totalBusinessDone);
					movieList.add(curMovie);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return movieList;
	}
	
	private List<String> parseCasting(String casting) {
		List <String> castList = new ArrayList<> ();
		String[] castingTokens = casting.split(";");
		
		for (String token : castingTokens) {
			castList.add(token);
		}
		
		return castList;
	}
	
	private Date parseDate(String strDate) {
		int dateIdx = 0, monthIdx = 1, yearIdx = 2;
		String formattedDate = "";
		Date parsedDate = null;
		
		String[] tokenDate = strDate.split("/");
		String date = tokenDate[dateIdx];
		String month = tokenDate[monthIdx];
		String year = tokenDate[yearIdx];
		
		date = date.length() == 1 ? "0" + date : date;
		month = month.length() == 1 ? "0" + month : month;
		
		formattedDate += "20" + year + "-" + month + "-" + date;
		parsedDate = Date.valueOf(formattedDate);
		
		return parsedDate;
	}
	
	private Language parseLanguage(String language) {
		Language languageToReturn = null;
		
		for (Language lang : Language.values()) {
			if (lang.getLanguage().equals(language)) {
				languageToReturn = lang;
			}
		}
		
		return languageToReturn;
	}
	
	private Category parseMovieType(String movieType) {
		String movieTypeToCmp = movieType.toUpperCase();
		Category catMovieType = null;
		
		for (Category cat : Category.values()) {
			if (cat.name().equals(movieTypeToCmp)) {
				catMovieType = cat;
				break;
			}
		}
		
		return catMovieType;
	}
	
	private boolean lineFromFileIsValid(String line) {
		boolean isValid = true;
		
		try {
			System.out.println(line);
			
			String[] tokens = line.split(",");
			
			if (tokens.length != 8) {
				throw new IncorrectValueCountException(tokens.length);
			}	
			
			try {
				Integer.parseInt(tokens[0]);
			} catch (NumberFormatException e) {
				throw new InvalidMovieIdException(tokens[0]);
			}
			
			if (! inLanguagesEnum(tokens[3])) {
				throw new InvalidLanguageException(tokens[3]);
			}
			
		} catch (IncorrectValueCountException | InvalidLanguageException | InvalidMovieIdException e) {
			isValid = false;
			System.out.println("^^^");
			e.printStackTrace();
		}
		
		return isValid;
	}
	
	private boolean inLanguagesEnum(String language) {
		boolean present = false;
		
		for (Language l : Language.values()) {
			if (l.getLanguage().equals(language)) {
				present = true;
				break;
			}
		}
		
		return present;
	}
	
	public void printMovieList(List <Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Movies myMoviesObj = new Movies();
		File file = new File("movies.txt");
		List <Movie> myMovies = myMoviesObj.populateMovies(file);
		
		System.out.println("\nPopulated movies list from file - " + file.getName() + "\n");
		myMoviesObj.printMovieList(myMovies);
		
	}
	
}
