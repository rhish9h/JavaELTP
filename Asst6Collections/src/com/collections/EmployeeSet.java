package com.collections;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class EmployeeSet {

	private TreeSet<Employee> empTreeSet;
	
	public EmployeeSet() {
		empTreeSet = new TreeSet<Employee>();
		populateEmpTreeSet();
	}
	
	@Override
	public String toString() {
		return "EmployeeSet [empTreeSet=" + empTreeSet + "]";
	}

	public void populateEmpTreeSet() {		
		int empId;
		String name;
		String designation;
		ArrayList<String> vehicles;
		Date dateOfJoining;
		Random rand = new Random();
		
		String [] names = {"Bob", "Harry", "Tom", "Ram", "Laxman", "Sita", "Gita", "Parvati", "John"};
		String [] designations = {"Software Engineer", "Test Engineer", "Vice President", "Manager", "Clerk"};
		String [] vehicleStr = {"Mustang", "Audi", "BMW", "Citroen", "Hellcat"};
		
		for (int i = 0; i < 7; i++) {
			// create random employee and add to Tree set
			empId = rand.nextInt(1000);
			name = names[rand.nextInt(names.length)];
			designation = designations[rand.nextInt(designations.length)];
			vehicles = new ArrayList<String>( new ArrayList<String>(Arrays.asList(vehicleStr)).subList(0, rand.nextInt(vehicleStr.length + 1)));
			dateOfJoining = Date.from(ZonedDateTime.now().minusMonths(i*2).toInstant());
			
			Employee temployee = new Employee(empId, name, designation, vehicles, dateOfJoining);
			empTreeSet.add(temployee);
		}
	}
	
	public void printEmpJoinedBefore(Date date) {
		Employee target = new Employee(1, "x", "y", new ArrayList<String>(), date);
		
		printEmpTreeSet(empTreeSet.headSet(target));
	}
	
	public void printEmpTreeSet() {
		for (Employee e : empTreeSet) {
			System.out.println(e);
		}
		System.out.println();
	}
	
	public void printEmpTreeSet(SortedSet<Employee> ipEmpTreeSet) {
		for (Employee e : ipEmpTreeSet) {
			System.out.println(e);
		}
		System.out.println();
	}
	
	public void printEmpJoinedBeforeMonths(int months) {
		Date xMonthsAgo = Date.from(ZonedDateTime.now().minusMonths(6).toInstant());
		printEmpJoinedBefore(xMonthsAgo);
	}
	
	public void printRecentJoinees() {
		Iterator <Employee> itr = empTreeSet.descendingIterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println();
	}
	
	public TreeSet<Employee> getEmpTreeSet() {
		return empTreeSet;
	}
	
	public static void main(String[] args) {
		EmployeeSet eSet = new EmployeeSet();
		
		System.out.println("All Employee Information :");
		System.out.println("**************************");
		eSet.printEmpTreeSet();
		
		Date oneMonthAgo = Date.from(ZonedDateTime.now().minusMonths(1).toInstant());
		System.out.println("All Employees that joined before " + oneMonthAgo + ": ");
		System.out.println("**************************");
		eSet.printEmpJoinedBefore(oneMonthAgo);
		
		System.out.println("All Employees that joined before 6 months : ");
		System.out.println("**************************");
		eSet.printEmpJoinedBeforeMonths(6);
		
		System.out.println("All Employees as per joining date : ");
		System.out.println("**************************");
		eSet.printRecentJoinees();
		
	}

}
