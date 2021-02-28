package com.jdbcAsst;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	private static void bookShow() {
		// TODO Auto-generated method stub
		
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

	private static void updateShow() {
		// TODO Auto-generated method stub
		
	}

	private static void deleteShow() {
		// TODO Auto-generated method stub
		
	}

	private static void addNewShow() {
		// TODO Auto-generated method stub
		
	}

	private static void addNewMovie() {
		// TODO Auto-generated method stub
		
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
