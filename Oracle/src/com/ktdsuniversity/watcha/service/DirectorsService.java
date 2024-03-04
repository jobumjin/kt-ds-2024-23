package com.ktdsuniversity.watcha.service;

import java.util.List;

import com.ktdsuniversity.watcha.dao.DirectorsDao;
import com.ktdsuniversity.watcha.dao.MoviesDao;
import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.DirectorsVO;
import com.ktdsuniversity.watcha.vo.MoviesVO;

/**
 * DB의 트렌젝션을 관리.
 */
public class DirectorsService {

	private DirectorsDao directorsDao;
	private MoviesDao moviesDao;
	
	public DirectorsService() {
		this.directorsDao = new DirectorsDao();
		this.moviesDao = new MoviesDao();
	}
	
	public boolean createNewDirector(String direcotrsName, String directorsProfile) {
		
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open(); // Database에 연결하는 역할. Autocommit을 비활성화 처리.
		
		DirectorsVO directorsVO = new DirectorsVO();
		directorsVO.setName(direcotrsName);
		directorsVO.setProfle(directorsProfile);
		
		// insert 처리중에 예외가 발생한다면, 변셩사항들을 모두 ROLLBACK 한다.
		int insertedCount = 0;
		try {			
			insertedCount = this.directorsDao.insertNewDirector(dbSupporter, directorsVO);
		} catch (RuntimeException re) {
			dbSupporter.rollback();
		}
		
		dbSupporter.close(); // Database와 연결을 해제한다. 별다른 문제가 없었을 때는 Commit을 한다. 
		return insertedCount > 0;
	}
	
	
	public List<DirectorsVO> findDirectorsWithMovies() {
		
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		// 데이터 베이스에 등록된 모든 감독을 조회한다.
		List<DirectorsVO> directors = this.directorsDao.selectAllDirectors(dbSupporter);

		// 감독 목록을 반복하면서 해당 감독이 재작한 영화 목록을 조회한다.
		directors.forEach((director) -> {
			List<MoviesVO> movies = this.moviesDao.selectMoviesByDirectorId(dbSupporter, director.getDirectorId());
			director.setMovies(movies);
		});
		
		dbSupporter.close();
		return directors;
	}

	public List<DirectorsVO> findAllDirectors() {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		// 데이터 베이스에 등록된 모든 감독을 조회한다.
		List<DirectorsVO> directors = this.directorsDao.selectAllDirectors(dbSupporter);

			
		dbSupporter.close();
		return directors;
	}

	public List<DirectorsVO> findDirectorsByName(String name) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		// 데이터 베이스에 등록된 모든 감독을 조회한다.
		List<DirectorsVO> directors = this.directorsDao.selectDirectorsByName(dbSupporter, name);

			
		dbSupporter.close();
		return directors;
	}

	public DirectorsVO findDirectorsById(String directorsId) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		// 데이터 베이스에 등록된 모든 감독을 조회한다.
		DirectorsVO directorsVO = this.directorsDao.selectDirectorById(dbSupporter, directorsId);

			
		dbSupporter.close();
		return directorsVO;
	}

	public boolean modifyOneDirector(DirectorsVO directorsVO) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		// 데이터 베이스에 등록된 모든 감독을 조회한다.
		int updatedCount = this.directorsDao.updateOneDirector(dbSupporter, directorsVO);

			
		dbSupporter.close();
		return updatedCount > 0;
	}

	public boolean deleteOneDirectorById(String directorsId) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		int deletedProducingCount = this.ProducingDao.deleteProducingByDirectorsId(dbSupporter, directorsId);
		
		
		// 데이터 베이스에 등록된 모든 감독을 조회한다.
		int deletedCount = this.directorsDao.deleteOneDirectorById(dbSupporter, directorsId);

			
		dbSupporter.close();
		return deletedCount > 0;
	}
}
