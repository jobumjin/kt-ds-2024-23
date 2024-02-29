package com.ktdsuniversity.watcha.dao;

import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.ActorsVO;

public class ActorsDao {

	
	public String makNextValue(DBSupporter dbSupporter) {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT 'AC-' || TO_CHAR(SYSDATE, 'YYYYMMDD') ||'-' || LPAD(SEQ_ACTORS_PK.NEXTVAL, 6, '0') ");
		query.append("   FROM DUAL ");
		
		return dbSupporter.selectOne(query.toString(), null, String.class);
	
	}
	
	public int insertNewActor(DBSupporter dbSupporter, ActorsVO actorsVO) {
		StringBuffer query = new StringBuffer();
		
		query.append(" INSERT INTO ACTORS ");
		query.append(" (ACTOR_ID ");
		query.append(" , PROFLE ");
		query.append(" , NAME) ");
		query.append(" VALUES ");
		query.append("  (? /*ACTOR_ID*/ ");
		query.append(" , ? /*PROFLE*/ ");
		query.append(" , ? /*NAME*/) ");
		
		return dbSupporter.insert(query.toString(), 
		           new Object[] { actorsVO.getActorId()
		        		        , actorsVO.getName()
		        		        , actorsVO.getProfle() });

	}
	
	
}
