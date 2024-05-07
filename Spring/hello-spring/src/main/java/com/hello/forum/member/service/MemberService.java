package com.hello.forum.member.service;

import com.hello.forum.member.vo.MemberVO;

public interface MemberService {

	/**
	 * 회원가입을 처리한다.
	 * @param memberVO 사용자가 작성한 사용자 정보
	 * @return 회원가입이 정상적으로 처리되었는지 여부
	 */
	public boolean createNewMember(MemberVO memberVO);

	/**
	 * 사용자가 입력한 email 이 사용가능한 이메일인지 확인한다.
	 * @param email 사용자가 등록한 이메일
	 * @return 사용가능한 이메일이라면 true 사용불가능한 이메일이라면 false 를 반환
	 */
	public boolean checkAvailableEmail(String email);

	public boolean deleteMe(String email);

}
