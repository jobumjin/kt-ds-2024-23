package com.hello.forum.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hello.forum.member.service.MemberService;
import com.hello.forum.member.vo.MemberVO;
import com.hello.forum.utils.StringUtils;
import com.hello.forum.utils.ValidationUtils;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/regist")
	public String viewRegistMemberPage() {
		return "member/memberregist";
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
			System.out.println("회원가입에 성공했습니다.");
		}
		else {
			System.out.println("회원가입에 실패했습니다.");
		}
		
		return "member/login";
	}
}
