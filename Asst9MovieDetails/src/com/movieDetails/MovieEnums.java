package com.movieDetails;

public class MovieEnums {
	enum Category {
		THRILLER, ACTION, ROMANCE, COMEDY, HORROR, DRAMA;
	}

	enum Language {
		ENGLISH("English"), 
		HINDI("Hindi"), 
		MARATHI("Marathi");
		
		private String language;
		
		Language(String language) {
			this.language = language;
		}
		
		public String getLanguage() {
			return this.language;
		}
	}
}
