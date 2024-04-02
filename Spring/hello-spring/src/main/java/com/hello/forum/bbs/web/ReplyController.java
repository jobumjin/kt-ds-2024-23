package com.hello.forum.bbs.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hello.forum.bbs.service.ReplyService;
import com.hello.forum.bbs.vo.ReplyVO;
import com.hello.forum.member.vo.MemberVO;


@RestController
public class ReplyController {

	private Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@GetMapping("/board/reply/{boardId}")
	public Map<String, Object> getAllReplies(@PathVariable int boardId){
		List<ReplyVO> replyList = replyService.getAllReplies(boardId);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("count", replyList.size());
		resultMap.put("replies", replyList);
		return resultMap;
	}
	
	@PostMapping("pathrd/reply/{boardId}")
	public Map<String, Object> doCreateNewReplies(@PathVariable int boardId,
			@ModelAttribute ReplyVO replyVO,
			@SessionAttribute("_LOGIN_USER_") MemberVO memberVO) {
		boolean isSuccess = replyService.createNewReply(replyVO);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", isSuccess);
		return resultMap;
	}
	
	@GetMapping("/board/reply/delete/{replyId}")
	public Map<String, Object> doDeleteReplies(@RequestParam int replyId,
			@SessionAttribute("_LOGIN_USER_") MemberVO memberVO) {
		boolean isSuccess = replyService.deleteOneReply(replyId, memberVO.getEmail());
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", isSuccess);
		return resultMap;
	}
	
	@PostMapping("/board/reply/modify/{replyId}")
	public Map<String, Object> doModifyReplies(@PathVariable int replyId,
			@ModelAttribute ReplyVO replyVO,
			@SessionAttribute("_LOGIN_USER_") MemberVO memberVO){
		replyVO.setReplyId(replyId);
		replyVO.setEmail(memberVO.getEmail());
		
		boolean isSuccess = replyService.modifyOneReply(replyVO);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", isSuccess);
		return resultMap;
	}
	
	@GetMapping("/board/reply/recommend/{replyId}")
	public Map<String, Object> doRecommendReplies(@PathVariable int replyId,
			@SessionAttribute("_LOGIN_USER_") MemberVO memberVO){
		boolean isSuccess = replyService.recommendOneReply(replyId, memberVO.getEmail());
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", isSuccess);
		return resultMap;
	}
	
	
}
