package com.hello.forum.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.forum.bbs.dao.BoardDao;
import com.hello.forum.bbs.vo.BoardListVO;
import com.hello.forum.bbs.vo.BoardVO;

/*
 * @Service : @Controller 와 @Repository를 연결하는 역할
 * 	- 주로 Transaction 처리 담당.
 * 	- 업무 로직을 담당.
 * 	- 업무 로직?
 * 		- 토스 
 * 			- 이체 : 내 통장에서 출금해서 다른 통장으로 입금한다.
 * 				1. 내 통장에서 출금한다.
 * 				-----> 원인을 알 수 없는 예외가 발생!
 * 				-----> 예외가 발생하면 Application 이 종료된다.
 * 				-----------> 내 통장에서 출금한 돈은 어딘가로 사라지고 없다!!!
 * 				-----> 업무로직 진행 중에 예외가 발생할 경우, Rollback 처리를 하고
 * 				-----> 업무로직이 정상적으로 종료가 되었다면 Commit 을 수행. ==> Transaction
 * 				2. 출금한 돈을 다른 통장으로 입금한다.
 * 			- 출금 : 통장에서 돈을 뺀다.
 * 			- 입금 : 통장으로 돈을 넣는다.
 * @Controller
 * @Service
 * @Repository
 * 이 3개는 Spring 이 객체로 생성해서 Bean Container 에 보관하는 역할
 */
@Service
public class BoardServiceImpl implements BoardService {

	/*
	 * 멤버변수 위에 @Autowired 를 작성하면
	 * BeanContainer 에서 멤버변수의 타입과 일치하는 객체를
	 * 찾아서 멤버변수에게 자동으로 할당해준다.(Spring) 
	 */
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public BoardListVO getAllBoard() {
		// BoardDaoImpl 의 getBoardAllCount 를 이용해서 게시글의 건 수를 알고 싶고
		int boardCount = this.boardDao.getBoardAllCount();
		// BoardDaoImpl 의 getAllBoard 를 이용해서 게시글의 목록을 알고싶다!
		List<BoardVO> boardList = this.boardDao.getAllBoard();
		
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardCnt(boardCount);
		boardListVO.setBoardList(boardList);
		return boardListVO;
	}

	@Override
	public boolean createNewBoard(BoardVO boardVO) {
		
		int insertedCount = this.boardDao.insertNewBoard(boardVO);
		return insertedCount > 0;
	}

	@Override
	public BoardVO getOneBoard(int id) {
		// 1. 게시글 정보 조회하기
		BoardVO boardVO = this.boardDao.selectOneBoard(id);
		// 2. 게시글의 조회수를 1증가시키기
		int updatedCount = this.boardDao.increaseViewCount(id);
		if(updatedCount == 0) {
			// 업데이트 영향을 받은 ROW가 단 한건도 없다면
			// 사용자가 잘못 요청을 했거나
			// 부정적인 방법으로 시스템을 이용하는 중으로 판단.
			throw new IllegalArgumentException("잘못된 접근입니다.");
		}
		return boardVO;
	}
	
	
}