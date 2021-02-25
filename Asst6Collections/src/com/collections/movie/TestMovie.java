package com.collections.movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TestMovie {

	public List<Movie> createMovieList() {
		String [] names = {"Bob", "Harry", "Tom", "Ram", "Laxman", "Sita", "Gita", "Parvati", "John"};
		String [] languages = {"Hindi", "Marathi", "English", "Latin", "French", "German", "Spanish"};
		
		List <Movie> movies = new ArrayList <Movie> ();
		int nameidx, langidx, diridx, prodidx, duration;
		Date release;
		Random rand = new Random();
		int namelen = names.length;
		int langlen = languages.length;
		
		for (int i = 0; i < 5; i++) {
			nameidx = rand.nextInt(namelen);
			langidx = rand.nextInt(langlen);
			diridx = rand.nextInt(namelen);
			prodidx = rand.nextInt(namelen);
			release = new Date();
			duration = rand.nextInt(100);
			movies.add(new Movie(names[nameidx], languages[langidx], names[diridx], names[prodidx], release, duration));
		}
		
		return movies;
	}
	
	public void printMovieList(List <Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
		System.out.println();
	}
	
	public void sortByLanguage(List<Movie> movieList) {
		Collections.sort(movieList);
		System.out.println("****Sorted by Language****");
		printMovieList(movieList);
	}
	
	public void sortByDirector(List<Movie> movieList) {
		Collections.sort(movieList, new DirectorComparator());
		System.out.println("****Sorted by Director****");
		printMovieList(movieList);
	}
	
	public void sortByDuration(List <Movie> movieList) {
		Collections.sort(movieList, new DurationComparator());
		System.out.println("****Sorted by Duration****");
		printMovieList(movieList);
	}
	
	public void sortByLanguageAndReleaseDate(List <Movie> movieList) {
		Collections.sort(movieList, new LangAndReleaseComparator());
		System.out.println("****Sorted by Language and Release Date****");
		printMovieList(movieList);
	}
	
	public static void main(String[] args) {
		TestMovie mlist = new TestMovie();
		List <Movie> movieList = mlist.createMovieList();
		
		System.out.println("****Normal List****");
		mlist.printMovieList(movieList);
		
		Collections.sort(movieList);
		System.out.println("****Default Sorted List****");
		mlist.printMovieList(movieList);
		
		mlist.sortByLanguage(movieList);
		
		mlist.sortByDirector(movieList);
		
		mlist.sortByDuration(movieList);
		
		mlist.sortByLanguageAndReleaseDate(movieList);
	}

}
