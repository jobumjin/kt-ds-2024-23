package com.ktdsuniversity.watcha.service;

import com.ktdsuniversity.watcha.dao.ActorsDao;
import com.ktdsuniversity.watcha.dao.CastsDao;
import com.ktdsuniversity.watcha.dao.MoviesDao;
import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.ActorsVO;
import com.ktdsuniversity.watcha.vo.MoviesVO;

public class CastsService {
	
	private CastsDao castsDao;
	private ActorsDao actorsDao;
	private MoviesDao moviesDao;
	
	public CastsService() {
		this.actorsDao = new ActorsDao();
		this.castsDao = new CastsDao();
	}
	
	public boolean createNewCasts(String characterName, String mainActorYn, ActorsVO actor, MoviesVO movie) {
		
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		
		
		
		
		dbSupporter.close();
		return false;
	}
}
