package com.hello.forum.bbs.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hello.forum.bbs.vo.BoardVO;

/**
 * DB에 쿼리를 전송 및 실행하고 결과를 받아오는 클래스.
 * 
 * SqlSessionDaoSupport : Mybatis가 Database에 접속을 해서 데이터들을 제어하는 역할
 * 					-- Insert, Update, Select, Delete
 * @Repository : Bean Contatiner 에 적재를 시키기 위한 힌트
 * @Controller : Spring이 클래스를 객체화 시켜서 Bean Container에 적재.
 */
@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	@Override
	public int getBoardAllCount() {
		return 0;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return null;
	}

	
}
