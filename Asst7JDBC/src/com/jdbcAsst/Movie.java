package com.jdbcAsst;

public class Movie {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

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
