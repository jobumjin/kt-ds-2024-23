package com.hello.forum.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.forum.bbs.dao.BoardDao;
import com.hello.forum.bbs.vo.BoardListVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public BoardListVO getAllBoard() {
		
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardCnt(boardDao.getBoardAllCount());
		boardListVO.setBoardList(boardDao.getAllBoard());
		return null;
		
	}

}
