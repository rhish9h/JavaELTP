package com.collections.movie;

import java.util.Comparator;

public class LangAndReleaseComparator implements Comparator <Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		int langCompare = o1.language.compareTo(o2.language);
		
		if (langCompare > 0) {
			return 1;
		} else if (langCompare < 0) {
			return -1;
		} else {
			return o1.releaseDate.compareTo(o2.releaseDate);
		}
	}

}
