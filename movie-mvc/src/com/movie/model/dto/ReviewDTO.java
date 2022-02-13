package com.movie.model.dto;

public class ReviewDTO {
	
	private int movieCode;
	private int reviewCode;
	private String movieTitle;
	private String review;
	private int rating;
	
	public ReviewDTO() {}

	public ReviewDTO(int movieCode, int reviewCode, String movieTitle, String review, int rating) {
		super();
		this.movieCode = movieCode;
		this.reviewCode = reviewCode;
		this.movieTitle = movieTitle;
		this.review = review;
		this.rating = rating;
	}

	public int getMovieCode() {
		return movieCode;
	}

	public void setMovieCode(int movieCode) {
		this.movieCode = movieCode;
	}

	public int getReviewCode() {
		return reviewCode;
	}

	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}




	

}
