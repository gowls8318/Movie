package com.movie.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.movie.model.dto.MovieDTO;
import com.movie.model.dto.ReviewDTO;

import static com.movie.common.JDBCTemplate.*;

public class MovieDAO {
	
	private Properties prop = new Properties();	
	
	public MovieDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/movie-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 영화 전체 검색
	public List<MovieDTO> selectAllMovie(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<MovieDTO> movieList = null;
		
		String query = prop.getProperty("selectAllMovie");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			movieList = new ArrayList<MovieDTO>();
			
			while(rset.next()) {
				MovieDTO movieDTO = new MovieDTO();
				movieDTO.setMovieCode(rset.getInt("MOVIE_CODE"));
				movieDTO.setTitle(rset.getString("TITLE"));
				movieDTO.setGenreNo(rset.getInt("GENRE_NO"));
				
				movieList.add(movieDTO);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		
		return movieList;
	}
	
	
	public int selectGenreNo(Connection con, MovieDTO movie) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int genreNo = 0;
		
		String query = prop.getProperty("selectGenreNo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, movie.getGenre());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				genreNo = rset.getInt("GENRE_NO");
				
				movie.setGenreNo(genreNo);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return genreNo;
	}

	public void selectGenre(Connection con, List<MovieDTO> movieList) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		
		
		String query = prop.getProperty("selectGenre");
		for (MovieDTO movie : movieList) {
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, movie.getGenreNo());
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					movie.setGenre(rset.getString("GENRE"));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rset);
			}
		}
		

	}	
		
	
//	영화 등록 메소드
	public int insertMovieTable(Connection con, MovieDTO movie) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMovieTable");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, movie.getTitle());
			pstmt.setInt(2, movie.getGenreNo());
			
			result = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		

		
		return result;
	}

	public int selectGenre(Connection con, MovieDTO movie) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int genreNo = 0;
		
		String query = prop.getProperty("selectGenreNo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, movie.getGenre());
			rset = pstmt.executeQuery();

			if(rset.next()) {

				genreNo = rset.getInt("GENRE_NO");
				movie.setGenreNo(genreNo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


		
		return genreNo;
	}

	public int insertMovie(Connection con, MovieDTO movie) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMovie");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, movie.getMovieCode());
			pstmt.setString(2, movie.getNation());
			pstmt.setString(3, movie.getDirector());
			pstmt.setInt(4, movie.getRunningTime());
			pstmt.setDate(5, movie.getReleaseDate());
			pstmt.setString(6, movie.getLeadActor());
			pstmt.setString(7, movie.getSynopsis());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	public int selectMovieCode(Connection con, MovieDTO movie) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int movieCode = 0;
		
		String query = prop.getProperty("selectMovieCode");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, movie.getTitle());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				movieCode = rset.getInt("MOVIE_CODE");
				movie.setMovieCode(movieCode);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return movieCode;
	}

	
// 영화 이름으로 검색용 메소드
	public MovieDTO searchTitle(Connection con, String title) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		MovieDTO movie = null;
		
		String query = prop.getProperty("searchTitle");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			
			rset = pstmt.executeQuery();
						
			if(rset.next()) {
				movie = new MovieDTO();
				
				movie.setMovieCode(rset.getInt("MOVIE_CODE"));
				movie.setTitle(rset.getString("TITLE"));
				movie.setGenre(rset.getString("GENRE"));
				movie.setNation(rset.getString("NATION"));
				movie.setDirector(rset.getString("DIRECTOR"));
				movie.setRunningTime(rset.getInt("RUNNING_TIME"));
				movie.setReleaseDate(rset.getDate("RELEASE_DATE"));
				movie.setLeadActor(rset.getString("LEAD_ACTOR"));
				movie.setSynopsis(rset.getString("SYNOPSIS"));
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return movie;		
	}

// 영화 장르로 검색용 메소드
	public List<MovieDTO> searchGenre(Connection con, String genre) {
			
		PreparedStatement pstmt = null;
		ResultSet rset = null;
			
		List<MovieDTO> movieList = null;
			
		String query = prop.getProperty("searchGenre");		
			
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, genre);
			
			rset = pstmt.executeQuery();
				
			movieList = new ArrayList<>();
				
			while(rset.next()) {
				MovieDTO movie = new MovieDTO();
				movie.setMovieCode(rset.getInt("MOVIE_CODE"));
				movie.setTitle(rset.getString("TITLE"));
				movie.setGenre(rset.getString("GENRE"));
				movie.setSynopsis(rset.getString("SYNOPSIS"));
					
				movieList.add(movie);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return movieList;		
	}

//	리뷰 검색
	public List<ReviewDTO> searchReview(Connection con, String inputMovie) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        List<ReviewDTO> reviewList = null;

        String query = prop.getProperty("searchReview");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,inputMovie);

            rset = pstmt.executeQuery();

            reviewList = new ArrayList<>();

            while(rset.next()) {
                ReviewDTO review = new ReviewDTO();
                review.setReviewCode(rset.getInt("REVIEW_CODE"));
                review.setMovieTitle(rset.getString("TITLE"));
                review.setRating(rset.getInt("RATING"));
                review.setReview(rset.getString("REVIEW"));

                reviewList.add(review);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return reviewList;
    }
	
	
//영화 리뷰 등록
	public int registReview(Connection con, ReviewDTO review) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("uploadReview");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, review.getMovieCode());
            pstmt.setString(2, review.getReview());
            pstmt.setInt(3, review.getRating());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);

        }

        return result;
    }

    public List<ReviewDTO> searchRating(Connection con, int rating) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        List<ReviewDTO> reviewList = null;

        String query = prop.getProperty("searchRating");

        MovieDTO movieDTO = new MovieDTO();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, rating);

            rset = pstmt.executeQuery();
            reviewList = new ArrayList<>();

        while(rset.next()) {
            ReviewDTO review = new ReviewDTO();
            review.setMovieCode(rset.getInt("MOVIE_CODE"));
            review.setReviewCode(rset.getInt("REVIEW_CODE"));
            review.setReview(rset.getString("REVIEW"));
            review.setRating(rset.getInt("RATING"));
            review.setMovieTitle(rset.getString("TITLE"));

            reviewList.add(review);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return reviewList;
    }
	
	
	

// 영화 장르별 추천	
	public List<MovieDTO> recommendMovie(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<MovieDTO> recommendList = null;
		
		String query = prop.getProperty("recommendedMovie");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			recommendList = new ArrayList<MovieDTO>();
			
			
			while(rset.next()) {
				
				MovieDTO movie = new MovieDTO();
				movie.setGenre(rset.getString("GENRE"));
			
				movie.setTitle(rset.getString("TITLE"));
				movie.setAvgRating(rset.getInt("MAX(R.RATING)"));
				
				recommendList.add(movie);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return recommendList;
		
	}

	public int selectMovieCode(Connection con, ReviewDTO review) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int movieCode = 0;
		
		String query = prop.getProperty("selectMovieCode");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, review.getMovieTitle());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				movieCode = rset.getInt("MOVIE_CODE");
				review.setMovieCode(movieCode);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return movieCode;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
