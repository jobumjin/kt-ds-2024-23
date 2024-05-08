package com.hello.forum.bbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hello.forum.bbs.service.ReplyService;
import com.hello.forum.bbs.vo.ReplyVO;
import com.hello.forum.bbs.vo.SearchReplyVO;
import com.hello.forum.member.vo.MemberVO;
import com.hello.forum.utils.AjaxResponse;


@RestController
public class ReplyController {

	// 프린트하면 쓰려했는데 프린트 하는 곳이 없는 것 같다..
//	private Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@GetMapping("/ajax/board/reply/{boardId}")
	public AjaxResponse getAllReplies(@PathVariable int boardId,
			SearchReplyVO searchReplyVO) {
		searchReplyVO.setBoardId(boardId);
		List<ReplyVO> replyList = this.replyService
				.getAllReplies(searchReplyVO);

		searchReplyVO.setPageCount(replyList.size());

		return new AjaxResponse().append("count", replyList.size())
				.append("replies", replyList).append("paginate", searchReplyVO);
	}
	
	@PostMapping("/ajax/board/reply/{boardId}")
	public AjaxResponse doCreateNewReplies(@PathVariable int boardId,
			@ModelAttribute ReplyVO replyVO,
			Authentication authentication) {
		
		replyVO.setEmail(authentication.getName());
		boolean isSuccess = replyService.createNewReply(replyVO);
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put("result", isSuccess);
//		return resultMap;
		return new AjaxResponse().append("result", isSuccess);
	}
	
	@GetMapping("/ajax/board/reply/delete/{replyId}")
	public AjaxResponse doDeleteReplies(@PathVariable int replyId,
			Authentication authentication) {
		
		
		boolean isSuccess = replyService.deleteOneReply(replyId, authentication.getName());
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put("result", isSuccess);
//		return resultMap;
		return new AjaxResponse().append("result", isSuccess);
	}
	
	@PostMapping("/ajax/board/reply/modify/{replyId}")
	public AjaxResponse doModifyReplies(@PathVariable int replyId,
			@ModelAttribute ReplyVO replyVO,
			Authentication authentication){
		replyVO.setReplyId(replyId);
		replyVO.setEmail(authentication.getName());
		
		boolean isSuccess = replyService.modifyOneReply(replyVO);
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put("result", isSuccess);
//		return resultMap;
		return new AjaxResponse().append("result", isSuccess);
	}
	
	@GetMapping("/ajax/board/reply/recommend/{replyId}")
	public AjaxResponse doRecommendReplies(@PathVariable int replyId,
			Authentication authentication){
		boolean isSuccess = replyService.recommendOneReply(replyId, authentication.getName());
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put("result", isSuccess);
//		return resultMap;
		return new AjaxResponse().append("result", isSuccess);
	}
	
	
}
