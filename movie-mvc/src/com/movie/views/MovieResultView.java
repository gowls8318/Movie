package com.movie.views;

import java.util.List;

import com.movie.model.dto.MovieDTO;
import com.movie.model.dto.ReviewDTO;


public class MovieResultView {

    public void display(List<MovieDTO> movieList) {
        System.out.println("*************************");
        System.out.println("*        영화 리스트       *");
        System.out.println("*************************");
        int i = 1;
        for(MovieDTO m : movieList) {

            System.out.println( i++ + ". 영화 제목 : " + m.getTitle() + ", 영화 장르 :" + m.getGenre());

        }
    }
    public void displayReview(List<ReviewDTO> reviewList) {
        System.out.println("*************************");
        System.out.println("*          리뷰          *");
        System.out.println("*************************");
        int i = 1;
        for(ReviewDTO r : reviewList) {

        	System.out.println(i++ + ". 영화 제목 : " + r.getMovieTitle() + ", 평점 : " + r.getRating() + ", 한줄 평 : " + r.getReview());

        }
        System.out.println();
        System.out.println();
        System.out.println();
        
    }
    
    public void displayRecommend(List<MovieDTO> movieList) {
        System.out.println("*************************");
        System.out.println("*      장르별 추천 영화      *");
        System.out.println("*************************");

        for(MovieDTO m : movieList) {

            System.out.println("영화 제목 : " + m.getTitle() + ", 영화 장르 :" + m.getGenre()+ ", 평점 :" + m.getAvgRating());

        }
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
    }
	public void displayDmlResult(String code) {
		
		switch(code) {
			case "insertFailed" : System.out.println("영화 등록 실패!"); break;
			case "serchFailed" : System.out.println("영화 조회 실패!"); break;
			case "insertSuccess" : System.out.println("영화 등록 성공!"); break;
			default : System.out.println("알 수 없는 에러 발생!"); break;
		}		
        System.out.println();
        System.out.println();
        System.out.println();
 
	}
	
	public void display(MovieDTO m) {
		
		System.out.println("*************");
		System.out.println("*   영화 정보  *");
		System.out.println("*************");
		System.out.println("영화 제목 : " + m.getTitle());
		System.out.println("영화 장르 : " + m.getGenre());
		System.out.println("영화 제작 국가 : " + m.getNation());
		System.out.println("영화 감독 : " + m.getDirector());
		System.out.println("영화 러닝 타임 : " + m.getRunningTime());
		System.out.println("영화 개봉일 : " + m.getReleaseDate());
		System.out.println("영화 주연 : " + m.getLeadActor());
		System.out.println("영화 줄거리");
		System.out.println(m.getSynopsis());
        System.out.println();
        System.out.println();
        System.out.println();

        
	}
    public void displayRenre(List<MovieDTO> movieList) {
        System.out.println("*************************");
        System.out.println("*       장르별 검색        *");
        System.out.println("*************************");

        for(MovieDTO m : movieList) {

            System.out.println("영화 제목 : " + m.getTitle() + ", 영화 장르 :" + m.getGenre());

        }
    }
	

}





















