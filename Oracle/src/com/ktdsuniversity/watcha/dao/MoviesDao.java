package com.ktdsuniversity.watcha.dao;

import java.util.List;

import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.MoviesVO;

public class MoviesDao {
	
	/**
	 * 다음 PK의 값을 만들어준다.  
	 * 
	 */
	public String makeNextValue(DBSupporter dbSupporter) {
		StringBuffer query = new StringBuffer();
		
		query.append(" SELECT 'MV-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_MOVIES_PK.NEXTVAL,6 ,'0') /*MOVIE_ID*/ ");
		query.append("   FROM DUAL ");
		
		return dbSupporter.selectOne(query.toString(), null, String.class);
	}
	
	public int insertNewMovie(DBSupporter dbSupporter
			   , MoviesVO newMoviesVO) {

		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO MOVIES "); 
		query.append(" (MOVIE_ID ");
		query.append(" , TITLE ");
		query.append(" , MINIMUM_AGE ");
		query.append(" , OPEN_YEAR ");
		query.append(" , RUNNING_TIME ");
		query.append(" , GENRE ");
		query.append(" , ATMOSPHERE ");
		query.append(" , LOCATION ");
		query.append(" , SUMMARY ");
		query.append(" , POSTER ");
		query.append(" ) ");
		query.append(" VALUES  ");
		query.append(" ( ? /*MOVIE_ID*/ ");
		query.append(" , ? /*TITLE*/ ");
		query.append(" , ? /*MINIMUM_AGE*/ ");
		query.append(" , ? /*OPEN_YEAR*/ ");
		query.append(" , ? /*RUNNING_TIME*/ ");
		query.append(" , ? /*GENRE*/ ");
		query.append(" , ? /*ATMOSPHERE*/ ");
		query.append(" , ? /*LOCATION*/ ");
		query.append(" , ? /*SUMMARY*/ ");
		query.append(" , ? /*POSTER*/ ");
		query.append(" ) ");
		
		return dbSupporter.insert(query.toString(), new Object[] { newMoviesVO.getMovieId(),
																   newMoviesVO.getTitle(),
																   newMoviesVO.getMinimumAge(), 
																   newMoviesVO.getOpenYear(), 
																   newMoviesVO.getRunningTime(),
																   newMoviesVO.getGenre(), 
																   newMoviesVO.getAtmosphere(), 
																   newMoviesVO.getLocation(),
																   newMoviesVO.getSummary(), 
																   newMoviesVO.getPoster()});
	}
	
	public List<MoviesVO> selectMoviesByDirectorId(DBSupporter dbSupporter, String directorId) {
		
		StringBuffer query = new StringBuffer();
		query.append(" SELECT * ");
		query.append("   FROM MOVIES ");
		query.append("  WHERE MOVIE_ID IN (SELECT MOVIE_ID ");
		query.append("                       FROM PRODUCINGS ");
		query.append("                      WHERE DIRECTOR_ID = ?) ");
				
		
		return dbSupporter.selectList(query.toString(), new Object[] {directorId}, MoviesVO.class);
	}
}
