package com.ioAsst;

public class Movie {
	int id;
	String name, language, date;
	
	Movie(int id, String name, String language, String date) {
		this.id = id;
		this.name = name;
		this.language = language;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "[" + " id = " + id + " name = " + name + " language = " + language + " date = " + date + "]";
	}
}
