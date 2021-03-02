package com.movieDetails;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.movieDetails.MovieEnums.Category;
import com.movieDetails.MovieEnums.Language;

public class Movie implements Serializable {
	
	private static final long serialVersionUID = 6625316129290657856L;
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

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Category getMovieType() {
		return movieType;
	}

	public void setMovieType(Category movieType) {
		this.movieType = movieType;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<String> getCasting() {
		return casting;
	}

	public void setCasting(List<String> casting) {
		this.casting = casting;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getTotalBusinessDone() {
		return totalBusinessDone;
	}

	public void setTotalBusinessDone(Double totalBusinessDone) {
		this.totalBusinessDone = totalBusinessDone;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieType=" + movieType + ", language="
				+ language + ", releaseDate=" + releaseDate + ", casting=" + casting + ", rating=" + rating
				+ ", totalBusinessDone=" + totalBusinessDone + "]";
	}
	
}
