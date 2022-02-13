package com.movie.model.service;

import static com.movie.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.movie.model.dao.MovieDAO;
import com.movie.model.dto.MovieDTO;
import com.movie.model.dto.ReviewDTO;

public class MovieService {
	
	private MovieDAO movieDAO = new MovieDAO();
	
	
// 영화 전체 검색
	public List<MovieDTO> selectAllMovie() {
	
		Connection con = getConnection();
		List<MovieDTO> movieList = movieDAO.selectAllMovie(con);
		
		movieDAO.selectGenre(con, movieList);
		
		close(con);
		
		return movieList;
	}	
	
	
// 영화 등록 메소드	
	public int insertMovie(MovieDTO movie) {
		
		Connection con = getConnection();
		
		int genreNo = movieDAO.selectGenre(con, movie);

		int resultMovie = movieDAO.insertMovieTable(con, movie);
		
		int movieCode = movieDAO.selectMovieCode(con, movie);
		
		int resultMovieDetail = movieDAO.insertMovie(con, movie);
		
		if(genreNo > 0 && resultMovie > 0 && movieCode > 0 && resultMovieDetail > 0) {
			commit(con);
		}else {
			rollback(con);
		}
			
		close(con);
		
		return resultMovie;
	}
	
//	이름으로 검색용 메소드
	public MovieDTO searchTitle(String title) {
		Connection con = getConnection();
		
		MovieDTO movie = movieDAO.searchTitle(con, title);
		
		close(con);
		
		return movie;
	}
	
//	장르로 검색용 메소드
	public List<MovieDTO> searchGenre(String genre) {
		Connection con = getConnection();
		
		List<MovieDTO> movieList = movieDAO.searchGenre(con, genre);
		
		close(con);
		
		return movieList;
	}

/* 리뷰검색 - service */
    public List<ReviewDTO> searchReview(String inputMovie) {

        Connection con = getConnection();

        List<ReviewDTO> reviewList= movieDAO.searchReview(con, inputMovie);

        close(con);

        return reviewList;
    }

// 리뷰 등록
	public int registReview(ReviewDTO review) {
        Connection con = getConnection();
        
        int movieCode = movieDAO.selectMovieCode(con, review);

        int result = movieDAO.registReview(con, review);
        
        if(result > 0 && movieCode > 0) {
            commit(con);
            result = 1;
        } else {
            rollback(con);
        }
        close(con);

        return result;
    }

    public List<ReviewDTO> searchRating(int rating) {

        Connection con = getConnection();


        List<ReviewDTO> reviewList = movieDAO.searchRating(con, rating);

        close(con);

        return reviewList;
    }	
	
// 추천 영화
	public List<MovieDTO> recommendMovie() {
		
		Connection con = getConnection();	
		
		List<MovieDTO> recommendList = movieDAO.recommendMovie(con);
		
		close(con);
		
		return recommendList;
	}


	
	
	
}
