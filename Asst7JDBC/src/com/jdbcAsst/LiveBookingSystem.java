package com.jdbcAsst;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class LiveBookingSystem {

	private static Scanner sc = new Scanner(System.in);
	private static Connection dbConn = DbConnection.getConnection();
	
	public static boolean welcomePage() throws SQLException {
		boolean end = false;
		int input;
		
		System.out.println("********************************");
		System.out.println("Live Movie Booking System");
		System.out.println("********************************");
		System.out.println();
		
		System.out.println("1. Add new movie");
		System.out.println("2. Add new show");
		System.out.println("3. Delete show");
		System.out.println("4. Update show");
		System.out.println("5. Show all movies");
		System.out.println("6. Show all bookings");
		System.out.println("7. Display movies by language");
		System.out.println("8. Display movies by shows for today");
		System.out.println("9. Book a movie show");
		System.out.println("10. Exit");
		
		System.out.println("\nInput choice >");
		if (sc.hasNextInt()) {
			input = sc.nextInt();
			
			switch (input) {
				case 1:
					addNewMovie();
					break;
				case 2:
					addNewShow();
					break;
				case 3:
					deleteShow();
					break;
				case 4:
					updateShow();
					break;
				case 5:
					showAllMovies();
					break;
				case 6:
					showAllBookings();
					break;
				case 7:
					dispMoviesBylang();
					break;
				case 8:
					dispMoviesByShowsToday();
					break;
				case 9:
					bookShow();
					break;
				case 10:
					end = true;
					break;
				default:
					System.out.println("Invalid Choice.");
			}
		}
		
		return end;
	}
	
	private static void pressKeyToContinue() {
		System.out.println("\nPress Enter key to continue.");
		sc.nextLine();
		sc.nextLine();
	}
	
	private static void bookShow() throws SQLException {
		showAllBookings();
		
		System.out.println("Enter show id to make bookings : ");
		int showId = sc.nextInt();
		
		String seatSql = "select totalseats, availableseats from shows where id = ?";
		PreparedStatement prep = dbConn.prepareStatement(seatSql);
		prep.setInt(1, showId);
		ResultSet rs = prep.executeQuery();
		
		rs.next();
		int totalSeats = rs.getInt(1);
		int availableSeats = rs.getInt(2);
		
		if (availableSeats == 0) {
			System.out.println("No seats available.");
		} else {
			System.out.println("For id - " + showId + " total seats = " + totalSeats + " availableSeats = " + availableSeats);
			
			System.out.println("Enter number of seats to book : ");
			int toBook = sc.nextInt();
			
			String sql = "update shows set availableseats = ? where id = ?";
			prep = dbConn.prepareStatement(sql);
			prep.setInt(1, availableSeats - toBook);
			prep.setInt(2, showId);
			
			int result = prep.executeUpdate();
			
			System.out.println("Show booking status : " + result);
		}
		
		pressKeyToContinue();
	}

	private static void dispMoviesByShowsToday() throws SQLException {
		Statement stmt = dbConn.createStatement();
		String sql = "select s.id, s.movie_id, m.name, s.time, s.totalseats, s.availableseats\r\n" + 
				"from shows s inner join movies m\r\n" + 
				"on s.movie_id = m.id\r\n" + 
				"where s.time = to_char(sysdate, 'dd-mon-yy')\r\n" + 
				"order by time desc";
		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println("Today's Shows : \n");

		while (rs.next()) {
			System.out.print(" id = " + rs.getInt(1));
			System.out.print(" movie id = " + rs.getInt(2));
			System.out.print(" movie name = " + rs.getString(3));
			System.out.print(" time = " + rs.getDate(4));
			System.out.print(" total seats = " + rs.getInt(5));
			System.out.print(" available seats = " + rs.getInt(6));
			System.out.println();
		}
		
		pressKeyToContinue();
		
	}

	private static void dispMoviesBylang() throws SQLException {
		Statement stmt = dbConn.createStatement();
		String languageQuery = "select distinct language from movies";
		ResultSet languages = stmt.executeQuery(languageQuery);

		System.out.println("Available movie languages : \n");
		
		while (languages.next()) {
			System.out.println(languages.getString(1));
		}
		
		sc.nextLine();
		System.out.println("\nEnter required movie language : \n");
		String lang = sc.nextLine();
		
		String movieQuery = "select * from movies where language = ?";
		PreparedStatement prep = dbConn.prepareStatement(movieQuery);
		prep.setString(1, lang);
		ResultSet movies = prep.executeQuery();
		
		while (movies.next()) {
			System.out.print(" id = " + movies.getInt(1));
			System.out.print(" name = " + movies.getString(2));
			System.out.print(" language = " + movies.getString(3));
			System.out.print(" release date = " + movies.getDate(4));
			System.out.println();
		}
		
		pressKeyToContinue();
	}

	private static void showAllBookings() throws SQLException {
		Statement stmt = dbConn.createStatement();
		String sql = "select s.id, s.movie_id, m.name, s.time, s.totalseats, s.availableseats " + 
				"from shows s inner join movies m " + 
				"on s.movie_id = m.id " + 
				"order by time desc";
		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println("Showing all shows with bookings : \n");

		while (rs.next()) {
			System.out.print(" id = " + rs.getInt(1));
			System.out.print(" movie id = " + rs.getInt(2));
			System.out.print(" movie name = " + rs.getString(3));
			System.out.print(" time = " + rs.getDate(4));
			System.out.print(" total seats = " + rs.getInt(5));
			System.out.print(" available seats = " + rs.getInt(6));
			System.out.println();
		}
		
		pressKeyToContinue();
		
	}

	private static void showAllMovies() throws SQLException {
		Statement stmt = dbConn.createStatement();
		String sql = "select * from movies";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("Showing all movies : \n");
		
		while (rs.next()) {
			System.out.print(" id = " + rs.getInt(1));
			System.out.print(" name = " + rs.getString(2));
			System.out.print(" language = " + rs.getString(3));
			System.out.print(" release date = " + rs.getDate(4));
			System.out.println();
		}
		
		pressKeyToContinue();
	}

	private static void updateShow() throws SQLException {
		showAllBookings();
		
		System.out.println("Enter show id to update :");
		int showId = sc.nextInt();
		
		String sql = "select * from shows where id = ?";
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setInt(1, showId);
		ResultSet rs = prep.executeQuery();
		System.out.println("Show " + showId + " : \n");
		
		int id=0, movieId=0, totalSeats=0, availableSeats=0;
		Date time = null;

		while (rs.next()) {
			id = rs.getInt(1);
			System.out.print(" id = " + id);
			
			movieId = rs.getInt(2);
			System.out.print(" movie id = " + movieId);
			
			time = rs.getDate(3);
			System.out.print(" time = " + time);
			
			totalSeats = rs.getInt(4);
			System.out.print(" total seats = " + totalSeats);
			
			availableSeats = rs.getInt(5);
			System.out.print(" available seats = " + availableSeats);
			
			System.out.println();
		}
		
		int option = -1;
		
		while (option != 0) {
			System.out.println("\nEnter number to change following : ");
			System.out.println("1. movie id");
			System.out.println("2. time");
			System.out.println("3. total seats");
			System.out.println("4. available seats");
			System.out.println("5. Cancel.");
			System.out.println("0. Done.");
			option = sc.nextInt();
			
			switch (option) {
				case 1:
					System.out.println("Enter movie id : ");
					movieId = sc.nextInt();
					break;
				case 2:
					System.out.println("Enter time in yyyy-mm-dd format eg. 2015-03-31 :");
					sc.nextLine();
					time = Date.valueOf(sc.nextLine());
					break;
				case 3:
					System.out.println("Enter total seats : ");
					totalSeats = sc.nextInt();
					break;
				case 4:
					System.out.println("Enter available seats : ");
					availableSeats = sc.nextInt();
					break;
				case 5:
					System.out.println("Cancelling update.");
					pressKeyToContinue();
					return;
				case 0:
					break;	
				default:
					System.out.println("Invalid option.");
					break;
			}
		}
		
		sql = "update shows set movie_id = ?, time = ?, totalseats = ?, availableseats = ? " +
				"where id = ?";
		prep = dbConn.prepareStatement(sql);
		prep.setInt(1, movieId);
		prep.setDate(2, time);
		prep.setInt(3, totalSeats);
		prep.setInt(4, availableSeats);
		prep.setInt(5, showId);
		
		int res = prep.executeUpdate();
		System.out.println("Rows updated : " + res);
		
		pressKeyToContinue();
	}

	private static void deleteShow() throws SQLException {
		showAllBookings();
		
		System.out.println("Enter show id to delete the show : ");
		int showId = sc.nextInt();
		
		String sql = "delete from shows where id = ?";
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setInt(1, showId);
		
		int result = prep.executeUpdate();
		System.out.println(result + " row deleted.");
		
		pressKeyToContinue();
	}

	private static void addNewShow() throws SQLException {
		showAllMovies();
		
		System.out.println("Enter movie id to book show : ");
		int movieId = sc.nextInt();
		
		System.out.println("Enter time of show in yyyy-mm-dd format eg. 2015-03-31: ");
		sc.nextLine();
		Date showTime = Date.valueOf(sc.nextLine());
		
		System.out.println("Enter total number of seats : ");
		int totalSeats = sc.nextInt();
		
		Random random = new Random();
		String sql = "insert into shows values (?, ?, ?, ?, ?)";
		PreparedStatement prep = dbConn.prepareStatement(sql);
		
		prep.setInt(1, random.nextInt(10000));
		prep.setInt(2, movieId);
		prep.setDate(3, showTime);
		prep.setInt(4, totalSeats);
		prep.setInt(5,  totalSeats);
		
		int result = prep.executeUpdate();
		System.out.println("Inserted " + result + " row/s succesfully.");
		
		pressKeyToContinue();
	}

	private static void addNewMovie() throws SQLException {
		Random random = new Random();
		int id = random.nextInt(10000);
		String name, language;
		Date releaseDate = null;
		
		String sql = "insert into movies values(?, ?, ?, ?)";
		PreparedStatement prep = dbConn.prepareStatement(sql);
		
		System.out.println("Enter name of the movie : ");
		sc.nextLine();
		name = sc.nextLine();
		System.out.println("Enter language of the movie : ");
		language = sc.nextLine();
		System.out.println("Enter release date in yyyy-mm-dd format eg. 2015-03-31 : ");
		releaseDate = Date.valueOf(sc.nextLine());
		
		prep.setInt(1, id);
		prep.setString(2, name);
		prep.setString(3, language);
		prep.setDate(4, releaseDate);
		
		int result = prep.executeUpdate();
		System.out.println("Rows added : " + result);
		
		pressKeyToContinue();
	}

	public static void main(String[] args) {
		
		boolean end = false;
		
		while (!end) {
			try {
				end |= welcomePage();
			} catch (SQLException e) {
				e.printStackTrace();
				pressKeyToContinue();
				continue;
			}
		}

		System.out.println("\nExiting system.");
		System.out.println("Thank you for using the Live Booking System.");
	}

}
