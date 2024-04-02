package com.hello.forum.member.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hello.forum.member.service.MemberService;
import com.hello.forum.member.vo.MemberVO;
import com.hello.forum.utils.AjaxResponse;
import com.hello.forum.utils.StringUtils;
import com.hello.forum.utils.ValidationUtils;
import com.hello.forum.utils.Validator;
import com.hello.forum.utils.Validator.Type;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/regist")
	public String viewRegistMemberPage() {
		return "member/memberregist";
	}
	
	// http://localhost:8080/member/regist/available?email=aaa@aaa.com
	@ResponseBody // JSON으로 응답한다.
	@GetMapping("/ajax/member/regist/available")
	public Map<String, Object> checkAvailableEmail(@RequestParam String email){
		
		// 사용가능한 이메일이라면 true 아니라면 false 를 반환
		boolean isAvailableEmail = this.memberService.checkAvailableEmail(email);
		
		/*
		 * { "email": "aaa@aaa.com", 
		 *   "available": false }
		 */
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("email", email);
		responseMap.put("available", isAvailableEmail);
		return responseMap;
	}
	
	
	@PostMapping("/member/regist")
	public String doRegistMember(MemberVO memberVO,Model model) {
		boolean isNotEmptyEmail = ValidationUtils.notEmpty(memberVO.getEmail());
		boolean isEmailFormat = ValidationUtils.email(memberVO.getEmail());
		boolean isNotEmptyName = ValidationUtils.notEmpty(memberVO.getName());
		boolean isNotEmptyPassword= ValidationUtils.notEmpty(memberVO.getPassword());
		boolean isEnoughSize = ValidationUtils.size(memberVO.getPassword(), 10);
		boolean isNotEmptyConfrimPassword = ValidationUtils.notEmpty(memberVO.getConfirmPassword());
		boolean isEqualsPassword = ValidationUtils.isEquals(memberVO.getPassword(), memberVO.getConfirmPassword());
		boolean isPasswordFormat = StringUtils.correctPasswordFormat(memberVO.getPassword());
		
		if(!isNotEmptyEmail) {
			model.addAttribute("errorMessage","이메일을 입력해주세요.");
			model.addAttribute("memberVO",memberVO);
			return "member/memberregist";
		}
		if(!isEmailFormat) {
			model.addAttribute("errorMessage","이메일 형태로 입력해주세요.");
			model.addAttribute("memberVO",memberVO);
			return "member/memberregist";
		}
		if(!isNotEmptyName) {
			model.addAttribute("errorMessage","이름을 입력해주세요.");
			model.addAttribute("memberVO",memberVO);
			return "member/memberregist";
		}
		if(!isNotEmptyPassword) {
			model.addAttribute("errorMessage","비밀번호를 입력해주세요.");
			model.addAttribute("memberVO",memberVO);
			return "member/memberregist";
		}
		if(!isEnoughSize) {
			model.addAttribute("errorMessage","비밀번호를 10글자 이상 입력해주세요.");
			model.addAttribute("memberVO",memberVO);
			return "member/memberregist";
		}
		if(!isNotEmptyConfrimPassword) {
			model.addAttribute("errorMessage","비밀번호 확인을 입력해주세요.");
			model.addAttribute("memberVO",memberVO);
			return "member/memberregist";
		}
		if(!isEqualsPassword) {
			model.addAttribute("errorMessage","비밀번호 확인을 비밀번호와 같게 입력해주세요.");
			model.addAttribute("memberVO",memberVO);
			return "member/memberregist";
		}
		if(!isPasswordFormat) {
			model.addAttribute("errorMessage","비밀번호 형식에 맞게 입력해주세요.");
			model.addAttribute("memberVO",memberVO);
			return "member/memberregist";
		}
		
		
		boolean isSuccess = this.memberService.createNewMember(memberVO);

		if(isSuccess) {
			logger.info("회원가입에 성공했습니다.");
		}
		else {
			logger.info("회원가입에 실패했습니다.");
		}
		
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/login")
	public String viewLoginPage() {
		return "member/memberlogin";
	}
	
	@ResponseBody
	@PostMapping("/ajax/member/login")
	public AjaxResponse doLogin(MemberVO memberVO, HttpSession session, @RequestParam(defaultValue = "/board/list") String nextUrl) {
		
		logger.info("nextUrl: " + nextUrl);
		// Validation Check(파라미터 유효성 검사)
		Validator<MemberVO> validator = new Validator<>(memberVO);
		validator.add("email", Type.NOT_EMPTY, "이메일을 입력해주세요.")
		         .add("email", Type.EMAIL, "이메일 형식이 아닙니다.")
		         .add("password", Type.NOT_EMPTY, "비밀번호를 입력해주세요.").start();
		
		if(validator.hasErrors()) {
			Map<String, List<String>> errors = validator.getErrors();
			return new AjaxResponse().append("errors", errors);
		}
		
		
//		try {
			MemberVO member = this.memberService.getMember(memberVO);
			// 로그인이 정상적으로 이루어졋다면 세션을 생성한다.
			session.setAttribute("_LOGIN_USER_", member);
			session.setMaxInactiveInterval(0);
//		} catch (IllegalArgumentException iae) {
			// 로그인에 실패했다면 화면으로 실패사유를 보내준다.
//			return new AjaxResponse().append("errorMessage", iae.getMessage());
//		}
		
		return new AjaxResponse().append("next", nextUrl);
	}
	
	@GetMapping("/member/logout")
	public String doLogout(HttpSession session) {
		// Logout 처리
		// sessionID로 전달된 세션의 모든 정보를 삭제
		session.invalidate();
		return "redirect:/board/list";
	}
	
	@ResponseBody
	@GetMapping("/ajax/member/delete-me")
	public AjaxResponse doDeleteMe(HttpSession session, @SessionAttribute("_LOGIN_USER_") MemberVO memberVO) {
		
		// 현재 로그인되어있는 사용자의 정보
//		MemberVO memberVO = (MemberVO) session.getAttribute("_LOGIN_USER_");
		boolean isSuccess = this.memberService.deleteMe(memberVO.getEmail());
		
		return new AjaxResponse().append("next", isSuccess ? "/member/success-delete-me" : "/member/fail-delete-me");
	}
	
	@GetMapping("/member/{result}-delete-me")
	public String viewDeleteMePage(@PathVariable String result) {
		result = result.toLowerCase();
		if(!result.equals("fail") && !result.equals("success")) {
			return "error/404";
		}
		
		return "member/" +result +"deleteme";
	}
}
