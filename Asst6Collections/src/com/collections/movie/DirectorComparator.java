package com.collections.movie;

import java.util.Comparator;

public class DirectorComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.director.compareTo(o2.director);
	}
	
}
