package com.hello.forum.bbs.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hello.forum.bbs.service.BoardService;
import com.hello.forum.bbs.vo.BoardListVO;
import com.hello.forum.bbs.vo.BoardVO;
import com.hello.forum.bbs.vo.SearchBoardVO;
import com.hello.forum.beans.security.SecurityUser;
import com.hello.forum.exceptions.PageNotFoundException;
import com.hello.forum.member.vo.MemberVO;
import com.hello.forum.utils.ApiResponse;
import com.hello.forum.utils.ValidationUtils;

@RestController
@RequestMapping("/api/v1")
public class ApiBoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/boards")
	public ApiResponse getBoardList(SearchBoardVO searchBoardVO) {
		
		BoardListVO boardListVO = this.boardService.searchAllBoard(searchBoardVO);
		
		return ApiResponse.Ok(boardListVO.getBoardList()
				, boardListVO.getBoardCnt()
				, searchBoardVO.getPageCount()
				, searchBoardVO.getPageNo()< searchBoardVO.getPageCount() - 1);
	}
	
	@GetMapping("/boards/{id}")
	public ApiResponse getViewBoardDetail(@PathVariable int id) {
		
		BoardVO boardVO = this.boardService.getOneBoard(id, true);
		return ApiResponse.Ok(boardVO, boardVO == null ? 0 : 1);
	}
	
	@DeleteMapping("/boards/{id}")
	public ApiResponse deleteBoard(@PathVariable int id, Authentication authentication) {
		
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		MemberVO memberVO = ((SecurityUser) userDetails).getMemberVO();
		
		BoardVO boardVO = this.boardService.getOneBoard(id, false);
		
		if(!memberVO.getEmail().equals(boardVO.getMemberVO().getEmail())) {
			return ApiResponse.FORBIDDEN("삭제할 권한이 없습니다.");
		}
		
		boolean isSuccess = this.boardService.deleteOneBoard(id);
		return ApiResponse.Ok(isSuccess);
	}
	
	@PostMapping("/boards")
	public ApiResponse doBoardWrite(BoardVO boardVO,
			@RequestParam(required = false) MultipartFile file,
			Authentication authentication
			) {
		boolean isNotEmptySubject = ValidationUtils.notEmpty(boardVO.getSubject());
		boolean isNotEmptycontent = ValidationUtils.notEmpty(boardVO.getContent());
		
		List<String> errorMessage = null;
		
		if(!isNotEmptySubject) {
			//제목을 입력하지 않았다면...
			if(errorMessage == null) {
				errorMessage = new ArrayList<>();
			}
			errorMessage.add("제목을 입력해주세요.");
		}
		if(!isNotEmptycontent) {
			//내용을 입력하지 않았다면...
			if(errorMessage == null) {
				errorMessage = new ArrayList<>();
			}
			errorMessage.add("내용을 입력해주세요.");
		}
		if(errorMessage!= null) {
			return ApiResponse.BAD_REQUEST(errorMessage);
		}
		
		boardVO.setEmail(authentication.getName());
		
		boolean isCreateSuccess = this.boardService.createNewBoard(boardVO, file);
		
		return ApiResponse.Ok(isCreateSuccess);
	}
	
	@PutMapping("/boards/{id}")
	public ApiResponse doboardModify(@PathVariable int id, BoardVO boardVO, @RequestParam(required = false) MultipartFile file, Authentication authentication) {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		MemberVO memberVO = ((SecurityUser) userDetails).getMemberVO();
		
		BoardVO originalBoardVO = this.boardService.getOneBoard(id, false);
		
		if(!originalBoardVO.getEmail().equals(authentication.getName())
				&& memberVO.getAdminYn().equals("N")) {
			throw new PageNotFoundException();
		}
		
		// 수동 검사 시작
		// 제목 검사
		boolean isNotEmptySubject = ValidationUtils.notEmpty(boardVO.getSubject());
		boolean isNotEmptycontent = ValidationUtils.notEmpty(boardVO.getContent());
		
		List<String> errorMessage = null;
		
		if(!isNotEmptySubject) {
			//제목을 입력하지 않았다면...
			if(errorMessage == null) {
				errorMessage = new ArrayList<>();
			}
			errorMessage.add("제목을 입력해주세요.");
		}
		if(!isNotEmptycontent) {
			//내용을 입력하지 않았다면...
			if(errorMessage == null) {
				errorMessage = new ArrayList<>();
			}
			errorMessage.add("내용을 입력해주세요.");
		}
		if(errorMessage!= null) {
			return ApiResponse.BAD_REQUEST(errorMessage);
		}

		boardVO.setId(id);
				
		boolean isUpdatedSuccess= this.boardService.updateOneBoard(boardVO, file);
		
		return ApiResponse.Ok(isUpdatedSuccess);
	}
	
	
}
