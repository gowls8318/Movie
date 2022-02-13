package com.movie.model.dto;

import java.sql.Date;

public class MovieDTO {
	
	private int movieCode;
	private String title;
	private String genre;
	private int genreNo;
	private String nation;
	private String director;
	private int runningTime;
	private Date releaseDate;
	private String leadActor;
	private String synopsis;
	private int avgRating; 
	
	public MovieDTO(){}

	public MovieDTO(int movieCode, String title, String genre, int genreNo, String nation, String director,
			int runningTime, Date releaseDate, String leadActor, String synopsis, int avgRating) {
		super();
		this.movieCode = movieCode;
		this.title = title;
		this.genre = genre;
		this.genreNo = genreNo;
		this.nation = nation;
		this.director = director;
		this.runningTime = runningTime;
		this.releaseDate = releaseDate;
		this.leadActor = leadActor;
		this.synopsis = synopsis;
		this.avgRating = avgRating;
	}

	public int getMovieCode() {
		return movieCode;
	}

	public void setMovieCode(int movieCode) {
		this.movieCode = movieCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getGenreNo() {
		return genreNo;
	}

	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public int getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}


	



	

}
