package com.movieDetails;

import java.sql.Date;
import java.util.List;

import com.movieDetails.MovieEnums.Category;
import com.movieDetails.MovieEnums.Language;

public class Movie {
	
	private Integer movieId;
	private String movieName;
	private Category movieType;
	private Language language;
	private Date releaseDate;
	private List<String> casting;
	private Double rating;
	private Double totalBusinessDone;
	
	public Movie(Integer movieId, String movieName, Category movieType, Language language, Date releaseDate,
			List<String> casting, Double rating, Double totalBusinessDone) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieType = movieType;
		this.language = language;
		this.releaseDate = releaseDate;
		this.casting = casting;
		this.rating = rating;
		this.totalBusinessDone = totalBusinessDone;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieType=" + movieType + ", language="
				+ language + ", releaseDate=" + releaseDate + ", casting=" + casting + ", rating=" + rating
				+ ", totalBusinessDone=" + totalBusinessDone + "]";
	}
	
}
