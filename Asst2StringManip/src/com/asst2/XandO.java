package com.asst2;

import java.util.Scanner;

public class XandO {

	int size;
	static char [][] board;
	static Scanner sc;
	static char curplayer;
	
	XandO() {
		sc = new Scanner(System.in);
		
		System.out.println("Enter size of board - ");
		size = sc.nextInt();
		
		board = new char[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = 'e';
			}
		}
		
		curplayer = 'x';
	}
	
	private static void printBoard() { 
		for (char[] row : board) {
			for (char elem : row) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}
	}
	
	private static boolean boardFilled() {
		boolean filled = true;
		
		for (char[] row : board) {
			for (char elem : row) {
				if (elem == 'e') {
					filled = false;
					break;
				}
			}
		}
		
		return filled;
	}
	
	public void play() {
		char winner = 'e';
		
		while (! boardFilled()) {
			printBoard();
			nextMove();
			winner = checkWinner();
			if (winner != 'e') {
				System.out.println("Winner is - " + winner);
				printBoard();
				break;
			}
		}
		
		if (winner == 'e') {
			System.out.println("There was no winner. Game was a draw.");
		}
	}
	
	private static void nextMove() {
		System.out.println("Enter next move for " + curplayer + " - ");
		System.out.println("X: ");
		int x = sc.nextInt();
		System.out.println("Y: ");
		int y = sc.nextInt();
		
		board[x][y] = curplayer;
		if (curplayer == 'x') {
			curplayer = 'o';
		} else {
			curplayer = 'x';
		}
	}
	
	private static char checkWinner() {
		boolean found = false;
		char winner='e';
		
		// all rows
		for (char[] row : board) {
			char cur = row[0];
			boolean innerfound = true;
			
			for (char elem : row) {
				if (elem != cur) {
					innerfound = false;
					break;
				}
			}
			
			if (innerfound && (cur != 'e')) {
				found = true;
				winner = cur;
				break;
			}
		}
		
		if (!found) {
			// all cols
			for (int j = 0; j < board.length; j++) { 
				char cur = board[0][j];
				boolean innerfound = true;
				
				for (int i = 0; i < board.length; i++) {
					if (board[i][j] != cur) {
						innerfound = false;
						break;
					}
				}
				
				if (innerfound && (cur != 'e')) {
					found = true;
					winner = cur;
					break;
				}
			}
		}
		
		
		// diagonal - top left -> bot right
		if (!found) {
			char cur = board[0][0];
			boolean innerfound = true;
			
			for (int i = 0; i < board.length; i++) {
				if (board[i][i] != cur) {
					innerfound = false;
					break;
				}
			}
			
			if (innerfound && (cur != 'e')) {
				found = true;
				winner = cur;
			}
		}
		
		// diagonal - top right -> bot left
		if (!found) {
			int i = 0, j = board.length - 1;
			char cur = board[i][j];
			boolean innerfound = true;
			
			for (; i < board.length && j >= 0; i++, j--) {
				if (cur != board[i][j]) {
					innerfound = false;
					break;
				}
			}
			
			if (innerfound && (cur != 'e')) {
				found = true;
				winner = cur;
			}
		}
		
		return winner;
	}
	
	public static void main(String[] args) {
		XandO game = new XandO();
		game.play();
		
	}

}
