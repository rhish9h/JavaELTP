package com.asst8.account;

public class Account {
	int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
	
	public synchronized void withdraw(int amount) throws InterruptedException {
		if (amount > balance) {
			System.out.println("Insufficient balance - needs " + (amount - balance) + " more");
			wait();
		} 
		
		balance -= amount;
		System.out.println("Withdrew " + amount + " - Remaining balance - " + balance);
	}
	
	public synchronized void deposit(int amount) {
		balance += amount;
		
		System.out.println("Deposited " + amount + " - Remaining balance - " + balance);
		notify();
	}
	
	public static void main(String [] args) {
		
		Account myAcc = new Account(100);
		
		Thread withdrawThread = new Thread() {
			public void run() {
				try {
					myAcc.withdraw(120);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		withdrawThread.start();
		
		Thread depositThread = new Thread () {
			public void run() {
				myAcc.deposit(25);
			}
		};
		
		depositThread.start();
	}
}
