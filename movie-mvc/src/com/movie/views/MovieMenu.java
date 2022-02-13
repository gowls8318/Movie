package com.movie.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.movie.controller.MovieController;

public class MovieMenu {
	
	private Scanner sc = new Scanner(System.in);
	MovieController movieController = new MovieController();

	public void displayMenu() {
		
		
		
		do {
			System.out.println("*****************************");
			System.out.println("*          Na!Chos          *");
			System.out.println("*****************************");
			
			System.out.println("1. 새 영화 등록");
			System.out.println("2. 영화 검색(제목, 장르)");
			System.out.println("3. 영화 리뷰 보기");
			System.out.println("4. 영화 리뷰 등록");
			System.out.println("5. 전체 영화 목록");
			System.out.println("6. 추천 영화");
			System.out.println("7. 프로그램 종료");			
			System.out.print("번호 선택 : ");
			int num = sc.nextInt();
			sc.nextLine();

			
			switch(num) {
			case 1 : movieController.registNewMovie(inputMovie()); break;
			case 2 : inputFindingMovie(); break;
			case 3 : movieController.searchReview(inputMovieTitle()); break;
			case 4 : movieController.registReview(inputReview()); break;
			case 5 : movieController.searchAllMovie(); break;
			case 6 : movieController.searchBestMovie(); break;
			case 7 : movieController.endOfProgram();  return; 
			default : System.out.println("1 ~ 7 사이의 번호를 입력해주세요");
			
			}
			
		}while(true);
		
	}
	



	private Map<String, String> inputMovie() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("**********************");
		System.out.println("*       영화 등록       *");
		System.out.println("**********************");
		System.out.print("영화 제목 : ");
		map.put("title", sc.nextLine());
		System.out.print("영화 장르 : ");
		map.put("genre", sc.nextLine());
		System.out.print("영화 제작 국가 : ");
		map.put("nation", sc.nextLine());
		System.out.print("영화 제작 감독 : ");
		map.put("director", sc.nextLine());
		System.out.print("영화 상영 시간 : ");
		map.put("runningTime", sc.nextLine());
		System.out.print("영화 개봉일 : ");
		map.put("releaseDate", sc.nextLine());
		System.out.print("영화 주연 : ");
		map.put("leadActor", sc.nextLine());
		System.out.print("영화 줄거리 : ");
		map.put("synopsis", sc.nextLine());

		return map;
	}

	private void inputFindingMovie() {
		
		System.out.println("**********************");
		System.out.println("*     검색 카테고리      *");
		System.out.println("**********************");
		System.out.println("1. 영화 제목");
		System.out.println("2. 영화 장르");
		
		System.out.print("번호 선택 : ");
		int searchCatagoryNum = sc.nextInt();
		
		sc.nextLine(); // 입력 버퍼 삭제
		
		switch(searchCatagoryNum) {
		case 1 : 
			System.out.print("영화 제목을 입력해주세요 : ");
			String title = sc.nextLine();
			movieController.searchMovie(title); 
			break;
		case 2 : 
			System.out.print("영화 장르을 입력해주세요 : ");
			String genre = sc.nextLine();
			movieController.searchGenre(genre); 
			break;


		default : System.out.println("1 ~ 2 사이의 번호를 입력해주세요");
		}
		

	}
	
	private String inputMovieTitle() {
		System.out.println("**********************");
		System.out.println("*     영화 리뷰 보기     *");
		System.out.println("**********************");
		System.out.print("영화 제목 : ");
		String title = sc.nextLine();
		
		return title;
	}
	
	private Map<String, String> inputReview() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("**********************");
		System.out.println("*       리뷰 등록       *");
		System.out.println("**********************");
		System.out.print("영화 제목 : ");
		map.put("title", sc.nextLine());
		System.out.print("리뷰 작성 : ");
		map.put("review", sc.nextLine());
		System.out.print("평점(0~5) : ");
		map.put("rating", sc.nextLine());
		
		
		
		
		return map;
	}


}
