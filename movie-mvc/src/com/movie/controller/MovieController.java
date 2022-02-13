package com.movie.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.movie.model.dto.MovieDTO;
import com.movie.model.dto.ReviewDTO;
import com.movie.model.service.MovieService;
import com.movie.views.MovieResultView;

public class MovieController {
	
	private MovieService movieService = new MovieService();
	private MovieResultView movieResultView = new MovieResultView();

	
// 전체 영화 검색
	public void searchAllMovie() {

		List<MovieDTO> movieList = movieService.selectAllMovie();
			
		if(!movieList.isEmpty()) {
			movieResultView.display(movieList);			
		} else {
			movieResultView.displayDmlResult("selectFailed");
		}		
	}	

// 영화 등록
	public void registNewMovie(Map<String, String> requestMap) {
		MovieDTO movieDTO = new MovieDTO();
		
		movieDTO.setTitle(requestMap.get("title"));
		movieDTO.setGenre(requestMap.get("genre"));
		movieDTO.setNation(requestMap.get("nation"));
		movieDTO.setDirector(requestMap.get("director"));
		movieDTO.setRunningTime(Integer.valueOf(requestMap.get("runningTime")));
		movieDTO.setLeadActor(requestMap.get("leadActor"));
		movieDTO.setSynopsis(requestMap.get("synopsis"));

		Date releaseTime = Date.valueOf(requestMap.get("releaseDate"));
		movieDTO.setReleaseDate(releaseTime);
		
		int result = movieService.insertMovie(movieDTO);
		
	}

// 영화 제목으로 검색 (DTO로 영화 개별 조회)
	public void searchMovie(String title) {
		MovieDTO movie = movieService.searchTitle(title);
		
		if(movie != null) {
			movieResultView.display(movie);
		} else {
			movieResultView.displayDmlResult("serchFailed");
		}
				
	}
	
// 영화 장르로 검색	(List로 조회)
	public void searchGenre(String genre) {
		List<MovieDTO> movieList = movieService.searchGenre(genre);
		
		if(!movieList.isEmpty()) {
			movieResultView.displayRenre(movieList);
		} else {
			movieResultView.displayDmlResult("serchFailed");
		}
				
	}
	
/* 리뷰로 검색 - (list로 조회) */
    public void searchReview(String inputMovie){

        List<ReviewDTO> reviewList = movieService.searchReview(inputMovie);

        if(!reviewList.isEmpty()) {
//            System.out.println("**");
//            System.out.println(" 영화 리스트 *");
//            System.out.println("**");
//            int i = 1;
//            for(ReviewDTO r : reviewList) {
//                System.out.println(r);
//            }
        	movieResultView.displayReview(reviewList);
        } else {
            movieResultView.displayDmlResult("selectFailed");
        }
    }
	
// 영화 리뷰 등록
	
	public List<ReviewDTO> searchRating(int rating) {
        return movieService.searchRating(rating);
    }

    public void registReview(Map<String,String> map) {

        ReviewDTO reviewDTO = new ReviewDTO();

        reviewDTO.setMovieTitle(map.get("title"));
        reviewDTO.setReview(map.get("review"));
        reviewDTO.setRating(Integer.parseInt(map.get("rating")));

        int result = movieService.registReview(reviewDTO);
    }	
	
// 영화 추천
	public void searchBestMovie() {
		
		List<MovieDTO> recommendList = movieService.recommendMovie();
		
		if(recommendList != null) {
			movieResultView.displayRecommend(recommendList);
		} else {
//			movieResultView.displayCrudResult();
		}
		
	}

	
	public void endOfProgram() {
			
	}	
	
	






}
