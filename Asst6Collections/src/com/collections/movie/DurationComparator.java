package com.collections.movie;

import java.util.Comparator;

public class DurationComparator implements Comparator <Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		if (o1.duration > o2.duration) {
			return 1;
		} else if (o1.duration < o2.duration) {
			return -1;
		}
		return 0;
	}

}
