package com.movieDetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.movieDetails.MovieEnums.Category;
import com.movieDetails.MovieEnums.Language;
import com.movieDetails.exceptions.IncorrectValueCountException;
import com.movieDetails.exceptions.InvalidLanguageException;
import com.movieDetails.exceptions.InvalidMovieIdException;

import oracle.sql.ARRAY;

public class Movies {
	
	Connection movieDetailsDbConn;
	
	public Movies() {
		movieDetailsDbConn = DbConnection.getConnection();
	}
	
	public List<Movie> populateMovies(File file) {
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
	
	private String deParseCasting(List <String> casting) {
		String castStr = String.join(";", casting);
		return castStr;
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
	
	public void displayHeading(String heading) {
		System.out.println("\n***********************************************************");
		System.out.println(heading);
		System.out.println("***********************************************************\n");
	}
	
	public boolean addAllMoviesInDb(List <Movie> movies) {
		boolean successInAddingMovieInDb = true;
		
		String sql = "insert into movieDetails values (?,?,?,?,?,?,?,?)";
		int rowsInserted = 0;
		
		try {
			PreparedStatement prep = movieDetailsDbConn.prepareStatement(sql);
			
			for (Movie movie : movies) {
				
				try {
					prep.setInt(1, movie.getMovieId());
					prep.setString(2, movie.getMovieName());
					prep.setString(3, movie.getMovieType().name());
					prep.setString(4, movie.getLanguage().name());
					prep.setDate(5, movie.getReleaseDate());
					prep.setString(6, deParseCasting(movie.getCasting()));
					prep.setDouble(7, movie.getRating());
					prep.setDouble(8, movie.getTotalBusinessDone());
					
					rowsInserted += prep.executeUpdate();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}	
			}
			
			if (rowsInserted == 0) {
				throw new SQLException("0 rows inserted.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			successInAddingMovieInDb = false;
		}

		System.out.println("Rows inserted in the database = " + rowsInserted);
		return successInAddingMovieInDb;
	}
	
	public void addMovie(Movie movie, List<Movie> movies) {
		movies.add(movie);
	}
	
	public void addDummyMovie(List<Movie> movies) {
		Integer movieId = 10;
		String movieName = "Sully";
		Category movieType = Category.DRAMA;
		Language language = Language.ENGLISH;
		Date releaseDate = Date.valueOf("2016-09-09");
		List<String> casting = new ArrayList<String>(Arrays.asList(new String[] {"Tom Hanks", "Laura Linney"}));
		Double rating = 3.4;
		Double totalBusinessDone = 240d;
		
		Movie movie = new Movie(movieId, movieName, movieType, language, releaseDate, casting, rating, totalBusinessDone);
		
		System.out.println("Adding movie - " + movie.getMovieName());
		System.out.println(movie);
		addMovie(movie, movies);
	}
	
	public void serializeMovies(List <Movie> movies, String fileName) {
		File file = new File(fileName);
		
		try (FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream out = new ObjectOutputStream(fos)){
			
			out.writeObject(movies);
			
			System.out.println("Serialized movies list");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Movie> deserializeMovies(String fileName) {
		File file = new File(fileName);
		List<Movie> movies = new ArrayList<>();
		
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fis)) {
			
			movies = (ArrayList<Movie>) in.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return movies;
	}
	
	public static void main(String[] args) {
		Movies myMoviesObj = new Movies();
		File file = new File("movies.txt");
		List <Movie> myMovies = myMoviesObj.populateMovies(file);
		
		myMoviesObj.displayHeading("Populate movies list from file - " + file.getName());
		myMoviesObj.printMovieList(myMovies);
		
		myMoviesObj.displayHeading("Store all movies in db");
		System.out.println(myMoviesObj.addAllMoviesInDb(myMovies));
		
		myMoviesObj.displayHeading("Add new movie in the list");
		myMoviesObj.addDummyMovie(myMovies);
		System.out.println();
		myMoviesObj.printMovieList(myMovies);
		
		String serialFileName = "serialFileName";
		myMoviesObj.displayHeading("Serialize movie data to - " + serialFileName);
		myMoviesObj.serializeMovies(myMovies, serialFileName);
		
		myMoviesObj.displayHeading("Deserialize movie data from - " + serialFileName);
		List <Movie> deserialMovies = myMoviesObj.deserializeMovies(serialFileName);
		myMoviesObj.printMovieList(deserialMovies);
	}
	
}
