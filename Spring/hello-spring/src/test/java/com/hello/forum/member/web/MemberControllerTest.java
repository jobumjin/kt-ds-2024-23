package com.hello.forum.member.web;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import com.hello.forum.member.service.MemberService;

@WebMvcTest(MemberController.class)
@Import(MemberService.class)
public class MemberControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private MemberService memberService;
	
	@Test
	@DisplayName("회원가입 페이지 보여주기 테스트")
	public void viewRegistMemberPageTest() throws Exception {
		// Given (없음)
		// When
		// mvc를 통해 실제 Request 를 전송.
		mvc.perform(get("/member/regist"))
		   // 응답 받은 데이터를 출력한다.
		   .andDo(print())
		   // status().isOk() : HttpServletResponse의 http status 코드가 200인지 확인.
		   .andExpect(status().isOk())
		   .andExpect(view().name("member/memberregist"));
	}
	
	@Test
	@DisplayName("이메일 중복검사 테스트")
	public void checkAvailableEmailTest() throws Exception {
		
		// Given
		given(this.memberService.checkAvailableEmail("user01@gmail.com")).willReturn(true);
		
		// When
		mvc.perform(get("/ajax/member/regist/available?email=user01@gmail.com"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("user01@gmail.com")))
			.andExpect(content().string(containsString("true")))
			.andExpect(content().string(containsString("\"available\":true")))
			.andExpect(content().string(containsString("\"email\":\"user01@gmail.com\"")));
		
		verify(this.memberService).checkAvailableEmail("user01@gmail.com");
	}
	
	@Test
	@DisplayName("회원가입 파라미터 유효성 검사 실패 테스트")
	public void doRegistMemberFailTest() throws Exception {
		mvc.perform(post("/member/regist"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attribute("errorMessage", "이메일을 입력해주세요."));
	
		mvc.perform(post("/member/regist")
				.param("email", "user01gmail.com"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attribute("errorMessage", "이메일 형태로 입력해주세요."));

		mvc.perform(post("/member/regist")
				.param("email", "user01@gmail.com"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attribute("errorMessage", "이름을 입력해주세요."));

		mvc.perform(post("/member/regist")
				.param("email", "user01@gmail.com")
				.param("name", "testname"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attribute("errorMessage", "비밀번호를 입력해주세요."));
	
		mvc.perform(post("/member/regist")
				.param("email", "user01@gmail.com")
				.param("name", "testname")
				.param("password", "asdf"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attribute("errorMessage", "비밀번호를 10글자 이상 입력해주세요."));

		mvc.perform(post("/member/regist")
				.param("email", "user01@gmail.com")
				.param("name", "testname")
				.param("password", "asdfasdfasdf"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attribute("errorMessage", "비밀번호 확인을 입력해주세요."));

		mvc.perform(post("/member/regist")
				.param("email", "user01@gmail.com")
				.param("name", "testname")
				.param("password", "asdfasdfasdf")
				.param("confirmPassword", "asdfasdfas"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attribute("errorMessage", "비밀번호 확인을 비밀번호와 같게 입력해주세요."));

		mvc.perform(post("/member/regist")
				.param("email", "user01@gmail.com")
				.param("name", "testname")
				.param("password", "asdfasdfasdf")
				.param("confirmPassword", "asdfasdfasdf"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attribute("errorMessage", "비밀번호 형식에 맞게 입력해주세요."));
	}
	
	@Test
	@DisplayName("회원가입 성공 테스트")
	public void doRegistMemberSuccessTest() throws Exception {
		mvc.perform(post("/member/regist")
				.param("email", "user01@gmail.com")
				.param("name", "testname")
				.param("password", "Qwert12345")
				.param("confirmPassword", "Qwert12345"))
		.andDo(print())
		.andExpect(status().is3xxRedirection()) // Redirect를 반환할때 사용..
		.andExpect(view().name("redirect:/member/login"));
	}
}
