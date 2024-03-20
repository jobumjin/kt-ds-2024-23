package com.hello.forum.bbs.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.forum.bbs.vo.BoardVO;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int getBoardAllCount() {
		return getSqlSession().selectOne(BoardDao.NAME_SPACE + "getBoardAllCount");
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return getSqlSession().selectList(BoardDao.NAME_SPACE + "getAllBoard");
	}

}
