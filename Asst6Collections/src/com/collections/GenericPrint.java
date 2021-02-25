package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.collections.movie.Movie;
import com.collections.movie.TestMovie;

public class GenericPrint {

	public <T> void printAnyCollection(Collection<T> ipCollection) {
		System.out.println(ipCollection);
		System.out.println();
	}
	
	public static void main(String[] args) {
		GenericPrint gp = new GenericPrint();
		
		System.out.println("Printing vehicles :");
		System.out.println("**************************");
		List <String> vehicles = new ArrayList<String>(Arrays.asList(new String[] {"Mustang", "Audi", "BMW", "Citroen"}));
		gp.printAnyCollection(vehicles);
		
		
		TestMovie mlist = new TestMovie();
		System.out.println("Printing movies :");
		System.out.println("**************************");
		List <Movie> movieList = mlist.createMovieList();
		gp.printAnyCollection(movieList);

		
		System.out.println("Printing employees :");
		System.out.println("**************************");
		EmployeeSet eSet = new EmployeeSet();
		gp.printAnyCollection(eSet.getEmpTreeSet());
	}

}
