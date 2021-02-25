package com.asst3.book;

import java.util.Scanner;

public class BookManager {

	int size;
	Book [] books;
	Scanner sc = new Scanner(System.in);
	
	BookManager() {
		size = 0;
		books = new Book[0];
	}
	
	BookManager(int size) {
		this.size = size;
		this.books = new Book[size];
		this.createBooks();
	}
	
	private void createBooks() {
		
		String book_title = "", book_author = "", book_publication = "";
		double book_price = 0;
		
		for (int i = 0; i < size; i++) {
			System.out.println("Enter details for book - " + i + " : ");
			
			System.out.println("Book title - ");
			book_title = sc.nextLine();
			
			System.out.println("Book price - ");
			book_price = sc.nextDouble();
			sc.nextLine();
			
			System.out.println("Book author - ");
			book_author = sc.nextLine();
			
			System.out.println("Book publication - ");
			book_publication = sc.nextLine();
			
			books[i] = new Book(book_title, book_price, book_author, book_publication);
		}
	}
	
	public void showBooks() {
		System.out.printf("%20s %20s %20s %20s \n", "Book title", "Book price", "Book author", "Book publication");
		
		for (Book book : books) {
			System.out.format("%20s %20f %20s %20s", book.book_title, book.book_price, book.book_author, book.book_publication);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of books to add - ");
		int numOfBooks = sc.nextInt();
		
		BookManager bMan = new BookManager(numOfBooks);
		bMan.showBooks();
		sc.close();
	}

}
