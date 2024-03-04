package com.ktdsuniversity.watcha.service;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.watcha.dao.CastsDao;
import com.ktdsuniversity.watcha.dao.MoviesDao;
import com.ktdsuniversity.watcha.dao.ProducingDao;
import com.ktdsuniversity.watcha.dao.RatingsDao;
import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.MoviesVO;

public class MoviesService {
	private MoviesDao moviesDao;
	private ProducingDao producingDao;
	private RatingsDao ratingsDao;
	private CastsDao castsDao;
	
	public MoviesService() {
		this.moviesDao = new MoviesDao();
		this.producingDao = new ProducingDao();
		this.ratingsDao = new RatingsDao();
		this.castsDao = new CastsDao();
	}
	
	public boolean createNewMovie(String title
			                     , int minimumAge
			                     , String openYear
			                     , int runningTime
			                     , String genre
			                     , String athmosphere
			                     , String location
			                     , String summary
			                     , String poster
			                     , List<String> directorsId) {
		
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		// 영화의 새로운 PK값을 받아온다.
		String newMoviePk = this.moviesDao.makeNextValue(dbSupporter);
		
		MoviesVO moviesVO = new MoviesVO();
		moviesVO.setMovieId(newMoviePk);
		moviesVO.setTitle(title);
		moviesVO.setMinimumAge(minimumAge);
		moviesVO.setOpenYear(openYear);
		moviesVO.setRunningTime(runningTime);
		moviesVO.setGenre(genre);
		moviesVO.setAtmosphere(athmosphere);
		moviesVO.setLocation(location);
		moviesVO.setSummary(summary);
		moviesVO.setPoster(poster);
		
		int insertMovieCount = 0;
		try {
			insertMovieCount = this.moviesDao.insertNewMovie(dbSupporter, moviesVO);
		} 
		catch (RuntimeException re) {
			re.printStackTrace();
			dbSupporter.rollback();
		}
		
		int insertDirectorsCount = 0;
		
		// 영화 등록에 성공했다면
		if(insertMovieCount > 0 && directorsId != null) {
			// 제작 정보를 insert 한다.
			// 영화 1--n 제작 n--1 감독
//			람다를 쓸 수 없다.. 외부에서 값을 가져올 수 없고 변경할수도 없기 때문이다. 
//			directorsId.forEach((directorId) -> {
//				insertDirectorsCount += this.producingDao.insertNewProducing(dbSupporter, directorId, newMoviePk);
//			});
			for (String directorId : directorsId) {
				try {
					insertDirectorsCount += this.producingDao.insertNewProducing(dbSupporter, directorId, newMoviePk);
				} 
				catch (RuntimeException re) {
					re.printStackTrace();
					dbSupporter.rollback();
					dbSupporter.close();
					return false;
				}
			}			
		}
		
		dbSupporter.close();
		return insertMovieCount > 0 || insertDirectorsCount > 0;
	}
	
	public List<MoviesVO> findAllMovies() {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		List<MoviesVO> movies = null;
		try {
			movies = this.moviesDao.selectAllMovies(dbSupporter);
		} catch (RuntimeException re) {
			re.printStackTrace();
			dbSupporter.close();
			return new ArrayList<>();
		}
		
		
		dbSupporter.close();
		return movies;
	}

	public List<MoviesVO> findMoviesByTitle(String movieTitle) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		List<MoviesVO> movies = null;
		try {
			movies = this.moviesDao.selectMoviesByTitle(dbSupporter, movieTitle);
		} catch (RuntimeException re) {
			re.printStackTrace();
			dbSupporter.close();
			return new ArrayList<>();
		}
		
		
		dbSupporter.close();
		return movies;
	}

	public MoviesVO findMovieById(String movieId) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		MoviesVO moviesVO = null;
		try {
			moviesVO = this.moviesDao.selectMoviesById(dbSupporter, movieId);
		} catch (RuntimeException re) {
			re.printStackTrace();
			dbSupporter.close();
			return null;
		}
		
		
		dbSupporter.close();
		return moviesVO;
	}

	public boolean modifyOneMovie(MoviesVO moviesVO) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		int updatedCount = 0;
		try {
			updatedCount = this.moviesDao.updateOneMovie(dbSupporter, moviesVO);
		} catch (RuntimeException re) {
			re.printStackTrace();
			dbSupporter.close();
			return false;
		}
		
		
		dbSupporter.close();
		return updatedCount > 0;
	}

	public boolean deleteOneMovieById(String movieId) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		try {
			int deletedRatingsCount = this.ratingsDao.deleteRatingsByMovieId(dbSupporter, movieId);
			System.out.println(deletedRatingsCount + "건의 평점을 삭제했습니다.");
		} catch (RuntimeException re) {
			re.printStackTrace();
			dbSupporter.close();
			return false;
		}
		
		try {
			int deletedCastsCount = this.castsDao.deleteCastsByMovieId(dbSupporter, movieId);
			System.out.println(deletedCastsCount + "건의 출연배우를 삭제했습니다.");
		} catch (RuntimeException re) {
			re.printStackTrace();
			dbSupporter.close();
			return false;
		}
		
		try {
			int deletedProducingCount = this.producingDao.deleteProducingByMovieId(dbSupporter, movieId);
			System.out.println(deletedProducingCount + "건의 제작자를 삭제했습니다.");
		} catch (RuntimeException re) {
			re.printStackTrace();
			dbSupporter.close();
			return false;
		}
		
		int deletedCount = 0;
		try {
			deletedCount = this.moviesDao.deleteOneMovieById(dbSupporter, movieId);
		} catch (RuntimeException re) {
			re.printStackTrace();
			dbSupporter.close();
			return false;
		}
		
		
		dbSupporter.close();
		return deletedCount > 0;
	}

	
	
	
}
