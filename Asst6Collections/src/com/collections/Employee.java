package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Employee implements Comparable <Employee> {

	private int empId;
	private String name;
	private String designation;
	private ArrayList<String> vehicles;
	private Date dateOfJoining;
	
	public Employee(int empId, String name, String designation, ArrayList<String> vehicles, Date dateOfJoining) {
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.vehicles = vehicles;
		this.dateOfJoining = dateOfJoining;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + ", vehicles=" + vehicles
				+ ", dateOfJoining=" + dateOfJoining.getDate() + "/" + dateOfJoining.getMonth() + "/" + dateOfJoining.getYear() + "]";
	}
	
	@Override
	public int compareTo(Employee o) {
		return dateOfJoining.compareTo(o.dateOfJoining);
	}
	
	public static void main(String[] args) {
		int empId;
		String name, designation;
		ArrayList<String> vehicles;
		Employee e;
		
		empId = 1; name = "Bob"; designation = "President";
		vehicles = new ArrayList<String>(Arrays.asList(new String[] {"Hellcat", "Pagani", "Lamborghini", "Rolls Royce"}));
		e = new Employee(empId, name, designation, vehicles, new Date());
		System.out.println(e);
		
		empId = 2; name = "Tom"; designation = "Vice President";
		vehicles = new ArrayList<String>(Arrays.asList(new String[] {"Mustang", "Audi", "BMW", "Citroen"}));
		e = new Employee(empId, name, designation, vehicles, new Date());
		System.out.println(e);

	}

}
