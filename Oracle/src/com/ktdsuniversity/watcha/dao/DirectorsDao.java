package com.ktdsuniversity.watcha.dao;

import java.util.List;

import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.DirectorsVO;

public class DirectorsDao {

	/**
	 * DIRECTORS 테이블에 새로운 감독 정보를 INSERT 하는 역할
	 * @return DIRECTORS 테이블에 INSERT를 한 개수
	 */
	public int insertNewDirector(DBSupporter dbSupporter
							   , DirectorsVO newDirectorsVO) {
		
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO DIRECTORS ");
		query.append("  (DIRECTOR_ID ");
		query.append(" , NAME ");
		query.append(" , PROFLE) ");
		query.append(" VALUES ");
		query.append("  ('DR-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_DERECTORS_PK.NEXTVAL,6 ,'0') /*DIRECTOR_ID*/ ");
		query.append(" , ? /*NAME*/ ");
		query.append(" , ? /*PROFLE*/) ");
		
		return dbSupporter.insert(query.toString(), 
				           new Object[] { newDirectorsVO.getName(), newDirectorsVO.getProfle() });
		
	}
	
	public List<DirectorsVO> selectAlldirectors(DBSupporter dbSupporter) {
		
		StringBuffer query = new StringBuffer();
		query.append(" SELECT * ");
		query.append("   FROM DIRECTORS ");
				
		
		return dbSupporter.selectList(query.toString(), null, DirectorsVO.class);
	}
	
}
