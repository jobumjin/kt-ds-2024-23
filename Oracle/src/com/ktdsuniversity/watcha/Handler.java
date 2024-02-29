package com.ktdsuniversity.watcha;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.watcha.service.ActorsService;
import com.ktdsuniversity.watcha.service.DirectorsService;
import com.ktdsuniversity.watcha.service.MoviesService;
import com.ktdsuniversity.watcha.vo.CastsVO;

public class Handler {

	public static void main(String[] args) {
		
		DirectorsService directorsService = new DirectorsService();
		MoviesService moviesService = new MoviesService();
		ActorsService actorsService = new ActorsService();
		
//		감독생성코드
//		boolean wasCreate = directorsService.createNewDirector("장항준", "장항준.png");
//		
//		if(wasCreate) {
//			System.out.println("감독을 잘 생성했습니다.");
//		}
//		else {
//			System.out.println("감독 생성에 실패했습니다.");
//		}

//		감독이 만든.. 영화 목록 검색하기..? 
//		List<DirectorsVO> directors = directorsService.findDirectorsWithMovies();
//		directors.forEach(director -> {
//			System.out.println("감독명: " + director.getName());
//			
//			List<MoviesVO> movies = director.getMovies();
//			movies.forEach(movie -> {
//				System.out.println("영화명: " + movie.getTitle());
//			});			
//		});
		
//		영화 추가 
//		boolean movieIsCreate = moviesService.createNewMovie("열한시"
//				                    , 15
//				                    , "2013"
//				                    , 98
//				                    , "스릴러"
//				                    , "추리"
//				                    , "한국"
//				                    , "투자 기업으로부터 프로젝트 중단을 통보 받은 시간 이동 프로젝트 연구원 우석은 연구를 지속하기 위해 영은과 위험한 테스트 이동을 감행한다."
//				                    , "열한시.png"
//				                    , List.of("DR-20240228-000001"));
//		
//		if (movieIsCreate) {
//			System.out.println("영화 등록을 성공했습니다.");
//		}
//		else {
//			System.out.println("영화 등록을 실패했습니다.");
//		}
		
		List<CastsVO> castList = new ArrayList<>();
		CastsVO casts = new CastsVO();
		casts.setMovieId("MV-20240229-000027");
		casts.setCharacterName("우석");
		casts.setMainActorYn("Y");
		castList.add(casts);
		
		boolean actorIsCreate = actorsService.createNewActor("정재영.png", "정재영", castList);
		
		if(actorIsCreate) {
			System.out.println("배우 등록에 성공했습니다.");
		}
		else {
			System.out.println("배우 등록에 실페했습니다.");			
		}
		
	}
}
