package com.hello.forum.bbs.dao;

import java.util.List;

import com.hello.forum.bbs.vo.BoardVO;

public interface BoardDao {
	
	public String NAME_SPACE = "com.hello.forum.bbs.dao.BoardDao";
	
	public int getBoardAllCount();
	
	public List<BoardVO> getAllBoard();
	
}
