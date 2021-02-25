package com.collections.movie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Movie implements Comparable<Movie>{

	String name, language, director, producer;
	Date releaseDate;
	int duration;
	
	public Movie(String name, String language, String director, String producer, Date releaseDate, int duration) {
		this.name = name;
		this.language = language;
		this.director = director;
		this.producer = producer;
		this.releaseDate = releaseDate;
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Movie [name=" + name + ", language=" + language + ", director=" + director + ", producer=" + producer
				+ ", releaseDate=" + releaseDate + ", duration=" + duration + "]";
	}

	@Override
	public int compareTo(Movie o) {
		return language.compareTo(o.language);
	}
	
	public static void main(String[] args) {
		Movie test = new Movie("tom", "english", "bob", "harry", new Date(), 10);
		System.out.println(test);

	}

}
