package com.hello.forum.member.service;

import com.hello.forum.member.vo.MemberVO;

public interface MemberService {

	/**
	 * 회원가입을 처리한다.
	 * @param memberVO 사용자가 작성한 사용자 정보
	 * @return 회원가입이 정상적으로 처리되었는지 여부
	 */
	boolean createNewMember(MemberVO memberVO);

}
